package mbutakov.swordmod;

import cpw.mods.fml.common.registry.GameRegistry;
import mbutakov.swordmod.common.items.Sword;
import net.minecraft.item.Item;

public class mbItemRegister {
	
	public static Item ItemSwordBleach;
	public static Item ItemSwordBleach2;
	public static Item ItemSwordBleach3;
	public static Item ItemSwordBleach4;
	public static Item ItemSwordBleach5;
	public static Item ItemSwordBleach6;
	public static Item CyanBlade;
	public static Item IdkBlade;
	
	public static void registerItems() {
		ItemSwordBleach = new Sword("abv", "Bleach Sword",50,10,1.2f, new int[] {6});
		ItemSwordBleach2 = new Sword("abv", "Bleach Sword 2",49,30,1.5f, new int[] {2});
		ItemSwordBleach3 = new Sword("abv", "Bleach Sword 3",48,40,1.3f, new int[] {3});
		ItemSwordBleach4 = new Sword("abv", "Bleach Sword 4",47,5,1.7f, new int[] {4});
		ItemSwordBleach5 = new Sword("abv", "Bleach Sword 5",46,35,2.5f, new int[] {5});
		ItemSwordBleach6 = new Sword("abv", "Bleach Sword 6",45,65,1.9f, new int[] {6});
		CyanBlade = new Sword("abv", "Cyan blade",44,24,1.1f,new int[] {3});
		IdkBlade = new Sword("abv", "idk blade",43,31,1.15f,new int[] {5});
		
	}

}
