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
		return damageSword + getCountModules(stack)[1] * 50;
	}
	
	public float getCritProcent(ItemStack stack) {
		return this.critProcent + getCountModules(stack)[2] * 0.05f;
	}
	public int getCritChance(ItemStack stack) {
		return this.chanceToCrit + getCountModules(stack)[0] * 3;
	}
	
	public int[] getCountModules(ItemStack item) {
		if(item == null) {
			int gcm[] = {0,0,0,0,0,0,0,0};
			return gcm ;
		}
		int moduleDamage = 0;
		int moduleCrit = 0;
		int moduleHead = 0;
		int moduleCritCf = 0;
		int modulePosion = 0;
		int moduleBlind = 0;
		int moduleSplash3 = 0;
		int moduleSplash5 = 0;
		if (hasNbtSwordModules(item)) {
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagCompound modulesTags = nbt.getCompoundTag("SwordModules");
			for (int i = 1; i <= 21; i++) {
				if (modulesTags.getCompoundTag("module_" + i) != null) {
					ItemStack module = ItemStack.loadItemStackFromNBT(modulesTags.getCompoundTag("module_" + i));
					if (module != null) {
						if(module.getUnlocalizedName().equals("item.Module Crit")){
							moduleCrit++;
						}
						if(module.getUnlocalizedName().equals("item.Module Head")){
							moduleHead++;
						}
						if(module.getUnlocalizedName().equals("item.Module Damage")){
							moduleDamage++;
						}
						if(module.getUnlocalizedName().equals("item.Module CritCf")){
							moduleCritCf++;
						}
						if(module.getUnlocalizedName().equals("item.Module posion")){
							modulePosion++;
						}
						if(module.getUnlocalizedName().equals("item.Module Blind")){
							moduleBlind++;
						}
						if(module.getUnlocalizedName().equals("item.Module Splash 3")){
							moduleSplash3++;
						}
						if(module.getUnlocalizedName().equals("item.Module Splash 5")){
							moduleSplash5++;
						}
						
					}
				}
			}
		}
		String s =  moduleCrit + "/" + moduleDamage + "/" + moduleCritCf + "/" + moduleHead + "/" + moduleBlind + "/" + modulePosion + "/" + moduleSplash3 + "/" + moduleSplash5 ;
    	String [] stringModuleCount  = s.split("/");
    	int [] countModules = {Integer.parseInt(stringModuleCount[0]),Integer.parseInt(stringModuleCount[1]),Integer.parseInt(stringModuleCount[2]),Integer.parseInt(stringModuleCount[3]),Integer.parseInt(stringModuleCount[4]),Integer.parseInt(stringModuleCount[5]),Integer.parseInt(stringModuleCount[6]),Integer.parseInt(stringModuleCount[7])};
 
		return countModules;
		
		
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
