package mbutakov.swordmod.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import mbutakov.swordmod.client.ClientProxy;
import mbutakov.swordmod.client.gui.GuiOptionsSwordMod;
import mbutakov.swordmod.client.render.RenderItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ClientEvents {
	
	@SubscribeEvent
	public void tickers(TickEvent.RenderTickEvent event) {
		RenderItemSword.renderTicks = event.renderTickTime;
	}
	
	@SubscribeEvent
	public void keyPress(KeyInputEvent event) {
		if (ClientProxy.KeyOpenSwordModGui.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiOptionsSwordMod());
		}
	}
}
