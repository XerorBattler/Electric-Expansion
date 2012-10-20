package electricexpansion.alex_hawks.itemblocks;

import java.util.logging.Logger;

import electricexpansion.alex_hawks.helpers.ItemBlockCableHelper;
import net.minecraft.src.Block;

public class ItemBlockInsualtedWire extends ItemBlockCableHelper 
{
	public ItemBlockInsualtedWire(int par1, Block mainBlock)
	{super(par1, mainBlock);}
	
	public int getIconFromDamage(int i)
	{return i + 16;}
}