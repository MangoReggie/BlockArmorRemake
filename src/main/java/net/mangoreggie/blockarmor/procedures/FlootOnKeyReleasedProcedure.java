package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;

public class FlootOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world) {
		BlockArmorModVariables.WorldVariables.get(world).spaceHeld = false;
		BlockArmorModVariables.WorldVariables.get(world).markSyncDirty();
	}
}