package net.mangoreggie.blockarmor.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CountdownProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer == 0) {
			BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer = 200;
			BlockArmorModVariables.MapVariables.get(world).markSyncDirty();
		} else {
			BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer = BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer - 1;
			BlockArmorModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}