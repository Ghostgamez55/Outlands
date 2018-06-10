package com.outland.handlers;

import com.outland.gui.GuiTalentScreen;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static Gui CurrentlyOpenGui;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int _ID, EntityPlayer _player, World _world, int _x, int _y, int _z) 
	{
		//TileEntitySniffer te = (TileEntitySniffer)world.getTileEntity(x, y, z);
		
		//TileEntitySniffer te = (TileEntitySniffer)_world.getTileEntity(new BlockPos(_x, _y, _z));
		
		/*
		*	Switches the ID, return a new GUI.
		*/
		switch(_ID)
		{
		case 0:
			return new GuiTalentScreen();
		default:
			break;
		}
		return null;
	}

}
