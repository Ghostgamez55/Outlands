package com.outland.Items;

import java.util.ArrayList;

import com.outland.main.OutlandMod;

import net.minecraft.item.Item;

/**
 *  @author Xcisso
 *  
 * 
 * 	This is the main item class. It contains the basic mod specific item properties, as well as 
 *	a collection of all the created items in this mod. This class can be extended when we need to add
 *	other logic to an item.
 */
public class ItemBase extends Item
{
	/**	
	 * 	This list contains all the items that should be registered by the mod. (All created items adds itself.)
	 */
	public static ArrayList<Item> itemsToRegister = new ArrayList<Item>();
	
	
	/**
	 * @param _name Unlocalized name
	 */
	public ItemBase(String _name)
	{
		this.setUnlocalizedName(_name);
		this.setRegistryName(_name);
		
		this.setCreativeTab(OutlandMod.modTab);
		
		itemsToRegister.add(this);
		
	}
}
