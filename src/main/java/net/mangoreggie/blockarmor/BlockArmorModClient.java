package net.mangoreggie.blockarmor;

import net.mangoreggie.blockarmor.network.BlockArmorModVariables;
import net.mangoreggie.blockarmor.init.BlockArmorModKeyMappings;
import net.mangoreggie.blockarmor.init.BlockArmorModBlocksRenderers;
import net.mangoreggie.blockarmor.init.BlockArmorModArmorModels;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class BlockArmorModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		BlockArmorModBlocksRenderers.clientLoad();
		BlockArmorModArmorModels.clientLoad();
		BlockArmorModKeyMappings.clientLoad();
		ClientPlayNetworking.registerGlobalReceiver(BlockArmorModVariables.SavedDataSyncMessage.TYPE, BlockArmorModVariables.SavedDataSyncMessage::handleData);
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}