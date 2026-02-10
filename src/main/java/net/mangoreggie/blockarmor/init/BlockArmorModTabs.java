/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mangoreggie.blockarmor.BlockArmorMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class BlockArmorModTabs {
	public static ResourceKey<CreativeModeTab> TAB_BLOCK_ARMOR = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(BlockArmorMod.MODID, "block_armor"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_BLOCK_ARMOR,
				FabricItemGroup.builder().title(Component.translatable("item_group.block_armor.block_armor")).icon(() -> new ItemStack(BlockArmorModItems.DIRT_CHESTPLATE)).displayItems((parameters, tabData) -> {
					tabData.accept(BlockArmorModItems.DIRT_HELMET);
					tabData.accept(BlockArmorModItems.DIRT_CHESTPLATE);
					tabData.accept(BlockArmorModItems.DIRT_LEGGINGS);
					tabData.accept(BlockArmorModItems.DIRT_BOOTS);
					tabData.accept(BlockArmorModItems.STONE_HELMET);
					tabData.accept(BlockArmorModItems.STONE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.STONE_LEGGINGS);
					tabData.accept(BlockArmorModItems.STONE_BOOTS);
					tabData.accept(BlockArmorModItems.GRANITE_HELMET);
					tabData.accept(BlockArmorModItems.GRANITE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.GRANITE_LEGGINGS);
					tabData.accept(BlockArmorModItems.GRANITE_BOOTS);
					tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_HELMET);
					tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_CHESTPLATE);
					tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_LEGGINGS);
					tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_BOOTS);
					tabData.accept(BlockArmorModItems.OBSIDIAN_HELMET);
					tabData.accept(BlockArmorModItems.OBSIDIAN_CHESTPLATE);
					tabData.accept(BlockArmorModItems.OBSIDIAN_LEGGINGS);
					tabData.accept(BlockArmorModItems.OBSIDIAN_BOOTS);
					tabData.accept(BlockArmorModItems.AMETHYST_HELMET);
					tabData.accept(BlockArmorModItems.AMETHYST_CHESTPLATE);
					tabData.accept(BlockArmorModItems.AMETHYST_LEGGINGS);
					tabData.accept(BlockArmorModItems.AMETHYST_BOOTS);
					tabData.accept(BlockArmorModItems.HONEY_COMB_HELMET);
					tabData.accept(BlockArmorModItems.HONEY_COMB_CHESTPLATE);
					tabData.accept(BlockArmorModItems.HONEY_COMB_LEGGINGS);
					tabData.accept(BlockArmorModItems.HONEY_COMB_BOOTS);
					tabData.accept(BlockArmorModItems.TUFF_HELMET);
					tabData.accept(BlockArmorModItems.TUFF_CHESTPLATE);
					tabData.accept(BlockArmorModItems.TUFF_LEGGINGS);
					tabData.accept(BlockArmorModItems.TUFF_BOOTS);
					tabData.accept(BlockArmorModItems.GLOWSTONE_HELMET);
					tabData.accept(BlockArmorModItems.GLOWSTONE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.GLOWSTONE_LEGGINGS);
					tabData.accept(BlockArmorModItems.GLOWSTONE_BOOTS);
					tabData.accept(BlockArmorModItems.SPONGE_HELMET);
					tabData.accept(BlockArmorModItems.SPONGE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.SPONGE_LEGGINGS);
					tabData.accept(BlockArmorModItems.SPONGE_BOOTS);
					tabData.accept(BlockArmorModItems.TUFF_BRICKS_HELMET);
					tabData.accept(BlockArmorModItems.TUFF_BRICKS_CHESTPLATE);
					tabData.accept(BlockArmorModItems.TUFF_BRICKS_LEGGINGS);
					tabData.accept(BlockArmorModItems.TUFF_BRICKS_BOOTS);
					tabData.accept(BlockArmorModItems.OAK_PLANK_HELMET);
					tabData.accept(BlockArmorModItems.OAK_PLANK_CHESTPLATE);
					tabData.accept(BlockArmorModItems.OAK_PLANK_LEGGINGS);
					tabData.accept(BlockArmorModItems.OAK_PLANK_BOOTS);
					tabData.accept(BlockArmorModItems.CHORUS_FLOWER_HELMET);
					tabData.accept(BlockArmorModItems.CHORUS_FLOWER_CHESTPLATE);
					tabData.accept(BlockArmorModItems.CHORUS_FLOWER_LEGGINGS);
					tabData.accept(BlockArmorModItems.CHORUS_FLOWER_BOOTS);
					tabData.accept(BlockArmorModItems.MELON_HELMET);
					tabData.accept(BlockArmorModItems.MELON_CHESTPLATE);
					tabData.accept(BlockArmorModItems.MELON_LEGGINGS);
					tabData.accept(BlockArmorModItems.MELON_BOOTS);
					tabData.accept(BlockArmorModItems.RED_SANDSTONE_HELMET);
					tabData.accept(BlockArmorModItems.RED_SANDSTONE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.RED_SANDSTONE_LEGGINGS);
					tabData.accept(BlockArmorModItems.RED_SANDSTONE_BOOTS);
					tabData.accept(BlockArmorModItems.BOOKSHELF_HELMET);
					tabData.accept(BlockArmorModItems.BOOKSHELF_CHESTPLATE);
					tabData.accept(BlockArmorModItems.BOOKSHELF_LEGGINGS);
					tabData.accept(BlockArmorModItems.BOOKSHELF_BOOTS);
					tabData.accept(BlockArmorModItems.JACK_O_LANTERN_HELMET);
					tabData.accept(BlockArmorModItems.JACK_O_LANTERN_CHESTPLATE);
					tabData.accept(BlockArmorModItems.JACK_O_LANTERN_LEGGINGS);
					tabData.accept(BlockArmorModItems.JACK_O_LANTERN_BOOTS);
					tabData.accept(BlockArmorModItems.RED_MUSHROOM_HELMET);
					tabData.accept(BlockArmorModItems.RED_MUSHROOM_CHESTPLATE);
					tabData.accept(BlockArmorModItems.RED_MUSHROOM_LEGGINGS);
					tabData.accept(BlockArmorModItems.RED_MUSHROOM_BOOTS);
					tabData.accept(BlockArmorModItems.CALCITE_HELMET);
					tabData.accept(BlockArmorModItems.CALCITE_CHESTPLATE);
					tabData.accept(BlockArmorModItems.CALCITE_LEGGINGS);
					tabData.accept(BlockArmorModItems.CALCITE_BOOTS);
					tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_HELMET);
					tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_CHESTPLATE);
					tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_LEGGINGS);
					tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_BOOTS);
				}).build());
	}
}