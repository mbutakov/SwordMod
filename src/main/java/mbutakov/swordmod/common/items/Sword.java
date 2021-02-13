package mbutakov.swordmod.common.items;

import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbMaterialSword;
import mbutakov.swordmod.common.entity.EntityParticleFireFx;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.Super;

public class Sword extends ItemSword {
	
	
	private int colorEffectSword;
	private double damageSword;
	private int chanceToCrit;
	private float critProcent;
	
	public Sword(String nameTexture,String name,double damage,int chanceToCrit,float critProcent,int params[]) {
		super(mbMaterialSword.Bleach);
		setCreativeTab(CreativeTabs.tabMisc);
		setFull3D();
		setTextureName(":" + nameTexture);
		setUnlocalizedName(name);
		setCreativeTab(Main.swordTab);
		GameRegistry.registerItem(this, name); 
		this.damageSword = damage;
		this.colorEffectSword = params[0];
		this.chanceToCrit = chanceToCrit;
		this.critProcent = critProcent;
		
	}

	
	public void onUpdate(ItemStack item, World w, Entity e, int p_77663_4_, boolean p_77663_5_) {
		EntityPlayer player = (EntityPlayer) e;
		if(player.swingProgressInt == -1 && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof Sword) {
			 player.playSound("mbSwordMod:swingblade", 1.0F, 0.75F + player.getRNG().nextFloat() * 0.05F);
		}
	}
	
	
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase elb, EntityLivingBase elbDamageCause)
    {
		if (elbDamageCause instanceof EntityPlayer) {
	    	if(getCrit(getCritChance()) == true) {
	    		float addDamage = (float) (((itemRand.nextFloat() * damageSword) /damageSword) * 5);
	    		float finalCritDamage = (float) ((float) addDamage + (damageSword * getCritProcent()));	
				elb.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) elbDamageCause),(float) finalCritDamage);
				((EntityPlayer) elbDamageCause).addChatMessage(new ChatComponentText("Вы нанесли крит атаку + " + (int)(finalCritDamage) + " + " + (int)(damageSword)));
	    	}
		}
        return true;
    }
    
	
	@Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.clear();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.damageSword, 0));
        return multimap;
    }
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack p_77636_1_) {
		return false;
	}

	public float getCritProcent() {
		return this.critProcent - 1;
	}
	public int getCritChance() {
		return this.chanceToCrit;
	}
	
	
	public boolean getCrit(int chance) {
		Random rand = new Random();
		int dropNum = rand.nextInt(100);
		if(dropNum < chance) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getColorEffect() {
		return colorEffectSword;
	}
}
