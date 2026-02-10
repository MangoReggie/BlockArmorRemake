package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;

public class EffectKeyPressedProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world) {
		BlockArmorModVariables.WorldVariables.get(world).effectKeyHeld = true;
		BlockArmorModVariables.WorldVariables.get(world).markSyncDirty();
	}
}