package mbutakov.swordmod.common.blocks.blockChangeSkin;

import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventorBlockChangeSkin extends InventoryBasic {

	public ItemStack lastGunStack;
	private boolean busy = false;

	public InventorBlockChangeSkin() {
		super("Sword Modification Table", true, 22);
	}
	
	public void markDirty() {

		if (!this.busy) {
			ItemStack gunStack = this.getStackInSlot(0);
			if (gunStack != null && gunStack.getItem() instanceof ItemSwordMb) {
				if (!gunStack.hasTagCompound()) {
					return;
				}
				if (gunStack.getTagCompound() == null) {
					return;
				}
				if (gunStack != this.lastGunStack) {
					busy = true;
					NBTTagCompound attachmentTags = gunStack.stackTagCompound.getCompoundTag("SwordModules");
					for(int i = 1; i <= 7; i++) {
						this.setInventorySlotContents(i,ItemStack.loadItemStackFromNBT(attachmentTags.getCompoundTag("module_" + i)));
					}
					for(int i = 1; i <= 7; i++) {
						this.setInventorySlotContents(7 + i,ItemStack.loadItemStackFromNBT(attachmentTags.getCompoundTag("module_" + (i + 7))));
					}
					for(int i = 1; i <= 7; i++) {
						this.setInventorySlotContents(14 + i,ItemStack.loadItemStackFromNBT(attachmentTags.getCompoundTag("module_" + (i + 14))));
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
					gunStack.stackTagCompound = gunTags;
				}
				this.lastGunStack = gunStack;
			}
		}
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
