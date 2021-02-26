package mbutakov.swordmod.client.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.common.items.CharacteristicSword;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderItemSwordBleach3 implements IItemRenderer {

	
	public RenderItemSwordBleach3() {
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
	
	public void renderItem(ItemRenderType type,ItemStack is) {
	       float f6 = Minecraft.getMinecraft().thePlayer.swingProgress;
	        float f7 = MathHelper.sin(f6 * (float)Math.PI);
			GL11.glPushMatrix();
			GL11.glNormal3f(0, 0, 0);
		    RenderPlayer render;
		    render = (RenderPlayer) RenderManager.instance.getEntityRenderObject(Minecraft.getMinecraft().thePlayer);
			GL11.glScalef(2.1f, 2.1f, 2.1f);
			GL11.glRotatef(-10, 1, 0, 1);
			GL11.glTranslatef(-0.8F, -0.55F, -1.2F);
			GL11.glRotatef(-220, 0, 1, 0);
			GL11.glRotatef(f7 * 90, 1, 0, 0);
			GL11.glRotatef(f7 * 10, 0, 0, 1);
			Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach4Tex);
			mbResourceLocation.SwordBleach4.renderAll();
		  	   CharacteristicSword cs = ((ItemSwordMb)is.getItem()).getCs(is);
		  	   if(cs.getCountModules(is)[11] > 0 || cs.getCountModules(is)[12] > 0 || cs.getCountModules(is)[13] > 0){
		  		    float r = 0;
		  		    float g = 0;
		  		    float b = 0;
		  		    if(cs.getCountModules(is)[11] > 0) {
		  		    	r = 1;
		  		    	g = 1;
		  		    	b = 1;
		  		    }
		  		    if(cs.getCountModules(is)[12] > 0) {
		  		    	r = 1;
		  		    	g = 0;
		  		    	b = 0;
		  		    }
		  		    if(cs.getCountModules(is)[13] > 0) {
				    	r = 1;
		  		    	g = 255/215;
		  		    	b = 0;
		  		    }
				GL11.glPushMatrix();
			        GL11.glDepthFunc(514);
			        GL11.glDisable(2896);
			        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
			        GL11.glEnable(3042);
			        GL11.glBlendFunc(768, 1);
			        GL11.glColor4f(r, g, b, 1F);
			        GL11.glMatrixMode(5890);
			        GL11.glPushMatrix();
			        float f8 = 0.125F;
			        GL11.glScalef(f8, f8, f8);
			        float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
			        GL11.glTranslatef(f9, 0.0F, 0.0F);
			        GL11.glPopMatrix();
			        GL11.glPushMatrix();
			        GL11.glScalef(f8, f8, f8);
			        f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
			        GL11.glTranslatef(-f9, 0.0F, 0.0F);
			        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
			        mbResourceLocation.SwordBleach4.renderAll();
			        GL11.glPopMatrix();
				    GL11.glMatrixMode(5888);
					GL11.glPopMatrix();
			        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			        GL11.glEnable(2896);
				     GL11.glDepthFunc(515);	   
			    }
			GL11.glPopMatrix();
			
		}
		
	@Override
	public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			renderItem(type, is);
		}
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
				float changePosition = 0;
				if(eop.isBlocking()) {
					changePosition = 1;
				}
				if(eop.swingProgress > 0) {
					changePosition = 1;
				}
				if(Cplayer.ticksExisted % 1 == 0) {
					Main.proxy.spawnEffectSword(world1, eop, (double) ((float) posX),(double) ((float) posY + eop.eyeHeight - 1.1f + changePosition/4), (double) ((float) posZ),
							(double) ((float) posX), (double) ((float) posY + eop.eyeHeight - 1f + changePosition/4),(double) ((float) posZ),
							0.25F, ((ItemSwordMb)eop.getHeldItem().getItem()).getColorEffect(), true, -0.6f - changePosition, false, 2.3f);
					
				}
				//блок меча для клиента у другого человека
				if (eop.getHeldItem() != null) {
					if (eop.isBlocking()) {
						GL11.glRotatef(25, 0, 0, 1);
						GL11.glRotatef(35, 1, 0, 0);
						GL11.glTranslatef(0.3f, 0f, -0f);
					}
				}
			}
		}
		float changePosition = 0;
		if(Cplayer.isBlocking()) {
			changePosition = 1;
		}
		if(Cplayer.swingProgress > 0) {
			changePosition = 1;
		}
		double posX = Cplayer.posX;
		double posY = Cplayer.posY;
		double posZ = Cplayer.posZ;
		if(mc.gameSettings.thirdPersonView != 0) {
			if(Cplayer.getHeldItem() != null) {
				if(Cplayer.getHeldItem().getItem() instanceof ItemSwordMb) {
					if(Cplayer.ticksExisted % 2  == 0) {
						Main.proxy.spawnEffectSword(Cplayer.worldObj, Cplayer, (double) ((float) posX),(double) ((float) posY + Cplayer.eyeHeight - 1.1f + changePosition/4), (double) ((float) posZ),
								(double) ((float) posX), (double) ((float) posY + Cplayer.eyeHeight - 1f + changePosition/4),(double) ((float) posZ),
								0.25F, ((ItemSwordMb)Cplayer.getHeldItem().getItem()).getColorEffect(), true, -0.6f - changePosition, false, 2.3f);
					}
				}
			}
		}
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glScalef(2.25f, 2.25f, 2.25f);
		if(type ==ItemRenderType.EQUIPPED ) {
			GL11.glTranslatef(0.65F, 0.05F, 0.70F);
			GL11.glRotatef(45, 0, 1, 0);
			GL11.glRotatef(-70, 1, 0, 0);
			GL11.glRotatef(180, 0, 1, 0);
			
		} else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON  && mc.gameSettings.thirdPersonView == 0) {
			GL11.glRotatef(-10, 1, 0, 1);
			GL11.glTranslatef(1F, -0.7F, 0.1F);
			GL11.glRotatef(-220, 0, 1, 0);
			if(Cplayer.isBlocking()) {
				GL11.glTranslatef(-1f, 1, -0.4f);
				GL11.glRotatef(-20, 0, 1, 0);
				GL11.glRotatef(-50, 1, 0, 0);
				GL11.glTranslatef(0.7f, -0.9f, -0.5f);
			}
			
		
		}
		if(type == ItemRenderType.ENTITY) {
			GL11.glTranslatef(-0.2f, -0.2f, 0f);
			GL11.glScalef(0.8f, 0.8f, 0.8f);
			GL11.glPushMatrix();
			GL11.glScalef(1f, 1f, 1f);
			GL11.glTranslatef(0.6f, 2.9f, 0f);
			GL11.glRotatef(180, 1, 0, 0);
			Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach4Tex);
			mbResourceLocation.SwordBleach4.renderAll();
			   CharacteristicSword cs = ((ItemSwordMb)is.getItem()).getCs(is);
		  	   if(cs.getCountModules(is)[11] > 0 || cs.getCountModules(is)[12] > 0 || cs.getCountModules(is)[13] > 0){
		  		    float r = 0;
		  		    float g = 0;
		  		    float b = 0;
		  		    if(cs.getCountModules(is)[11] > 0) {
		  		    	r = 1;
		  		    	g = 1;
		  		    	b = 1;
		  		    }
		  		    if(cs.getCountModules(is)[12] > 0) {
		  		    	r = 1;
		  		    	g = 0;
		  		    	b = 0;
		  		    }
		  		    if(cs.getCountModules(is)[13] > 0) {
				    	r = 1;
		  		    	g = 255/215;
		  		    	b = 0;
		  		    }
	   			GL11.glPushMatrix();
			        GL11.glDepthFunc(514);
			        GL11.glDisable(2896);
			        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
			        GL11.glEnable(3042);
			        GL11.glBlendFunc(768, 1);
			        float f7 = 1F;
			        GL11.glColor4f(r, g, b, 1F);
			        GL11.glMatrixMode(5890);
			        GL11.glPushMatrix();
			        float f8 = 0.125F;
			        GL11.glScalef(f8, f8, f8);
			        float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
			        GL11.glTranslatef(f9, 0.0F, 0.0F);
			        GL11.glPopMatrix();
			        GL11.glPushMatrix();
			        GL11.glScalef(f8, f8, f8);
			        f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
			        GL11.glTranslatef(-f9, 0.0F, 0.0F);
			        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
			        mbResourceLocation.SwordBleach4.renderAll();
			        GL11.glPopMatrix();
				    GL11.glMatrixMode(5888);
					GL11.glPopMatrix();
			        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			        GL11.glEnable(2896);
				     GL11.glDepthFunc(515);	   
			    }
			GL11.glPopMatrix();
			
		}
		
		Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach3Tex);
		mbResourceLocation.SwordBleach3.renderAll();
	  	   CharacteristicSword cs = ((ItemSwordMb)is.getItem()).getCs(is);
	  	   if(cs.getCountModules(is)[11] > 0 || cs.getCountModules(is)[12] > 0 || cs.getCountModules(is)[13] > 0){
	  		    float r = 0;
	  		    float g = 0;
	  		    float b = 0;
	  		    if(cs.getCountModules(is)[11] > 0) {
	  		    	r = 1;
	  		    	g = 1;
	  		    	b = 1;
	  		    }
	  		    if(cs.getCountModules(is)[12] > 0) {
	  		    	r = 1;
	  		    	g = 0;
	  		    	b = 0;
	  		    }
	  		    if(cs.getCountModules(is)[13] > 0) {
			    	r = 1;
	  		    	g = 255/215;
	  		    	b = 0;
	  		    }
   			GL11.glPushMatrix();
		        GL11.glDepthFunc(514);
		        GL11.glDisable(2896);
		        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
		        GL11.glEnable(3042);
		        GL11.glBlendFunc(768, 1);
		        float f7 = 1F;
		        GL11.glColor4f(r, g, b, 1F);
		        GL11.glMatrixMode(5890);
		        GL11.glPushMatrix();
		        float f8 = 0.125F;
		        GL11.glScalef(f8, f8, f8);
		        float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
		        GL11.glTranslatef(f9, 0.0F, 0.0F);
		        GL11.glPopMatrix();
		        GL11.glPushMatrix();
		        GL11.glScalef(f8, f8, f8);
		        f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
		        GL11.glTranslatef(-f9, 0.0F, 0.0F);
		        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
		        mbResourceLocation.SwordBleach3.renderAll();
		        GL11.glPopMatrix();
			    GL11.glMatrixMode(5888);
				GL11.glPopMatrix();
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		        GL11.glEnable(2896);
			     GL11.glDepthFunc(515);	   
		    }
			GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
	}
}