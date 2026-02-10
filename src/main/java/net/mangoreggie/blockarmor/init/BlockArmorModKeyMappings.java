/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mangoreggie.blockarmor.network.SpecialEffectKeyMessage;
import net.mangoreggie.blockarmor.network.FlootMessage;

@EventBusSubscriber(Dist.CLIENT)
public class BlockArmorModKeyMappings {
	public static final KeyMapping FLOOT = new KeyMapping("key.block_armor.floot", GLFW.GLFW_KEY_SPACE, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new FlootMessage(0, 0));
				FlootMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FLOOT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLOOT_LASTPRESS);
				ClientPacketDistributor.sendToServer(new FlootMessage(1, dt));
				FlootMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPECIAL_EFFECT_KEY = new KeyMapping("key.block_armor.special_effect_key", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new SpecialEffectKeyMessage(0, 0));
				SpecialEffectKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SPECIAL_EFFECT_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SPECIAL_EFFECT_KEY_LASTPRESS);
				ClientPacketDistributor.sendToServer(new SpecialEffectKeyMessage(1, dt));
				SpecialEffectKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long FLOOT_LASTPRESS = 0;
	private static long SPECIAL_EFFECT_KEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FLOOT);
		event.register(SPECIAL_EFFECT_KEY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				FLOOT.consumeClick();
				SPECIAL_EFFECT_KEY.consumeClick();
			}
		}
	}
}