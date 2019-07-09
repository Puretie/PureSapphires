package org.puretie.puresapphires.objects.items.tools;

import net.minecraft.item.ItemSpade;

public class ItemCustomSpade extends ItemSpade
{

	public ItemCustomSpade(String name, ToolMaterial material)
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
