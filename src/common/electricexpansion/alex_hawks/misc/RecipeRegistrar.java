package electricexpansion.alex_hawks.misc;

import universalelectricity.prefab.RecipeHelper;
import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import electricexpansion.ElectricExpansion;

public class RecipeRegistrar 
{	

	private static final Block blockSwitchWire = ElectricExpansion.blockSwitchWire;
	private static final Block blockSwitchWireBlock = ElectricExpansion.blockSwitchWireBlock;
	private static final Block blockAdvBox = ElectricExpansion.blockBigBatteryBox;
	private static final Block blockWireMill = ElectricExpansion.blockWireMill;
	private static final Block blockRawWire = ElectricExpansion.blockRawWire;
	private static final Block blockInsulatedWire = ElectricExpansion.blockInsulatedWire;
	private static final Block blockWireBlock = ElectricExpansion.blockWireBlock;
	private static final Block blockSwitchWireOff = ElectricExpansion.blockRawWire;
	private static final Block blockSwitchWireBlockOff = ElectricExpansion.blockRawWire;
	private static final Item itemParts = ElectricExpansion.itemParts;
	
	public static void crafting()
	{
		
		//Uninsulated Wire Recipes
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockRawWire, 7, 0), new Object [] {" @ ", " @ ", " @ ", '@', "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockRawWire, 7, 1), new Object [] {" @ ", " @ ", " @ ", '@', "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockRawWire, 7, 2), new Object [] {" @ ", " @ ", " @ ", '@', "ingotSilver"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockRawWire, 7, 3), new Object [] {" @ ", " @ ", " @ ", '@', "ingotAluminium"}));

				//Recipes for supporting other UE add-ons, the slack way...
				//CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe("copperWire"), new Object[]{new ItemStack(blockInsulatedWire, 1, 0)}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockInsulatedWire, 1, 0), new Object[]{"copperWire"}));

				//Shapeless Insulated Wire Recipes (From insulation, and the corresponding Uninsulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockInsulatedWire, 1, 0), new Object[]{new ItemStack(blockRawWire, 1, 0), Block.cloth}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockInsulatedWire, 1, 1), new Object[]{new ItemStack(blockRawWire, 1, 1), Block.cloth}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockInsulatedWire, 1, 2), new Object[]{new ItemStack(blockRawWire, 1, 2), Block.cloth}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockInsulatedWire, 1, 3), new Object[]{new ItemStack(blockRawWire, 1, 3), Block.cloth}));

				//Shaped Insulated Wire Recipes (From insulation, and the corresponding OreDictionary Ingots)
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockInsulatedWire, 7, 0), new Object [] {"#@#", "#@#", "#@#", '#', Block.cloth, '@', "ingotCopper"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockInsulatedWire, 7, 1), new Object [] {"#@#", "#@#", "#@#", '#', Block.cloth, '@', "ingotTin"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockInsulatedWire, 7, 2), new Object [] {"#@#", "#@#", "#@#", '#', Block.cloth, '@', "ingotSilver"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockInsulatedWire, 7, 3), new Object [] {"#@#", "#@#", "#@#", '#', Block.cloth, '@', "ingotAluminium"}));

				//Wire Block Recipes (From insulation, Block.stone, and the corresponding Uninsulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 0), new Object[]{new ItemStack(blockRawWire, 1, 0), Block.cloth, Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 1), new Object[]{new ItemStack(blockRawWire, 1, 1), Block.cloth, Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 2), new Object[]{new ItemStack(blockRawWire, 1, 2), Block.cloth, Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 3), new Object[]{new ItemStack(blockRawWire, 1, 3), Block.cloth, Block.stone}));

				//Wire Block Recipes (From Block.stone, and the corresponding Insulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 0), new Object[]{new ItemStack(blockInsulatedWire, 1, 0), Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 1), new Object[]{new ItemStack(blockInsulatedWire, 1, 1), Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 2), new Object[]{new ItemStack(blockInsulatedWire, 1, 2), Block.stone}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockWireBlock, 1, 3), new Object[]{new ItemStack(blockInsulatedWire, 1, 3), Block.stone}));

				//Shapeless Switch Wire Recipes (From insulation, a lever, and the corresponding Uninsulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 0), new Object[]{new ItemStack(blockRawWire, 1, 0), Block.cloth, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 1), new Object[]{new ItemStack(blockRawWire, 1, 1), Block.cloth, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 2), new Object[]{new ItemStack(blockRawWire, 1, 2), Block.cloth, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 3), new Object[]{new ItemStack(blockRawWire, 1, 3), Block.cloth, Block.lever}));

				//Shapeless Switch Wire Recipes (From insulation, a lever, and the corresponding Uninsulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 0), new Object[]{new ItemStack(blockInsulatedWire, 1, 0), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 1), new Object[]{new ItemStack(blockInsulatedWire, 1, 1), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 2), new Object[]{new ItemStack(blockInsulatedWire, 1, 2), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireOff, 1, 3), new Object[]{new ItemStack(blockInsulatedWire, 1, 3), Block.lever}));

				//Switch Wire Block Recipes (From insulation, Block.stone, Block.lever and the corresponding Uninsulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 0), new Object[]{new ItemStack(blockRawWire, 1, 0), Block.cloth, Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 1), new Object[]{new ItemStack(blockRawWire, 1, 1), Block.cloth, Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 2), new Object[]{new ItemStack(blockRawWire, 1, 2), Block.cloth, Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 3), new Object[]{new ItemStack(blockRawWire, 1, 3), Block.cloth, Block.stone, Block.lever}));

				//Switch Wire Block Recipes (From Block.stone, Block,lever and the corresponding Insulated Wire)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 0), new Object[]{new ItemStack(blockInsulatedWire, 1, 0), Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 1), new Object[]{new ItemStack(blockInsulatedWire, 1, 1), Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 2), new Object[]{new ItemStack(blockInsulatedWire, 1, 2), Block.stone, Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 3), new Object[]{new ItemStack(blockInsulatedWire, 1, 3), Block.stone, Block.lever}));

				//Switch Wire Block Recipes (From Block.lever, and the corresponding Wire Block)
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 0), new Object[]{new ItemStack(blockWireBlock, 1, 0), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 1), new Object[]{new ItemStack(blockWireBlock, 1, 1), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 2), new Object[]{new ItemStack(blockWireBlock, 1, 2), Block.lever}));
				CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(blockSwitchWireBlockOff, 1, 3), new Object[]{new ItemStack(blockWireBlock, 1, 3), Block.lever}));

				//Machines
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockAdvBox), new Object [] {"!!!", "!@!", "#$#", '!', ElectricExpansion.itemSuperConduct.getUncharged(),'@', "batteryBox", '?', "battery"}));
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(blockAdvBox, new Object [] {"!!!", "!@!", "#$#", '!', "battery",'@', "batteryBox", '?', "battery", '$', "eliteCircuit", '#', blockWireBlock}));
				//	GameRegistry.addRecipe(new ItemStack(blockWireMill), new Object [] {"#$#", "!%!", "@!@", '!', "motor", '#', "plateSteel", '@', "plateBronze", '$', "basicCircuit", '%', new ItemStack(itemParts, 1, 0)});
		
				//Parts
				GameRegistry.addRecipe(new ItemStack(itemParts, 1, 0), new Object [] {" ! ", "! !", " ! ", '!', Item.ingotIron});	
				
			//	RecipeHelper.removeRecipe(recipe)
	}
	public static void drawing()
	{
		WireMillRecipes.addDrawing("ingotCopper", new ItemStack(blockRawWire, 3, 0), 60);
		WireMillRecipes.addDrawing("ingotTin", new ItemStack(blockRawWire, 3, 1), 60);
		WireMillRecipes.addDrawing("ingotSilver", new ItemStack(blockRawWire, 3, 2), 60);
		WireMillRecipes.addDrawing("ingotAluminium", new ItemStack(blockRawWire, 3, 3), 60);
		
		WireMillRecipes.addDrawing(new ItemStack(Block.cloth), new ItemStack(Item.silk, 3), 40);
	}
}
