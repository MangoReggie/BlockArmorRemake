package net.mangoreggie.blockarmor.client.renderer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.mangoreggie.blockarmor.init.BlockArmorModItems;
import net.mangoreggie.blockarmor.init.BlockArmorModArmorModels;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class TuffBricksArmor {
	public static void clientLoad() {
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.TUFF_BRICKS_HELMET, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/tuffbrick_layer_1.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.TUFF_BRICKS_CHESTPLATE, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/tuffbrick_layer_1.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.TUFF_BRICKS_LEGGINGS, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/tuffbrick_layer_2.png");
			}
		});
		BlockArmorModArmorModels.ARMOR_MODELS.put(BlockArmorModItems.TUFF_BRICKS_BOOTS, new BlockArmorModArmorModels.ArmorModel() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("block_armor:textures/models/armor/tuffbrick_layer_1.png");
			}
		});
	}
}