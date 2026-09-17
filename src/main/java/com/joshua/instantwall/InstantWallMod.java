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
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InstantWallMod implements ModInitializer {
	public static final String MOD_ID = "instantwall";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item INSTANT_WALL = register("instant_wall", Blocks.COBBLESTONE_WALL, 2, false);
	public static final Item INSTANT_MOSSY_COBBLESTONE_WALL = register("instant_mossy_cobblestone_wall", Blocks.MOSSY_COBBLESTONE_WALL, 2, false);
	public static final Item INSTANT_STONE_BRICK_WALL = register("instant_stone_brick_wall", Blocks.STONE_BRICK_WALL, 2, false);
	public static final Item INSTANT_MOSSY_STONE_BRICK_WALL = register("instant_mossy_stone_brick_wall", Blocks.MOSSY_STONE_BRICK_WALL, 2, false);
	public static final Item INSTANT_GRANITE_WALL = register("instant_granite_wall", Blocks.GRANITE_WALL, 2, false);
	public static final Item INSTANT_DIORITE_WALL = register("instant_diorite_wall", Blocks.DIORITE_WALL, 2, false);
	public static final Item INSTANT_ANDESITE_WALL = register("instant_andesite_wall", Blocks.ANDESITE_WALL, 2, false);
	public static final Item INSTANT_BRICK_WALL = register("instant_brick_wall", Blocks.BRICK_WALL, 2, false);
	public static final Item INSTANT_SANDSTONE_WALL = register("instant_sandstone_wall", Blocks.SANDSTONE_WALL, 2, false);
	public static final Item INSTANT_RED_SANDSTONE_WALL = register("instant_red_sandstone_wall", Blocks.RED_SANDSTONE_WALL, 2, false);
	public static final Item INSTANT_NETHER_BRICK_WALL = register("instant_nether_brick_wall", Blocks.NETHER_BRICK_WALL, 2, false);
	public static final Item INSTANT_RED_NETHER_BRICK_WALL = register("instant_red_nether_brick_wall", Blocks.RED_NETHER_BRICK_WALL, 2, false);
	public static final Item INSTANT_END_STONE_BRICK_WALL = register("instant_end_stone_brick_wall", Blocks.END_STONE_BRICK_WALL, 2, false);
	public static final Item INSTANT_BLACKSTONE_WALL = register("instant_blackstone_wall", Blocks.BLACKSTONE_WALL, 2, false);
	public static final Item INSTANT_POLISHED_BLACKSTONE_WALL = register("instant_polished_blackstone_wall", Blocks.POLISHED_BLACKSTONE_WALL, 2, false);
	public static final Item INSTANT_POLISHED_BLACKSTONE_BRICK_WALL = register("instant_polished_blackstone_brick_wall", Blocks.POLISHED_BLACKSTONE_BRICK_WALL, 2, false);
	public static final Item INSTANT_DEEPSLATE_BRICK_WALL = register("instant_deepslate_brick_wall", Blocks.DEEPSLATE_BRICK_WALL, 2, false);
	public static final Item INSTANT_DEEPSLATE_TILE_WALL = register("instant_deepslate_tile_wall", Blocks.DEEPSLATE_TILE_WALL, 2, false);
	public static final Item INSTANT_MUD_BRICK_WALL = register("instant_mud_brick_wall", Blocks.MUD_BRICK_WALL, 2, false);
	public static final Item INSTANT_TUFF_WALL = register("instant_tuff_wall", Blocks.TUFF_WALL, 2, false);
	public static final Item INSTANT_POLISHED_TUFF_WALL = register("instant_polished_tuff_wall", Blocks.POLISHED_TUFF_WALL, 2, false);
	public static final Item INSTANT_TUFF_BRICK_WALL = register("instant_tuff_brick_wall", Blocks.TUFF_BRICK_WALL, 2, false);
	public static final Item INSTANT_SAND = register("instant_sand", Blocks.SAND, 9, true);
	public static final Item INSTANT_GRAVEL = register("instant_gravel", Blocks.GRAVEL, 9, true);

	private static final Item[] CREATIVE_ITEMS = {
		INSTANT_WALL,
		INSTANT_MOSSY_COBBLESTONE_WALL,
		INSTANT_STONE_BRICK_WALL,
		INSTANT_MOSSY_STONE_BRICK_WALL,
		INSTANT_GRANITE_WALL,
		INSTANT_DIORITE_WALL,
		INSTANT_ANDESITE_WALL,
		INSTANT_BRICK_WALL,
		INSTANT_SANDSTONE_WALL,
		INSTANT_RED_SANDSTONE_WALL,
		INSTANT_NETHER_BRICK_WALL,
		INSTANT_RED_NETHER_BRICK_WALL,
		INSTANT_END_STONE_BRICK_WALL,
		INSTANT_BLACKSTONE_WALL,
		INSTANT_POLISHED_BLACKSTONE_WALL,
		INSTANT_POLISHED_BLACKSTONE_BRICK_WALL,
		INSTANT_DEEPSLATE_BRICK_WALL,
		INSTANT_DEEPSLATE_TILE_WALL,
		INSTANT_MUD_BRICK_WALL,
		INSTANT_TUFF_WALL,
		INSTANT_POLISHED_TUFF_WALL,
		INSTANT_TUFF_BRICK_WALL,
		INSTANT_SAND,
		INSTANT_GRAVEL
	};

	private static Item register(String id, net.minecraft.world.level.block.Block block, int height, boolean replaceWater) {
		ResourceKey<Item> key = ResourceKey.create(
				Registries.ITEM,
				Identifier.fromNamespaceAndPath(MOD_ID, id)
		);
		return Registry.register(
				BuiltInRegistries.ITEM,
				key,
				new InstantWallItem(new Item.Properties().setId(key), block, height, replaceWater)
		);
	}

	@Override
	public void onInitialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register(entries -> {
					for (Item item : CREATIVE_ITEMS) {
						entries.accept(item);
					}
				});

		LOGGER.info("Instant Wall materials are ready to deploy.");
	}
}
