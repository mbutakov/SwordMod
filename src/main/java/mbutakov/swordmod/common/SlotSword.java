package mbutakov.swordmod.common;

import mbutakov.swordmod.common.items.Sword;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSword extends Slot {

	private SlotSword swordSlot;

	public SlotSword(IInventory inventory, int i, int x, int y, SlotSword s) {
		super(inventory, i, x, y);
		this.swordSlot = s;
	}

	public boolean isItemValid(ItemStack stack) {
		return stack == null || stack.getItem() instanceof Sword;
	}

}
