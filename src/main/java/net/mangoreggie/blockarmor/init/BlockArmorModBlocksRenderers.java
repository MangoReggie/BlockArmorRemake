/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mangoreggie.blockarmor.init;

import net.mangoreggie.blockarmor.block.IlluminateBlockBlock;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class BlockArmorModBlocksRenderers {
	public static void clientLoad() {
		IlluminateBlockBlock.registerRenderLayer();
	}
	// Start of user code block custom block renderers
	// End of user code block custom block renderers
}