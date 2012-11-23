package electricexpansion.mattredsox.items;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemUpgrade extends Item
{
    private String[] names = new String[] {"Tier 1 Storage Upgrade", "Tier 2 Storage Upgrade", "Tier 3 Storage Upgrade", "BC Compatibility Upgrade", "IC2 Compatibility Upgrade"};

    public ItemUpgrade(int id, int texture)
    {
        super(id);
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getItemNameIS(ItemStack itemstack)
    {
        return names[itemstack.getItemDamage()];
    }

    @Override
    public int getIconFromDamage(int i)
    {
if(i == 0)

	{return 5;}
if(i == 1)
	{return 4;}
if(i == 2)
	{return 8;}
if(i == 3)
	{ return 7;}
	return 6;
	
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for(int i = 0; i < names.length; i++)
        {
    		par3List.add(new ItemStack(this, 1, i));
        }
    }
}
