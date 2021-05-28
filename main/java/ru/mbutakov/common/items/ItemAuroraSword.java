package ru.mbutakov.common.items;

import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAuroraSword extends ItemSword {

	private CharacteristicSword cs;
	
	public ItemAuroraSword(String name,CharacteristicSword cs,int params[]) {
		super(ToolMaterial.DIAMOND);
		this.cs = cs;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.FOOD);
	}
	
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (stack.hasTagCompound()) {
			
		}else {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
    }
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	tooltip.add(TextFormatting.GRAY + "Урон: " + TextFormatting.AQUA + (int)(cs.getDamageSword(stack)));
    	tooltip.add(TextFormatting.GRAY + "Шанс крита: " + TextFormatting.AQUA + cs.getCritChance(stack) + "%");
    	tooltip.add(TextFormatting.GRAY + "Коэффициент крита: " + TextFormatting.AQUA + (int)((cs.getCritProcent(stack)) * 100) + "%");
    	tooltip.add(TextFormatting.DARK_GRAY + "Зажмите shift ");
    	if(Keyboard.isKeyDown(42)) {
    		tooltip.add(TextFormatting.GRAY + "Установленные модули:");
    		if(cs.hasNbtSwordModules(stack)) {
				if (cs.getCountModules(stack)[2] > 0) {
					tooltip.add(TextFormatting.AQUA + "Модуль крит коэффициента " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[2]);
				}
				if (cs.getCountModules(stack)[0] > 0) {
					tooltip.add(TextFormatting.AQUA + "Модуль крит шанса " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[0]);
				}
				if (cs.getCountModules(stack)[1] > 0) {
					tooltip.add(TextFormatting.AQUA + "Модуль урона " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[1]);
				}
				if (cs.getCountModules(stack)[3] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль выпадения головы " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[3]);
				}
				if (cs.getCountModules(stack)[4] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль Слепоты " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[4]);
				}
				if (cs.getCountModules(stack)[5] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль Отравления " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[5]);
				}
				if (cs.getCountModules(stack)[6] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль Сплеш атаки 3 " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[6]);
				}
				if (cs.getCountModules(stack)[7] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль Сплеш атаки 5 " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[7]);
				}
				if (cs.getCountModules(stack)[8] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль мгновенной смерти " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[8]);
				}
				if (cs.getCountModules(stack)[9] > 0) { 
					tooltip.add(TextFormatting.AQUA + "Модуль частиц " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[9]);
				}
				if (cs.getCountModules(stack)[10] > 0) { 
					tooltip.add(TextFormatting.GOLD + "Модуль мгновенной смерти " + TextFormatting.DARK_PURPLE + "x" + cs.getCountModules(stack)[10]);
				}
				if (cs.getCountModules(stack)[11] > 0) { 
					tooltip.add(TextFormatting.RED + "Модуль переливания Серебрянный");
				}
				if (cs.getCountModules(stack)[12] > 0) { 
					tooltip.add(TextFormatting.RED + "Модуль переливания Красный");
				}
				if (cs.getCountModules(stack)[13] > 0) { 
					tooltip.add(TextFormatting.RED + "Модуль переливания Золотой");
				}
				int total = 0;
				for(int i = 0; i < cs.getCountModules(stack).length; i++) {
					total += cs.getCountModules(stack)[i];
				}
				if(total == 0) {
					tooltip.add(TextFormatting.YELLOW + "Отсутствуют");
				}
    		}else {
				tooltip.add(TextFormatting.YELLOW + "Отсутствуют");

    		}
    	}
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if (attacker instanceof EntityPlayer) {
		} else {
			return true;
		}
		
		if(cs.getCountModules(stack)[5] > 0) {
		    target.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 200, 2));
		}
		if(cs.getCountModules(stack)[4] > 0) {
			   target.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 60, 2));
		}
		if (cs.getCountModules(stack)[8] > 0) { 
			if(cs.getCrit(1)) {
				if(target instanceof EntityPlayer) {
					 target.attackEntityFrom(new DamageSource("administrative.kill"), Float.MAX_VALUE);
				}
			}
		}
		if (cs.getCountModules(stack)[10] > 0) { 
				if(target instanceof EntityPlayer) {
				    target.attackEntityFrom(new DamageSource("administrative.kill"), Float.MAX_VALUE);
			}
		}
		float addDamage = 0;
		float finalCritDamage = 0;
		if (cs.getCrit(cs.getCritChance(stack)) == true) {
			addDamage = (float) (((itemRand.nextFloat() * cs.getDamageSword(stack)) / cs.getDamageSword(stack)) * 5);
			finalCritDamage = (float) ((float) addDamage + (cs.getDamageSword(stack) * cs.getCritProcent(stack)));
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), (float) finalCritDamage);

		}
		return true;
		
    }
    

}
