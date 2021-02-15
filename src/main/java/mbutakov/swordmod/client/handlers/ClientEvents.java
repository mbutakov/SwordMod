package mbutakov.swordmod.client.handlers;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
import mbutakov.swordmod.client.ClientProxy;
import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.client.gui.GuiOptionsSwordMod;
import mbutakov.swordmod.client.render.RenderItemSword;
import mbutakov.swordmod.common.items.Sword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import scala.util.continuations.cpsMinus;

public class ClientEvents {

	@SubscribeEvent
	public void tickers(TickEvent.RenderTickEvent event) {
		RenderItemSword.renderTicks = event.renderTickTime;
	}

	@SubscribeEvent
	public void keyPress(KeyInputEvent event) {
		if (ClientProxy.KeyOpenSwordModGui.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiOptionsSwordMod());
		}
	}

	@SubscribeEvent
	public void itemDamageRemove(ItemTooltipEvent event) {
		ItemStack is = event.itemStack;
		if (is.getItem() instanceof Sword) {
			for (int i = 0; i < event.toolTip.size(); i++) {
				if (event.toolTip.get(i).startsWith("§9+")) {
					event.toolTip.remove(i);
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderTwoSword(RenderPlayerEvent.Specials.Post paramPost) {
		EntityPlayer Cplayer = paramPost.entityPlayer;
		double posX = Cplayer.posX;
		double posY = Cplayer.posY;
		double posZ = Cplayer.posZ;
		if (Cplayer.getHeldItem() != null
				&& Cplayer.getHeldItem().getItem() instanceof Sword) {
			if (Cplayer.getHeldItem().getItem() == mbItemRegister.ItemSwordBleach3) {
				if (Minecraft.getMinecraft().thePlayer.ticksExisted % 2 == 0) {
					Main.proxy.spawnEffectSword(Cplayer.worldObj, Cplayer, (double) ((float) posX),
							(double) ((float) posY + Cplayer.eyeHeight - 1.1f), (double) ((float) posZ),
							(double) ((float) posX), (double) ((float) posY + Cplayer.eyeHeight - 1),
							(double) ((float) posZ), 0.25F, 1, true, -1f, true);
				}
				GL11.glPushMatrix();
				paramPost.renderer.modelBipedMain.bipedLeftArm.postRender(0.0625F);
				GL11.glScalef(0.8f, 0.8f, 0.8f);
				if(Cplayer.isBlocking()) {
					GL11.glRotatef(5, 1, 0, 1);
					GL11.glRotatef(20, -1, 1, 0);
					GL11.glRotatef(5, 1, 0, 0);
					GL11.glTranslatef(0f, -0f, 0f);
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach4Tex);
				GL11.glRotatef(-130, 1, 0, 0);
				GL11.glRotatef(0, 0, 0, 1);
				GL11.glTranslatef(0.1f, -0.74f, 0.6f);
				mbResourceLocation.SwordBleach4.renderAll();
				GL11.glPopMatrix();
			}
			if (Cplayer.getHeldItem().getItem() == mbItemRegister.IdkBlade) {
				if (Minecraft.getMinecraft().thePlayer.ticksExisted % 2 == 0) {
					Main.proxy.spawnEffectSword(Cplayer.worldObj, Cplayer, (double) ((float) posX),
							(double) ((float) posY + Cplayer.eyeHeight - 1.1f), (double) ((float) posZ),
							(double) ((float) posX), (double) ((float) posY + Cplayer.eyeHeight - 1),
							(double) ((float) posZ), 0.25F, ((Sword)Cplayer.getHeldItem().getItem()).getColorEffect(), true, -1f, true);
				}
				GL11.glPushMatrix();
				paramPost.renderer.modelBipedMain.bipedLeftArm.postRender(0.0625F);
				GL11.glScalef(0.8f, 0.8f, 0.8f);
				if(Cplayer.isBlocking()) {
					GL11.glRotatef(5, 1, 0, 1);
					GL11.glRotatef(20, -1, 1, 0);
					GL11.glRotatef(5, 1, 0, 0);
					GL11.glTranslatef(0f, -0f, 0f);
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.IdkBladeTex);
				GL11.glRotatef(-130, 1, 0, 0);
				GL11.glRotatef(0, 0, 0, 1);
				GL11.glTranslatef(0.1f, -0.74f, 0.6f);
				mbResourceLocation.IdkBlade.renderAll();
				GL11.glPopMatrix();
			}
		}
	}

}
