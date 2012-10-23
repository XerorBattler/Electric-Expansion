package electricexpansion.mattredsox.blocks;

import ic2.api.IEnergyConductor;

import java.util.List;
import java.util.Random;

import electricexpansion.EECommonProxy;
import electricexpansion.ElectricExpansion;
import electricexpansion.mattredsox.tileentities.TileEntityVoltDetector;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.BasicComponents;
import universalelectricity.UniversalElectricity;
import universalelectricity.basiccomponents.TileEntityCoalGenerator;
import universalelectricity.implement.IRedstoneProvider;
import universalelectricity.prefab.BlockMachine;
import universalelectricity.prefab.Vector3;

public class BlockVoltDetector extends BlockMachine
{
	public static final int BATTERY_BOX_METADATA = 0;	
    public BlockVoltDetector(int id, int textureIndex)
    {
        super("Basic Machine", id, UniversalElectricity.machine, CreativeTabs.tabDecorations);
        this.blockIndexInTexture = textureIndex;
        this.setStepSound(soundMetalFootstep);
        this.setRequiresSelfNotify();
    }

    @Override
    public String getTextureFile()
    {
        return EECommonProxy.MattBLOCK_TEXTURE_FILE;
    }
    
   
    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int metadata)
    {
    	if (side == 0 || side == 1)
        {
            return this.blockIndexInTexture;
        }
    	else if(metadata >= BATTERY_BOX_METADATA)
    	{
    		metadata -= BATTERY_BOX_METADATA;
    		
    		//If it is the front side
            if (side == metadata+2)
            {
                return this.blockIndexInTexture + 3;
            }
            //If it is the back side
            else if (side == ForgeDirection.getOrientation(metadata+2).getOpposite().ordinal())
            {
                return this.blockIndexInTexture + 2;
            }
      //      else if (side == 3)
      //      {
       //     	return this.blockIndexInTexture + 1;
        //    }

            return this.blockIndexInTexture + 5;
    	}
    	else
    	{
    		 //If it is the front side
            if (side == metadata+2)
            {
            	return this.blockIndexInTexture + 3;
            }
            //If it is the back side
            else if (side == ForgeDirection.getOrientation(metadata+2).getOpposite().ordinal())
            {
            	return this.blockIndexInTexture + 5;
            }
    	}
    	
        return this.blockIndexInTexture + 1;
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving)
    {
    	int metadata = par1World.getBlockMetadata(x, y, z);
    	
        int angle = MathHelper.floor_double((par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int change = 3;

	        switch (angle)
	        {
	            case 0: par1World.setBlockMetadataWithNotify(x, y, z, BATTERY_BOX_METADATA + 3); break;
	            case 1: par1World.setBlockMetadataWithNotify(x, y, z, BATTERY_BOX_METADATA + 1); break;
	            case 2: par1World.setBlockMetadataWithNotify(x, y, z, BATTERY_BOX_METADATA + 2); break;
	            case 3: par1World.setBlockMetadataWithNotify(x, y, z, BATTERY_BOX_METADATA + 0); break;
	        }
	        this.checkForConductors(par1World, x, y, z);
        }
      
    
    @Override
    public void onNeighborBlockChange(World par1World, int x, int y, int z, int par4)
    {
    	this.checkForConductors(par1World, x, y, z);
    }
    
    public void checkForConductors(World par1World, int x, int y, int z)
    {
    	//This makes sure battery boxes can only have wires on it's correct side placed.
    	int metadata = par1World.getBlockMetadata(x, y, z);

    	if(metadata >= BATTERY_BOX_METADATA)
        {
    		TileEntityVoltDetector tileEntity = (TileEntityVoltDetector)par1World.getBlockTileEntity(x, y, z);
    		
    		for (byte i = 0; i < 6; i++)
    		{
        		Vector3 position = new Vector3(x, y, z);
    			position.modifyPositionFromSide(ForgeDirection.getOrientation(i));

    			if(!tileEntity.canConnect(ForgeDirection.getOrientation(i).getOpposite()))
    			{
    				TileEntity neighborTile = par1World.getBlockTileEntity(position.intX(), position.intY(), position.intZ());
		            
    				if(neighborTile != null)
		    		{
		            	boolean tossPipe = false;
		            	/*
		            	if(Loader.isModLoaded("BuildCraft|Transport"))
		            	{
		            		try
		            		{
		            			if(neighborTile.getClass() == Class.forName("buildcraft.transport.TileGenericPipe"))
		            			{
		            				tossPipe = true;
		            			}
		            		}
		            		catch (Exception e)
		            		{
		            			System.out.println("Failed to identify Buildcraft class. Contact UE developers to update their API!");
		            		}
		            	}*/
		            	
		            	//IEnergyConductor
		            	if(neighborTile instanceof IEnergyConductor || tossPipe)
		            	{
			    			this.breakConductor(par1World, position);
		            	}
		    		}
    			}  			
    		}
        }
    }
    
    public void breakConductor(World par1World, Vector3 position)
    {
    	int neighborBlockID = par1World.getBlockId(position.intX(), position.intY(), position.intZ());
		
		if(Block.blocksList[neighborBlockID] != null)
		{
			Block.blocksList[neighborBlockID].dropBlockAsItem(par1World, position.intX(), position.intY(), position.intZ(), par1World.getBlockMetadata(position.intX(), position.intY(), position.intZ()), 0);
		}
		
		par1World.setBlockWithNotify(position.intX(), position.intY(), position.intZ(), 0);
    }

    @Override
    public boolean onUseWrench(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer)
    {
    	int metadata = par1World.getBlockMetadata(x, y, z);
    	int original = metadata;
    	
    	int change = 0;
    	    	
	 if(metadata >= BATTERY_BOX_METADATA)
		{
			original -= BATTERY_BOX_METADATA;
		}
    	
        //Reorient the block
        switch (original)
        {
            case 0: change = 3; break;
            case 3: change = 1; break;
            case 1: change = 2; break;
            case 2: change = 0; break;
        }
		 if(metadata >= BATTERY_BOX_METADATA)
		{
			change += BATTERY_BOX_METADATA;
		}
		 
        par1World.setBlockMetadataWithNotify(x, y, z, change);
        
        return true;
    }

    /**
     * Called when the block is right clicked by the player
     */
    @Override
    public boolean onMachineActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer)
    {
        if (!par1World.isRemote)
        {
            TileEntityVoltDetector tileEntity = (TileEntityVoltDetector)par1World.getBlockTileEntity(x, y, z);

            par5EntityPlayer.openGui(ElectricExpansion.instance, 1, par1World, x, y, z);

        }

        return true;
    }
    /**
     * Is this block powering the block on the specified side
     */
    @Override
    public boolean isPoweringTo(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)
    {
        TileEntity tileEntity = par1IBlockAccess.getBlockTileEntity(x, y, z);
        
        if(tileEntity instanceof IRedstoneProvider)
        {
        	 return ((IRedstoneProvider)tileEntity).isPoweringTo((byte)side);
        }
        
       return false;
    }

    /**
     * Is this block indirectly powering the block on the specified side
     */
    @Override
    public boolean isIndirectlyPoweringTo(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)
    {
    	TileEntity tileEntity = par1IBlockAccess.getBlockTileEntity(x, y, z);
        
        if(tileEntity instanceof IRedstoneProvider)
        {
        	 return ((IRedstoneProvider)tileEntity).isIndirectlyPoweringTo((byte)side);
        }
        
       return false;
    }


    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int metadata)
	{
			return new TileEntityVoltDetector();
	}
	
}
