package mbutakov.swordmod.common;

import mbutakov.swordmod.common.blocks.blockChangeSkin.ContainerBlockChangeSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class CommonProxy {

	public void preInit() {

	}

	public void Init() {

	}

	public void spawnEffectSword(World worldObj, EntityPlayer player, double posX, double posY, double posZ,
			double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity,
			boolean leftHand) {
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
