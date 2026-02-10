package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;
import net.mangoreggie.blockarmor.event.PlayerEvents;

public class XPEffectProcedure {
	public static boolean eventResult = true;

	public XPEffectProcedure() {
		PlayerEvents.END_PLAYER_TICK.register(entity -> {
			execute(entity.level(), entity);
		});
	}

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack enchItem = ItemStack.EMPTY;
		double armorCount = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:xp")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:xp")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:xp")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:xp")))) {
			armorCount = armorCount + 1;
		}
		if (BlockArmorModVariables.MapVariables.get(world).BlockArmorTimer == 0 && armorCount >= 2) {
			if (entity instanceof Player _player) {
				_player.giveExperiencePoints(1);
			}
		}
		armorCount = 0;
	}
}