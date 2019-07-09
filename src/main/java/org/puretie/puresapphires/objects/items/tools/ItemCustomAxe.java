package org.puretie.puresapphires.objects.items.tools;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class ItemCustomAxe extends ItemAxe
{

	public ItemCustomAxe(String name, ToolMaterial material)
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
