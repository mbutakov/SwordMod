package mbutakov.swordmod.common.blocks.blockChangeSkin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.client.particle.PortalParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityBlockChangeSkin extends TileEntity {

	public void updateEntity() {
		if(super.worldObj.isRemote) {
	        for(int var71 = 0; var71 < 1; ++var71) {
	         //   this.SetEffect(super.worldObj, (double)((float)super.xCoord + 0.5F), (double)((float)super.yCoord + 0.7f), (double)((float)super.zCoord + 0.5F), (double)((float)super.xCoord + 0.25F + super.worldObj.rand.nextFloat() * 0.5F), (double)((float)super.yCoord + 1F), (double)((float)super.zCoord + 0.25F + super.worldObj.rand.nextFloat() * 0.5F), 0.5F, 3, true, -0.025F);
	            this.SetEffect(super.worldObj, (double)((float)super.xCoord + 0.5F), (double)((float)super.yCoord + 0), (double)((float)super.zCoord + 0.5F), (double)((float)super.xCoord + 1.5f + super.worldObj.rand.nextFloat() * 0.5F), (double)((float)super.yCoord + 0.5F), (double)((float)super.zCoord + super.worldObj.rand.nextFloat() * 0.5F), 0.5F, 1, true, -0.025F);
	            this.SetEffect(super.worldObj, (double)((float)super.xCoord + 0.5F), (double)((float)super.yCoord + 0), (double)((float)super.zCoord + 0.5F), (double)((float)super.xCoord - 1.5f + super.worldObj.rand.nextFloat() * 0.5F), (double)((float)super.yCoord + 0.5F), (double)((float)super.zCoord + super.worldObj.rand.nextFloat() * 0.5F), 0.5F, 2, true, -0.025F);
	            this.SetEffect(super.worldObj, (double)((float)super.xCoord + 0.5F), (double)((float)super.yCoord + 0), (double)((float)super.zCoord + 0.5F), (double)((float)super.xCoord  + super.worldObj.rand.nextFloat() * 0.5F), (double)((float)super.yCoord + 0.5F), (double)((float)super.zCoord + 1.5f + super.worldObj.rand.nextFloat() * 0.5F), 0.5F, 3, true, -0.025F);
	            this.SetEffect(super.worldObj, (double)((float)super.xCoord + 0.5F), (double)((float)super.yCoord + 0), (double)((float)super.zCoord + 0.5F), (double)((float)super.xCoord  + super.worldObj.rand.nextFloat() * 0.5F), (double)((float)super.yCoord + 0.5F), (double)((float)super.zCoord - 1.5f + super.worldObj.rand.nextFloat() * 0.5F), 0.5F, 4, true, -0.025F);
	            
	        }
		}
	}

	   @SideOnly(Side.CLIENT)
	   public void SetEffect(World worldObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity) {
 	      PortalParticle ef11 = new PortalParticle(worldObj, posX, posY, posZ, posX2, posY2, posZ2, size, type);
	      ef11.setGravity(gravity);
	      ef11.shrink = shrink;
	      Minecraft.getMinecraft().effectRenderer.addEffect(ef11);
	   }
}
