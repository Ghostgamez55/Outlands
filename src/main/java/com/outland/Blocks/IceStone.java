package com.outland.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IceStone extends BlockBase {

	public IceStone(String _name, Material _blockMat) {
		super(_name, _blockMat);
		
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 1);
	}
}