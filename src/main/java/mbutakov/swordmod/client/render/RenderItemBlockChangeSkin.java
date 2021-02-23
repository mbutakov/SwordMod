package mbutakov.swordmod.client.render;

import org.lwjgl.opengl.GL11;

import mbutakov.swordmod.client.mbResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderItemBlockChangeSkin implements IItemRenderer{
	

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		// TODO Auto-generated method stub
		GL11.glPushMatrix();
		if(type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glTranslatef(0.3f, 0.3f, 0.3f);
		}
		if(type == ItemRenderType.EQUIPPED) {
			GL11.glTranslatef(0.5f, 0.7f, 0.5f);
		}
		
		Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.blockTex);
		mbResourceLocation.block.renderAll();
		GL11.glPopMatrix();
	}
	
	

}
