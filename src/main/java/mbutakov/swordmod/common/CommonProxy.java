package mbutakov.swordmod.common;

import cpw.mods.fml.common.FMLCommonHandler;
import mbutakov.swordmod.common.blocks.blockChangeSkin.ContainerBlockChangeSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void preInit() {

	}

	public void Init() {
		CommonEvents ce = new CommonEvents();
		MinecraftForge.EVENT_BUS.register(ce);
		FMLCommonHandler.instance().bus().register(ce);
	}

	public void spawnEffectSword(World worldObj, EntityPlayer player, double posX, double posY, double posZ,
			double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity,
			boolean leftHand,double lenght) {
		// TODO Auto-generated method stub
	}

	public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public Container getServerGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			return new ContainerBlockChangeSkin(player.inventory, world);
		}
		return null;
	}
}
