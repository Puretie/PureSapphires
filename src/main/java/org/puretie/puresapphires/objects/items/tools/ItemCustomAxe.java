package org.puretie.puresapphires.objects.items.tools;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class ItemCustomAxe extends ItemAxe
{

	public ItemCustomAxe(String name, ToolMaterial material, float damage, float speed)
	{
		super(material, damage, speed);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
