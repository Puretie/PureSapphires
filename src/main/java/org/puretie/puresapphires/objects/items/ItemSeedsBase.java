package org.puretie.puresapphires.objects.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSeedsBase extends ItemSeeds
{
	
	private final Block crops;
	private final Block soilBlock;

	public ItemSeedsBase(Block crops, Block soil, String name)
	{	
		super(crops, soil);
		this.crops = crops;
		this.soilBlock = soil;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	public EnumActionResult onItemUse(EntityPlayer p, World w, BlockPos pos, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ)
	{
		ItemStack istack = p.getHeldItem(hand);
		net.minecraft.block.state.IBlockState state = w.getBlockState(pos);
		if (face == EnumFacing.UP && p.canPlayerEdit(pos.offset(face), face, istack) && state.getBlock()== this.soilBlock && w.isAirBlock(pos.up()))
		{
			w.setBlockState(pos.up(), crops.getDefaultState());
			
			if(p instanceof EntityPlayerMP)
			{
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)p, pos.up(), istack);
			}
		
		istack.shrink(1);
		return EnumActionResult.SUCCESS;
		
		}
		else
		{
			return EnumActionResult.FAIL;
		}
	
	}

}
