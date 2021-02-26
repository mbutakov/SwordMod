package mbutakov.swordmod.common;

import cpw.mods.fml.common.network.IGuiHandler;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.client.gui.GuiBlockChangeSkin;
import mbutakov.swordmod.common.blocks.blockChangeSkin.ContainerBlockChangeSkin;
import mbutakov.swordmod.common.blocks.blockChangeSkin.TileEntityBlockChangeSkin;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class mbGuiHandler implements IGuiHandler {
	
    
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case 1:
		         return new ContainerBlockChangeSkin(player.inventory, world);
			default:
				return null;
		}
	}
    
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	switch (ID) {
    		case 1:
    		    return new GuiBlockChangeSkin(player.inventory, world);
    		default:
    			return null;
    	}
    }
    
}