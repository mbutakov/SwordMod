package mbutakov.swordmod.client.gui;

import org.lwjgl.opengl.GL11;

import mbutakov.swordmod.common.blocks.blockChangeSkin.ContainerBlockChangeSkin;
import mbutakov.swordmod.common.items.ItemSwordMb;
import mbutakov.swordmod.utils.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiBlockChangeSkin extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("mbswordmod", "textures/gui/swordModuleTable.png");
	private InventoryPlayer inventory;
	
	public GuiBlockChangeSkin(InventoryPlayer inv, World w) 
	{
		super(new ContainerBlockChangeSkin(inv, w));
		inventory = inv;
		ySize = 256;
	}
	
	
    @Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
    {
    	fontRendererObj.drawString("Инвентарь", 8, 100 + 2, 0x404040);
    	fontRendererObj.drawString("Модификация меча", 40, 3, 0x404040);
    	ItemStack swordStack = inventorySlots.getSlot(0).getStack();
        if(swordStack != null && swordStack.getItem() instanceof ItemSwordMb)
        {
         	GuiUtils.renderCenteredText(swordStack.getDisplayName(), xSize/2, 17, 0x404040);
        }
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.6F);
		mc.renderEngine.bindTexture(texture);
		int xOrigin = (width - xSize) / 2;
		int yOrigin = (height - ySize) / 2;
		drawTexturedModalRect(xOrigin, yOrigin, 0, 0, xSize, ySize);
		GL11.glDisable(3042);
		ItemStack itemStack = inventorySlots.getSlot(0).getStack();
		if (itemStack != null && itemStack.getItem() != null) {
			for (int col = 0; col < 7; ++col) {
				itemStack = inventorySlots.getSlot(1 + col).getStack();
				inventorySlots.getSlot(1 + col).yDisplayPosition = 29;
				if (itemStack != null && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 0 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 0 * 20, 176, 256, 18, 18);

				}
			}
			for (int col = 0; col < 7; ++col) {
				itemStack = inventorySlots.getSlot(8 + col).getStack();
				inventorySlots.getSlot(8 + col).yDisplayPosition = 29 + 20;
				if (itemStack != null && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 1 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 1 * 20, 176, 256, 18, 18);

				}
			}
			for (int col = 0; col < 7; ++col) {
				itemStack = inventorySlots.getSlot(15 + col).getStack();
				inventorySlots.getSlot(15 + col).yDisplayPosition = 29 + 40;
				if (itemStack != null && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 2 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 2 * 20, 176, 256, 18, 18);

				}
			}
		}else {
	        for(int z = 1; z < 22; z++) {
	        	inventorySlots.getSlot(z).yDisplayPosition = -1000;
	        }
		}
	        
	}
	
	
}
