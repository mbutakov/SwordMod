package mbutakov.swordmod.common;

import mbutakov.swordmod.common.items.ItemModule;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotModule extends Slot {

	private SlotSword swordSlot;
	private int slotID;
	   
	public SlotModule(IInventory inventory, int i, int x, int y, SlotSword s) {
		super(inventory, i, x, y);
		this.swordSlot = s;
		this.slotID = i;
	}

	public boolean isItemValid(ItemStack stack) {
		return swordSlot.getHasStack() == true && stack.getItem() instanceof ItemModule;
	}

}
