package org.puretie.puresapphires.init;

import org.puretie.puresapphires.objects.blocks.BlockBase;
import org.puretie.puresapphires.objects.blocks.BlockOre;
import org.puretie.puresapphires.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
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

	public static void init()
	{
		sapphireBlock = new BlockBase("block_sapphire", Material.ROCK).setHardness(1.5f).setCreativeTab(ItemInit.tabPsaphsMod).setLightLevel(0.4f);
		sapphireBlock.setHarvestLevel("pickaxe", 2);
		
		sapphireOreBlock = new BlockOre("ore_sapphire", Material.ROCK, ItemInit.sapphireIngot, 1).setHardness(3f).setResistance(5f).setCreativeTab(ItemInit.tabPsaphsMod);
		sapphireOreBlock.setHarvestLevel("pickaxe", 2);
		
		
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(sapphireBlock, sapphireOreBlock);
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(new ItemBlock(sapphireBlock).setRegistryName(sapphireBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(sapphireOreBlock).setRegistryName(sapphireOreBlock.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(sapphireBlock));
		registerRender(Item.getItemFromBlock(sapphireOreBlock));
	}

	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
