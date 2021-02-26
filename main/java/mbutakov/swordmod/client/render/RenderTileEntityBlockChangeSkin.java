package mbutakov.swordmod.client.render;

import org.lwjgl.opengl.GL11;

import mbutakov.swordmod.client.mbResourceLocation;
import mbutakov.swordmod.common.blocks.blockChangeSkin.TileEntityBlockChangeSkin;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityBlockChangeSkin extends TileEntitySpecialRenderer
{ 
    
    private void render(final TileEntityBlockChangeSkin tile, final double x, final double y, final double z, final float f) {
        int i = 0;
        int rotation = 0;
        switch (tile.getBlockMetadata() % 4) {
            case 0: {
                rotation = 0;
                break;
            }
            case 1: {
                rotation = 90;
                break;
            }
            case 2: {
                rotation = 180;
                break;
            }
            case 3: {
                rotation = 270;
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        GL11.glColor4f(1f,1f,1.0f,1f);
        GL11.glRotatef(90 - rotation, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(180, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(1.0f, -1.0f, -1.0f);
        this.bindTexture(mbResourceLocation.blockTex);
        mbResourceLocation.block.renderAll();
        GL11.glPopMatrix();
    }
    
    public void renderTileEntityAt(final TileEntity tile, final double x, final double y, final double z, final float f) {
        this.render((TileEntityBlockChangeSkin)tile, x, y, z, f);
    }
}

