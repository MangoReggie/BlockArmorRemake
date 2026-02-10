/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.mangoreggie.blockarmor.command.GiveAllArmorCommand;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class BlockArmorModCommands {
	public static void load() {
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, environment) -> {
			GiveAllArmorCommand.register(dispatcher, commandBuildContext, environment);
		});
	}
}