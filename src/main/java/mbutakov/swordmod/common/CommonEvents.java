package mbutakov.swordmod.common;

import java.util.Random;

import javax.swing.text.html.CSS;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mbutakov.swordmod.common.items.CharacteristicSword;
import mbutakov.swordmod.common.items.ItemSwordMb;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class CommonEvents {

    private void addDrop(final LivingDropsEvent event, final ItemStack drop) {
        final EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.delayBeforeCanPickup = 10;
        event.drops.add(entityitem);
    }
    
	@SubscribeEvent
    public void onPlayerAttacked(LivingAttackEvent event) {
	    if (event.isCanceled())
	        return; 
    }
    
	@SubscribeEvent
	public void onLivingDrops(final LivingDropsEvent event) {
		if (event.recentlyHit && event.source.getEntity() instanceof EntityPlayer) {
			final EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (event.entityLiving instanceof EntitySkeleton) {
				if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemSwordMb) {
					if (getCountHeadModule(player.getHeldItem()) > 0) {
						Random rand = new Random();
						if (rand.nextBoolean()) {
							this.addDrop(event, new ItemStack(Items.skull, 1, 1));
						}
					}
				}
			}
			if (event.entityLiving instanceof EntityCreeper) {
				if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemSwordMb) {
					if (getCountHeadModule(player.getHeldItem()) > 0) {
						Random rand = new Random();
						if (rand.nextBoolean()) {
							this.addDrop(event, new ItemStack(Items.skull, 1, 4));
						}
					}
				}
			}

			if (event.entityLiving instanceof EntityZombie) {
				if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemSwordMb) {
					if (getCountHeadModule(player.getHeldItem()) > 0) {
						Random rand = new Random();
						if (rand.nextBoolean()) {
							this.addDrop(event, new ItemStack(Items.skull, 1, 2));
						}
					}
				}
			}
		}
	}

	
	public int getCountHeadModule(ItemStack item) {
		if(item == null) {
			return 0;
		}
		int i1 = 0;
		if (item.hasTagCompound()) {
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagCompound modulesTags = nbt.getCompoundTag("SwordModules");
		if (!modulesTags.hasNoTags()) {
			int xx = 0;
			for (int i = 1; i <= 21; i++) {
				if (modulesTags.getCompoundTag("module_" + i) != null) {
					ItemStack module = ItemStack.loadItemStackFromNBT(modulesTags.getCompoundTag("module_" + i));
					if (module != null) {
						if(module.getUnlocalizedName().equals("item.Module Head")){
							i1++;
						}
					}
				}
			}
		}
		}
		return i1;
	}
}
