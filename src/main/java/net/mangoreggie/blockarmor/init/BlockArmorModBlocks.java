/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mangoreggie.blockarmor.block.IlluminateBlockBlock;
import net.mangoreggie.blockarmor.BlockArmorMod;

import java.util.function.Function;

public class BlockArmorModBlocks {
	public static Block ILLUMINATE_BLOCK;

	public static void load() {
		ILLUMINATE_BLOCK = register("illuminate_block", IlluminateBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BlockArmorMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}