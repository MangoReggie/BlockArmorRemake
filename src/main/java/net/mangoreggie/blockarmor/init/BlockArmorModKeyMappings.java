/*
* MCreator note: This file will be REGENERATED on each build.
*/
package net.mangoreggie.blockarmor.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mangoreggie.blockarmor.network.SpecialEffectKeyMessage;
import net.mangoreggie.blockarmor.network.FlootMessage;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class BlockArmorModKeyMappings {
	public static final KeyMapping FLOOT = new KeyMapping("key.block_armor.floot", GLFW.GLFW_KEY_SPACE, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPlayNetworking.send(new FlootMessage(0, 0));
				FlootMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FLOOT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLOOT_LASTPRESS);
				ClientPlayNetworking.send(new FlootMessage(1, dt));
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
				ClientPlayNetworking.send(new SpecialEffectKeyMessage(0, 0));
				SpecialEffectKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SPECIAL_EFFECT_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SPECIAL_EFFECT_KEY_LASTPRESS);
				ClientPlayNetworking.send(new SpecialEffectKeyMessage(1, dt));
				SpecialEffectKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long FLOOT_LASTPRESS = 0;
	private static long SPECIAL_EFFECT_KEY_LASTPRESS = 0;

	public static void clientLoad() {
		KeyBindingHelper.registerKeyBinding(FLOOT);
		KeyBindingHelper.registerKeyBinding(SPECIAL_EFFECT_KEY);
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			if (client.screen == null) {
				FLOOT.consumeClick();
				SPECIAL_EFFECT_KEY.consumeClick();
			}
		});
	}
}