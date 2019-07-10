package org.puretie.puresapphires.objects.items.armors;

import org.puretie.puresapphires.init.ItemInit;
import org.puretie.puresapphires.util.Reference;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemCustomArmor extends ItemArmor
{

	public ItemCustomArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipmentSlot)
	{
		super(material, 0, equipmentSlot);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		setCreativeTab(ItemInit.tabPsaphsMod);
	}

}
