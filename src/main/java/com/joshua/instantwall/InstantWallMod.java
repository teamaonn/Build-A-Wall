package com.joshua.instantwall;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InstantWallMod implements ModInitializer {
	public static final String MOD_ID = "instantwall";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final ResourceKey<Item> INSTANT_WALL_KEY = ResourceKey.create(
			Registries.ITEM,
			Identifier.fromNamespaceAndPath(MOD_ID, "instant_wall")
	);

	public static final Item INSTANT_WALL = Registry.register(
			BuiltInRegistries.ITEM,
			INSTANT_WALL_KEY,
			new InstantWallItem(new Item.Properties().setId(INSTANT_WALL_KEY))
	);

	@Override
	public void onInitialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register(entries -> entries.accept(INSTANT_WALL));

		LOGGER.info("Instant Wall is ready to deploy.");
	}
}
