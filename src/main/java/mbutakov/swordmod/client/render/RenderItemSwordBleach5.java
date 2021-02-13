package mbutakov.swordmod.client.render;

import org.lwjgl.opengl.GL11;

import mbutakov.swordmod.Main;
import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.common.items.Sword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderItemSwordBleach5 implements IItemRenderer {

	
	public RenderItemSwordBleach5() {
	}
	
	
	
	@Override
	public boolean handleRenderType(ItemStack is, ItemRenderType type) {
		if (type == ItemRenderType.INVENTORY) return false;
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
		if (type == ItemRenderType.INVENTORY) return false;
		return true;
	}
	
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
		RenderHelper.disableStandardItemLighting();
		Minecraft mc = Minecraft.getMinecraft();
		EntityClientPlayerMP Cplayer = mc.thePlayer;
		GL11.glPushMatrix();
		if(type == ItemRenderType.INVENTORY) {
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			GL11.glTranslatef(0f, -1f, 0);
			GL11.glRotatef(-10, 1, 0, 1);
			GL11.glTranslatef(0.5F, -0.3F, 0.5F);
			GL11.glRotatef(-220, 0, 1, 0);
		}
		for(int i = 0; i < data.length; i++) {
			if(data[i] instanceof EntityOtherPlayerMP) {
				EntityOtherPlayerMP eop = (EntityOtherPlayerMP) data[i];
				double posX = eop.posX;
				double posY = eop.posY;
				double posZ = eop.posZ;
				World world1 = eop.worldObj;
				if(Cplayer.ticksExisted % 1 == 0) {
					Main.proxy.spawnEffectSword(world1, eop, (double)((float)posX), (double)((float)posY + eop.eyeHeight - 0.9f), (double)((float)posZ ), (double)((float)posX), (double)((float)posY + eop.eyeHeight - 1.1), (double)((float)posZ), 0.2F,((Sword)eop.getHeldItem().getItem()).getColorEffect(), true, -1f);
				}
				//блок меча для клиента у другого человека
				if (eop.getHeldItem() != null) {
					if (eop.isBlocking()) {
						GL11.glRotatef(30, 0, 0, 1);
						GL11.glTranslatef(0f, -0.4f, 0);
					}
				}
			}
		}
		GL11.glPushMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glScalef(1.25f, 1.25f, 1.25f);
		if(type ==ItemRenderType.EQUIPPED ) {
			GL11.glTranslatef(0.85F, 0.1F, 0.9F);
			GL11.glRotatef(40, 0, 1, 0);
			GL11.glRotatef(-40, 1, 0, 0);
			GL11.glRotatef(180, 0, 1, 0);
		} else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON  && mc.gameSettings.thirdPersonView == 0) {
			GL11.glRotatef(-10, 1, 0, 1);
			GL11.glTranslatef(0.5F, -0.3F, 0.5F);
			GL11.glRotatef(-220, 0, 1, 0);
			if(Cplayer.isBlocking()) {
				GL11.glTranslatef(-1f, 1, -0.2f);
				GL11.glRotatef(-20, 0, 1, 0);
				GL11.glRotatef(-50, 1, 0, 0);
				GL11.glTranslatef(0.7f, -0.9f, -0.5f);
			}
		
		}
		if(type == ItemRenderType.ENTITY) {
			GL11.glScalef(0.8f, 0.8f, 0.8f);
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach5Tex);
		mbResourceLocation.SwordBleach5.renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		RenderHelper.enableStandardItemLighting();
	}
}