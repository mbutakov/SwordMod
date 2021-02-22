package mbutakov.swordmod.common.blocks.blockChangeSkin;

import mbutakov.swordmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChangeSkin extends Block implements ITileEntityProvider {

	public BlockChangeSkin() {
        super(Material.wood);
        this.setUnlocalizedName("Block change Skin");
        this.setTextureName("mbswordmod:changeSkin");
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
