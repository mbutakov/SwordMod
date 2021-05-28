package ru.mbutakov.common;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import ru.mbutakov.client.gui.GuiBlockChangeSkin;
import ru.mbutakov.common.container.ContainerBlockChangeSkin;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_TUTORIAL_CONTAINER_ID = 0;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_TUTORIAL_CONTAINER_ID:
                return new ContainerBlockChangeSkin(player.inventory, world);
            default: return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_TUTORIAL_CONTAINER_ID:
                return new GuiBlockChangeSkin(player.inventory, world);
            default: return null;
        }
    }
}