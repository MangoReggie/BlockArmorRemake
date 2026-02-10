/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mangoreggie.blockarmor.block.IlluminateBlockBlock;
import net.mangoreggie.blockarmor.BlockArmorMod;

import java.util.function.Function;

public class BlockArmorModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BlockArmorMod.MODID);
	public static final DeferredBlock<Block> ILLUMINATE_BLOCK;
	static {
		ILLUMINATE_BLOCK = register("illuminate_block", IlluminateBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}