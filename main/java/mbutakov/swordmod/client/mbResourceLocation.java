package mbutakov.swordmod.client;

import mbutakov.swordmod.utils.ModelWrapperDisplayList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class mbResourceLocation {

	   public static final ResourceLocation PortalParticleTexture = new ResourceLocation("mbswordmod", "textures/particle/portal_part.png");
	   public static final ResourceLocation pp = new ResourceLocation("mbswordmod", "textures/particle/pp.png");
		
	   public static final ResourceLocation SwordBleachTex = new ResourceLocation("mbswordmod", "textures/models/BladeTex.png");
	   public static final ResourceLocation SwordBleach2Tex = new ResourceLocation("mbswordmod", "textures/models/BleachSword1.png");
	   public static final ResourceLocation SwordBleach3Tex = new ResourceLocation("mbswordmod", "textures/models/BleachSword2.png");
	   public static final ResourceLocation SwordBleach4Tex = new ResourceLocation("mbswordmod", "textures/models/BleachSword_3.png");
	   public static final ResourceLocation SwordBleach5Tex = new ResourceLocation("mbswordmod", "textures/models/BleachSword_4.png");
	   public static final ResourceLocation SwordBleach6Tex = new ResourceLocation("mbswordmod", "textures/models/BleachSword_5.png");
	   public static final ResourceLocation CyanSwordTex = new ResourceLocation("mbswordmod", "textures/models/CyanBlade.png");
	   public static final ResourceLocation IdkBladeTex = new ResourceLocation("mbswordmod", "textures/models/IDK_Blade.png");
	   public static final ResourceLocation blockTex = new ResourceLocation("mbswordmod", "textures/blocks/block.png");
		  
	   public static final IModelCustom SwordBleach = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/bleach.obj")));
	   public static final IModelCustom SwordBleach2 = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/BleachSword_1.obj")));
	   public static final IModelCustom SwordBleach3 = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/BleachSword_2.obj")));
	   public static final IModelCustom SwordBleach4 = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/BleachSword_3.obj")));
	   public static final IModelCustom SwordBleach5 = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/BleachSword_4.obj")));
	   public static final IModelCustom SwordBleach6 = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/BleachSword_5.obj")));
	   public static final IModelCustom CyanSword = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/CyanSword.obj")));
	   public static final IModelCustom IdkBlade = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/IDK_Blade.obj")));
	   public static final IModelCustom block = new ModelWrapperDisplayList((WavefrontObject)AdvancedModelLoader.loadModel(new ResourceLocation("mbswordmod", "models/block.obj")));
		
}
