package mbutakov.swordmod.client.gui;

import cpw.mods.fml.client.config.GuiSlider;
import mbutakov.swordmod.client.config.SwordModConfig;
import mbutakov.swordmod.utils.GuiCustomButton;
import mbutakov.swordmod.utils.GuiSliderButton;
import mbutakov.swordmod.utils.GuiUtils;
import mbutakov.swordmod.utils.ISliderListener;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.GameSettings.Options;
import net.minecraft.util.EnumChatFormatting;

public class GuiOptionsSwordMod extends GuiScreen implements ISliderListener {
	
	public void initGui(){
		buttonList.add(new GuiCustomButton(0, this.width /2 - 30,this.height/2 - 25, 60, 20, SwordModConfig.isOffOtherPlayer == 0 ? "Да" : "Нет" + "", SwordModConfig.isOffOtherPlayer == 0 ? "0x34324" : "0xd11717"));
        GuiSliderButton slider = new GuiSliderButton(this, 1,  this.width/2 - 50, this.height/2 + 15, 100, 20,((float)SwordModConfig.distanceRenderParticle)/80);
        buttonList.add(slider);
        buttonList.add(new GuiCustomButton(1, this.width /2 - 30,this.height/2 + 55, 60, 20, SwordModConfig.offRenderInInventory == 1 ? "Да" : "Нет" + "", SwordModConfig.offRenderInInventory == 1 ? "0x34324" : "0xd11717"));
        
	}
	
	public void drawScreen(int x, int y, float partialTicks){
        this.drawCenteredString(this.fontRendererObj, EnumChatFormatting.RESET + "Настройки " + EnumChatFormatting.LIGHT_PURPLE  + EnumChatFormatting.UNDERLINE +  "Sword Mod", this.width / 2, this.height/2 - 60, 0xffbcd9);
        this.drawCenteredString(this.fontRendererObj, "Включить частицы от меча", this.width / 2 , this.height/2 - 40, 0xff9baa);
        this.drawCenteredString(this.fontRendererObj, "Дальность прорисовки частиц", this.width / 2 , this.height/2 , 0xff9baa);
        this.drawCenteredString(this.fontRendererObj, "Рендер предмета в инвентаре", this.width / 2 , this.height/2 + 40, 0xff9baa);
        
        super.drawScreen(x, y, partialTicks);
	}
	
	public void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			if (SwordModConfig.isOffOtherPlayer == 1) {
				SwordModConfig.isOffOtherPlayer = 0;
			} else {
				SwordModConfig.isOffOtherPlayer = 1;
			}
			SwordModConfig.save();
			this.mc.displayGuiScreen((GuiScreen) null);
		}
		if (button.id == 1) {
			if (SwordModConfig.offRenderInInventory == 1) {
				SwordModConfig.offRenderInInventory = 0;
			} else {
				SwordModConfig.offRenderInInventory = 1;
			}
			SwordModConfig.save();
			this.mc.displayGuiScreen((GuiScreen) null);
		}
	}
	
    public boolean doesGuiPauseGame()
    {
        return false;
    }

	@Override
	public void mouseDragged(GuiSliderButton guiSliderButton) {
		guiSliderButton.displayString =  ""  + (int) (guiSliderButton.sliderValue * 80) + " блоков";
	}

	@Override
	public void mousePressed(GuiSliderButton guiSliderButton) {
		
	}

	@Override
	public void mouseReleased(GuiSliderButton guiSliderButton) {
		SwordModConfig.distanceRenderParticle = (int) (guiSliderButton.sliderValue * 80);
		SwordModConfig.save();
	}

}
