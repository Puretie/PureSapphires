package org.puretie.puresapphires.objects.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOre extends BlockBase
{

	Item toDrop;
	int minDropAmount = 1;
	int maxDropAmount = 1;

	public BlockOre(String name, Material material)
	{
		this(name, material, null, 1, 1);
	}

	public BlockOre(String name, Material material, Item toDrop)
	{
		this(name, material, toDrop, 1, 1);
	}

	public BlockOre(String name, Material material, Item toDrop, int dropAmount)
	{
		this(name, material, toDrop, dropAmount, dropAmount);
	}

	public BlockOre(String name, Material material, Item toDrop, int minDropAmount, int maxDropAmount)
	{
		super(name, material);
		this.toDrop = toDrop;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return toDrop == null ? Item.getItemFromBlock(this) : toDrop;
	}

	public int QuantityDropped(Random random)
	{
		return this.minDropAmount;
	}

	public int QuantityDroppedWithBonus(int fortune, Random random)
	{
		if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune))
		{
			int i = random.nextInt(fortune + 2) - 1;

			if(i < 0)
			{
				i = 0;
			}

			return this.QuantityDropped(random) * (i + 1);
		}

		else
		{
			return this.QuantityDropped(random);
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		//BUG: Not checking if broken with proper tool.
	    this.dropXpOnBlockBreak(world, pos, 1 + world.rand.nextInt(2));
	}
}
