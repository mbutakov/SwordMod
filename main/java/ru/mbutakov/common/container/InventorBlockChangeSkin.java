package ru.mbutakov.common.container;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ru.mbutakov.common.items.ItemAuroraSword;

public class InventorBlockChangeSkin extends InventoryBasic {

	public ItemStack lastGunStack;
	private boolean busy = false;
	public InventorBlockChangeSkin() {
		super("Sword Modification Table", true, 22);
	}
	
	public void markDirty() {
		if (!this.busy) {
			ItemStack swordStack = this.getStackInSlot(0);
			if (swordStack != null && swordStack.getItem() instanceof ItemAuroraSword) {
				if (!swordStack.hasTagCompound()) {
					return;
				}
				if (swordStack.getTagCompound() == null) {
					return;
				}
				
				if (swordStack != this.lastGunStack) {
					busy = true;
						NBTTagCompound attachmentTags = swordStack.getTagCompound().getCompoundTag("SwordModules");
						ItemStack moduleItem;
						for(int i = 1; i <= 7; i++) {
							moduleItem = new ItemStack(attachmentTags.getCompoundTag("module_" + i));
							if(moduleItem.getItem() == Items.AIR) {
								moduleItem = ItemStack.EMPTY;
							}
							this.setInventorySlotContents(i,moduleItem);
						}
						for(int i = 1; i <= 7; i++) {
							this.setInventorySlotContents(7 + i,new ItemStack(attachmentTags.getCompoundTag("module_" + (i + 7))));
						}
						for(int i = 1; i <= 7; i++) {
							this.setInventorySlotContents(14 + i,new ItemStack(attachmentTags.getCompoundTag("module_" + (i + 14))));
						}
		

					this.busy = false;
				}else {
					NBTTagCompound gunTags = new NBTTagCompound();
					NBTTagCompound attachmentTags = new NBTTagCompound();
					for(int i = 1; i <= 7; i++) {
						this.writeAttachmentTags(attachmentTags, this.getStackInSlot(i), "module_" + i);
					}
					for(int i = 1; i <= 7; i++) {
						this.writeAttachmentTags(attachmentTags, this.getStackInSlot(7 + i), "module_" + (i + 7));
					}
					for(int i = 1; i <= 7; i++) {
						this.writeAttachmentTags(attachmentTags, this.getStackInSlot(14 + i), "module_" + (i + 14));
					}

					gunTags.setTag("SwordModules", attachmentTags);
					swordStack.setTagCompound(gunTags);
				}
				this.lastGunStack = swordStack;
			}
		}
	}

	public boolean hasNbtSwordModules(ItemStack item) {
		if(item == null) {
			return false;
		}
		if (!item.hasTagCompound()) {
			return false;
		}
		NBTTagCompound nbt = item.getTagCompound();
		NBTTagCompound modulesTags = nbt.getCompoundTag("SwordModules");
		if (modulesTags.hasNoTags()) {
			return false;
		}
		
		return true;
	}
	
	public void writeAttachmentTags(NBTTagCompound attachmentTags, ItemStack attachmentStack, String attachmentName) {
		NBTTagCompound tags = new NBTTagCompound();
		if (attachmentStack != null) {
			attachmentStack.writeToNBT(tags);
		}

		attachmentTags.setTag(attachmentName, tags);
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

}
