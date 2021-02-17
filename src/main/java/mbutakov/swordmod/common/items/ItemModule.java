package mbutakov.swordmod.common.items;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemModule extends Item {
	
	
	
	
	public ItemModule(String name,String nameTexture) {
		super();
		setCreativeTab(Main.swordTab);
		setTextureName("mbswordmod:" + nameTexture);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this,name);
		setMaxStackSize(1);
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer ep, List l, boolean p_77624_4_) {
    	if(is.getItem() == mbItemRegister.Item_m_damage) {
    		l.add(EnumChatFormatting.GREEN + "Модуль:");
    		l.add(EnumChatFormatting.GREEN + "Увеличивает урон на 50");
    	}
    	if(is.getItem() == mbItemRegister.Item_m_crit_chance) {
    		l.add(EnumChatFormatting.GREEN + "Модуль:");
    		l.add(EnumChatFormatting.GREEN + "Увеличивает крит шанс на 3%");
    	}
    	if(is.getItem() == mbItemRegister.Item_m_crit_cf) {
    		l.add(EnumChatFormatting.GREEN + "Модуль:");
    		l.add(EnumChatFormatting.GREEN + "Увеличивает крит кооф на 0.05");
    	}
    }
	
	

}
