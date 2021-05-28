package ru.mbutakov;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import ru.mbutakov.common.BlocksRegister;
import ru.mbutakov.common.CommonProxy;
import ru.mbutakov.common.GuiHandler;
import ru.mbutakov.common.ItemsRegister;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
	
	public static final String MODID = "mswordmod";
	public static final String PROJECTNAME = "Aurora";
	public static final String NAME = "mswordmod";
	public static final String VERSION = "0.1";

	@Instance(Main.MODID)
	public static Main instance;	
	
	
    @SidedProxy(clientSide = "ru.mbutakov.client.ClientProxy", serverSide = "ru.mbutakov.common.CommonProxy")
    public static CommonProxy proxy;
	public static SimpleNetworkWrapper network;
	

    public static final CreativeTabs mbTabItem = new CreativeTabs("mbItems") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemsRegister.ItemSwordBleach);
        }
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
	    network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
	    BlocksRegister.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
    
}
