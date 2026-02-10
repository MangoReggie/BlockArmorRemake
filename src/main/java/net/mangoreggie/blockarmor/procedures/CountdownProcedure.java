package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class CountdownProcedure {
	public static boolean eventResult = true;

	public CountdownProcedure() {
		ServerTickEvents.END_WORLD_TICK.register((level) -> {
			execute(level);
		});
	}

	public static void execute(LevelAccessor world) {
		if (BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer == 0) {
			BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer = 200;
			BlockArmorModVariables.MapVariables.get(world).markSyncDirty();
		} else {
			BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer = BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer - 1;
			BlockArmorModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}