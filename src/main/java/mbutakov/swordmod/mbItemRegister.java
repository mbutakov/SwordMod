package mbutakov.swordmod;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mbutakov.swordmod.common.items.Sword;
import mbutakov.swordmod.common.items.СharacteristicSword;
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
		//название текстуры иконки/ Название меча / урон /шанс крита(от 0 до 100%)/коофицент крита от основного урона/номер эффекта.
		ItemSwordBleach = new Sword("sword1", "Bleach Sword",new СharacteristicSword(50,10,0.2f), new int[] {6});
		LanguageRegistry.addName(ItemSwordBleach, "Bleach Sword");
		ItemSwordBleach2 = new Sword("sword2", "Bleach Sword 2",new СharacteristicSword(49,30,0.5f), new int[] {2});
		LanguageRegistry.addName(ItemSwordBleach2, "Bleach Sword 2");
		ItemSwordBleach3 = new Sword("sword3", "Bleach Sword 3",new СharacteristicSword(48,40,0.3f), new int[] {3});
		LanguageRegistry.addName(ItemSwordBleach3, "Bleach Sword 3");
		ItemSwordBleach4 = new Sword("sword4", "Bleach Sword 4",new СharacteristicSword(47,5,0.7f), new int[] {4});
		LanguageRegistry.addName(ItemSwordBleach4, "Bleach Sword 4");
		ItemSwordBleach5 = new Sword("sword5", "Bleach Sword 5",new СharacteristicSword(46,35,0.5f), new int[] {5});
		LanguageRegistry.addName(ItemSwordBleach5, "Bleach Sword 5");
		ItemSwordBleach6 = new Sword("sword6", "Bleach Sword 6",new СharacteristicSword(45,65,0.9f), new int[] {6});
		LanguageRegistry.addName(ItemSwordBleach6, "Bleach Sword 6");
		CyanBlade = new Sword("sword7", "Cyan blade",new СharacteristicSword(44,24,0.1f),new int[] {1});
		LanguageRegistry.addName(CyanBlade, "Cyan Blade");
		IdkBlade = new Sword("sword8", "idk blade",new СharacteristicSword(43,31,0.15f),new int[] {5});
		LanguageRegistry.addName(IdkBlade, "IDK Blade");
		
	}

}
