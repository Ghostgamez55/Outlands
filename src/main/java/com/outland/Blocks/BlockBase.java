package com.outland.Blocks;

import java.util.ArrayList;

import com.outland.Items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


/**
 * @author Xcisso
 * 
 * This is the main block class. It contains the basic mod specific block properties, as well as 
 * a collection of all the created blocks in this mod. This class can be extended when we need to add
 * custom logic to a block.
 *
 */
public class BlockBase extends Block
{
	/**
	 * This list contains all the blocks that should be registered by the mod. (All created blocks adds itself.)
	 */
	public static ArrayList<BlockBase> blocksToRegister = new ArrayList<BlockBase>();
	
	

	/**
	 * @param _name Unlocalized name
	 * @param _blockMat The blockaterial of this block.
	 */
	public BlockBase(String _name, Material _blockMat) 
	{
		super(_blockMat);
		
		this.setUnlocalizedName(_name);
		
		blocksToRegister.add(this);
		
		ItemBase.itemsToRegister.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}


}
