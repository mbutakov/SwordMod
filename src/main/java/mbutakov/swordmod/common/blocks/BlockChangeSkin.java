package mbutakov.swordmod.common.blocks;

import mbutakov.swordmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChangeSkin extends Block implements ITileEntityProvider {

	public BlockChangeSkin() {
        super(Material.wood);
        this.setBlockName("Block change Skin");
        this.setBlockTextureName("mbswordmod:changeSkin");
		setCreativeTab(Main.swordTab);
	}
	@Override
    public TileEntity createNewTileEntity(final World world, final int metadata) {
        return new TileEntityBlockChangeSkin();
    }
}
