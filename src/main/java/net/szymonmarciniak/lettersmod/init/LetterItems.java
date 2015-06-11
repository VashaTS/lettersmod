package net.szymonmarciniak.lettersmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.szymonmarciniak.lettersmod.LettersMod;
import net.szymonmarciniak.lettersmod.Reference;

public class LetterItems {
	
	public static Item reverse_stick;
	public static Item vertical_stick;
	public static Item horizontal_stick;
	
	public static void init(){
		reverse_stick = new Item().setUnlocalizedName("reverse_stick").setCreativeTab(LettersMod.tabLetters);
		vertical_stick = new Item().setUnlocalizedName("vertical_stick").setCreativeTab(LettersMod.tabLetters);
		horizontal_stick = new Item().setUnlocalizedName("horizontal_stick").setCreativeTab(LettersMod.tabLetters);
	}
	
	public static void register(){
		GameRegistry.registerItem(reverse_stick, reverse_stick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(vertical_stick, vertical_stick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(horizontal_stick, horizontal_stick.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(reverse_stick);
		registerRender(vertical_stick);
		registerRender(horizontal_stick);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
