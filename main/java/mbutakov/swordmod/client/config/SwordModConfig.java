package mbutakov.swordmod.client.config;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.swordmod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;

@SideOnly(Side.CLIENT)
public class SwordModConfig {

	public static File file = new File(Minecraft.getMinecraft().mcDataDir, Main.MODID + "." + Main.MODID);

	public static int isOffOtherPlayer = 0;
	public static int distanceRenderParticle = 32;
	public static int offRenderInInventory = 0;
	public static void save() {
		try (FileOutputStream out = new FileOutputStream(file)) {
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("isOffOtherPlayer", isOffOtherPlayer);
			tag.setInteger("distanceRenderParticle", distanceRenderParticle);
			tag.setInteger("offRenderInInventory", offRenderInInventory);
			CompressedStreamTools.writeCompressed(tag, out);
		} catch (IOException e) {
			System.out.println("Failed to save client data.");
			e.printStackTrace();
		}
	}

	public static void load() {
		if (!file.exists()) {
			return;
		}

		try (FileInputStream in = new FileInputStream(file)) {
			file.canRead();
			NBTTagCompound tag = CompressedStreamTools.readCompressed(in);
			isOffOtherPlayer = tag.getInteger("isOffOtherPlayer");
			distanceRenderParticle = tag.getInteger("distanceRenderParticle");
			offRenderInInventory = tag.getInteger("offRenderInInventory");
		} catch (IOException e) {
			System.out.println("Failed to load client data.");
			e.printStackTrace();
		}
	}
}