package ru.mbutakov.common.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.mbutakov.common.items.ItemAuroraSword;

public class SlotSword extends Slot {


	public SlotSword(IInventory inventory, int i, int x, int y, SlotSword s) {
		super(inventory, i, x, y);
	}

	public boolean isItemValid(ItemStack stack) {
		return stack == null || stack.getItem() instanceof ItemAuroraSword;
	}

}
