package mbutakov.swordmod.client;

import javax.swing.text.html.CSS;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
import mbutakov.swordmod.client.config.SwordModConfig;
import mbutakov.swordmod.client.gui.GuiBlockChangeSkin;
import mbutakov.swordmod.client.handlers.ClientEvents;
import mbutakov.swordmod.client.particle.SwordParticle;
import mbutakov.swordmod.client.particle.SwordParticleInFirstPerson;
import mbutakov.swordmod.client.render.RenderItemSwordBleach;
import mbutakov.swordmod.client.render.RenderItemSwordBleach2;
import mbutakov.swordmod.client.render.RenderItemSwordBleach3;
import mbutakov.swordmod.client.render.RenderItemSwordBleach5;
import mbutakov.swordmod.client.render.RenderItemSwordBleach6;
import mbutakov.swordmod.client.render.RenderItemSwordCyan;
import mbutakov.swordmod.client.render.RenderItemSwordIdk;
import mbutakov.swordmod.common.CommonProxy;
import mbutakov.swordmod.common.items.CharacteristicSword;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
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
	
	
	public static void spawnEffectSwordInFirstPerson(World worldObj, double posX, double posY, double posZ)
	{
		SwordParticleInFirstPerson ef11 = new SwordParticleInFirstPerson(worldObj, posX, posY, posZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(ef11);
	}
	
	@Override
	public void spawnEffectSword(World worldObj,EntityPlayer player, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity,boolean leftHand,double lenght)
	{
	if(!Minecraft.getMinecraft().isGamePaused()) {
		if(SwordModConfig.isOffOtherPlayer != 1) {
			if(player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemSwordMb) {
				CharacteristicSword cs = ((ItemSwordMb)player.getHeldItem().getItem()).getCs(player.getHeldItem());
				if (cs.getCountModules(player.getHeldItem())[9] > 0) { 
					SwordParticle ef11 = new SwordParticle(worldObj, player, posX, posY, posZ, posX2, posY2, posZ2, size, type,leftHand,lenght);
					ef11.setGravity(gravity);
					ef11.shrink = shrink;
					Minecraft.getMinecraft().effectRenderer.addEffect(ef11);
				}
			}
		}
	}
		
	}
	
}