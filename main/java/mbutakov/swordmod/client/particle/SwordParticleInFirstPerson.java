package mbutakov.swordmod.client.particle;

import org.lwjgl.opengl.GL11;

import mbutakov.swordmod.client.mbResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class SwordParticleInFirstPerson extends EntityFX {

	public SwordParticleInFirstPerson(World p_i1218_1_, double p_i1218_2_, double p_i1218_4_, double p_i1218_6_) {
		super(p_i1218_1_, p_i1218_2_, p_i1218_4_, p_i1218_6_);
	    super.particleMaxAge = 3;	      

	}

	public void renderParticle(Tessellator tes, float f, float f1, float f2, float f3, float f4, float f5) {
	      Minecraft.getMinecraft().entityRenderer.disableLightmap(0.0D);
	      GL11.glPushMatrix();
	      GL11.glEnable(3553);
	      GL11.glEnable(3042);
	      GL11.glBlendFunc(770, 771);
	      GL11.glDisable(2896);
	      GL11.glDisable(GL11.GL_CULL_FACE);
	      Minecraft.getMinecraft().getTextureManager().bindTexture(mbResourceLocation.pp);
	      GL11.glRotatef(90.0F - Minecraft.getMinecraft().thePlayer.rotationYaw, 0.0F, 1.0F, 0.0F);
	      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	      double d2 = 0.1D;
	      double d3 = 0.1D;
	      double d4 = d3 + 1.0D;
	      double d5 = Math.sin(d2) * 0.5D;
	      double d6 = Math.cos(d2) * 0.5D;
	      double d7 = Math.sin(d2) * d3;
	      double d8 = Math.sin(d2) * d4;
	      double d9 = Math.cos(d2) * d3;
	      double d10 = Math.cos(d2) * d4;
	      GL11.glTranslated((double)((float)(-2.0D * d6)) + 0.75f, particleAge * 0.1f - 0.2f + interpPosY - Minecraft.getMinecraft().thePlayer.posY, - 0.2f);
	      float f41 = 0.1F;
	      GL11.glScalef(f41, f41, f41);
	      tes.startDrawingQuads();
	      tes.addVertexWithUV(d9 + d5, d7 - d6, 0.0D, 0.0D, 1.0D);
	      tes.addVertexWithUV(d10 + d5, d8 - d6, 0.0D, 1.0D, 1.0D);
	      tes.addVertexWithUV(d10 - d5, d8 + d6, 0.0D, 1.0D, 0.0D);
	      tes.addVertexWithUV(d9 - d5, d7 + d6, 0.0D, 0.0D, 0.0D);
	      tes.draw();
	      tes.startDrawingQuads();
	      tes.addVertexWithUV(d9, d7, -0.5D, 0.0D, 1.0D);
	      tes.addVertexWithUV(d9, d7, 0.5D, 0.0D, 0.0D);
	      tes.addVertexWithUV(d10, d8, 0.5D, 1.0D, 0.0D);
	      tes.addVertexWithUV(d10, d8, -0.5D, 1.0D, 1.0D);
	      tes.draw();
	      GL11.glEnable(2896);
	      GL11.glPopMatrix();
	      Minecraft.getMinecraft().entityRenderer.enableLightmap(0.0D);
	}

	public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.interpPosY += 0.01f;
        if(super.particleAge++ >= super.particleMaxAge) {
            this.setDead();
         }
	      
	}

	public int getFXLayer() {
		return 3;
	}

}
