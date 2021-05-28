package ru.mbutakov.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import ru.mbutakov.Main;
import ru.mbutakov.common.blocks.BlockUpgrader.BlockUpgrader;

public class BlocksRegister {

	public static Block tutorialBlock;

	public static void preInit() {
		tutorialBlock = new BlockUpgrader(Material.ROCK, "tutorial_block");
		registerBlocks();
	}

	public static void registerBlocks() {
		registerBlock(tutorialBlock);
	}

	public static void registerBlock(Block block) {
		 ForgeRegistries.BLOCKS.register(block);
	     ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	     
	}

	public static void registerRenders() {
		registerRender(tutorialBlock);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
