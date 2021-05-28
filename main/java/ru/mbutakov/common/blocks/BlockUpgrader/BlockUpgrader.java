package ru.mbutakov.common.blocks.BlockUpgrader;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.mbutakov.Main;

public class BlockUpgrader extends Block implements ITileEntityProvider {

    public BlockUpgrader(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    	this.setCreativeTab(CreativeTabs.FOOD);
        this.setHardness(1F);
        this.setResistance(1F);
        this.setSoundType(SoundType.SLIME);
        this.setLightLevel(1F);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		 return new TileEntityBlockUpgrader();
	}


	   @Override
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
	        if (!worldIn.isRemote) {
	            playerIn.openGui(Main.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
	        } else {
	            return false;
	        }
	        return true;
	    }
	
	
}
