package com.outland.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Xcisso
 *	This block is just created as an example on how to add new blocks to this mod.
 *	Remember to also add the model .json file to the project as well. It need to have the same name as the name
 *	you give the block :D
 *
 *	TODO: Remove this before release
 */
public class BlockTestBlock extends BlockBase
{

	public BlockTestBlock(String _name, Material _blockMat) 
	{
		super(_name, _blockMat);
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	@Override
	public boolean onBlockActivated(World _worldIn, BlockPos _pos, IBlockState _state, EntityPlayer _playerIn, EnumHand _hand, EnumFacing _facing, float _hitX, float _hitY, float _hitZ)
    {
		//	When the player right clicks, it launches him into the air.
		_playerIn.addVelocity(0, 1.5d, 0);
		_playerIn.fallDistance = 0;
		return true;
    }
	

}
