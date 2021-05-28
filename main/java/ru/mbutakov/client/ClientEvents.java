package ru.mbutakov.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class ClientEvents {

	public final static Minecraft mc = Minecraft.getMinecraft();
	public final static FontRenderer fontRenderer = mc.fontRenderer;
	
	//open gui option sword mod
	@SubscribeEvent
	public void keyPress(KeyInputEvent event) {
		//if (ClientProxy.KeyOpenSwordModGui.isPressed()) {
	//		Minecraft.getMinecraft().displayGuiScreen(new GuiOptionsSwordMod());
		//}
	}
	
	@SubscribeEvent
	public void itemDamageRemove(ItemTooltipEvent event) {
//		int startIndex = 0;
//		ItemStack is = event.getItemStack();
//		if (is.getItem() instanceof ItemAuroraSword) {
//			for (int i = 0; i < event.getToolTip().size(); i++) {
//				if (event.getToolTip().get(i).startsWith("When") ) {
//					startIndex = i;
//					for(int j = startIndex; j < event.getToolTip().size(); j++) {
//						event.getToolTip().remove(j);
//					}
//				}
//			}
		//}
	}
	
	
}
