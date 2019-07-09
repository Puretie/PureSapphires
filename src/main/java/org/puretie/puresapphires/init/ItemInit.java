package org.puretie.puresapphires.init;

import org.puretie.puresapphires.objects.items.ItemBase;
import org.puretie.puresapphires.objects.items.tools.ItemCustomPickaxe;
import org.puretie.puresapphires.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ItemInit
{

	static Item sapphireIngot;
	static Item sapphirePickaxe;
	static Item sapphireAxe;
	static Item sapphireSpade;
	static Item sapphireHoe;
	static Item sapphireSword;

	public static final ToolMaterial SAPPHIREMATERIAL = EnumHelper.addToolMaterial("SAPPHIREMATERIAL", 3, 780, 8f, 3f, 10);

	public static final CreativeTabs tabPsaphsMod = new CreativeTabs("tabPsaphsMod")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(sapphireIngot);
		}

		@Override
		public boolean hasSearchBar()
		{
			return true;
		}
	}.setBackgroundImageName("item_search.png");

	public static void init()
	{
		sapphireIngot = new ItemBase("ingot_sapphire").setCreativeTab(tabPsaphsMod).setMaxStackSize(32);
		sapphirePickaxe = new ItemCustomPickaxe("sapphire_pickaxe", SAPPHIREMATERIAL).setCreativeTab(tabPsaphsMod);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(sapphireIngot, sapphirePickaxe);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(sapphireIngot);
		registerRender(sapphirePickaxe);
	}
	

	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
