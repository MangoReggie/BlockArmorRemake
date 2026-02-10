package net.mangoreggie.blockarmor.network;

import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mangoreggie.blockarmor.BlockArmorMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class BlockArmorModVariables {
	public static void variablesLoad() {
		PayloadTypeRegistry.playS2C().register(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC);
		ServerPlayerEvents.JOIN.register((player) -> {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				ServerPlayNetworking.send(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				ServerPlayNetworking.send(player, new SavedDataSyncMessage(1, worlddata));
		});
		ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((player, origin, destination) -> {
			if (!destination.isClientSide()) {
				SavedData worlddata = WorldVariables.get(player.level());
				if (worlddata != null)
					ServerPlayNetworking.send(player, new SavedDataSyncMessage(1, worlddata));
			}
		});
		ServerTickEvents.END_WORLD_TICK.register((level) -> {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				level.players().forEach(player -> ServerPlayNetworking.send(player, new SavedDataSyncMessage(1, worldVariables)));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PlayerLookup.world(level).forEach(player -> ServerPlayNetworking.send(player, new SavedDataSyncMessage(0, mapVariables)));
				mapVariables._syncDirty = false;
			}
		});
	}

	public static class WorldVariables extends SavedData {
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>("block_armor_worldvars", ctx -> new WorldVariables(), ctx -> CompoundTag.CODEC.xmap(tag -> {
			WorldVariables instance = new WorldVariables();
			instance.read(tag, ctx.levelOrThrow().registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), ctx.levelOrThrow().registryAccess())), null);
		boolean _syncDirty = false;
		public boolean spaceHeld = false;
		public boolean effectKeyHeld = false;
		public double cooldown = 100.0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			spaceHeld = nbt.getBooleanOr("spaceHeld", false);
			effectKeyHeld = nbt.getBooleanOr("effectKeyHeld", false);
			cooldown = nbt.getDoubleOr("cooldown", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("spaceHeld", spaceHeld);
			nbt.putBoolean("effectKeyHeld", effectKeyHeld);
			nbt.putDouble("cooldown", cooldown);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(WorldVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>("block_armor_mapvars", ctx -> new MapVariables(), ctx -> CompoundTag.CODEC.xmap(tag -> {
			MapVariables instance = new MapVariables();
			instance.read(tag, ctx.levelOrThrow().registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), ctx.levelOrThrow().registryAccess())), null);
		boolean _syncDirty = false;
		public double BlockArmorTimer = 0.0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			BlockArmorTimer = nbt.getDoubleOr("BlockArmorTimer", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("BlockArmorTimer", BlockArmorTimer);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAccessor) {
				return serverLevelAccessor.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(MapVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BlockArmorMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data instanceof MapVariables mapVariables)
				buffer.writeNbt(mapVariables.save(new CompoundTag(), buffer.registryAccess()));
			else if (message.data instanceof WorldVariables worldVariables)
				buffer.writeNbt(worldVariables.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final ClientPlayNetworking.Context context) {
			if (message.data != null) {
				context.client().execute(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(((MapVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(((WorldVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				});
			}
		}
	}
}