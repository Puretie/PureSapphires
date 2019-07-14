package org.puretie.puresapphires.init;

import org.puretie.puresapphires.objects.items.ItemBase;
import org.puretie.puresapphires.objects.items.ItemCustomFood;
import org.puretie.puresapphires.objects.items.ItemSeedsBase;
import org.puretie.puresapphires.objects.items.armors.ItemCustomArmor;
import org.puretie.puresapphires.objects.items.tools.ItemCustomAxe;
import org.puretie.puresapphires.objects.items.tools.ItemCustomHoe;
import org.puretie.puresapphires.objects.items.tools.ItemCustomPickaxe;
import org.puretie.puresapphires.objects.items.tools.ItemCustomSpade;
import org.puretie.puresapphires.objects.items.tools.ItemCustomSword;
import org.puretie.puresapphires.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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

	public static Item sapphireIngot;
	static Item sapphirePickaxe;
	static Item sapphireAxe;
	static Item sapphireSpade;
	static Item sapphireHoe;
	static Item sapphireSword;
	static Item sapphireHelmet;
	static Item sapphireChestplate;
	static Item sapphireLeggings;
	static Item sapphireBoots;
	public static Item indiCarrot;
	public static Item indiCarrotSeeds;

	public static final ToolMaterial SAPPHIREMATERIAL = EnumHelper.addToolMaterial("SAPPHIREMATERIAL", 3, 780, 8f, 3f, 10);
	public static final ArmorMaterial SAPPHIREARMOR = EnumHelper.addArmorMaterial(Reference.MOD_ID + ":" + "sapphire_armor", Reference.MOD_ID + ":sapphire", 160, new int[]{2, 5, 6, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);


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
			return false;
		}
	};

	public static void init()
	{
		sapphireIngot = new ItemBase("ingot_sapphire").setCreativeTab(tabPsaphsMod).setMaxStackSize(32);
		sapphirePickaxe = new ItemCustomPickaxe("sapphire_pickaxe", SAPPHIREMATERIAL).setCreativeTab(tabPsaphsMod);
		sapphireAxe = new ItemCustomAxe("sapphire_axe", SAPPHIREMATERIAL, 9.0f, 2.8f).setCreativeTab(tabPsaphsMod);
		sapphireSword = new ItemCustomSword("sapphire_sword", SAPPHIREMATERIAL).setCreativeTab(tabPsaphsMod);
		sapphireSpade = new ItemCustomSpade("sapphire_spade", SAPPHIREMATERIAL).setCreativeTab(tabPsaphsMod);
		sapphireHoe = new ItemCustomHoe("sapphire_hoe", SAPPHIREMATERIAL).setCreativeTab(tabPsaphsMod);
		sapphireHelmet = new ItemCustomArmor("sapphire_helmet", SAPPHIREARMOR, EntityEquipmentSlot.HEAD).setCreativeTab(tabPsaphsMod);
		sapphireChestplate = new ItemCustomArmor("sapphire_chestplate", SAPPHIREARMOR, EntityEquipmentSlot.CHEST).setCreativeTab(tabPsaphsMod);
		sapphireLeggings = new ItemCustomArmor("sapphire_leggings", SAPPHIREARMOR, EntityEquipmentSlot.LEGS).setCreativeTab(tabPsaphsMod);
		sapphireBoots = new ItemCustomArmor("sapphire_boots", SAPPHIREARMOR, EntityEquipmentSlot.FEET).setCreativeTab(tabPsaphsMod);
		
		indiCarrot = new ItemCustomFood("indi_carrot", 5, 0.3f, false).setCreativeTab(tabPsaphsMod);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(sapphireIngot, sapphirePickaxe, sapphireAxe, sapphireSword, sapphireSpade, sapphireHoe, sapphireHelmet, sapphireChestplate, sapphireLeggings, sapphireBoots, indiCarrot, indiCarrotSeeds);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(sapphireIngot);
		registerRender(sapphirePickaxe);
		registerRender(sapphireAxe);
		registerRender(sapphireSword);
		registerRender(sapphireSpade);
		registerRender(sapphireHoe);
		registerRender(sapphireHelmet);
		registerRender(sapphireChestplate);
		registerRender(sapphireLeggings);
		registerRender(sapphireBoots);
		registerRender(indiCarrot);
		registerRender(indiCarrotSeeds);
	}
	

	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
