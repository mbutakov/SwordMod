package mbutakov.swordmod.utils;

import mbutakov.swordmod.mbItemRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class mbCreativeTab extends CreativeTabs {

	public mbCreativeTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return mbItemRegister.CyanBlade;
	}
}