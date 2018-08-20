package com.outland.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IceShardBlock extends BlockBase {

	public IceShardBlock(String _name, Material _blockMat) 
	{
		super(_name, _blockMat);
		
		setSoundType(SoundType.STONE);
		setHardness(0.8F);
		setResistance(12.5F);
		setHarvestLevel("pickaxe", 1);
	}
}