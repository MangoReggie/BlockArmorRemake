/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.mangoreggie.blockarmor.network.SpecialEffectKeyMessage;
import net.mangoreggie.blockarmor.network.FlootMessage;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class BlockArmorModKeyMappingsServer {
	public static void serverLoad() {
		PayloadTypeRegistry.playC2S().register(FlootMessage.TYPE, FlootMessage.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(FlootMessage.TYPE, FlootMessage::handleData);
		PayloadTypeRegistry.playC2S().register(SpecialEffectKeyMessage.TYPE, SpecialEffectKeyMessage.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(SpecialEffectKeyMessage.TYPE, SpecialEffectKeyMessage::handleData);
	}
}