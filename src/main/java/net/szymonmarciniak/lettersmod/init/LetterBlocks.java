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
	public static Block blue_d;
	public static Block blue_e;
	public static Block blue_f;
	public static Block blue_g;
	public static Block blue_h;
	public static Block blue_i;
	public static Block blue_j;
	public static Block blue_k;
	public static Block blue_l;
	public static Block blue_m;
	public static Block blue_n;
	public static Block blue_o;
	public static Block blue_p;
	public static Block blue_q;
	public static Block blue_r;
	
	public static void init(){
		blue_a = new BlockLetters(Material.wood).setUnlocalizedName("blue_a").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_b = new BlockLetters(Material.wood).setUnlocalizedName("blue_b").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_c = new BlockLetters(Material.wood).setUnlocalizedName("blue_c").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_d = new BlockLetters(Material.wood).setUnlocalizedName("blue_d").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_e = new BlockLetters(Material.wood).setUnlocalizedName("blue_e").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_f = new BlockLetters(Material.wood).setUnlocalizedName("blue_f").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_g = new BlockLetters(Material.wood).setUnlocalizedName("blue_g").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_h = new BlockLetters(Material.wood).setUnlocalizedName("blue_h").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_i = new BlockLetters(Material.wood).setUnlocalizedName("blue_i").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_j = new BlockLetters(Material.wood).setUnlocalizedName("blue_j").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_k = new BlockLetters(Material.wood).setUnlocalizedName("blue_k").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_l = new BlockLetters(Material.wood).setUnlocalizedName("blue_l").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_m = new BlockLetters(Material.wood).setUnlocalizedName("blue_m").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_n = new BlockLetters(Material.wood).setUnlocalizedName("blue_n").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_o = new BlockLetters(Material.wood).setUnlocalizedName("blue_o").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_p = new BlockLetters(Material.wood).setUnlocalizedName("blue_p").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_q = new BlockLetters(Material.wood).setUnlocalizedName("blue_q").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
		blue_r = new BlockLetters(Material.wood).setUnlocalizedName("blue_r").setCreativeTab(LettersMod.tabLetters).setHardness(0.5F);
	}
	
	public static void register(){
		GameRegistry.registerBlock(blue_a, blue_a.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_b, blue_b.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_c, blue_c.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_d, blue_d.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_e, blue_e.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_f, blue_f.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_g, blue_g.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_h, blue_h.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_i, blue_i.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_j, blue_j.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_k, blue_k.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_l, blue_l.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_m, blue_m.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_n, blue_n.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_o, blue_o.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_p, blue_p.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_q, blue_q.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blue_r, blue_r.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders(){
		registerRender(blue_a);
		registerRender(blue_b);
		registerRender(blue_c);
		registerRender(blue_d);
		registerRender(blue_e);
		registerRender(blue_f);
		registerRender(blue_g);
		registerRender(blue_h);
		registerRender(blue_i);
		registerRender(blue_j);
		registerRender(blue_k);
		registerRender(blue_l);
		registerRender(blue_m);
		registerRender(blue_n);
		registerRender(blue_o);
		registerRender(blue_p);
		registerRender(blue_q);
		registerRender(blue_r);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
