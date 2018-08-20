package com.outland.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IceObs extends BlockBase {

	public IceObs(String _name, Material _blockMat) {
		super(_name, _blockMat);
		
		setSoundType(SoundType.STONE);
		setHardness(47.5F);
		setResistance(5750.0F);
		setHarvestLevel("pickaxe", 3);
	}
}