package com.honigdose.abyssmagicmod.block;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.alchemy.MortarAndPestleBlock;
import com.honigdose.abyssmagicmod.block.alchemy.ResearchTable.ResearchTableBlock;
import com.honigdose.abyssmagicmod.block.alchemy.ShelfBlock;
import com.honigdose.abyssmagicmod.block.alchemy.ShelfCornerBlock;
import com.honigdose.abyssmagicmod.block.alchemy.ShelfDekoBlock;
import com.honigdose.abyssmagicmod.block.custom.*;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicRoundBottlesBlock;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicSquareBottlesBlock;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicTriangleBottlesBlock;
import com.honigdose.abyssmagicmod.block.crystals.LargeMagicCrystalBlock;
import com.honigdose.abyssmagicmod.block.custom.ModFlammableRotatedPillarBlock;
import com.honigdose.abyssmagicmod.block.custom.ModFlammableWoodBlock;
import com.honigdose.abyssmagicmod.block.custom.ModRotatedBlock;
import com.honigdose.abyssmagicmod.block.natur.ScarletLeavesBlock;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AbyssMagicMod.MOD_ID);

// ORE
    public static final RegistryObject<Block> ABYSSSTEEL_ORE = registerrareOreDeepslate("abysssteel_ore", 1, 2, 10);
    public static final RegistryObject<Block> FIRERYTE_ORE = registerrareOreDeepslate("fireryte_ore", 1, 2, 10);
    public static final RegistryObject<Block> SOLARIUM_ORE = registerrareOreDeepslate("solarium_ore", 1, 2, 10);
    public static final RegistryObject<Block> LUNARIUM_ORE = registerrareOreDeepslate("lunarium_ore", 1, 2, 10);
    public static final RegistryObject<Block> SUIRYTE_ORE = registerrareOreDeepslate("suiryte_ore", 1, 2, 10);
    public static final RegistryObject<Block> FLORASTEEL_ORE = registerrareOreDeepslate("florasteel_ore", 1, 2, 10);
    public static final RegistryObject<Block> SYLPHTHYL_ORE = registerrareOreDeepslate("sylphthyl_ore", 1, 2, 10);

    public static final RegistryObject<Block> FIRERYTE_ORE_STONE = registerrareOreStone("fireryte_ore_stone", 1, 2, 10);
    public static final RegistryObject<Block> SOLARIUM_ORE_STONE = registerrareOreStone("solarium_ore_stone", 1, 2, 10);
    public static final RegistryObject<Block> LUNARIUM_ORE_STONE = registerrareOreStone("lunarium_ore_stone", 1, 2, 10);
    public static final RegistryObject<Block> SUIRYTE_ORE_STONE = registerrareOreStone("suiryte_ore_stone", 1, 2, 10);
    public static final RegistryObject<Block> FLORASTEEL_ORE_STONE = registerrareOreStone("florasteel_ore_stone", 1, 2, 10);
    public static final RegistryObject<Block> SYLPHTHYL_ORE_STONE = registerrareOreStone("sylphthyl_ore_stone", 1, 2, 10);


    public static final RegistryObject<Block> ASTRATHYL_BLOCK = registerIngotBlock("astrathyl_block", 1);
    public static final RegistryObject<Block> FIRERYTE_BLOCK = registerIngotBlock("fireryte_block", 1);
    public static final RegistryObject<Block> SUIRYTE_BLOCK = registerIngotBlock("suiryte_block", 1);
    public static final RegistryObject<Block> SOLARIUM_BLOCK = registerIngotBlock("solarium_block", 1);
    public static final RegistryObject<Block> LUNARIUM_BLOCK = registerIngotBlock("lunarium_block", 1);
    public static final RegistryObject<Block> FLORASTEEL_BLOCK = registerIngotBlock("florasteel_block", 1);
    public static final RegistryObject<Block> SYLPHTHYL_BLOCK = registerIngotBlock("sylphthyl_block", 1);
    public static final RegistryObject<Block> BLOODGOLD_BLOCK = registerIngotBlock("bloodgold_block", 1);
    public static final RegistryObject<Block> CELESTIUM_BLOCK = registerIngotBlock("celestium_block", 1);
    public static final RegistryObject<Block> ABYSSSTEEL_BLOCK = registerIngotBlock("abysssteel_block", 1);

    public static final RegistryObject<Block> SILVER_ORE_STONE = registerOreStone("silver_ore_stone", 10);
    public static final RegistryObject<Block> AIR_SILVER_ORE_STONE = registerOreStone("air_silver_ore_stone", 10);
    public static final RegistryObject<Block> FIRE_SILVER_ORE_STONE = registerOreStone("fire_silver_ore_stone", 10);
    public static final RegistryObject<Block> NATUR_SILVER_ORE_STONE = registerOreStone("natur_silver_ore_stone", 10);
    public static final RegistryObject<Block> WATER_SILVER_ORE_STONE = registerOreStone("water_silver_ore_stone", 10);
    public static final RegistryObject<Block> SOLAR_SILVER_ORE_STONE = registerOreStone("solar_silver_ore_stone", 10);
    public static final RegistryObject<Block> LUNAR_SILVER_ORE_STONE = registerOreStone("lunar_silver_ore_stone", 10);

    public static final RegistryObject<Block> SILVER_ORE_DEEPSLATE = registerOreDeepslate("silver_ore_deepslate", 10);
    public static final RegistryObject<Block> AIR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("air_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> FIRE_SILVER_ORE_DEEPSLATE = registerOreDeepslate("fire_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> NATUR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("natur_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> WATER_SILVER_ORE_DEEPSLATE = registerOreDeepslate("water_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> SOLAR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("solar_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> LUNAR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("lunar_silver_ore_deepslate", 10);

    public static final RegistryObject<Block> AIR_GOLD_ORE_STONE = registerOreStone("air_gold_ore_stone", 10);
    public static final RegistryObject<Block> FIRE_GOLD_ORE_STONE = registerOreStone("fire_gold_ore_stone", 10);
    public static final RegistryObject<Block> NATUR_GOLD_ORE_STONE = registerOreStone("natur_gold_ore_stone", 10);
    public static final RegistryObject<Block> WATER_GOLD_ORE_STONE = registerOreStone("water_gold_ore_stone", 10);
    public static final RegistryObject<Block> SOLAR_GOLD_ORE_STONE = registerOreStone("solar_gold_ore_stone", 10);
    public static final RegistryObject<Block> LUNAR_GOLD_ORE_STONE = registerOreStone("lunar_gold_ore_stone", 10);

    public static final RegistryObject<Block> AIR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("air_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> FIRE_GOLD_ORE_DEEPSLATE = registerOreDeepslate("fire_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> NATUR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("natur_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> WATER_GOLD_ORE_DEEPSLATE = registerOreDeepslate("water_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> SOLAR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("solar_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> LUNAR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("lunar_gold_ore_deepslate", 10);


    public static final RegistryObject<Block> MYRINIUM_ORE_DEEPSLATE = registerBlock("myrinium_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final RegistryObject<Block> MYRINIUM_ORE_STONE = registerBlock("myrinium_ore_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));


// CRYSTALS
    public static final RegistryObject<Block> BABY_FIRE_CRYSTAL = registerClusterCrystalBlock("baby_fire_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_AIR_CRYSTAL = registerClusterCrystalBlock("baby_air_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_NATUR_CRYSTAL = registerClusterCrystalBlock("baby_natur_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_WATER_CRYSTAL = registerClusterCrystalBlock("baby_water_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_SOLAR_CRYSTAL = registerClusterCrystalBlock("baby_solar_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_LUNAR_CRYSTAL = registerClusterCrystalBlock("baby_lunar_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_VOID_CRYSTAL = registerClusterCrystalBlock("baby_void_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_DEMONIC_CRYSTAL = registerClusterCrystalBlock("baby_demonic_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_CELESTIAL_CRYSTAL = registerClusterCrystalBlock("baby_celestial_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_ARCANA_CRYSTAL = registerClusterCrystalBlock("baby_arcana_crystal",2,1,5);

    public static final RegistryObject<Block> VERY_SMALL_FIRE_CRYSTAL = registerClusterCrystalBlock("very_small_fire_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_AIR_CRYSTAL = registerClusterCrystalBlock("very_small_air_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_NATUR_CRYSTAL = registerClusterCrystalBlock("very_small_natur_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_WATER_CRYSTAL = registerClusterCrystalBlock("very_small_water_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_SOLAR_CRYSTAL = registerClusterCrystalBlock("very_small_solar_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_LUNAR_CRYSTAL = registerClusterCrystalBlock("very_small_lunar_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_VOID_CRYSTAL = registerClusterCrystalBlock("very_small_void_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_DEMONIC_CRYSTAL = registerClusterCrystalBlock("very_small_demonic_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_CELESTIAL_CRYSTAL = registerClusterCrystalBlock("very_small_celestial_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_ARCANA_CRYSTAL = registerClusterCrystalBlock("very_small_arcana_crystal",2,2,5);

    public static final RegistryObject<Block> SMALL_FIRE_CRYSTAL = registerClusterCrystalBlock("small_fire_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_AIR_CRYSTAL = registerClusterCrystalBlock("small_air_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_NATUR_CRYSTAL = registerClusterCrystalBlock("small_natur_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_WATER_CRYSTAL = registerClusterCrystalBlock("small_water_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_SOLAR_CRYSTAL = registerClusterCrystalBlock("small_solar_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_LUNAR_CRYSTAL = registerClusterCrystalBlock("small_lunar_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_VOID_CRYSTAL = registerClusterCrystalBlock("small_void_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_DEMONIC_CRYSTAL = registerClusterCrystalBlock("small_demonic_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_CELESTIAL_CRYSTAL = registerClusterCrystalBlock("small_celestial_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_ARCANA_CRYSTAL = registerClusterCrystalBlock("small_arcana_crystal",4,2,5);

    public static final RegistryObject<Block> FIRE_CRYSTAL = registerClusterCrystalBlock("fire_crystal",6,4,5);
    public static final RegistryObject<Block> AIR_CRYSTAL = registerClusterCrystalBlock("air_crystal",6,4,5);
    public static final RegistryObject<Block> NATUR_CRYSTAL = registerClusterCrystalBlock("natur_crystal",6,4,5);
    public static final RegistryObject<Block> WATER_CRYSTAL = registerClusterCrystalBlock("water_crystal",6,4,5);
    public static final RegistryObject<Block> SOLAR_CRYSTAL = registerClusterCrystalBlock("solar_crystal",6,4,5);
    public static final RegistryObject<Block> LUNAR_CRYSTAL = registerClusterCrystalBlock("lunar_crystal",6,4,5);
    public static final RegistryObject<Block> VOID_CRYSTAL = registerClusterCrystalBlock("void_crystal",6,4,5);
    public static final RegistryObject<Block> DEMONIC_CRYSTAL = registerClusterCrystalBlock("demonic_crystal",6,4,5);
    public static final RegistryObject<Block> CELESTIAL_CRYSTAL = registerClusterCrystalBlock("celestial_crystal",6,4,5);
    public static final RegistryObject<Block> ARCANA_CRYSTAL = registerClusterCrystalBlock("arcana_crystal",6,4,5);

    public static final RegistryObject<Block> LARGE_ARCANA_CRYSTAL = registerLargeClusterCrystalBlock("large_arcana_crystal",4);
    public static final RegistryObject<Block> LARGE_FIRE_CRYSTAL = registerLargeClusterCrystalBlock("large_fire_crystal",4);
    public static final RegistryObject<Block> LARGE_AIR_CRYSTAL = registerLargeClusterCrystalBlock("large_air_crystal",4);
    public static final RegistryObject<Block> LARGE_NATUR_CRYSTAL = registerLargeClusterCrystalBlock("large_natur_crystal",4);
    public static final RegistryObject<Block> LARGE_WATER_CRYSTAL = registerLargeClusterCrystalBlock("large_water_crystal",4);
    public static final RegistryObject<Block> LARGE_SOLAR_CRYSTAL = registerLargeClusterCrystalBlock("large_solar_crystal",4);
    public static final RegistryObject<Block> LARGE_LUNAR_CRYSTAL = registerLargeClusterCrystalBlock("large_lunar_crystal",4);
    public static final RegistryObject<Block> LARGE_VOID_CRYSTAL = registerLargeClusterCrystalBlock("large_void_crystal",4);
    public static final RegistryObject<Block> LARGE_DEMONIC_CRYSTAL = registerLargeClusterCrystalBlock("large_demonic_crystal",4);
    public static final RegistryObject<Block> LARGE_CELESTIAL_CRYSTAL = registerLargeClusterCrystalBlock("large_celestial_crystal",4);


    public static final RegistryObject<Block> FIRE_CRYSTAL_BLOCK = registerCrystalBlock("fire_crystal_block",4, 11);
    public static final RegistryObject<Block> AIR_CRYSTAL_BLOCK = registerCrystalBlock("air_crystal_block",4, 11);
    public static final RegistryObject<Block> NATUR_CRYSTAL_BLOCK = registerCrystalBlock("natur_crystal_block",4, 11);
    public static final RegistryObject<Block> WATER_CRYSTAL_BLOCK = registerCrystalBlock("water_crystal_block",4, 11);
    public static final RegistryObject<Block> SOLAR_CRYSTAL_BLOCK = registerCrystalBlock("solar_crystal_block",4, 11);
    public static final RegistryObject<Block> LUNAR_CRYSTAL_BLOCK = registerCrystalBlock("lunar_crystal_block",4, 11);
    public static final RegistryObject<Block> VOID_CRYSTAL_BLOCK = registerCrystalBlock("void_crystal_block",4,11);
    public static final RegistryObject<Block> DEMONIC_CRYSTAL_BLOCK = registerCrystalBlock("demonic_crystal_block",4, 11);
    public static final RegistryObject<Block> CELESTIAL_CRYSTAL_BLOCK = registerCrystalBlock("celestial_crystal_block",4, 11);
    public static final RegistryObject<Block> ARCANA_CRYSTAL_BLOCK = registerCrystalBlock("arcana_crystal_block",4, 15);


    // Alchemy
    public static final RegistryObject<Block> RESEARCH_TABLE_OAK = registerBlock("research_table_oak",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_ACACIA = registerBlock("research_table_acacia",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_DARK_OAK = registerBlock("research_table_dark_oak",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_JUNGLE = registerBlock("research_table_jungle",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_CHERRY = registerBlock("research_table_cherry",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_MANGROVE = registerBlock("research_table_mangrove",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_BIRCH = registerBlock("research_table_birch",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_SPRUCE = registerBlock("research_table_spruce",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_WARPED = registerBlock("research_table_warped",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> RESEARCH_TABLE_CRIMSON = registerBlock("research_table_crimson",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> ALCHEMY_BOOK = BLOCKS.register("alchemy_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> BESTIARY_BOOK = BLOCKS.register("bestiary_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> FORGE_BOOK = BLOCKS.register("forge_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> BOTANICUM_BOOK = BLOCKS.register("botanicum_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> MAGIC_ROUND_BOTTLE = BLOCKS.register("magic_round_bottle",
            () -> new MagicRoundBottlesBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MAGIC_TRIANGLE_BOTTLE = BLOCKS.register("magic_triangle_bottle",
            () -> new MagicTriangleBottlesBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MAGIC_SQUARE_BOTTLE = BLOCKS.register("magic_square_bottle",
            () -> new MagicSquareBottlesBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));


    public static final RegistryObject<Block> MORTAR_AND_PESTLE = BLOCKS.register("mortar_and_pestle",
            () -> new MortarAndPestleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    public static final RegistryObject<Block> INK_BOTTLE = BLOCKS.register("ink_bottle",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()) {
                public static final VoxelShape SHAPE = Block.box(5, 0, 5, 10, 5, 10);
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
                    return SHAPE;
                }
            });
    public static final RegistryObject<Block> EMPTY_INK_BOTTLE = BLOCKS.register("empty_ink_bottle",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()) {
                public static final VoxelShape SHAPE = Block.box(5, 0, 5, 10, 5, 10);
                @Override
                public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
                    return SHAPE;
                }
            });
    // WOOD / TREE
    //Minecraft Wood Typs
    public static final RegistryObject<Block> OAK_ALCHEMY_SHELF_JAR = registerBlock("oak_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_ALCHEMY_SHELF_MIX = registerBlock("oak_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_ALCHEMY_SHELF_JAR = registerBlock("dark_oak_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_ALCHEMY_SHELF_MIX = registerBlock("dark_oak_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_ALCHEMY_SHELF_JAR = registerBlock("acacia_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_ALCHEMY_SHELF_MIX = registerBlock("acacia_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_ALCHEMY_SHELF_JAR = registerBlock("jungle_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_ALCHEMY_SHELF_MIX = registerBlock("jungle_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_ALCHEMY_SHELF_JAR = registerBlock("cherry_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_ALCHEMY_SHELF_MIX = registerBlock("cherry_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_ALCHEMY_SHELF_JAR = registerBlock("mangrove_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_ALCHEMY_SHELF_MIX = registerBlock("mangrove_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> BIRCH_ALCHEMY_SHELF_JAR = registerBlock("birch_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> BIRCH_ALCHEMY_SHELF_MIX = registerBlock("birch_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_ALCHEMY_SHELF_JAR = registerBlock("crimson_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_ALCHEMY_SHELF_MIX = registerBlock("crimson_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_ALCHEMY_SHELF_JAR = registerBlock("spruce_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_ALCHEMY_SHELF_MIX = registerBlock("spruce_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_ALCHEMY_SHELF_JAR = registerBlock("warped_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_ALCHEMY_SHELF_MIX = registerBlock("warped_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));


    // Scarlet Tree
    public static final RegistryObject<Block> SCARLET_TREE_LOG = registerLogBlock("scarlet_tree_log");
    public static final RegistryObject<Block> SCARLET_TREE_WOOD = registerWoodBlock("scarlet_tree_wood");
    public static final RegistryObject<Block> STRIPPED_SCARLET_TREE_LOG = registerStrippedLogBlock("stripped_scarlet_tree_log");
    public static final RegistryObject<Block> STRIPPED_SCARLET_TREE_WOOD = registerStrippedWoodBlock("stripped_scarlet_tree_wood");

    public static final RegistryObject<Block> SCARLET_TREE_LEAVES = registerBlock("scarlet_tree_leaves",
            () -> new ScarletLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> SCARLET_TREE_SAPLING = registerBlock("scarlet_tree_sapling",
            () -> new SaplingBlock(ModTreeGrowers.SCARLET,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SCARLET_TREE_PLANKS = registerPlanks("scarlet_tree_planks");
    public static final RegistryObject<Block> SCARLET_TREE_SLAB = registerSlab("scarlet_tree_slab");
    public static final RegistryObject<Block> SCARLET_TREE_STAIR = registerBlock("scarlet_tree_stair",
            () -> new StairBlock(ModBlocks.SCARLET_TREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> SCARLET_TREE_PRESSURE_PLATE = registerPressurePlate("scarlet_tree_pressure_plate");
    public static final RegistryObject<Block> SCARLET_TREE_BUTTON = registerButton("scarlet_tree_button");
    public static final RegistryObject<Block> SCARLET_TREE_FENCE = registerFence("scarlet_tree_fence");
    public static final RegistryObject<Block> SCARLET_TREE_FENCE_GATE = registerFenceGate("scarlet_tree_fence_gate");
    public static final RegistryObject<Block> SCARLET_TREE_WALL = registerBlock("scarlet_tree_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> SCARLET_TREE_DOOR = registerDoor("scarlet_tree_door");
    public static final RegistryObject<Block> SCARLET_TREE_TRAPDOOR = registerTrapDoor("scarlet_tree_trapdoor");

    public static final RegistryObject<Block> RESEARCH_TABLE_SCARLET = registerBlock("research_table_scarlet",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().lightLevel(value -> 3)));

    public static final RegistryObject<Block> SCARLET_ALCHEMY_SHELF_JAR = registerBlock("scarlet_alchemy_shelf_jar",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SCARLET_ALCHEMY_SHELF_MIX = registerBlock("scarlet_alchemy_shelf_mix",
            () -> new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));



    // Life Tree
    public static final RegistryObject<Block> LIFE_TREE_LOG = registerBlock("life_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LIFE_TREE_WOOD = registerBlock("life_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_LIFE_TREE_LOG = registerBlock("stripped_life_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LIFE_TREE_WOOD = registerBlock("stripped_life_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> LIFE_TREE_LEAVES = registerBlock("life_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).lightLevel(value -> 8)));
    public static final RegistryObject<Block> LIFE_TREE_SAPLING = registerBlock("life_tree_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIFE_TREE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(value -> 6)));

    public static final RegistryObject<Block> LIFE_TREE_PLANKS = registerBlock("life_tree_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> LIFE_TREE_FIRETYP_DOOR = registerBlock("life_tree_firetyp_door",
            () -> new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static RegistryObject<Block> registerrareOreDeepslate(String name, int xp1, int xp2, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new DropExperienceBlock(UniformInt.of(xp1, xp2),BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerrareOreStone(String name, int xp1, int xp2, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new DropExperienceBlock(UniformInt.of(xp1, xp2),BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerOreDeepslate(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new Block(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerOreStone(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new Block(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerCrystalBlock(String name, float strength, int light) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new TintedGlassBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .lightLevel(value -> light)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerClusterCrystalBlock(String name, float x, float y , float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new AmethystClusterBlock(x,y,BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .lightLevel(value -> 10)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerLargeClusterCrystalBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new LargeMagicCrystalBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .noOcclusion()
                        .lightLevel(value -> 10)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerIngotBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModRotatedBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.COPPER)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerLogBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerWoodBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerStrippedLogBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerStrippedWoodBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerPlanks(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModFlammableWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerSlab(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerPressurePlate(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new PressurePlateBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerButton(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ButtonBlock(BlockSetType.OAK , 15,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerFence(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerFenceGate(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new FenceGateBlock(WoodType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerDoor(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerTrapDoor(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new TrapDoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }





    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}