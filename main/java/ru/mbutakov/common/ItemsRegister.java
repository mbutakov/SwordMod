package ru.mbutakov.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.mbutakov.common.items.CharacteristicSword;
import ru.mbutakov.common.items.ItemAuroraSword;
import ru.mbutakov.common.items.ItemModule;


public class ItemsRegister
{
	public static Item ItemSwordBleach = new ItemAuroraSword("sword1", new CharacteristicSword(50,10,0.2f), new int[] {4});
	public static Item ItemSwordBleach2 = new ItemAuroraSword("Bleach Sword 2",new CharacteristicSword(49,30,0.5f), new int[] {2});
	public static Item ItemSwordBleach3 = new ItemAuroraSword("Bleach Sword 3",new CharacteristicSword(48,40,0.3f), new int[] {2});
	public static Item ItemSwordBleach5 = new ItemAuroraSword("Bleach Sword 5",new CharacteristicSword(46,35,0.5f), new int[] {3});
	public static Item ItemSwordBleach6 = new ItemAuroraSword("Bleach Sword 6",new CharacteristicSword(45,65,0.9f), new int[] {8});
	public static Item CyanBlade = new ItemAuroraSword("Cyan blade",new CharacteristicSword(44,24,0.1f),new int[] {3});
	public static Item IdkBlade = new ItemAuroraSword("idk blade",new CharacteristicSword(43,31,0.15f),new int[] {6});
	public static Item Item_m_damage = new ItemModule("Module Damage","m_damage");
	public static Item Item_m_crit_chance = new ItemModule("Module Crit","m_crit");
	public static Item Item_m_crit_cf = new ItemModule("Module CritCf","m_critCf");
	public static Item item_m_head = new ItemModule("Module Head","m_head");
	public static Item item_m_splash3 = new ItemModule("Module Splash 3","m_splash3");
	public static Item item_m_splash5 = new ItemModule("Module Splash 5","m_splash5");
	public static Item item_m_posion = new ItemModule("Module posion","m_posion");
	public static Item item_m_blind = new ItemModule("Module Blind","m_eye");
	public static Item item_m_deathHit = new ItemModule("Module DeathHit","m_deathHit");
	public static Item item_m_deathHitAdmin = new ItemModule("Module DeathHitA","m_deathHitA");


    public static void register()
    {	
    	setRegister(ItemSwordBleach);
    	setRegister(ItemSwordBleach2);
    	setRegister(ItemSwordBleach3);
    	setRegister(ItemSwordBleach5);
    	setRegister(ItemSwordBleach6);
    	setRegister(CyanBlade);
    	setRegister(IdkBlade);
    	setRegister(Item_m_damage);
    	setRegister(Item_m_crit_chance);
    	setRegister(Item_m_crit_cf);
    	setRegister(item_m_head);
    	setRegister(item_m_splash3);
    	setRegister(item_m_splash5);
    	setRegister(item_m_posion);
    	setRegister(item_m_blind);
    	setRegister(item_m_deathHit);
    	setRegister(item_m_deathHitAdmin);
    	

    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
    	setRender(ItemSwordBleach);
    	setRender(ItemSwordBleach2);
    	setRender(ItemSwordBleach3);
    	setRender(ItemSwordBleach5);
    	setRender(ItemSwordBleach6);
    	setRender(CyanBlade);
    	setRender(IdkBlade);
    	setRender(Item_m_damage);
    	setRender(Item_m_crit_chance);
    	setRender(Item_m_crit_cf);
    	setRender(item_m_head);
    	setRender(item_m_splash3);
    	setRender(item_m_splash5);
    	setRender(item_m_posion);
    	setRender(item_m_blind);
    	setRender(item_m_deathHit);
    	setRender(item_m_deathHitAdmin);
    	
    	
    }

    private static void setRegister(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
