package org.puretie.puresapphires.objects.blocks;

import java.util.Random;

import org.puretie.puresapphires.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropBase extends BlockCrops
{
	public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, 4);
	private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.35D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.40D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};
	
	
	public BlockCropBase(String name)
	{
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	protected boolean canSustainBush(IBlockState state)
	{
		return state.getBlock() == Blocks.FARMLAND;
	}
	
	public boolean canBlockStay(World w, BlockPos pos, IBlockState state)
	{
		IBlockState soil = w.getBlockState(pos.down());
		return (w.getLight(pos) >= 8 || w.canSeeSky(pos)) && soil.getBlock() == Blocks.FARMLAND;
	}
	
	protected PropertyInteger getAgeProperty()
	{
		return CROP_AGE;
	}
	
	public int getMaxAge()
	{
		return 3;
	}
	
	protected Item getSeed()
	{
		return ItemInit.indiCarrot;
		//TODO: MAKE SEED
	}
	
	public void updateTick(World w, BlockPos pos, IBlockState state, Random rand)
	{
		if (rand.nextInt(3) == 0)
		{
			this.checkAndDropBlock(w, pos, state);
		}
		else
		{
			super.updateTick(w, pos, state, rand);
		}
	}
	
	protected int getBonemealAgeIncrease(World w)
	{
		return MathHelper.getInt(w.rand, 1, 3);
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {CROP_AGE});
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return CROP_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}
}
