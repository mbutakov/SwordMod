package mbutakov.swordmod.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
import mbutakov.swordmod.client.config.SwordModConfig;
import mbutakov.swordmod.client.gui.GuiBlockChangeSkin;
import mbutakov.swordmod.client.handlers.ClientEvents;
import mbutakov.swordmod.client.particle.SwordParticle;
import mbutakov.swordmod.client.render.RenderItemSwordBleach;
import mbutakov.swordmod.client.render.RenderItemSwordBleach2;
import mbutakov.swordmod.client.render.RenderItemSwordBleach3;
import mbutakov.swordmod.client.render.RenderItemSwordBleach5;
import mbutakov.swordmod.client.render.RenderItemSwordBleach6;
import mbutakov.swordmod.client.render.RenderItemSwordCyan;
import mbutakov.swordmod.client.render.RenderItemSwordIdk;
import mbutakov.swordmod.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public static KeyBinding KeyOpenSwordModGui;
	
	
	public void preInit() {
		super.preInit();
	}

	public void Init() {
		super.Init();
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.ItemSwordBleach, new RenderItemSwordBleach());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.ItemSwordBleach2, new RenderItemSwordBleach2());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.ItemSwordBleach3, new RenderItemSwordBleach3());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.ItemSwordBleach5, new RenderItemSwordBleach5());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.ItemSwordBleach6, new RenderItemSwordBleach6());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.CyanBlade, new RenderItemSwordCyan());
		MinecraftForgeClient.registerItemRenderer(mbItemRegister.IdkBlade, new RenderItemSwordIdk());
		KeyOpenSwordModGui = new KeyBinding("Настроки" + Main.MODID, Keyboard.KEY_H, Main.MODID);
		ClientRegistry.registerKeyBinding(KeyOpenSwordModGui);
		final ClientEvents cevents = new ClientEvents();
		MinecraftForge.EVENT_BUS.register(cevents);
		FMLCommonHandler.instance().bus().register(cevents);
	}
	
	@Override
	public void spawnEffectSword(World worldObj,EntityPlayer player, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity,boolean leftHand)
	{
	if(!Minecraft.getMinecraft().isGamePaused()) {
		if(SwordModConfig.isOffOtherPlayer != 1) {
			SwordParticle ef11 = new SwordParticle(worldObj, player, posX, posY, posZ, posX2, posY2, posZ2, size, type,leftHand);
			ef11.setGravity(gravity);
			ef11.shrink = shrink;
			Minecraft.getMinecraft().effectRenderer.addEffect(ef11);
		}
	}
		
	}
	
}