package org.puretie.puresapphires.objects.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SapphireBlock extends BlockBase
{

	public SapphireBlock(String name, Material material)
	{
		super(name, material);
		
		setSoundType(SoundType.METAL);
	}

}
