package mbutakov.swordmod.common.blocks.blockChangeSkin;

import mbutakov.swordmod.common.SlotModule;
import mbutakov.swordmod.common.SlotSword;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerBlockChangeSkin extends Container {

	   private InventorBlockChangeSkin inventory;
	   public InventoryPlayer playerInv;
	   public World world;

	   public ContainerBlockChangeSkin(InventoryPlayer i, World w) {
	      this.playerInv = i;
	      this.inventory = new InventorBlockChangeSkin();
	      this.world = w;
	      SlotSword swordSlot = new SlotSword(this.inventory, 0, 9, 48, (SlotSword)null);
	      this.addSlotToContainer(swordSlot);
	      for(int col = 0; col < 7; ++col) {
	             this.addSlotToContainer(new SlotModule(this.inventory,  1 +col, 30 + col * 21, 29 + 0, swordSlot));
	       }
	      for(int col = 0; col < 7; ++col) {
	             this.addSlotToContainer(new SlotModule(this.inventory,  8 + col, 30 + col * 21, 29 + 20, swordSlot));
	       }
	      for(int col = 0; col < 7; ++col) {
	             this.addSlotToContainer(new SlotModule(this.inventory,  15+ col, 30 + col * 21, 29 + 40, swordSlot));
	       }
	      
	      for(int row = 0; row < 3; ++row) {
	          for(int col = 0; col < 9; ++col) {
	             this.addSlotToContainer(new Slot(this.playerInv, col + row * 9 + 9, 8 + col * 18, 114 + row * 18));
	          }
	       }
	      for(int col = 0; col < 9; ++col) {
	          this.addSlotToContainer(new Slot(this.playerInv, col, 8 + col * 18, 172));
	       }
	      
	   }
	   
	public void onContainerClosed(EntityPlayer player) {
		if (this.inventory.getStackInSlot(0) != null) {
			player.dropPlayerItemWithRandomChoice(this.inventory.getStackInSlot(0), false);
		}

	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotID) {
		ItemStack stack = null;
        int slotCountContainer = this.inventorySlots.size() - 36;
        int slotIdPlusInventory = slotCountContainer + inventorySlots.size();
		Slot currentSlot = (Slot) super.inventorySlots.get(slotID);
	      if(currentSlot != null && currentSlot.getHasStack()) {
	          ItemStack slotStack = currentSlot.getStack();
	          stack = slotStack.copy();
	          if(slotID >= slotCountContainer) {
	             return null;
	          }
	          if(slotStack.stackSize == 0) {
	              currentSlot.putStack((ItemStack)null);
	           } else {
	              currentSlot.onSlotChanged();
	           }
	          if(slotStack.stackSize == stack.stackSize) {
	              return null;
	           }
	          currentSlot.onPickupFromSlot(player, slotStack);
	          
	      }
		return stack;
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return true;
	}

}
