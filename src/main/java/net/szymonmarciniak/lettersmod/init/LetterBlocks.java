package net.szymonmarciniak.lettersmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.szymonmarciniak.lettersmod.LettersMod;
import net.szymonmarciniak.lettersmod.Reference;
import net.szymonmarciniak.lettersmod.blocks.BlockLetters;

public class LetterBlocks {
	public static Block blue_a;
	public static Block blue_b;
	public static Block blue_c;
	public static Block blue_g;
	
	public static void init(){
		blue_a = new BlockLetters(Material.wood).setUnlocalizedName("blue_a").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_b = new BlockLetters(Material.wood).setUnlocalizedName("blue_b").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_c = new BlockLetters(Material.wood).setUnlocalizedName("blue_c").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_g = new BlockLetters(Material.wood).setUnlocalizedName("blue_g").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		
	}
	
	public static void register(){
		GameRegistry.registerBlock(blue_a, blue_a.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_b, blue_b.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_c, blue_c.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_g, blue_g.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(blue_a);
		registerRender(blue_b);
		registerRender(blue_c);
		registerRender(blue_g);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
