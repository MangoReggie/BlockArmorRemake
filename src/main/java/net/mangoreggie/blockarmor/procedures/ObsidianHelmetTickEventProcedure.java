package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mangoreggie.blockarmor.event.PlayerEvents;

public class ObsidianHelmetTickEventProcedure {
	public static boolean eventResult = true;

	public ObsidianHelmetTickEventProcedure() {
		PlayerEvents.END_PLAYER_TICK.register(entity -> {
			execute(entity.level(), entity);
		});
	}

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double armorCount = 0;
		ItemStack enchItem = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))) {
			armorCount = armorCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))) {
			armorCount = armorCount + 1;
		}
		if (armorCount >= 2) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))
					&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getEnchantments()
							.getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) == false) {
				enchItem = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).copy();
				enchItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 4);
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, enchItem);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))
					&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getEnchantments()
							.getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) == false) {
				enchItem = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).copy();
				enchItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 4);
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, enchItem);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))
					&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getEnchantments()
							.getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) == false) {
				enchItem = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).copy();
				enchItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 4);
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, enchItem);
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:obsidian_armor")))
					&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantments()
							.getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) == false) {
				enchItem = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).copy();
				enchItem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION), 4);
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, enchItem);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2, 4, false, false));
			}
		}
		armorCount = 0;
	}
}