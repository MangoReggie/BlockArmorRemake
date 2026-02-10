/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mangoreggie.blockarmor.BlockArmorMod;

public class BlockArmorModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockArmorMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCK_ARMOR = REGISTRY.register("block_armor",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.block_armor.block_armor")).icon(() -> new ItemStack(BlockArmorModItems.DIRT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(BlockArmorModItems.DIRT_HELMET.get());
				tabData.accept(BlockArmorModItems.DIRT_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.DIRT_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.DIRT_BOOTS.get());
				tabData.accept(BlockArmorModItems.STONE_HELMET.get());
				tabData.accept(BlockArmorModItems.STONE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.STONE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.STONE_BOOTS.get());
				tabData.accept(BlockArmorModItems.GRANITE_HELMET.get());
				tabData.accept(BlockArmorModItems.GRANITE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.GRANITE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.GRANITE_BOOTS.get());
				tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_HELMET.get());
				tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.MOSSY_STONE_BRICK_BOOTS.get());
				tabData.accept(BlockArmorModItems.OBSIDIAN_HELMET.get());
				tabData.accept(BlockArmorModItems.OBSIDIAN_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.OBSIDIAN_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.OBSIDIAN_BOOTS.get());
				tabData.accept(BlockArmorModItems.AMETHYST_HELMET.get());
				tabData.accept(BlockArmorModItems.AMETHYST_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.AMETHYST_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.AMETHYST_BOOTS.get());
				tabData.accept(BlockArmorModItems.HONEY_COMB_HELMET.get());
				tabData.accept(BlockArmorModItems.HONEY_COMB_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.HONEY_COMB_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.HONEY_COMB_BOOTS.get());
				tabData.accept(BlockArmorModItems.TUFF_HELMET.get());
				tabData.accept(BlockArmorModItems.TUFF_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.TUFF_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.TUFF_BOOTS.get());
				tabData.accept(BlockArmorModItems.GLOWSTONE_HELMET.get());
				tabData.accept(BlockArmorModItems.GLOWSTONE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.GLOWSTONE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.GLOWSTONE_BOOTS.get());
				tabData.accept(BlockArmorModItems.SPONGE_HELMET.get());
				tabData.accept(BlockArmorModItems.SPONGE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.SPONGE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.SPONGE_BOOTS.get());
				tabData.accept(BlockArmorModItems.TUFF_BRICKS_HELMET.get());
				tabData.accept(BlockArmorModItems.TUFF_BRICKS_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.TUFF_BRICKS_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.TUFF_BRICKS_BOOTS.get());
				tabData.accept(BlockArmorModItems.OAK_PLANK_HELMET.get());
				tabData.accept(BlockArmorModItems.OAK_PLANK_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.OAK_PLANK_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.OAK_PLANK_BOOTS.get());
				tabData.accept(BlockArmorModItems.CHORUS_FLOWER_HELMET.get());
				tabData.accept(BlockArmorModItems.CHORUS_FLOWER_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.CHORUS_FLOWER_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.CHORUS_FLOWER_BOOTS.get());
				tabData.accept(BlockArmorModItems.MELON_HELMET.get());
				tabData.accept(BlockArmorModItems.MELON_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.MELON_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.MELON_BOOTS.get());
				tabData.accept(BlockArmorModItems.RED_SANDSTONE_HELMET.get());
				tabData.accept(BlockArmorModItems.RED_SANDSTONE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.RED_SANDSTONE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.RED_SANDSTONE_BOOTS.get());
				tabData.accept(BlockArmorModItems.BOOKSHELF_HELMET.get());
				tabData.accept(BlockArmorModItems.BOOKSHELF_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.BOOKSHELF_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.BOOKSHELF_BOOTS.get());
				tabData.accept(BlockArmorModItems.JACK_O_LANTERN_HELMET.get());
				tabData.accept(BlockArmorModItems.JACK_O_LANTERN_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.JACK_O_LANTERN_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.JACK_O_LANTERN_BOOTS.get());
				tabData.accept(BlockArmorModItems.RED_MUSHROOM_HELMET.get());
				tabData.accept(BlockArmorModItems.RED_MUSHROOM_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.RED_MUSHROOM_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.RED_MUSHROOM_BOOTS.get());
				tabData.accept(BlockArmorModItems.CALCITE_HELMET.get());
				tabData.accept(BlockArmorModItems.CALCITE_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.CALCITE_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.CALCITE_BOOTS.get());
				tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_HELMET.get());
				tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_CHESTPLATE.get());
				tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_LEGGINGS.get());
				tabData.accept(BlockArmorModItems.BROWN_MUSHROOM_BOOTS.get());
			}).withSearchBar().build());
}