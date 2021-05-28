package ru.mbutakov.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import ru.mbutakov.Main;
import ru.mbutakov.common.BlocksRegister;
import ru.mbutakov.common.CommonProxy;
import ru.mbutakov.common.ItemsRegister;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		OBJLoader.INSTANCE.addDomain(Main.MODID);
		registerModel(ItemsRegister.ItemSwordBleach);

	}

	@Override
	public void init() {
		super.init();
		ItemsRegister.registerRender();
		BlocksRegister.registerRenders();
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
	}

	public void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(Main.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	@Override
	public void postInit() {
		super.postInit();
	}

}
