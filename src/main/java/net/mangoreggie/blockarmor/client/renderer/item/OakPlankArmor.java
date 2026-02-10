package net.mangoreggie.blockarmor.client.renderer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.mangoreggie.blockarmor.init.BlockArmorModItems;
import net.mangoreggie.blockarmor.init.BlockArmorModArmorModels;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class OakPlankArmor {
	public static void clientLoad() {
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.OAK_PLANK_HELMET, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/oak_planks_layer_1.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.OAK_PLANK_CHESTPLATE, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/oak_planks_layer_1.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.OAK_PLANK_LEGGINGS, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/oak_planks_layer_2.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.OAK_PLANK_BOOTS, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/oak_planks_layer_1.png");
			}
		});
	}
}