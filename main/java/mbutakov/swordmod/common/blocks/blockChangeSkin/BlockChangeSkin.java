package mbutakov.swordmod.common.blocks.blockChangeSkin;

import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockChangeSkin extends Block implements ITileEntityProvider {

	public BlockChangeSkin() {
        super(Material.wood);
        this.setBlockName("Block change Skin");
        this.setHardness(0.5f);
        this.setBlockTextureName("mbswordmod:changeSkin");
		setCreativeTab(Main.swordTab);
	}
	
	@Override
    public TileEntity createNewTileEntity(final World world, final int metadata) {
        return new TileEntityBlockChangeSkin();
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	         if(!world.isRemote) {
	        	 player.openGui(Main.instance, 1, world, x, y, z);
	         }
		
		
		return true;
	}
	
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper.floor_double((double)((double)(par5EntityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
        if (l == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }
        if (l == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }
        if (l == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
        if (l == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }
	
	
    public int getRenderType() {
        return -1;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
	
    public boolean renderAsNormalBlock() {
        return false;
    }
    
	
}
