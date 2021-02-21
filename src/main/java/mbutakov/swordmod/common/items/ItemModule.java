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
		if (is.getItem() == mbItemRegister.Item_m_damage) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Увеличивает урон на 50");
		}
		
		if (is.getItem() == mbItemRegister.Item_m_crit_chance) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Увеличивает крит шанс на 3%");
		}
		
		if (is.getItem() == mbItemRegister.Item_m_crit_cf) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Увеличивает крит кооф на 0.05");
		}
		
		if (is.getItem() == mbItemRegister.item_m_head) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Добовляет шанс на выпадение голов");
			l.add(EnumChatFormatting.DARK_GREEN + "с некоторых мобов");
		}
		
		if (is.getItem() == mbItemRegister.item_m_blind) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Накладывает слепоту");
		}
		
		if (is.getItem() == mbItemRegister.item_m_posion) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Накладывает отравление");
		}
		
		if (is.getItem() == mbItemRegister.item_m_splash3) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Бьет сплешом в радиусе 3");
		}
		
		if (is.getItem() == mbItemRegister.item_m_splash5) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Бьет сплешом в радиусе 5");
		}
		
		if (is.getItem() == mbItemRegister.item_m_deathHit) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Шанс мгновенно убить 1%");
		}
		
		if (is.getItem() == mbItemRegister.item_m_effectOn) {
			l.add(EnumChatFormatting.GREEN + "Модуль:");
			l.add(EnumChatFormatting.DARK_GREEN + "Включает частицы");
		}
    }
	
	

}
