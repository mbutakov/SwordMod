package ru.mbutakov.common.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.mbutakov.common.items.ItemModule;

public class SlotModule extends Slot {

	private SlotSword swordSlot;
	   
	public SlotModule(IInventory inventory, int i, int x, int y, SlotSword s) {
		super(inventory, i, x, y);
		this.swordSlot = s;
	}

	public boolean isItemValid(ItemStack stack) {
		return swordSlot.getHasStack() == true && stack.getItem() instanceof ItemModule;
	}

}
