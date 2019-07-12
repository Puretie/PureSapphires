package org.puretie.puresapphires;

import org.puretie.puresapphires.init.BlockInit;
import org.puretie.puresapphires.init.ItemInit;
import org.puretie.puresapphires.proxy.CommonProxy;
import org.puretie.puresapphires.util.Reference;
import org.puretie.puresapphires.worldgen.OreGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		System.out.println(Reference.MOD_ID + ":preInit");
		ItemInit.init();
		BlockInit.init();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		System.out.println(Reference.MOD_ID + ":Init");
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		System.out.println(Reference.MOD_ID + ":postInit");
	}
}
