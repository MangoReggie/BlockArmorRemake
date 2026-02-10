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

import net.mangoreggie.blockarmor.procedures.EffectKeyReleasedProcedure;
import net.mangoreggie.blockarmor.procedures.EffectKeyPressedProcedure;
import net.mangoreggie.blockarmor.BlockArmorMod;

@EventBusSubscriber
public record SpecialEffectKeyMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<SpecialEffectKeyMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BlockArmorMod.MODID, "key_special_effect_key"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SpecialEffectKeyMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SpecialEffectKeyMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new SpecialEffectKeyMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SpecialEffectKeyMessage> type() {
		return TYPE;
	}

	public static void handleData(final SpecialEffectKeyMessage message, final IPayloadContext context) {
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

			EffectKeyPressedProcedure.execute(world);
		}
		if (type == 1) {

			EffectKeyReleasedProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BlockArmorMod.addNetworkMessage(SpecialEffectKeyMessage.TYPE, SpecialEffectKeyMessage.STREAM_CODEC, SpecialEffectKeyMessage::handleData);
	}
}