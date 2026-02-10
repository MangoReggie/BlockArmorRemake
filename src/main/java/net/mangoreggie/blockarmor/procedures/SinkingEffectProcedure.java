package net.mangoreggie.blockarmor.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.ChatFormatting;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;
import net.mangoreggie.blockarmor.event.PlayerEvents;

public class SinkingEffectProcedure {
	public static boolean eventResult = true;

	public SinkingEffectProcedure() {
		PlayerEvents.END_PLAYER_TICK.register(entity -> {
			execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		});
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack enchItem = ItemStack.EMPTY;
		double armorCount = 0;
		double sinkCount = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:sinkable")))) {
			sinkCount = sinkCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:sinkable")))) {
			sinkCount = sinkCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:sinkable")))) {
			sinkCount = sinkCount + 1;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:sinkable")))) {
			sinkCount = sinkCount + 1;
		}
		if (sinkCount >= 2) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) {
				entity.setDeltaMovement(new Vec3(0, (-0.125), 0));
				if (BlockArmorModVariables.WorldVariables.get(world).spaceHeld == true) {
					entity.setDeltaMovement(new Vec3(0, 0.125, 0));
					if (world instanceof ServerLevel _level) {
						_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Spacebar is HELD").withColor(0xff0033).withStyle(ChatFormatting.BOLD), false);
					}
				}
			}
		}
		sinkCount = 0;
	}
}