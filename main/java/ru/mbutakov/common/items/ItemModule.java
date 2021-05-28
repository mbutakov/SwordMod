package ru.mbutakov.common.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.mbutakov.Main;
import ru.mbutakov.common.ItemsRegister;
public class ItemModule extends Item {
	
	
	public ItemModule(String name,String nameTexture) {
		super();
		setCreativeTab(Main.mbTabItem);
		setUnlocalizedName(name);
		setMaxStackSize(1);
		this.setRegistryName(name);
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, @Nullable World worldIn, List<String> l, ITooltipFlag flagIn)
    {
		if (is.getItem() == ItemsRegister.Item_m_damage) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Увеличивает урон на 50");
		}
		
		if (is.getItem() == ItemsRegister.Item_m_crit_chance) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Увеличивает крит шанс на 3%");
		}
		
		if (is.getItem() == ItemsRegister.Item_m_crit_cf) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Увеличивает крит кооф на 0.05");
		}
		
		if (is.getItem() == ItemsRegister.item_m_head) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Добовляет шанс на выпадение голов");
			l.add(TextFormatting.DARK_GREEN + "с некоторых мобов");
		}
		
		if (is.getItem() == ItemsRegister.item_m_blind) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Накладывает слепоту");
		}
		
		if (is.getItem() == ItemsRegister.item_m_posion) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Накладывает отравление");
		}
		
		if (is.getItem() == ItemsRegister.item_m_splash3) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Бьет сплешом в радиусе 3");
		}
		
		if (is.getItem() == ItemsRegister.item_m_splash5) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Бьет сплешом в радиусе 5");
		}
		
		if (is.getItem() == ItemsRegister.item_m_deathHit) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Шанс мгновенно убить 1%");
		}
		
		if (is.getItem() == ItemsRegister.item_m_deathHitAdmin) {
			l.add(TextFormatting.GREEN + "Модуль:");
			l.add(TextFormatting.DARK_GREEN + "Шанс мгновенно убить 100%");
		}
    }
	
	

}
