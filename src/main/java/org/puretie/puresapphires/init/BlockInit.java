package org.puretie.puresapphires.init;

import org.puretie.puresapphires.objects.blocks.BlockCropBase;
import org.puretie.puresapphires.objects.blocks.BlockOre;
import org.puretie.puresapphires.objects.blocks.SapphireBlock;
import org.puretie.puresapphires.objects.items.ItemSeedsBase;
import org.puretie.puresapphires.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class BlockInit
{
	static Block sapphireBlock;
	public static Block sapphireOreBlock;

	static Block indiCarrotCrop;

	public static void initSeeds()
	{

	}

	public static void init()
	{
		sapphireBlock = new SapphireBlock("block_sapphire", Material.IRON).setHardness(1.5f).setCreativeTab(ItemInit.tabPsaphsMod);
		sapphireBlock.setHarvestLevel("pickaxe", 2);

		sapphireOreBlock = new BlockOre("ore_sapphire", Material.ROCK, ItemInit.sapphireIngot, 1).setHardness(3f).setResistance(5f).setCreativeTab(ItemInit.tabPsaphsMod);
		sapphireOreBlock.setHarvestLevel("pickaxe", 2);

		indiCarrotCrop = new BlockCropBase("indi_carrot_crop");

	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(sapphireBlock, sapphireOreBlock, indiCarrotCrop);
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemBlock(sapphireBlock).setRegistryName(sapphireBlock.getRegistryName()));
		event.getRegistry().register(new ItemBlock(sapphireOreBlock).setRegistryName(sapphireOreBlock.getRegistryName()));

		ItemInit.indiCarrotSeeds = new ItemSeedsBase(BlockInit.indiCarrotCrop, Blocks.FARMLAND, "indi_carrot_seeds").setCreativeTab(ItemInit.tabPsaphsMod);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(sapphireBlock));
		registerRender(Item.getItemFromBlock(sapphireOreBlock));
	}

	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
