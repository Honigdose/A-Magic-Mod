package com.honigdose.abyssmagicmod.block;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.alchemy.MortarAndPestleBlock;
import com.honigdose.abyssmagicmod.block.alchemy.researchtable.ResearchTableBlock;
import com.honigdose.abyssmagicmod.block.alchemy.ShelfDekoBlock;
import com.honigdose.abyssmagicmod.block.alchemy.alchemy_circle.FireCircle;
import com.honigdose.abyssmagicmod.block.alchemy.alchemy_circle.WaterCircle;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottle;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottle;
import com.honigdose.abyssmagicmod.block.crystals.*;
import com.honigdose.abyssmagicmod.block.custom.*;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicRoundBottlesBlock;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicSquareBottlesBlock;
import com.honigdose.abyssmagicmod.block.alchemy.bottles.MagicTriangleBottlesBlock;
import com.honigdose.abyssmagicmod.block.custom.ModFlammableRotatedPillarBlock;
import com.honigdose.abyssmagicmod.block.custom.ModFlammableWoodBlock;
import com.honigdose.abyssmagicmod.block.custom.ModRotatedBlock;
import com.honigdose.abyssmagicmod.block.essence.block.air.AirEssence;
import com.honigdose.abyssmagicmod.block.essence.block.fire.FireEssence;
import com.honigdose.abyssmagicmod.block.essence.block.lunar.LunarEssence;
import com.honigdose.abyssmagicmod.block.essence.block.natur.NatureEssence;
import com.honigdose.abyssmagicmod.block.essence.block.solar.SolarEssence;
import com.honigdose.abyssmagicmod.block.essence.block.test.Essence;
import com.honigdose.abyssmagicmod.block.essence.block.water.WaterEssence;
import com.honigdose.abyssmagicmod.block.essence.bottle.lunar.LunarEssenceBottle;
import com.honigdose.abyssmagicmod.block.essence.bottle.nature.NatureEssenceBottle;
import com.honigdose.abyssmagicmod.block.essence.bottle.solar.SolarEssenceBottle;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottle;
import com.honigdose.abyssmagicmod.block.nature.CustomVineBlock;
import com.honigdose.abyssmagicmod.block.nature.ScarletGrassBlock;
import com.honigdose.abyssmagicmod.block.nature.TreeMushroom;
import com.honigdose.abyssmagicmod.block.nature.glowingmushroom.GlowingTreeMushroom;
import com.honigdose.abyssmagicmod.block.nature.hleaves.BLTFHLeaves;
import com.honigdose.abyssmagicmod.block.nature.hleaves.BLTFHLeavesPlant;
import com.honigdose.abyssmagicmod.block.nature.ScarletLeavesBlock;
import com.honigdose.abyssmagicmod.block.nature.hleaves.BLTFWLeavesPlant;
import com.honigdose.abyssmagicmod.block.nature.hleaves.BLTWHLeaves;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.shapes.CollisionContext;
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
    public static final RegistryObject<Block> NATURE_SILVER_ORE_STONE = registerOreStone("nature_silver_ore_stone", 10);
    public static final RegistryObject<Block> WATER_SILVER_ORE_STONE = registerOreStone("water_silver_ore_stone", 10);
    public static final RegistryObject<Block> SOLAR_SILVER_ORE_STONE = registerOreStone("solar_silver_ore_stone", 10);
    public static final RegistryObject<Block> LUNAR_SILVER_ORE_STONE = registerOreStone("lunar_silver_ore_stone", 10);

    public static final RegistryObject<Block> SILVER_ORE_DEEPSLATE = registerOreDeepslate("silver_ore_deepslate", 10);
    public static final RegistryObject<Block> AIR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("air_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> FIRE_SILVER_ORE_DEEPSLATE = registerOreDeepslate("fire_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> NATURE_SILVER_ORE_DEEPSLATE = registerOreDeepslate("nature_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> WATER_SILVER_ORE_DEEPSLATE = registerOreDeepslate("water_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> SOLAR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("solar_silver_ore_deepslate", 10);
    public static final RegistryObject<Block> LUNAR_SILVER_ORE_DEEPSLATE = registerOreDeepslate("lunar_silver_ore_deepslate", 10);

    public static final RegistryObject<Block> AIR_GOLD_ORE_STONE = registerOreStone("air_gold_ore_stone", 10);
    public static final RegistryObject<Block> FIRE_GOLD_ORE_STONE = registerOreStone("fire_gold_ore_stone", 10);
    public static final RegistryObject<Block> NATURE_GOLD_ORE_STONE = registerOreStone("nature_gold_ore_stone", 10);
    public static final RegistryObject<Block> WATER_GOLD_ORE_STONE = registerOreStone("water_gold_ore_stone", 10);
    public static final RegistryObject<Block> SOLAR_GOLD_ORE_STONE = registerOreStone("solar_gold_ore_stone", 10);
    public static final RegistryObject<Block> LUNAR_GOLD_ORE_STONE = registerOreStone("lunar_gold_ore_stone", 10);

    public static final RegistryObject<Block> AIR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("air_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> FIRE_GOLD_ORE_DEEPSLATE = registerOreDeepslate("fire_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> NATURE_GOLD_ORE_DEEPSLATE = registerOreDeepslate("nature_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> WATER_GOLD_ORE_DEEPSLATE = registerOreDeepslate("water_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> SOLAR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("solar_gold_ore_deepslate", 10);
    public static final RegistryObject<Block> LUNAR_GOLD_ORE_DEEPSLATE = registerOreDeepslate("lunar_gold_ore_deepslate", 10);


    public static final RegistryObject<Block> MYRINIUM_ORE_DEEPSLATE = registerBlock("myrinium_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final RegistryObject<Block> MYRINIUM_ORE_STONE = registerBlock("myrinium_ore_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));


// CRYSTALS
    public static final RegistryObject<Block> BABY_FIRE_CRYSTAL = registerBabyClusterCrystalBlock("baby_fire_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_AIR_CRYSTAL = registerBabyClusterCrystalBlock("baby_air_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_NATURE_CRYSTAL = registerBabyClusterCrystalBlock("baby_nature_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_WATER_CRYSTAL = registerBabyClusterCrystalBlock("baby_water_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_SOLAR_CRYSTAL = registerBabyClusterCrystalBlock("baby_solar_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_LUNAR_CRYSTAL = registerBabyClusterCrystalBlock("baby_lunar_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_VOID_CRYSTAL = registerBabyClusterCrystalBlock("baby_void_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_DEMONIC_CRYSTAL = registerBabyClusterCrystalBlock("baby_demonic_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_CELESTIAL_CRYSTAL = registerBabyClusterCrystalBlock("baby_celestial_crystal",2,1,5);
    public static final RegistryObject<Block> BABY_ARCANA_CRYSTAL = registerBabyClusterCrystalBlock("baby_arcana_crystal",2,1,5);

    public static final RegistryObject<Block> VERY_SMALL_FIRE_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_fire_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_AIR_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_air_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_NATURE_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_nature_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_WATER_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_water_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_SOLAR_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_solar_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_LUNAR_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_lunar_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_VOID_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_void_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_DEMONIC_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_demonic_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_CELESTIAL_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_celestial_crystal",2,2,5);
    public static final RegistryObject<Block> VERY_SMALL_ARCANA_CRYSTAL = registerVerySmallClusterCrystalBlock("very_small_arcana_crystal",2,2,5);

    public static final RegistryObject<Block> SMALL_FIRE_CRYSTAL = registerSmallClusterCrystalBlock("small_fire_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_AIR_CRYSTAL = registerSmallClusterCrystalBlock("small_air_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_NATURE_CRYSTAL = registerSmallClusterCrystalBlock("small_nature_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_WATER_CRYSTAL = registerSmallClusterCrystalBlock("small_water_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_SOLAR_CRYSTAL = registerSmallClusterCrystalBlock("small_solar_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_LUNAR_CRYSTAL = registerSmallClusterCrystalBlock("small_lunar_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_VOID_CRYSTAL = registerSmallClusterCrystalBlock("small_void_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_DEMONIC_CRYSTAL = registerSmallClusterCrystalBlock("small_demonic_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_CELESTIAL_CRYSTAL = registerSmallClusterCrystalBlock("small_celestial_crystal",4,2,5);
    public static final RegistryObject<Block> SMALL_ARCANA_CRYSTAL = registerSmallClusterCrystalBlock("small_arcana_crystal",4,2,5);

    public static final RegistryObject<Block> FIRE_CRYSTAL = registerClusterCrystalBlock("fire_crystal",6,4,5);
    public static final RegistryObject<Block> AIR_CRYSTAL = registerClusterCrystalBlock("air_crystal",6,4,5);
    public static final RegistryObject<Block> NATURE_CRYSTAL = registerClusterCrystalBlock("nature_crystal",6,4,5);
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
    public static final RegistryObject<Block> LARGE_NATURE_CRYSTAL = registerLargeClusterCrystalBlock("large_nature_crystal",4);
    public static final RegistryObject<Block> LARGE_WATER_CRYSTAL = registerLargeClusterCrystalBlock("large_water_crystal",4);
    public static final RegistryObject<Block> LARGE_SOLAR_CRYSTAL = registerLargeClusterCrystalBlock("large_solar_crystal",4);
    public static final RegistryObject<Block> LARGE_LUNAR_CRYSTAL = registerLargeClusterCrystalBlock("large_lunar_crystal",4);
    public static final RegistryObject<Block> LARGE_VOID_CRYSTAL = registerLargeClusterCrystalBlock("large_void_crystal",4);
    public static final RegistryObject<Block> LARGE_DEMONIC_CRYSTAL = registerLargeClusterCrystalBlock("large_demonic_crystal",4);
    public static final RegistryObject<Block> LARGE_CELESTIAL_CRYSTAL = registerLargeClusterCrystalBlock("large_celestial_crystal",4);


    public static final RegistryObject<Block> FIRE_CRYSTAL_BLOCK = registerCrystalBlock("fire_crystal_block",4);
    public static final RegistryObject<Block> AIR_CRYSTAL_BLOCK = registerCrystalBlock("air_crystal_block",4);
    public static final RegistryObject<Block> NATURE_CRYSTAL_BLOCK = registerCrystalBlock("nature_crystal_block",4);
    public static final RegistryObject<Block> WATER_CRYSTAL_BLOCK = registerCrystalBlock("water_crystal_block",4);
    public static final RegistryObject<Block> SOLAR_CRYSTAL_BLOCK = registerCrystalBlock("solar_crystal_block",4);
    public static final RegistryObject<Block> LUNAR_CRYSTAL_BLOCK = registerCrystalBlock("lunar_crystal_block",4);
    public static final RegistryObject<Block> VOID_CRYSTAL_BLOCK = registerCrystalBlock("void_crystal_block",4);
    public static final RegistryObject<Block> DEMONIC_CRYSTAL_BLOCK = registerCrystalBlock("demonic_crystal_block",4);
    public static final RegistryObject<Block> CELESTIAL_CRYSTAL_BLOCK = registerCrystalBlock("celestial_crystal_block",4);
    public static final RegistryObject<Block> ARCANA_CRYSTAL_BLOCK = registerCrystalBlock("arcana_crystal_block",4);

    //ESSENCE
    public static final RegistryObject<Block> ESSENCE = registerBlock("essence",
            () -> new Essence(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> FIRE_ESSENCE = registerBlock("fire_essence",
            () -> new FireEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> FIRE_ESSENCE_BOTTLE = BLOCKS.register("fire_essence_bottle",
            () -> new FireEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> WATER_ESSENCE = registerBlock("water_essence",
            () -> new WaterEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> WATER_ESSENCE_BOTTLE = BLOCKS.register("water_essence_bottle",
            () -> new WaterEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> AIR_ESSENCE = registerBlock("air_essence",
            () -> new AirEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> AIR_ESSENCE_BOTTLE = BLOCKS.register("air_essence_bottle",
            () -> new AirEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> NATURE_ESSENCE = registerBlock("nature_essence",
            () -> new NatureEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> NATURE_ESSENCE_BOTTLE = BLOCKS.register("nature_essence_bottle",
            () -> new NatureEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));

    public static final RegistryObject<Block> LUNAR_ESSENCE = registerBlock("lunar_essence",
            () -> new LunarEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> LUNAR_ESSENCE_BOTTLE = BLOCKS.register("lunar_essence_bottle",
            () -> new LunarEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SOLAR_ESSENCE = registerBlock("solar_essence",
            () -> new SolarEssence(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> SOLAR_ESSENCE_BOTTLE = BLOCKS.register("solar_essence_bottle",
            () -> new SolarEssenceBottle(BlockBehaviour.Properties.of().instabreak().noOcclusion().sound(SoundType.GLASS)));

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

    public static final RegistryObject<Block> ALCHEMY_BOOK1 = BLOCKS.register("alchemy_book1",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> ALCHEMY_BOOK2 = BLOCKS.register("alchemy_book2",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> ALCHEMY_BOOK3 = BLOCKS.register("alchemy_book3",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> BESTIARY_BOOK = BLOCKS.register("bestiary_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> FORGE_BOOK = BLOCKS.register("forge_book",
            () -> new BookBlock(BlockBehaviour.Properties.of().instabreak().noOcclusion()));

    public static final RegistryObject<Block> BOTANICA_BOOK = BLOCKS.register("botanica_book",
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
    //CIRCLE
    public static final RegistryObject<Block> FIRE_CIRCLE = BLOCKS.register("fire_circle",
            () -> new FireCircle(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    public static final RegistryObject<Block> WATER_CIRCLE = BLOCKS.register("water_circle",
            () -> new WaterCircle(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion()));

    // WOOD / TREE
    //Minecraft Wood Typs
    public static final RegistryObject<Block> OAK_ALCHEMY_SHELF_JAR = registerShelfBlock("oak_alchemy_shelf_jar");
    public static final RegistryObject<Block> OAK_ALCHEMY_SHELF_MIX = registerShelfBlock("oak_alchemy_shelf_mix");
    public static final RegistryObject<Block> DARK_OAK_ALCHEMY_SHELF_JAR = registerShelfBlock("dark_oak_alchemy_shelf_jar");
    public static final RegistryObject<Block> DARK_OAK_ALCHEMY_SHELF_MIX = registerShelfBlock("dark_oak_alchemy_shelf_mix");
    public static final RegistryObject<Block> ACACIA_ALCHEMY_SHELF_JAR = registerShelfBlock("acacia_alchemy_shelf_jar");
    public static final RegistryObject<Block> ACACIA_ALCHEMY_SHELF_MIX = registerShelfBlock("acacia_alchemy_shelf_mix");
    public static final RegistryObject<Block> JUNGLE_ALCHEMY_SHELF_JAR = registerShelfBlock("jungle_alchemy_shelf_jar");
    public static final RegistryObject<Block> JUNGLE_ALCHEMY_SHELF_MIX = registerShelfBlock("jungle_alchemy_shelf_mix");
    public static final RegistryObject<Block> CHERRY_ALCHEMY_SHELF_JAR = registerShelfBlock("cherry_alchemy_shelf_jar");
    public static final RegistryObject<Block> CHERRY_ALCHEMY_SHELF_MIX = registerShelfBlock("cherry_alchemy_shelf_mix");
    public static final RegistryObject<Block> MANGROVE_ALCHEMY_SHELF_JAR = registerShelfBlock("mangrove_alchemy_shelf_jar");
    public static final RegistryObject<Block> MANGROVE_ALCHEMY_SHELF_MIX = registerShelfBlock("mangrove_alchemy_shelf_mix");
    public static final RegistryObject<Block> BIRCH_ALCHEMY_SHELF_JAR = registerShelfBlock("birch_alchemy_shelf_jar");
    public static final RegistryObject<Block> BIRCH_ALCHEMY_SHELF_MIX = registerShelfBlock("birch_alchemy_shelf_mix");
    public static final RegistryObject<Block> CRIMSON_ALCHEMY_SHELF_JAR = registerShelfBlock("crimson_alchemy_shelf_jar");
    public static final RegistryObject<Block> CRIMSON_ALCHEMY_SHELF_MIX = registerShelfBlock("crimson_alchemy_shelf_mix");
    public static final RegistryObject<Block> SPRUCE_ALCHEMY_SHELF_JAR = registerShelfBlock("spruce_alchemy_shelf_jar");
    public static final RegistryObject<Block> SPRUCE_ALCHEMY_SHELF_MIX = registerShelfBlock("spruce_alchemy_shelf_mix");
    public static final RegistryObject<Block> WARPED_ALCHEMY_SHELF_JAR = registerShelfBlock("warped_alchemy_shelf_jar");
    public static final RegistryObject<Block> WARPED_ALCHEMY_SHELF_MIX = registerShelfBlock("warped_alchemy_shelf_mix");

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
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> SCARLET_ALCHEMY_SHELF_JAR = registerShelfBlock("scarlet_alchemy_shelf_jar");
    public static final RegistryObject<Block> SCARLET_ALCHEMY_SHELF_MIX = registerShelfBlock("scarlet_alchemy_shelf_mix");




    // Life Tree
    public static final RegistryObject<Block> BLIFE_TREE_LOG = registerBlock("blife_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BLIFE_TREE_WOOD = registerBlock("blife_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_BLIFE_TREE_LOG = registerBlock("stripped_blife_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_BLIFE_TREE_WOOD = registerBlock("stripped_blife_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> BLIFE_TREE_PLANKS = registerBlock("blife_tree_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> BLIFE_TREE_DOOR = registerBlock("blife_tree_door",
            () -> new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> BLIFE_TREE_TRAPDOOR = registerTrapDoor("blife_tree_trapdoor");
    public static final RegistryObject<Block> BLIFE_TREE_SLAB = registerSlab("blife_tree_slab");
    public static final RegistryObject<Block> BLIFE_TREE_STAIR = registerBlock("blife_tree_stair",
            () -> new StairBlock(ModBlocks.BLIFE_TREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> BLIFE_TREE_PRESSURE_PLATE = registerPressurePlate("blife_tree_pressure_plate");
    public static final RegistryObject<Block> BLIFE_TREE_BUTTON = registerButton("blife_tree_button");
    public static final RegistryObject<Block> BLIFE_TREE_FENCE = registerFence("blife_tree_fence");
    public static final RegistryObject<Block> BLIFE_TREE_FENCE_GATE = registerFenceGate("blife_tree_fence_gate");

    public static final RegistryObject<Block> RESEARCH_TABLE_BLIFE_TREE = registerBlock("research_table_blife_tree",
            () -> new ResearchTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> BLT_ALCHEMY_SHELF_JAR = registerShelfBlock("blt_alchemy_shelf_jar");
    public static final RegistryObject<Block> BLT_ALCHEMY_SHELF_MIX = registerShelfBlock("blt_alchemy_shelf_mix");

    //FIRE
    public static final RegistryObject<Block> BLIFE_TREE_FIRE_LEAVES = registerBlock("blife_tree_fire_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLT_FIRE_HLEAVES = registerBlock("blt_fire_hleaves",
            () -> new BLTFHLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noCollission()));
    public static final RegistryObject<Block> BLT_FIRE_HLEAVES_PLANT = registerBlock("blt_fire_hleaves_plant",
            () -> new BLTFHLeavesPlant(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noCollission()));
    public static final RegistryObject<Block> BLIFE_TREE_FIRE_SAPLING = registerBlock("blife_tree_fire_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIFE_TREE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BLIFE_TREE_FIRE_RESIN = registerBlock("blife_tree_fire_resin",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    //WATER
    public static final RegistryObject<Block> BLIFE_TREE_WATER_LEAVES = registerBlock("blife_tree_water_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLT_WATER_HLEAVES = registerBlock("blt_water_hleaves",
            () -> new BLTWHLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noCollission()));
    public static final RegistryObject<Block> BLT_WATER_HLEAVES_PLANT = registerBlock("blt_water_hleaves_plant",
            () -> new BLTFWLeavesPlant(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noCollission()));
    public static final RegistryObject<Block> BLIFE_TREE_WATER_RESIN = registerBlock("blife_tree_water_resin",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> LIFE_TREE_LEAVES = registerBlock("life_tree_leaves",
            () -> new ScarletLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LIFE_TREE_SAPLING = registerBlock("life_tree_sapling",
            () -> new SaplingBlock(ModTreeGrowers.LIFE_TREE,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(value -> 6)));

    //Plants
    public static final RegistryObject<Block> VOID_FLOWER = registerBlock("void_flower",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.2F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            }
    );
    public static final RegistryObject<Block> POTTED_VOID_FLOWER = BLOCKS.register("potted_void_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, VOID_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> WHITE_VOID_FLOWER = registerBlock("white_void_flower",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.2F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            }
    );
    public static final RegistryObject<Block> POTTED_WHITE_VOID_FLOWER = BLOCKS.register("potted_white_void_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_VOID_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> WHITE_BLACK_FLOWER = registerBlock("white_black_flower",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.05F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            }
    );
    public static final RegistryObject<Block> POTTED_WHITE_BLACK_FLOWER = BLOCKS.register("potted_white_black_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_BLACK_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> TALL_WHITE_BLACK_FLOWER = registerBlock("tall_white_black_flower",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.05F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            }
    );
    public static final RegistryObject<Block> POTTED_TALL_WHITE_BLACK_FLOWER = BLOCKS.register("potted_tall_white_black_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_BLACK_FLOWER,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));


    public static final RegistryObject<Block> PURE_VOID_FLOWER = registerBlock("pure_void_flower",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.2F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            });
    public static final RegistryObject<Block> POTTED_PURE_VOID_FLOWER = BLOCKS.register("potted_pure_void_flower",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), PURE_VOID_FLOWER, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> TALL_VOID_VINE = registerBlock("tall_void_vine",
            () -> new CustomVineBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.VINE).noOcclusion().noCollission()) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.2F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;
                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            });
    public static final RegistryObject<Block> VOID_VINE = registerBlock("void_vine",
            () -> new CustomVineBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.VINE).noOcclusion().noCollission()) {
                @Override
                public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
                    super.animateTick(state, level, pos, random);

                    if (random.nextFloat() < 0.2F) {
                        double radius = 1.5;
                        double angle = random.nextDouble() * Math.PI * 2;

                        double x = pos.getX() + 0.5 + Math.cos(angle) * (random.nextDouble() * radius);
                        double y = pos.getY() + 0.8 + (random.nextFloat() - 0.5) * 0.8;
                        double z = pos.getZ() + 0.5 + Math.sin(angle) * (random.nextDouble() * radius);

                        double dx = (random.nextFloat() - 0.5);
                        double dy = (random.nextFloat() - 0.5);
                        double dz = (random.nextFloat() - 0.5);

                        level.addParticle(ModParticles.VOID_PARTICLE.get(), x, y, z, dx, dy, dz);
                    }
                }
            });
    public static final RegistryObject<Block> SMALL_VOID_VINE = registerBlock("small_void_vine",
            () -> new CustomVineBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.VINE).noOcclusion().noCollission()));

    public static final RegistryObject<Block> SCARLET_FOREST_GRASS = registerBlock("scarlet_forest_grass",
            () -> new ScarletGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> SCARLET_FOREST_DIRT = registerBlock("scarlet_forest_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final RegistryObject<Block> INK_CAP = registerBlock("ink_cap",
            () -> new FlowerBlock(SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)));

    public static final RegistryObject<Block> POTTED_INK_CAP = BLOCKS.register("potted_ink_cap",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, INK_CAP,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> BROWN_TREE_MUSHROOM = registerBlock("brown_tree_mushroom",
            () -> new TreeMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)){
                public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 11, 16, 16, 16);
                public static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 5, 16, 16);
                public static final VoxelShape SHAPE_WEST = Block.box(11, 0, 0, 16, 16, 16);
                public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 5);
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    return switch (direction) {
                        case NORTH -> SHAPE_NORTH;
                        case EAST -> SHAPE_EAST;
                        case WEST -> SHAPE_WEST;
                        default -> SHAPE_SOUTH;
                    };
                }
            });

    public static final RegistryObject<Block> GLOWING_BROWN_MUSHROOM = registerBlock("glowing_brown_mushroom",
            () -> new GlowingTreeMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).lightLevel(value -> 4)){
                public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 11, 16, 16, 16);
                public static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 5, 16, 16);
                public static final VoxelShape SHAPE_WEST = Block.box(11, 0, 0, 16, 16, 16);
                public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 5);
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    return switch (direction) {
                        case NORTH -> SHAPE_NORTH;
                        case EAST -> SHAPE_EAST;
                        case WEST -> SHAPE_WEST;
                        default -> SHAPE_SOUTH;
                    };
                }
            });

    public static final RegistryObject<Block> GLOWING_DARK_BLUE_MUSHROOM = registerBlock("glowing_dark_blue_mushroom",
            () -> new GlowingTreeMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).lightLevel(value -> 4)){
                public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 11, 16, 16, 16);
                public static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 5, 16, 16);
                public static final VoxelShape SHAPE_WEST = Block.box(11, 0, 0, 16, 16, 16);
                public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 5);
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    return switch (direction) {
                        case NORTH -> SHAPE_NORTH;
                        case EAST -> SHAPE_EAST;
                        case WEST -> SHAPE_WEST;
                        default -> SHAPE_SOUTH;
                    };
                }
            });

    public static final RegistryObject<Block> GLOWING_RED_MUSHROOM = registerBlock("glowing_red_mushroom",
            () -> new GlowingTreeMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).lightLevel(value -> 4)){
                public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 11, 16, 16, 16);
                public static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 5, 16, 16);
                public static final VoxelShape SHAPE_WEST = Block.box(11, 0, 0, 16, 16, 16);
                public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 5);
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    return switch (direction) {
                        case NORTH -> SHAPE_NORTH;
                        case EAST -> SHAPE_EAST;
                        case WEST -> SHAPE_WEST;
                        default -> SHAPE_SOUTH;
                    };
                }
            });

    public static final RegistryObject<Block> GLOWING_WHITE_RED_MUSHROOM = registerBlock("glowing_white_red_mushroom",
            () -> new GlowingTreeMushroom(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).lightLevel(value -> 4)){
                public static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 11, 16, 16, 16);
                public static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 5, 16, 16);
                public static final VoxelShape SHAPE_WEST = Block.box(11, 0, 0, 16, 16, 16);
                public static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 5);
                public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
                    Direction direction = pState.getValue(FACING);
                    return switch (direction) {
                        case NORTH -> SHAPE_NORTH;
                        case EAST -> SHAPE_EAST;
                        case WEST -> SHAPE_WEST;
                        default -> SHAPE_SOUTH;
                    };
                }
            });


    public static final RegistryObject<Block> LIGHT_AIR_BLOCK = registerBlock("light_air_block",
            () -> new LightAirBlock(BlockBehaviour.Properties.of()));


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
    private static RegistryObject<Block> registerCrystalBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new CrystalBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 6)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerBabyClusterCrystalBlock(String name, float x, float y , float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new BabyCrystalClusterBlock(x,y,BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 2)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerVerySmallClusterCrystalBlock(String name, float x, float y , float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new VerySmallCrystalClusterBlock(x,y,BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 3)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerSmallClusterCrystalBlock(String name, float x, float y , float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new SmallCrystalClusterBlock(x,y,BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 4)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static RegistryObject<Block> registerClusterCrystalBlock(String name, float x, float y , float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new CrystalClusterBlock(x,y,BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 5)
                        .sound(SoundType.AMETHYST)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerLargeClusterCrystalBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new LargeCrystalBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .strength(1)
                        .noOcclusion()
                        .lightLevel(value -> 6)
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
    private static RegistryObject<Block> registerShelfBlock(String name) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ShelfDekoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }




    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}