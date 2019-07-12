package org.puretie.puresapphires.worldgen;

import java.util.Random;

import org.puretie.puresapphires.init.BlockInit;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
			case -1: //NETHER
				break;
			
			case 0: //OVERWORLD
				runGenerator(BlockInit.sapphireOreBlock.getDefaultState(), 4, 10, 2, 35, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
				
			case 1: //END
				break;
				
			default: //ANY OTHER DIMENSIONS
				break;
		}
		
	}
	
	private void runGenerator(IBlockState block, int amount, int spawnChance, int minHeight, int maxHeight, Predicate<IBlockState> replace, World w, Random r, int chunkX, int chunkZ)
	{
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Y U NO HEIGHT PROPERLY");
		
		WorldGenMinable generator = new WorldGenMinable(block, amount, replace);
		int heightdiff = maxHeight - minHeight + 1;
		for (int i = 0; i < spawnChance; i++)
		{
			int x = chunkX * 16 + r.nextInt(16);
			int y = minHeight + r.nextInt(heightdiff);
			int z = chunkZ * 16 + r.nextInt(16);
			
			generator.generate(w, r, new BlockPos(x, y, z));
		}
	}

}
