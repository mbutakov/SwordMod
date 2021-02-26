package mbutakov.swordmod.common.items;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collector.Characteristics;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Sound;

import com.google.common.collect.Multimap;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.reflect.internal.Trees.Super;

public class ItemSwordMb extends ItemSword {
	
	
	private int colorEffectSword;
	private CharacteristicSword cs;
	private int damageAddModule;
	public static final DamageSource ADMIN_KILL = (new DamageSource("mbswordmod.hitAdmin")).setDamageAllowedInCreativeMode().setDamageBypassesArmor().setDamageIsAbsolute();
	public ItemSwordMb(String nameTexture,String name,CharacteristicSword cs,int params[]) {
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
		if(player.swingProgressInt == -1 && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemSwordMb) {
			 player.playSound("mbSwordMod:swingblade", 1.0F, 0.75F + player.getRNG().nextFloat() * 0.3F);
		}
		if (item.hasTagCompound()) {
			
		}else {
			NBTTagCompound nbt = new NBTTagCompound();
			item.stackTagCompound = nbt;
		}
	
	}
	
	public CharacteristicSword getCs (ItemStack item) {
		return this.cs;
		
	}
	
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer ep, List l, boolean p_77624_4_) {
    	l.add(EnumChatFormatting.GRAY + "Урон: " + EnumChatFormatting.AQUA + (int)(cs.getDamageSword(is)));
    	l.add(EnumChatFormatting.GRAY + "Шанс крита: " + EnumChatFormatting.AQUA + cs.getCritChance(is) + "%");
    	l.add(EnumChatFormatting.GRAY + "Коэффициент крита: " + EnumChatFormatting.AQUA + (int)((cs.getCritProcent(is)) * 100) + "%");
    	l.add(EnumChatFormatting.DARK_GRAY + "Зажмите shift ");
    	if(Keyboard.isKeyDown(42)) {
    		l.add(EnumChatFormatting.GRAY + "Установленные модули:");
    		if(cs.hasNbtSwordModules(is)) {
    			NBTTagCompound nbt = is.getTagCompound();
    			NBTTagCompound modulesTags = nbt.getCompoundTag("SwordModules");
				if (cs.getCountModules(is)[2] > 0) {
					l.add(EnumChatFormatting.AQUA + "Модуль крит коэффициента " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[2]);
				}
				if (cs.getCountModules(is)[0] > 0) {
					l.add(EnumChatFormatting.AQUA + "Модуль крит шанса " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[0]);
				}
				if (cs.getCountModules(is)[1] > 0) {
					l.add(EnumChatFormatting.AQUA + "Модуль урона " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[1]);
				}
				if (cs.getCountModules(is)[3] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль выпадения головы " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[3]);
				}
				if (cs.getCountModules(is)[4] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль Слепоты " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[4]);
				}
				if (cs.getCountModules(is)[5] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль Отравления " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[5]);
				}
				if (cs.getCountModules(is)[6] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль Сплеш атаки 3 " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[6]);
				}
				if (cs.getCountModules(is)[7] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль Сплеш атаки 5 " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[7]);
				}
				if (cs.getCountModules(is)[8] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль мгновенной смерти " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[8]);
				}
				if (cs.getCountModules(is)[9] > 0) { 
					l.add(EnumChatFormatting.AQUA + "Модуль частиц " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[9]);
				}
				if (cs.getCountModules(is)[10] > 0) { 
					l.add(EnumChatFormatting.GOLD + "Модуль мгновенной смерти " + EnumChatFormatting.DARK_PURPLE + "x" + cs.getCountModules(is)[10]);
				}
				if (cs.getCountModules(is)[11] > 0) { 
					l.add(EnumChatFormatting.RED + "Модуль переливания Серебрянный");
				}
				if (cs.getCountModules(is)[12] > 0) { 
					l.add(EnumChatFormatting.RED + "Модуль переливания Красный");
				}
				if (cs.getCountModules(is)[13] > 0) { 
					l.add(EnumChatFormatting.RED + "Модуль переливания Золотой");
				}
				int total = 0;
				for(int i = 0; i < cs.getCountModules(is).length; i++) {
					total += cs.getCountModules(is)[i];
				}
				if(total == 0) {
					l.add(EnumChatFormatting.YELLOW + "Отсутствуют");
				}
    		}else {
				l.add(EnumChatFormatting.YELLOW + "Отсутствуют");

    		}
    	}
    }

	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase attacker) {
		if (attacker instanceof EntityPlayer) {
		} else {
			return true;
		}
		
		if(cs.getCountModules(is)[5] > 0) {
		    target.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 2, true));
		}
		if(cs.getCountModules(is)[4] > 0) {
			   target.addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 2, true));
		}
		if (cs.getCountModules(is)[8] > 0) { 
			if(cs.getCrit(1)) {
				if(target instanceof EntityPlayer) {
					 target.attackEntityFrom(new DamageSource("administrative.kill"), Float.MAX_VALUE);
				}
			}
		}
		if (cs.getCountModules(is)[10] > 0) { 
				if(target instanceof EntityPlayer) {
				    target.attackEntityFrom(new DamageSource("administrative.kill"), Float.MAX_VALUE);
			}
		}
		float finalDamage = 0;
		float addDamage = 0;
		float finalCritDamage = 0;
		if (cs.getCrit(cs.getCritChance(is)) == true) {
			addDamage = (float) (((itemRand.nextFloat() * cs.getDamageSword(is)) / cs.getDamageSword(is)) * 5);
			finalCritDamage = (float) ((float) addDamage + (cs.getDamageSword(is) * cs.getCritProcent(is)));
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), (float) finalCritDamage);

		}
		return true;
	}
	
    public boolean onLeftClickEntity(ItemStack is, EntityPlayer player, Entity entity)
    {
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).hurtTime == 0 && !((EntityLivingBase)entity).isDead) {
			if(cs.getCountModules(is)[6] > 0 && cs.getCountModules(is)[7] < 1) {
	            final int range = 3;
	            for (final Object obj : player.worldObj.getEntitiesWithinAABB((Class)EntityLivingBase.class, player.boundingBox.expand((double)range, (double)range, (double)range))) {
	                final EntityLivingBase e = (EntityLivingBase)obj;
	                if (!obj.equals(player)) {
	                    e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)player),( float) cs.getDamageSword(is));
					}
				}
			} else if (cs.getCountModules(is)[7] > 0) {
				final int range = 5;
	            for (final Object obj : player.worldObj.getEntitiesWithinAABB((Class)EntityLivingBase.class, player.boundingBox.expand((double)range, (double)range, (double)range))) {
	                final EntityLivingBase e = (EntityLivingBase)obj;
	                if (!obj.equals(player)) {
	                    e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)player), (float) cs.getDamageSword(is));
	                }
	            }
			}
        }
		
        return super.onLeftClickEntity(is, player, entity);
    }

    
	
	@Override
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.clear();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", cs.getDamageSword(null), 0));
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
