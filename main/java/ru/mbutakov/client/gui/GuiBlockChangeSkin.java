package ru.mbutakov.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.mbutakov.common.container.ContainerBlockChangeSkin;
import ru.mbutakov.common.items.ItemAuroraSword;

public class GuiBlockChangeSkin extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("mswordmod", "textures/gui/smt.png");
	
	public GuiBlockChangeSkin(InventoryPlayer inv, World w) 
	{
		super(new ContainerBlockChangeSkin(inv, w));
		ySize = 256;
	}
	
	
    @Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
    {
    	fontRenderer.drawString("Инвентарь", 8, 100 + 2, 0x404040);
    	fontRenderer.drawString("Модификация меча", 40, 3, 0x404040);
    	ItemStack swordStack = inventorySlots.getSlot(0).getStack();
        if(swordStack != null && swordStack.getItem() instanceof ItemAuroraSword)
        {
        	renderCenteredText(swordStack.getDisplayName(), xSize/2, 17, 0x404040);
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
				inventorySlots.getSlot(1 + col).yPos = 29;
				if (itemStack != null && itemStack.getItem() != Items.AIR && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 0 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 0 * 20, 176, 256, 18, 18);

				}
			}
			for (int col = 0; col < 7; ++col) {
				itemStack = inventorySlots.getSlot(8 + col).getStack();
				inventorySlots.getSlot(8 + col).yPos = 29 + 20;
				if (itemStack != null && itemStack.getItem() != Items.AIR && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 1 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 1 * 20, 176, 256, 18, 18);

				}
			}
			for (int col = 0; col < 7; ++col) {
				itemStack = inventorySlots.getSlot(15 + col).getStack();
				inventorySlots.getSlot(15 + col).yPos = 29 + 40;
				if (itemStack != null && itemStack.getItem() != Items.AIR && itemStack.getItem() != null) {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 2 * 20, 194, 256, 18, 18);
				} else {
					drawTexturedModalRect(xOrigin + 29 + col * 21, yOrigin + 28 + 2 * 20, 176, 256, 18, 18);

				}
			}
		}else {
	        for(int z = 1; z < 22; z++) {
	        	inventorySlots.getSlot(z).yPos = -1000;
	        }
		}
	        
	}
	
	
    

    
    public static void renderCenteredText(final String text, final int posX, final int posY, final int par4) {
        final Minecraft mc = Minecraft.getMinecraft();
        mc.fontRenderer.drawString(text, posX - mc.fontRenderer.getStringWidth(text) / 2, posY, par4);
    }
	
}
