package net.szymonmarciniak.lettersmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.szymonmarciniak.lettersmod.init.LetterBlocks;

public class LettersTab extends CreativeTabs {

	public LettersTab(String label) {
		super(label);
	}
	
	public Item getTabIconItem(){
		Item tempItem = Item.getItemFromBlock(LetterBlocks.blue_a);
		return tempItem;
	}
	
}
