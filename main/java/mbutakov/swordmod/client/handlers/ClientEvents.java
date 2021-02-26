package mbutakov.swordmod.client.handlers;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
import mbutakov.swordmod.client.ClientProxy;
import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.client.gui.GuiOptionsSwordMod;
import mbutakov.swordmod.client.render.RenderItemSwordBleach;
import mbutakov.swordmod.client.render.RenderItemSwordIdk;
import mbutakov.swordmod.common.items.CharacteristicSword;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import scala.util.continuations.cpsMinus;

public class ClientEvents {

	@SubscribeEvent
	public void keyPress(KeyInputEvent event) {
		if (ClientProxy.KeyOpenSwordModGui.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiOptionsSwordMod());
		}
	}

	@SubscribeEvent
	public void itemDamageRemove(ItemTooltipEvent event) {
		ItemStack is = event.itemStack;
		if (is.getItem() instanceof ItemSwordMb) {
			for (int i = 0; i < event.toolTip.size(); i++) {
				if (event.toolTip.get(i).startsWith("§9+")) {
					event.toolTip.remove(i);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onTickClient(ClientTickEvent event) {
		if(Minecraft.getMinecraft().thePlayer != null) {
			if(Minecraft.getMinecraft().theWorld != null) {
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;

			}
		}
	}
	

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderTwoSword(RenderPlayerEvent.Specials.Post e) {
		EntityPlayer Cplayer = e.entityPlayer;
		double posX = Cplayer.posX;
		double posY = Cplayer.posY;
		double posZ = Cplayer.posZ;
		
		RenderPlayer render = e.renderer;
		if (Cplayer.getHeldItem() != null && Cplayer.getHeldItem().getItem() instanceof ItemSwordMb && (Cplayer.getHeldItem().getItem() == mbItemRegister.IdkBlade || Cplayer.getHeldItem().getItem() == mbItemRegister.ItemSwordBleach3)  ) {
			render.modelArmorChestplate.bipedBody.rotateAngleY = 0;
	    	render.modelArmorChestplate.bipedBody.rotateAngleZ = 0;
	    	render.modelArmorChestplate.bipedBody.rotateAngleX = 0;
			render.modelArmorChestplate.heldItemLeft = render.modelArmor.heldItemLeft = render.modelBipedMain.heldItemLeft = 1;
			if (Cplayer.isBlocking()) {
				render.modelArmorChestplate.heldItemLeft = render.modelArmor.heldItemLeft = render.modelBipedMain.heldItemLeft = 3;
			}
			float f6 = 0;
	        if (Cplayer.swingProgress > 0)
	        {
	        	render.modelBipedMain.bipedLeftArm.rotateAngleY = 0.0F;
	            f6 = Cplayer.swingProgress;
	            f6 = 1.0F - Cplayer.swingProgress;
	            f6 *= f6;
	            f6 *= f6;
	            f6 = 1.0F - f6;
	            float f7 = MathHelper.sin(f6 * (float)Math.PI);
	            float f8 = MathHelper.sin(Cplayer.swingProgress * (float)Math.PI) * -(render.modelBipedMain.bipedHead.rotateAngleX - 0.7F) * 0.25F;
	            render.modelBipedMain.bipedLeftArm.rotateAngleX = (float)((double)render.modelBipedMain.bipedLeftArm.rotateAngleX - ((double)f7 * 1D + (double)f8));
	            render.modelBipedMain.bipedLeftArm.rotateAngleY -= render.modelBipedMain.bipedBody.rotateAngleY * 0.8F;
	        }	
		} else {
			render.modelArmorChestplate.heldItemLeft = render.modelArmor.heldItemLeft = render.modelBipedMain.heldItemLeft = 0;
		}

		float changePosition = 0;
		if(Cplayer.isBlocking()) {
			changePosition = 1;
		}
		if(Cplayer.swingProgress > 0) {
			changePosition = 1;
		}
		if (Cplayer.getHeldItem() != null && Cplayer.getHeldItem().getItem() instanceof ItemSwordMb) {
			
			if (Cplayer.getHeldItem().getItem() == mbItemRegister.ItemSwordBleach3) {
				if (Minecraft.getMinecraft().thePlayer.ticksExisted % 2 == 0) {
					Main.proxy.spawnEffectSword(Cplayer.worldObj, Cplayer, (double) ((float) posX),(double) ((float) posY + Cplayer.eyeHeight - 1.1f + changePosition/4), (double) ((float) posZ),
							(double) ((float) posX), (double) ((float) posY + Cplayer.eyeHeight - 1f + changePosition/4),(double) ((float) posZ),
							0.25F, ((ItemSwordMb)Cplayer.getHeldItem().getItem()).getColorEffect(), true, -0.6f - changePosition, true, 2.3f);
				}
				GL11.glPushMatrix();
				e.renderer.modelBipedMain.bipedLeftArm.postRender(0.0625F);
				GL11.glScalef(0.8f, 0.8f, 0.8f);
				
				if(Cplayer.isBlocking()) {
					GL11.glRotatef(5, 1, 0, 1);
					GL11.glRotatef(30, -1, 1, 0);
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.SwordBleach4Tex);
				GL11.glRotatef(-90, 1, 0, 0);
				GL11.glRotatef(0, 0, 0, 1);
				GL11.glTranslatef(0.1f, -0.45f, 0.7f);
				mbResourceLocation.SwordBleach4.renderAll();
			  	   CharacteristicSword cs = ((ItemSwordMb)Cplayer.getHeldItem().getItem()).getCs(Cplayer.getHeldItem());
			  	   if(cs.getCountModules(Cplayer.getHeldItem())[11] > 0 || cs.getCountModules(Cplayer.getHeldItem())[12] > 0 || cs.getCountModules(Cplayer.getHeldItem())[13] > 0){
			  		    float r = 0;
			  		    float g = 0;
			  		    float b = 0;
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[11] > 0) {
			  		    	r = 1;
			  		    	g = 1;
			  		    	b = 1;
			  		    }
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[12] > 0) {
			  		    	r = 1;
			  		    	g = 0;
			  		    	b = 0;
			  		    }
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[13] > 0) {
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
			changePosition = MathHelper.sin(changePosition);
			if (Cplayer.getHeldItem().getItem() == mbItemRegister.IdkBlade) {
				if (Minecraft.getMinecraft().thePlayer.ticksExisted % 2 == 0) {
					Main.proxy.spawnEffectSword(Cplayer.worldObj, Cplayer, (double) ((float) posX),(double) ((float) posY + Cplayer.eyeHeight - 1.1f + changePosition/4), (double) ((float) posZ),
							(double) ((float) posX), (double) ((float) posY + Cplayer.eyeHeight - 1.2f + changePosition/4),(double) ((float) posZ),
							0.25F, ((ItemSwordMb)Cplayer.getHeldItem().getItem()).getColorEffect(), true, -0.6f - changePosition, true, 2.5f);
				}
				GL11.glPushMatrix();
				ModelBiped biped = e.renderer.modelBipedMain;
				e.renderer.modelBipedMain.bipedLeftArm.postRender(0.0625F);
				GL11.glScalef(0.8f, 0.8f, 0.8f);
				if(Cplayer.isBlocking()) {
					GL11.glRotatef(25, 0, 1, 0);
					GL11.glRotatef(-10, 1, 0, 0);
					GL11.glTranslatef(0,0,0.1f);
				}
				Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.IdkBladeTex);
				GL11.glRotatef(-85, 1, 0, 0);
				GL11.glRotatef(0, 0, 0, 1);
				GL11.glTranslatef(0.1f, -0.28f, 0.7f);
				mbResourceLocation.IdkBlade.renderAll();
			  	   CharacteristicSword cs = ((ItemSwordMb)Cplayer.getHeldItem().getItem()).getCs(Cplayer.getHeldItem());
			  	   if(cs.getCountModules(Cplayer.getHeldItem())[11] > 0 || cs.getCountModules(Cplayer.getHeldItem())[12] > 0 || cs.getCountModules(Cplayer.getHeldItem())[13] > 0){
			  		    float r = 0;
			  		    float g = 0;
			  		    float b = 0;
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[11] > 0) {
			  		    	r = 1;
			  		    	g = 1;
			  		    	b = 1;
			  		    }
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[12] > 0) {
			  		    	r = 1;
			  		    	g = 0;
			  		    	b = 0;
			  		    }
			  		    if(cs.getCountModules(Cplayer.getHeldItem())[13] > 0) {
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
				        mbResourceLocation.IdkBlade.renderAll();
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
		}
	}

}
