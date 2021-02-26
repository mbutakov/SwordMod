package mbutakov.swordmod.common.entity;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.utils.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityParticleFireFx extends EntityFX {

	  private float alpha = 1.0F;
	   public EntityPlayer player;
	   private float flameScale;
	   
    public EntityParticleFireFx(World parWorld,EntityPlayer player,double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        this.particleScale = 0.45f;
        this.flameScale = super.particleScale;
        super.posX = super.posX * 0.009999999776482582D + parMotionX;
        super.posY = super.posY * 0.009999999776482582D + parMotionY;
        super.posZ = super.posZ * 0.009999999776482582D + parMotionZ;
        super.particleRed = super.particleGreen = super.particleBlue = 1.0F;
        super.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        setLocationAndAngles(player.posX + 1, player.posY, player.posZ, player.rotationYaw, player.rotationPitch);  
        this.player = player;
	}
    
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }

    

    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_)
    {
        return 1;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float var1) {
        float var2 = ((float)super.particleAge + var1) / (float)super.particleMaxAge;
        if(var2 < 0.0F) {
           var2 = 0.0F;
        }

        if(var2 > 1.0F) {
           var2 = 1.0F;
        }

        float var3 = super.getBrightness(var1);
        return var3 * var2 + (1.0F - var2);
    }
    

    public float getBlueColorF()
    {
        return this.particleBlue;
    }

    
    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7){
        var2 = 0.0F;
        float var8 = ((float)super.particleAge + var2) / (float)super.particleMaxAge;
        super.particleScale = this.flameScale * (1.0F - var8 * var8 * 0.5F);
        float var9 = (float)super.particleTextureIndexX / 16.0F;
        float var10 = var9 + 0.0624375F;
        float var11 = (float)super.particleTextureIndexY / 16.0F;
        float var12 = var11 + 0.0624375F;
        float var13 = 0.1F * super.particleScale;
        if(super.particleIcon != null) {
           var9 = super.particleIcon.getMinU();
           var10 = super.particleIcon.getMaxU();
           var11 = super.particleIcon.getMinV();
           var12 = super.particleIcon.getMaxV();
        }
        float var17 = 1.0F;
        float var14 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)var2 - interpPosX);
        float var15 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)var2 - interpPosY);
        float var16 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)var2 - interpPosZ);
        var1.setColorRGBA_F(super.particleRed * var17, super.particleGreen * var17, super.particleBlue * var17, super.particleAlpha);
        var1.addVertexWithUV((double)(var14 - var3 * var13 - var6 * var13), (double)(var15 - var4 * var13), (double)(var16 - var5 * var13 - var7 * var13), (double)var10, (double)var12);
        var1.addVertexWithUV((double)(var14 - var3 * var13 + var6 * var13), (double)(var15 + var4 * var13), (double)(var16 - var5 * var13 + var7 * var13), (double)var10, (double)var11);
        var1.addVertexWithUV((double)(var14 + var3 * var13 + var6 * var13), (double)(var15 + var4 * var13), (double)(var16 + var5 * var13 + var7 * var13), (double)var9, (double)var11);
        var1.addVertexWithUV((double)(var14 + var3 * var13 - var6 * var13), (double)(var15 - var4 * var13), (double)(var16 + var5 * var13 - var7 * var13), (double)var9, (double)var12);
    }

    public int getFXLayer() {
        return 3;
    }
    
}
