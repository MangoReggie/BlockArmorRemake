package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mangoreggie.blockarmor.BlockArmorMod;

public class GiveAllArmorCodeProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		BlockArmorMod.queueServerWork(400, () -> {
		});
		BlockArmorMod.queueServerWork(800, () -> {
		});
	}
}