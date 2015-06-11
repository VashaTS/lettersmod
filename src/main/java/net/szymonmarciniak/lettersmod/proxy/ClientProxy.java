package net.szymonmarciniak.lettersmod.proxy;

import net.szymonmarciniak.lettersmod.init.LetterBlocks;
import net.szymonmarciniak.lettersmod.init.LetterItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		LetterBlocks.registerRenders();
		LetterItems.registerRenders();
	}
}

