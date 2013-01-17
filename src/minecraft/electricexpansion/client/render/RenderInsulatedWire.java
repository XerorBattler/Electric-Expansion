package electricexpansion.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricexpansion.client.model.ModelInsulatedWire;
import electricexpansion.common.ElectricExpansion;
import electricexpansion.common.cables.TileEntityInsulatedWire;
import electricexpansion.common.cables.TileEntityLogisticsWire;
import electricexpansion.common.cables.TileEntitySwitchWire;
import electricexpansion.common.helpers.TileEntityConductorBase;

@SideOnly(Side.CLIENT)
public class RenderInsulatedWire extends TileEntitySpecialRenderer
{
	private static final ModelInsulatedWire model = new ModelInsulatedWire();

	public void renderAModelAt(TileEntity t, double x, double y, double z, float f)
	{
		String textureToUse = null;
		int blockID = t.worldObj.getBlockId(t.xCoord, t.yCoord, t.zCoord);
		int metadata = t.worldObj.getBlockMetadata(t.xCoord, t.yCoord, t.zCoord);

		if (metadata != -1)
		{
			if (blockID == ElectricExpansion.blockInsulatedWire.blockID)
			{
				if (metadata == 0)
					textureToUse = ElectricExpansion.TEXTURE_PATH + "InsulatedCopperWire.png";
				else if (metadata == 1)
					textureToUse = ElectricExpansion.TEXTURE_PATH + "InsulatedTinWire.png";
				else if (metadata == 2)
					textureToUse = ElectricExpansion.TEXTURE_PATH + "InsulatedSilverWire.png";
				else if (metadata == 3)
					textureToUse = ElectricExpansion.TEXTURE_PATH + "InsulatedHVWire.png";
				else if (metadata == 4)
					textureToUse = ElectricExpansion.TEXTURE_PATH + "InsulatedSCWire.png";
			}

			else if (blockID == ElectricExpansion.blockLogisticsWire.blockID)
			{

				switch (metadata)
				{
					case 0:
						textureToUse = ElectricExpansion.TEXTURE_PATH + "CopperLogisticsWire.png";
						break;
					case 1:
						textureToUse = ElectricExpansion.TEXTURE_PATH + "TinLogisticsWire.png";
						break;
					case 2:
						textureToUse = ElectricExpansion.TEXTURE_PATH + "SilverLogisticsWire.png";
						break;
					case 3:
						textureToUse = ElectricExpansion.TEXTURE_PATH + "HVLogisticsWire.png";
						break;
					case 4:
						textureToUse = ElectricExpansion.TEXTURE_PATH + "SCLogisticsWire.png";
						break;
				}

			}

			else if (blockID == ElectricExpansion.blockSwitchWire.blockID)
			{
				if (t.getWorldObj().isBlockIndirectlyGettingPowered(t.xCoord, t.yCoord, t.zCoord))
				{
					switch (metadata)
					{
						case 0:
							textureToUse = ElectricExpansion.TEXTURE_PATH + "CopperSwitchWireOn.png";
							break;
						case 1:
							textureToUse = ElectricExpansion.TEXTURE_PATH + "TinSwitchWireOn.png";
							break;
						case 2:
							textureToUse = ElectricExpansion.TEXTURE_PATH + "SilverSwitchWireOn.png";
							break;
						case 3:
							textureToUse = ElectricExpansion.TEXTURE_PATH + "HVSwitchWireOn.png";
							break;
						case 4:
							textureToUse = ElectricExpansion.TEXTURE_PATH + "SCSwitchWireOn.png";
							break;
					}
				}

				else
				{
					if (metadata == 0)
						textureToUse = ElectricExpansion.TEXTURE_PATH + "CopperSwitchWireOff.png";
					else if (metadata == 1)
						textureToUse = ElectricExpansion.TEXTURE_PATH + "TinSwitchWireOff.png";
					else if (metadata == 2)
						textureToUse = ElectricExpansion.TEXTURE_PATH + "SilverSwitchWireOff.png";
					else if (metadata == 3)
						textureToUse = ElectricExpansion.TEXTURE_PATH + "HVSwitchWireOff.png";
					else if (metadata == 4)
						textureToUse = ElectricExpansion.TEXTURE_PATH + "SCSwitchWireOff.png";
				}
			}
		}
		
		TileEntityConductorBase tileEntity = (TileEntityConductorBase) t;
		boolean[] connectedSides = tileEntity.visuallyConnected;
	
		if (textureToUse != null)
		{
			bindTextureByName(textureToUse);
		}

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);


		if (tileEntity instanceof TileEntityInsulatedWire || tileEntity instanceof TileEntityLogisticsWire)
		{
			if (connectedSides[0])
			{
				model.renderBottom();
			}
			if (connectedSides[1])
			{
				model.renderTop();
			}
			if (connectedSides[2])
			{
				model.renderBack();
			}
			if (connectedSides[3])
			{
				model.renderFront();
			}
			if (connectedSides[4])
			{
				model.renderLeft();
			}
			if (connectedSides[5])
			{
				model.renderRight();
			}
		}

		else if (tileEntity instanceof TileEntitySwitchWire)
		{
			if (tileEntity.getWorldObj().isBlockIndirectlyGettingPowered(t.xCoord, t.yCoord, t.zCoord))
			{
				if (connectedSides[0])
				{
					model.renderBottom();
				}
				if (connectedSides[1])
				{
					model.renderTop();
				}
				if (connectedSides[2])
				{
					model.renderBack();
				}
				if (connectedSides[3])
				{
					model.renderFront();
				}
				if (connectedSides[4])
				{
					model.renderLeft();
				}
				if (connectedSides[5])
				{
					model.renderRight();
				}
			}
		}
		model.renderMiddle();
		GL11.glPopMatrix();
		
		if (tileEntity instanceof TileEntityInsulatedWire)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glScalef(1.0F, -1F, -1F);
			
			bindTextureByName(ElectricExpansion.TEXTURE_PATH + "WirePaintOverlay.png");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1f);

			if (connectedSides[0])
			{
				model.renderBottom();
			}
			if (connectedSides[1])
			{
				model.renderTop();
			}
			if (connectedSides[2])
			{
				model.renderBack();
			}
			if (connectedSides[3])
			{
				model.renderFront();
			}
			if (connectedSides[4])
			{
				model.renderLeft();
			}
			if (connectedSides[5])
			{
				model.renderRight();
			}
			
			model.renderMiddle();
			GL11.glPopMatrix();
		}
		
		else
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glScalef(1.0F, -1F, -1F);
			
			bindTextureByName(ElectricExpansion.TEXTURE_PATH + "WirePaintOverlay.png");

			if (connectedSides[0])
			{
				model.renderBottom();
			}
			if (connectedSides[1])
			{
				model.renderTop();
			}
			if (connectedSides[2])
			{
				model.renderBack();
			}
			if (connectedSides[3])
			{
				model.renderFront();
			}
			if (connectedSides[4])
			{
				model.renderLeft();
			}
			if (connectedSides[5])
			{
				model.renderRight();
			}
			
			model.renderMiddle();
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	{
		this.renderAModelAt(tileEntity, var2, var4, var6, var8);
	}
}
