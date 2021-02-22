package mbutakov.swordmod.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.omg.CORBA.REBIND;

import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.client.config.SwordModConfig;

public class SwordParticle extends EntityFX {

   public boolean shrink;
   float moteParticleScale;
   int moteHalfLife;
   public boolean tinkle;
   public int blendmode;
   public EntityPlayer player;
   
   public SwordParticle(World world,EntityPlayer player, double d, double d1, double d2, float f, float red, float green, float blue,boolean leftHand,double lenght) {
      super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
      this.shrink = false;
      this.tinkle = false;
      this.blendmode = 1;
      if(red == 0.0F) {
         red = 1.0F;
      }
      super.particleRed = red;
      super.particleGreen = green;
      super.particleBlue = blue;
      super.particleGravity = 0.0F;
      super.motionX = super.motionY = super.motionZ = 0.0D;
      super.particleScale *= f;
      this.moteParticleScale = super.particleScale;
      super.particleMaxAge = (int)(36.0D / (Math.random() * 1.3D + 0.7D));
      this.moteHalfLife = super.particleMaxAge / 2;
      this.setSize(0.01F, 0.01F);
      byte visibleDistance = (byte) SwordModConfig.distanceRenderParticle;
      if(Minecraft.getMinecraft().renderViewEntity.getDistance(posX, posY, posZ) > (double)visibleDistance || Minecraft.getMinecraft().renderViewEntity.getDistance(posX, posY, posZ) > 80) {
          super.particleMaxAge = 0;
       }
      this.player = player;
      super.prevPosX = super.posX;
      super.prevPosY = super.posY;
      super.prevPosZ = super.posZ;
      
      
   }
   
   public SwordParticle(World world,EntityPlayer player, double d, double d1, double d2, float f, int type,boolean leftHand,double lenght) {
      this(world,player, d, d1, d2, f, 0.0F, 0.0F, 0.0F,leftHand,lenght);
      switch(type) {
      case 0:
         super.particleRed = 0.75F + world.rand.nextFloat() * 0.25F;
         super.particleGreen = 0.25F + world.rand.nextFloat() * 0.25F;
         super.particleBlue = 0.75F + world.rand.nextFloat() * 0.25F;
         break;
      case 1:
         super.particleRed = 0.5F + world.rand.nextFloat() * 0.3F;
         super.particleGreen = 0.5F + world.rand.nextFloat() * 0.3F;
         super.particleBlue = 0.2F;
         break;
      case 2:
         super.particleRed = 0.2F;
         super.particleGreen = 0.2F;
         super.particleBlue = 0.7F + world.rand.nextFloat() * 0.3F;
         break;
      case 3:
         super.particleRed = 0.2F;
         super.particleGreen = 0.7F + world.rand.nextFloat() * 0.3F;
         super.particleBlue = 0.5F;
         break;
      case 4:
         super.particleRed = 0.7F + world.rand.nextFloat() * 0.3F;
         super.particleGreen = 0.2F;
         super.particleBlue = 0.2F;
         break;
      case 5:
         this.blendmode = 771;
         super.particleRed = world.rand.nextFloat() * 0.1F;
         super.particleGreen = world.rand.nextFloat() * 0.1F;
         super.particleBlue = world.rand.nextFloat() * 0.1F;
         break;
      case 6:
         super.particleRed = 0.8F + world.rand.nextFloat() * 0.2F;
         super.particleGreen = 0.8F + world.rand.nextFloat() * 0.2F;
         super.particleBlue = 0.8F + world.rand.nextFloat() * 0.2F;
      }

   }

	public SwordParticle(World world, EntityPlayer player, double d, double d1, double d2, double x, double y, double z,
			float f, int type,boolean leftHand,double lenght) {
		this(world, player, d, d1, d2, f, type,leftHand,lenght);
		if (super.particleMaxAge > 0) {
			double dx = x - super.posX;
			double dy = y - super.posY;
			double dz = z - super.posZ;
			dx -= lenght * Math.sin(player.renderYawOffset / 180.0F * Math.PI);
			dz += lenght * Math.cos(player.renderYawOffset / 180.0F * Math.PI);
			super.motionX = dx / (double) super.particleMaxAge;
			super.motionY = dy / (double) super.particleMaxAge;
			super.motionZ = dz / (double) super.particleMaxAge;
			double pp = Math.toRadians(player.renderYawOffset);
			if(leftHand == true) {
				posX -= -Math.cos(pp) * 0.34f;
				posZ -= -Math.sin(pp) * 0.34f;
			}else {
				posX -= Math.cos(pp) * 0.34f;
				posZ -= Math.sin(pp) * 0.34f;
			}
		}
	}

   public void setGravity(float value) {
      super.particleGravity = value;
   }

   public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5) {
      float agescale = 1.3F;
      if(super.particleMaxAge > 0) {
         super.particleScale = this.moteParticleScale * agescale;
         tessellator.draw();
         GL11.glPushMatrix();
         GL11.glDepthMask(false);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, this.blendmode);
         Minecraft.getMinecraft().getTextureManager().bindTexture(mbResourceLocation.PortalParticleTexture);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
         float f10 = 0.5F * super.particleScale;
         float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - interpPosX);
         float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - interpPosZ);
         float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - interpPosY);
         tessellator.startDrawingQuads();
         tessellator.setBrightness(240);
         tessellator.setColorRGBA_F(super.particleRed, super.particleGreen, super.particleBlue, 0.085F);
         tessellator.addVertexWithUV((double)(f11 - f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 - f3 * f10 - f5 * f10), 0.0D, 1.0D);
         tessellator.addVertexWithUV((double)(f11 - f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 - f3 * f10 + f5 * f10), 1.0D, 1.0D);
         tessellator.addVertexWithUV((double)(f11 + f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 + f3 * f10 + f5 * f10), 1.0D, 0.0D);
         tessellator.addVertexWithUV((double)(f11 + f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 + f3 * f10 - f5 * f10), 0.0D, 0.0D);
         tessellator.draw();
         GL11.glDisable(3042);
         GL11.glDepthMask(true);
         GL11.glPopMatrix();
         tessellator.startDrawingQuads();
      }
   }

   public void onUpdate() {
      super.prevPosX = this.posX;
      super.prevPosY = this.posY;
      super.prevPosZ = this.posZ;
      if(super.particleAge == 0 && this.tinkle && super.worldObj.rand.nextInt(3) == 0) 
      {
      }
      if(super.particleAge++ >= super.particleMaxAge) {
    	  setDead();
      }
      super.posY -= 0.04D * (double)super.particleGravity;
      super.posX += super.motionX;
      super.posY += super.motionY * 6.0D;
      super.posZ += super.motionZ;
      super.motionX *= 0.9800000190734863D;
      super.motionY *= 0.8800000190734864D;
      super.motionZ *= 0.9800000190734863D;
      if(super.onGround) {
         super.motionX *= 0.699999988079071D;
         super.motionZ *= 0.699999988079071D;
      }

   }
   public int getFXLayer() {
       return 2;
   }
}
