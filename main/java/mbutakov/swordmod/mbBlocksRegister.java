package mbutakov.swordmod;

import cpw.mods.fml.common.registry.GameRegistry;
import mbutakov.swordmod.common.blocks.blockChangeSkin.BlockChangeSkin;
import net.minecraft.block.Block;

public class mbBlocksRegister {

    public static Block blockChangeSkins = new BlockChangeSkin();;
    
	public static void registerBlocks() {
        GameRegistry.registerBlock(blockChangeSkins, "blockChangeSkins");
	}
}
