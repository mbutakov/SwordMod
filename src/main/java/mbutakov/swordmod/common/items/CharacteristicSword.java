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
			int gcm[] = {0,0,0,0,0,0,0,0,0,0};
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
		int moduleDeathHit = 0;
		int moduleDeathHitAdmin = 0;
		int moduleEffect = 0;
		int moduletrGold = 0;
		int moduletrSilver = 0;
		int moduletrRed = 0;
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
						if(module.getUnlocalizedName().equals("item.Module DeathHit")) {
							moduleDeathHit++;
						}
						if(module.getUnlocalizedName().equals("item.Module Effect")) {
							moduleEffect++;
						}
						if(module.getUnlocalizedName().equals("item.Module DeathHitA")) {
							moduleDeathHit++;
						}
						if(module.getUnlocalizedName().equals("item.Module trGold")) {
							moduletrGold++;
						}
						if(module.getUnlocalizedName().equals("item.Module trSilver")) {
							moduletrSilver++;
						}
						if(module.getUnlocalizedName().equals("item.Module trRed")) {
							moduletrRed++;
						}
					}
				}
			}
		}
		String s =  moduleCrit + "/" + moduleDamage + "/" + moduleCritCf + "/" + moduleHead + "/" + moduleBlind + "/" + modulePosion + "/" + moduleSplash3 + "/" + moduleSplash5 + "/" + moduleDeathHit + "/" + moduleEffect + "/" + moduleDeathHitAdmin + "/" + moduletrSilver + "/" + moduletrRed + "/" + moduletrGold;
    	String [] stringModuleCount  = s.split("/");
    	int [] countModules = new int[stringModuleCount.length];
    	for(int i = 0; i < stringModuleCount.length; i++) {
    		countModules[i] = Integer.parseInt(stringModuleCount[i]);
    	}
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
