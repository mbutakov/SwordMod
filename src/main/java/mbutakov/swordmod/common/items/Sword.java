package mbutakov.swordmod.common.items;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector.Characteristics;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import mbutakov.swordmod.mbItemRegister;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.Super;

public class Sword extends ItemSword {
	
	
	private int colorEffectSword;
	private СharacteristicSword cs;
	
	public Sword(String nameTexture,String name,СharacteristicSword cs,int params[]) {
		super(mbMaterialSword.Bleach);
		this.cs = cs;
		setCreativeTab(CreativeTabs.tabMisc);
		setFull3D();
		setTextureName(Main.MODID.toLowerCase() +":" + nameTexture);
		setUnlocalizedName(name);
		setCreativeTab(Main.swordTab);
		this.colorEffectSword = params[0];
		GameRegistry.registerItem(this, name); 
	}

	
	public void onUpdate(ItemStack item, World w, Entity e, int p_77663_4_, boolean p_77663_5_) {
		EntityPlayer player = (EntityPlayer) e;
		if(player.swingProgressInt == -1 && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof Sword) {
			 player.playSound("mbSwordMod:swingblade", 1.0F, 0.75F + player.getRNG().nextFloat() * 0.3F);
		}
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer ep, List l, boolean p_77624_4_) {
    	l.add(EnumChatFormatting.GRAY + "Урон: " + EnumChatFormatting.AQUA + cs.getDamageSword());
    	l.add(EnumChatFormatting.GRAY + "Шанс крита: " + EnumChatFormatting.AQUA + cs.getCritChance() + "%");
    	l.add(EnumChatFormatting.GRAY + "Коэффициент крита: " + EnumChatFormatting.AQUA + (cs.getCritProcent()+1) + "%");
    	l.add(EnumChatFormatting.DARK_GRAY + "Зажмите shift ");
    	if(Keyboard.isKeyDown(42)) {
    		l.add(EnumChatFormatting.GRAY + "Установленные модули:");
        	
    	}
    }

    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase target, EntityLivingBase attacker)
    {
		if (attacker instanceof EntityPlayer) {
			
	    	if(cs.getCrit(cs.getCritChance()) == true) {
	    		float addDamage = (float) (((itemRand.nextFloat() * cs.getDamageSword()) /cs.getDamageSword()) * 5);
	    		float finalCritDamage = (float) ((float) addDamage + (cs.getDamageSword() * cs.getCritProcent()));	
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker),(float) finalCritDamage);
				((EntityPlayer) attacker).addChatMessage(new ChatComponentText("Вы нанесли крит атаку + " + (int)(finalCritDamage) + " + " + (int)(cs.getDamageSword())));
	    	}
		}
        return true;
    }
	
	@Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.clear();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", cs.getDamageSword(), 0));
        return multimap;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack p_77636_1_) {
		return false;
	}

	public int getColorEffect() {
		return colorEffectSword;
	}
}
