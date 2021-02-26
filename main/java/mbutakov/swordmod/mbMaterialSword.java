package mbutakov.swordmod;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class mbMaterialSword {
	public static ToolMaterial Bleach;
	public static void addMaterialSword() {
		Bleach = EnumHelper.addToolMaterial("Bleach", 2, -1, 10F, 0f, 17); 
		
	}
	
	
}
