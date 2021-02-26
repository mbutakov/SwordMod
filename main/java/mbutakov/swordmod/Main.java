package mbutakov.swordmod;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import mbutakov.swordmod.client.config.SwordModConfig;
import mbutakov.swordmod.common.CommonProxy;
import mbutakov.swordmod.common.mbGuiHandler;
import mbutakov.swordmod.common.blocks.blockChangeSkin.TileEntityBlockChangeSkin;
import mbutakov.swordmod.utils.mbCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "mbSwordMod", name = "mbSwordMod", version = "0.1")
public class Main {

	@SidedProxy(clientSide = "mbutakov.swordmod.client.ClientProxy", serverSide = "mbutakov.swordmod.common.CommonProxy")
	public static CommonProxy proxy;
	public static final mbCreativeTab swordTab = new mbCreativeTab("Sword Tab");
	public static final String MODID = "mbSwordMod";
	public static final String NAME = "mbSwordMod";
	public static final String VERSION = "0.1";
	public static final String MC_VERSION = "1.7.10";	
	@Instance(Main.MODID)
	public static Main instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new mbGuiHandler());
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			SwordModConfig.load();
		}
		proxy.preInit();
		GameRegistry.registerTileEntity(TileEntityBlockChangeSkin.class, "TileEntityBlockChangeSkin");
		mbMaterialSword.addMaterialSword();
		mbBlocksRegister.registerBlocks();
		mbItemRegister.registerItems();
	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		proxy.Init();
	}

	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		    
	}
	
}
