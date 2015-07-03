package net.szymonmarciniak.lettersmod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.szymonmarciniak.lettersmod.init.LetterBlocks;
import net.szymonmarciniak.lettersmod.init.LetterItems;
import net.szymonmarciniak.lettersmod.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class LettersMod {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final LettersTab tabLetters = new LettersTab("tabLetters");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LetterBlocks.init();
		LetterBlocks.register();
		LetterItems.init();
		LetterItems.register();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		GameRegistry.addRecipe(new ItemStack(LetterItems.reverse_stick, 2), "A "," A",'A',Items.stick);
		GameRegistry.addRecipe(new ItemStack(LetterItems.vertical_stick, 2), "A","A",'A',Items.stick);
		GameRegistry.addRecipe(new ItemStack(LetterItems.horizontal_stick, 2), "AA",'A',Items.stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_a), "ABC","DBD","D D",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.reverse_stick,'D',LetterItems.vertical_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_b), "BAC","BA ","BAD",'A',LetterItems.horizontal_stick,'B',LetterItems.vertical_stick,'C',LetterItems.reverse_stick,'D',Items.stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_c), "AB ","C  ","DB ",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_d), "ABD","A A","ABC",'A',LetterItems.vertical_stick,'B',LetterItems.horizontal_stick,'C',Items.stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_e), "CBB","CBB","CBB",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_f), "CBB","CBB","C  ",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_g), "AB ","C B","DBA",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_h), "C C","CBC","C C",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_i), "C","C","C",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_j), "  C","C C","DBA",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_k), "C A","CB ","C D",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_l), "C  ","C  ","CBB",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_m), "DCA","C C","C C",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_n), "CDC","C C","C C",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_o), "ABD","C C","DBA",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_p), "CBD","CBA","C  ",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_q), "ABD","C C","DBD",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_r), "CBD","CBA","C D",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_s), "ABB","DBD","BBA",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_t), "BBB"," C "," C ",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_u), "C C","C C","DBA",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_v), "CA ","C A","C C",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_w), "C C","C C","ACD",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_x), "D A"," C ","A D",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_y), "D A"," C "," C ",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
		GameRegistry.addRecipe(new ItemStack(LetterBlocks.blue_z), "BBB"," A ","BBB",'A',Items.stick,'B',LetterItems.horizontal_stick,'C',LetterItems.vertical_stick,'D',LetterItems.reverse_stick);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
		
	}
}
