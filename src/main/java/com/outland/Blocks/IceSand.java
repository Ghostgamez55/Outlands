package com.outland.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class IceSand extends BlockBase {

	public IceSand(String _name, Material _blockMat) {
		super(_name, _blockMat);
		
		setSoundType(SoundType.SAND);
		setHardness(0.5F);
		setResistance(15.0F);
		setHarvestLevel("shovel", 1);
	}
}