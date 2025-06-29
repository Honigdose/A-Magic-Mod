package com.honigdose.abyssmagicmod.util;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbyssMagicMod.MOD_ID);



    public static final RegistryObject<CreativeModeTab> ABYSSMAGIC_ITEMS_TAB = CREATIVE_MODE_TABS.register("abyssmagicmod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ABYSSSTEEL.get()))
                    .title(Component.translatable("creativetab.abyssmagicmod.abyssmagic_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        // ORE/INGOTS/RAW ORE
                        output.accept(ModItems.ASTRATHYL.get());
                        output.accept(ModItems.RAW_ASTRATHYL.get());
                        output.accept(ModBlocks.ASTRATHYL_BLOCK.get());

                        output.accept(ModItems.ABYSSSTEEL.get());
                        output.accept(ModItems.RAW_ABYSSSTEEL.get());
                        output.accept(ModBlocks.ABYSSSTEEL_ORE.get());
                        output.accept(ModBlocks.ABYSSSTEEL_BLOCK.get());

                        output.accept(ModItems.BLOODGOLD.get());
                        output.accept(ModItems.RAW_BLOODGOLD.get());
                        output.accept(ModBlocks.BLOODGOLD_BLOCK.get());

                        output.accept(ModItems.CELESTIUM.get());
                        output.accept(ModItems.RAW_CELESTIUM.get());
                        output.accept(ModBlocks.CELESTIUM_BLOCK.get());

                        output.accept(ModItems.FIRERYTE.get());
                        output.accept(ModItems.RAW_FIRERYTE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE_STONE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE.get());
                        output.accept(ModBlocks.FIRERYTE_BLOCK.get());

                        output.accept(ModItems.SUIRYTE.get());
                        output.accept(ModItems.RAW_SUIRYTE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE_STONE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE.get());
                        output.accept(ModBlocks.SUIRYTE_BLOCK.get());

                        output.accept(ModItems.FLORASTEEL.get());
                        output.accept(ModItems.RAW_FLORASTEEl.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE_STONE.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE.get());
                        output.accept(ModBlocks.FLORASTEEL_BLOCK.get());

                        output.accept(ModItems.SYLPHTHYL.get());
                        output.accept(ModItems.RAW_SYLPHTHYL.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE_STONE.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE.get());
                        output.accept(ModBlocks.SYLPHTHYL_BLOCK.get());

                        output.accept(ModItems.SOLARIUM.get());
                        output.accept(ModItems.RAW_SOLARIUM.get());
                        output.accept(ModBlocks.SOLARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.SOLARIUM_ORE.get());
                        output.accept(ModBlocks.SOLARIUM_BLOCK.get());

                        output.accept(ModItems.LUNARIUM.get());
                        output.accept(ModItems.RAW_LUNARIUM.get());
                        output.accept(ModBlocks.LUNARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.LUNARIUM_ORE.get());
                        output.accept(ModBlocks.LUNARIUM_BLOCK.get());

                        output.accept(ModItems.MYRINIUM.get());
                        output.accept(ModItems.RAW_MYRINIUM.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_STONE.get());

                        output.accept(ModItems.MANATHYL.get());

                        output.accept(ModItems.PURE_SILVER.get());

                        output.accept(ModItems.SILVER.get());
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModBlocks.SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.FIRE_SILVER.get());
                        output.accept(ModItems.RAW_FIRE_SILVER.get());
                        output.accept(ModBlocks.FIRE_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.WATER_SILVER.get());
                        output.accept(ModItems.RAW_WATER_SILVER.get());
                        output.accept(ModBlocks.WATER_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.WATER_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.NATURE_SILVER.get());
                        output.accept(ModItems.RAW_NATURE_SILVER.get());
                        output.accept(ModBlocks.NATURE_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.NATURE_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.AIR_SILVER.get());
                        output.accept(ModItems.RAW_AIR_SILVER.get());
                        output.accept(ModBlocks.AIR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.AIR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.SOLAR_SILVER.get());
                        output.accept(ModItems.RAW_SOLAR_SILVER.get());
                        output.accept(ModBlocks.SOLAR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.LUNAR_SILVER.get());
                        output.accept(ModItems.RAW_LUNAR_SILVER.get());
                        output.accept(ModBlocks.LUNAR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.PURE_GOLD.get());

                        output.accept(ModItems.FIRE_GOLD.get());
                        output.accept(ModItems.RAW_FIRE_GOLD.get());
                        output.accept(ModBlocks.FIRE_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.WATER_GOLD.get());
                        output.accept(ModItems.RAW_WATER_GOLD.get());
                        output.accept(ModBlocks.WATER_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.WATER_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.NATURE_GOLD.get());
                        output.accept(ModItems.RAW_NATURE_GOLD.get());
                        output.accept(ModBlocks.NATURE_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.NATURE_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.AIR_GOLD.get());
                        output.accept(ModItems.RAW_AIR_GOLD.get());
                        output.accept(ModBlocks.AIR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.AIR_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.SOLAR_GOLD.get());
                        output.accept(ModItems.RAW_SOLAR_GOLD.get());
                        output.accept(ModBlocks.SOLAR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.LUNAR_GOLD.get());
                        output.accept(ModItems.RAW_LUNAR_GOLD.get());
                        output.accept(ModBlocks.LUNAR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE.get());


                        // CRYSTALS
                        output.accept(ModItems.ARCANA_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.VOID_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.DEMONIC_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.CELESTIAL_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.FIRE_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.FIRE_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.WATER_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.NATURE_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_NATURE_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_NATURE_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_NATURE_CRYSTAL.get());
                        output.accept(ModBlocks.NATURE_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_NATURE_CRYSTAL.get());
                        output.accept(ModBlocks.NATURE_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.AIR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.SOLAR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.LUNAR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL_BLOCK.get());

                        // WOOD
                        //Minecraft Wood Typs
                        output.accept(ModBlocks.OAK_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.OAK_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.SPRUCE_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.SPRUCE_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.BIRCH_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.BIRCH_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.JUNGLE_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.JUNGLE_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.ACACIA_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.ACACIA_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.DARK_OAK_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.DARK_OAK_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.MANGROVE_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.MANGROVE_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.CHERRY_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.CHERRY_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.CRIMSON_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.CRIMSON_ALCHEMY_SHELF_MIX.get());
                        output.accept(ModBlocks.WARPED_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.WARPED_ALCHEMY_SHELF_MIX.get());

                        // Scarlet Tree
                        output.accept(ModBlocks.SCARLET_TREE_SAPLING.get());
                        output.accept(ModBlocks.SCARLET_TREE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get());
                        output.accept(ModBlocks.SCARLET_TREE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get());
                        output.accept(ModBlocks.SCARLET_TREE_LEAVES.get());
                        output.accept(ModBlocks.SCARLET_TREE_PLANKS.get());
                        output.accept(ModBlocks.SCARLET_TREE_STAIR.get());
                        output.accept(ModBlocks.SCARLET_TREE_SLAB.get());
                        output.accept(ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SCARLET_TREE_BUTTON.get());
                        output.accept(ModBlocks.SCARLET_TREE_FENCE.get());
                        output.accept(ModBlocks.SCARLET_TREE_FENCE_GATE.get());
                        output.accept(ModBlocks.SCARLET_TREE_WALL.get());
                        output.accept(ModBlocks.SCARLET_TREE_DOOR.get());
                        output.accept(ModBlocks.SCARLET_TREE_TRAPDOOR.get());
                        output.accept(ModBlocks.SCARLET_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.SCARLET_ALCHEMY_SHELF_MIX.get());

                        output.accept(ModBlocks.INK_CAP.get());
                        output.accept(ModBlocks.WHITE_BLACK_FLOWER.get());
                        output.accept(ModBlocks.TALL_WHITE_BLACK_FLOWER.get());
                        output.accept(ModBlocks.VOID_FLOWER.get());
                        output.accept(ModBlocks.WHITE_VOID_FLOWER.get());
                        output.accept(ModBlocks.PURE_VOID_FLOWER.get());
                        output.accept(ModBlocks.SMALL_VOID_VINE.get());
                        output.accept(ModBlocks.VOID_VINE.get());
                        output.accept(ModBlocks.TALL_VOID_VINE.get());
                        output.accept(ModBlocks.SCARLET_FOREST_GRASS.get());
                        output.accept(ModBlocks.SCARLET_FOREST_DIRT.get());
                        output.accept(ModBlocks.BROWN_TREE_MUSHROOM.get());
                        output.accept(ModBlocks.GLOWING_BROWN_MUSHROOM.get());
                        output.accept(ModBlocks.GLOWING_DARK_BLUE_MUSHROOM.get());
                        output.accept(ModBlocks.GLOWING_RED_MUSHROOM.get());
                        output.accept(ModBlocks.GLOWING_WHITE_RED_MUSHROOM.get());

                        // Life Tree
                        output.accept(ModBlocks.LIFE_TREE_SAPLING.get());
                        output.accept(ModBlocks.BLIFE_TREE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BLIFE_TREE_LOG.get());
                        output.accept(ModBlocks.BLIFE_TREE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BLIFE_TREE_WOOD.get());
                        output.accept(ModBlocks.BLIFE_TREE_PLANKS.get());
                        output.accept(ModBlocks.BLIFE_TREE_STAIR.get());
                        output.accept(ModBlocks.BLIFE_TREE_SLAB.get());
                        output.accept(ModBlocks.BLIFE_TREE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BLIFE_TREE_BUTTON.get());
                        output.accept(ModBlocks.BLIFE_TREE_FENCE.get());
                        output.accept(ModBlocks.BLIFE_TREE_FENCE_GATE.get());
                        output.accept(ModBlocks.BLIFE_TREE_DOOR.get());
                        output.accept(ModBlocks.BLIFE_TREE_TRAPDOOR.get());
                        output.accept(ModBlocks.BLT_ALCHEMY_SHELF_JAR.get());
                        output.accept(ModBlocks.BLT_ALCHEMY_SHELF_MIX.get());
                        //FIRE TYP
                        output.accept(ModBlocks.BLIFE_TREE_FIRE_SAPLING.get());
                        output.accept(ModBlocks.BLIFE_TREE_FIRE_LEAVES.get());
                        output.accept(ModBlocks.BLT_FIRE_HLEAVES.get());
                        output.accept(ModBlocks.BLIFE_TREE_FIRE_RESIN.get());
                        // WATER
                        output.accept(ModBlocks.BLIFE_TREE_WATER_LEAVES.get());
                        output.accept(ModBlocks.BLT_WATER_HLEAVES.get());
                        output.accept(ModBlocks.BLIFE_TREE_WATER_RESIN.get());



                        //Tools
                        //Stage 1
                        output.accept(ModItems.FIRERYTE_PICKAXE_STAGE1.get());




                    }).build());


    public static final RegistryObject<CreativeModeTab> ABYSSMAGIC_ALCHEMY_TAB = CREATIVE_MODE_TABS.register("abyssmagicmod_alchemy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALCHEMY_BOOK.get())).withTabsBefore(ABYSSMAGIC_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.abyssmagicmod.alchemy_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.RESEARCH_TABLE_OAK.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_SPRUCE.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_BIRCH.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_JUNGLE.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_ACACIA.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_DARK_OAK.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_MANGROVE.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_CHERRY.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_CRIMSON.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_WARPED.get());

                        output.accept(ModBlocks.RESEARCH_TABLE_SCARLET.get());
                        output.accept(ModBlocks.RESEARCH_TABLE_BLIFE_TREE.get());


                        output.accept(ModBlocks.ALCHEMY_BOOK.get());

                        output.accept(ModBlocks.BESTIARY_BOOK.get());
                        output.accept(ModBlocks.FORGE_BOOK.get());
                        output.accept(ModBlocks.BOTANICA_BOOK.get());

                        output.accept(ModItems.CHALK.get());
                        output.accept(ModItems.RAW_CHALK.get());

                        output.accept(ModItems.QUILL.get());

                        output.accept(ModBlocks.INK_BOTTLE.get());
                        output.accept(ModBlocks.EMPTY_INK_BOTTLE.get());

                        output.accept(ModBlocks.MORTAR_AND_PESTLE.get());

                        output.accept(ModBlocks.MAGIC_ROUND_BOTTLE.get());
                        output.accept(ModBlocks.MAGIC_SQUARE_BOTTLE.get());
                        output.accept(ModBlocks.MAGIC_TRIANGLE_BOTTLE.get());


                        output.accept(ModBlocks.ESSENCE.get());
                        output.accept(ModBlocks.FIRE_ESSENCE.get());
                        output.accept(ModBlocks.AIR_ESSENCE.get());
                        output.accept(ModBlocks.NATURE_ESSENCE.get());
                        output.accept(ModBlocks.WATER_ESSENCE.get());
                        output.accept(ModBlocks.LUNAR_ESSENCE.get());
                        output.accept(ModBlocks.SOLAR_ESSENCE.get());

                        output.accept(ModItems.ARCANA_ESSENCE_BOTTLE.get());
                        output.accept(ModItems.VOID_ESSENCE_BOTTLE.get());
                        output.accept(ModItems.CELESTIAL_ESSENCE_BOTTLE.get());
                        output.accept(ModItems.DEMONIC_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.FIRE_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.WATER_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.NATURE_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.AIR_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.SOLAR_ESSENCE_BOTTLE.get());
                        output.accept(ModBlocks.LUNAR_ESSENCE_BOTTLE.get());


                        output.accept(ModItems.FIRE_CIRCLE_PAPER.get());
                        output.accept(ModItems.WATER_CIRCLE_PAPER.get());


                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}