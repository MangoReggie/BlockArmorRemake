package net.mangoreggie.blockarmor.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mangoreggie.blockarmor.procedures.UnSinkProcedure;
import net.mangoreggie.blockarmor.procedures.FlootOnKeyReleasedProcedure;
import net.mangoreggie.blockarmor.BlockArmorMod;

@EventBusSubscriber
public record FlootMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<FlootMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BlockArmorMod.MODID, "key_floot"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlootMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FlootMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new FlootMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FlootMessage> type() {
		return TYPE;
	}

	public static void handleData(final FlootMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			UnSinkProcedure.execute(world);
		}
		if (type == 1) {

			FlootOnKeyReleasedProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BlockArmorMod.addNetworkMessage(FlootMessage.TYPE, FlootMessage.STREAM_CODEC, FlootMessage::handleData);
	}
}