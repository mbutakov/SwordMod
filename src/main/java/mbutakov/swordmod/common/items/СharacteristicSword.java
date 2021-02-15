package mbutakov.swordmod.common.items;

import java.util.Random;

import mbutakov.swordmod.mbMaterialSword;
import net.minecraft.item.ItemSword;

public class СharacteristicSword {

	private double damageSword;
	private int chanceToCrit;
	private float critProcent;
	
	public СharacteristicSword(double damage,int chanceToCrit,float critProcent) {
		this.damageSword = damage;
		this.chanceToCrit = chanceToCrit;
		this.critProcent = critProcent;
	}
	
	public double getDamageSword() {
		return damageSword;
	}
	
	public float getCritProcent() {
		return this.critProcent;
	}
	public int getCritChance() {
		return this.chanceToCrit;
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
