package mbutakov.swordmod.common.items;

import java.util.Random;

import mbutakov.swordmod.mbMaterialSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;

public class CharacteristicSword {

	private double damageSword;
	private int chanceToCrit;
	private float critProcent;
	
	public CharacteristicSword(double damage,int chanceToCrit,float critProcent) {
		this.damageSword = damage;
		this.chanceToCrit = chanceToCrit;
		this.critProcent = critProcent;
	}
	
	public double getDamageSword(ItemStack stack) {
		return damageSword + getCountDamageModule(stack) * 50;
	}
	
	public float getCritProcent(ItemStack stack) {
		return this.critProcent + getCountCritCfModule(stack) * 0.05f;
	}
	public int getCritChance(ItemStack stack) {
		return this.chanceToCrit + getCountCritModule(stack) * 3;
	}
	
	public int getCountDamageModule(ItemStack item) {
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
						if(module.getUnlocalizedName().equals("item.Module Damage")){
							i1++;
						}
					}
				}
			}
		}
		}
		return i1;
	}
	
	public int getCountCritModule(ItemStack item) {
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
						if(module.getUnlocalizedName().equals("item.Module Crit")){
							i1++;
						}
					}
				}
			}
		}
		}
		return i1;
	}
	
	
	public int getCountCritCfModule(ItemStack item) {
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
						if(module.getUnlocalizedName().equals("item.Module CritCf")){
							i1++;
						}
					}
				}
			}
		}
		}
		return i1;
	}
	
	
	
	
	
	public boolean getCrit(int chance) {
		Random rand = new Random();
		int dropNum = rand.nextInt(100);
		if(dropNum <= chance) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
