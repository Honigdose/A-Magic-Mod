package com.honigdose.abyssmagicmod.datagen.loot;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.ALCHEMY_BOOK.get());
        dropSelf(ModBlocks.BESTIARY_BOOK.get());
        dropSelf(ModBlocks.FORGE_BOOK.get());
        dropSelf(ModBlocks.BOTANICUM_BOOK.get());

        dropSelf(ModBlocks.MORTAR_AND_PESTLE.get());
        dropSelf(ModBlocks.INK_BOTTLE.get());
        dropSelf(ModBlocks.EMPTY_INK_BOTTLE.get());

        dropSelf(ModBlocks.FIRERYTE_BLOCK.get());
        dropSelf(ModBlocks.SUIRYTE_BLOCK.get());
        dropSelf(ModBlocks.FLORASTEEL_BLOCK.get());
        dropSelf(ModBlocks.SYLPHTHYL_BLOCK.get());
        dropSelf(ModBlocks.SOLARIUM_BLOCK.get());
        dropSelf(ModBlocks.LUNARIUM_BLOCK.get());
        dropSelf(ModBlocks.ABYSSSTEEL_BLOCK.get());
        dropSelf(ModBlocks.ASTRATHYL_BLOCK.get());
        dropSelf(ModBlocks.CELESTIUM_BLOCK.get());
        dropSelf(ModBlocks.BLOODGOLD_BLOCK.get());

        dropSelf(ModBlocks.MAGIC_ROUND_BOTTLE.get());
        dropSelf(ModBlocks.MAGIC_TRIANGLE_BOTTLE.get());
        dropSelf(ModBlocks.MAGIC_SQUARE_BOTTLE.get());

        dropSelf(ModBlocks.RESEARCH_TABLE_OAK.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_WARPED.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_JUNGLE.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_BIRCH.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_DARK_OAK.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_MANGROVE.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_CHERRY.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_ACACIA.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_SPRUCE.get());
        dropSelf(ModBlocks.RESEARCH_TABLE_CRIMSON.get());

        dropSelf(ModBlocks.OAK_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.OAK_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.BIRCH_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.BIRCH_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.DARK_OAK_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.DARK_OAK_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.JUNGLE_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.JUNGLE_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.CRIMSON_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.CRIMSON_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.SPRUCE_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.SPRUCE_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.WARPED_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.WARPED_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.MANGROVE_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.MANGROVE_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.CHERRY_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.CHERRY_ALCHEMY_SHELF_MIX.get());
        dropSelf(ModBlocks.ACACIA_ALCHEMY_SHELF_JAR.get());
        dropSelf(ModBlocks.ACACIA_ALCHEMY_SHELF_MIX.get());


        this.add(ModBlocks.FIRE_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.FIRE_CRYSTAL_BLOCK.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.WATER_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.WATER_CRYSTAL_BLOCK.get(), ModItems.WATER_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.AIR_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.AIR_CRYSTAL_BLOCK.get(), ModItems.AIR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.NATUR_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.NATUR_CRYSTAL_BLOCK.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.SOLAR_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.SOLAR_CRYSTAL_BLOCK.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LUNAR_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.LUNAR_CRYSTAL_BLOCK.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.VOID_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.VOID_CRYSTAL_BLOCK.get(), ModItems.VOID_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.ARCANA_CRYSTAL_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.ARCANA_CRYSTAL_BLOCK.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),1,4));

        this.add(ModBlocks.BABY_FIRE_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_FIRE_CRYSTAL.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_WATER_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_WATER_CRYSTAL.get(), ModItems.WATER_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_AIR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_AIR_CRYSTAL.get(), ModItems.AIR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_NATUR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_NATUR_CRYSTAL.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_SOLAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_SOLAR_CRYSTAL.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_LUNAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_LUNAR_CRYSTAL.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_VOID_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_VOID_CRYSTAL.get(), ModItems.VOID_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_CELESTIAL_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_CELESTIAL_CRYSTAL.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_DEMONIC_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_DEMONIC_CRYSTAL.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.BABY_ARCANA_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.BABY_ARCANA_CRYSTAL.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),0,1));

        this.add(ModBlocks.VERY_SMALL_FIRE_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_FIRE_CRYSTAL.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get(), ModItems.WATER_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_AIR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_AIR_CRYSTAL.get(), ModItems.AIR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_NATUR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_NATUR_CRYSTAL.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_VOID_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_VOID_CRYSTAL.get(), ModItems.VOID_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),0,1));
        this.add(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),0,1));

        this.add(ModBlocks.SMALL_FIRE_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_FIRE_CRYSTAL.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_WATER_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_WATER_CRYSTAL.get(), ModItems.WATER_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_AIR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_AIR_CRYSTAL.get(), ModItems.AIR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_NATUR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_NATUR_CRYSTAL.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_SOLAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_SOLAR_CRYSTAL.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_LUNAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_LUNAR_CRYSTAL.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_VOID_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_VOID_CRYSTAL.get(), ModItems.VOID_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_DEMONIC_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_DEMONIC_CRYSTAL.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SMALL_ARCANA_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SMALL_ARCANA_CRYSTAL.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),1,2));

        this.add(ModBlocks.FIRE_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.FIRE_CRYSTAL.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.WATER_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.WATER_CRYSTAL.get(), ModItems.WATER_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.AIR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.AIR_CRYSTAL.get(), ModItems.AIR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.NATUR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.NATUR_CRYSTAL.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.SOLAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.SOLAR_CRYSTAL.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.LUNAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LUNAR_CRYSTAL.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.VOID_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.VOID_CRYSTAL.get(), ModItems.VOID_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.CELESTIAL_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.CELESTIAL_CRYSTAL.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.DEMONIC_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.DEMONIC_CRYSTAL.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),1,2));
        this.add(ModBlocks.ARCANA_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.ARCANA_CRYSTAL.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),1,2));

        this.add(ModBlocks.LARGE_FIRE_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_FIRE_CRYSTAL.get(), ModItems.FIRE_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_WATER_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_WATER_CRYSTAL.get(), ModItems.WATER_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_AIR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_AIR_CRYSTAL.get(), ModItems.AIR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_NATUR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_NATUR_CRYSTAL.get(), ModItems.NATUR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_SOLAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_SOLAR_CRYSTAL.get(), ModItems.SOLAR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_LUNAR_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_LUNAR_CRYSTAL.get(), ModItems.LUNAR_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_VOID_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_VOID_CRYSTAL.get(), ModItems.VOID_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get(), ModItems.CELESTIAL_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_DEMONIC_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_DEMONIC_CRYSTAL.get(), ModItems.DEMONIC_CRYSTAL_SHARD.get(),1,4));
        this.add(ModBlocks.LARGE_ARCANA_CRYSTAL.get(),
                block -> createMultipleOreDrops(ModBlocks.LARGE_ARCANA_CRYSTAL.get(), ModItems.ARCANA_CRYSTAL_SHARD.get(),1,4));

        this.add(ModBlocks.ABYSSSTEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.ABYSSSTEEL_ORE.get(), ModItems.RAW_ABYSSSTEEL.get()));
        this.add(ModBlocks.FIRERYTE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.FIRERYTE_ORE.get(), ModItems.RAW_FIRERYTE.get(), 1,3));
        this.add(ModBlocks.LUNARIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.LUNARIUM_ORE.get(), ModItems.RAW_LUNARIUM.get(), 1,3));
        this.add(ModBlocks.SOLARIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SOLARIUM_ORE.get(), ModItems.RAW_SOLARIUM.get(), 1,3));
        this.add(ModBlocks.SUIRYTE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SUIRYTE_ORE.get(), ModItems.RAW_SUIRYTE.get(), 1,3));
        this.add(ModBlocks.SYLPHTHYL_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SYLPHTHYL_ORE.get(), ModItems.RAW_SYLPHTHYL.get(), 1,3));
        this.add(ModBlocks.FLORASTEEL_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.FLORASTEEL_ORE.get(), ModItems.RAW_FLORASTEEl.get(), 1,3));

        this.add(ModBlocks.FIRERYTE_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.FIRERYTE_ORE_STONE.get(), ModItems.RAW_FIRERYTE.get(), 1,3));
        this.add(ModBlocks.LUNARIUM_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.LUNARIUM_ORE_STONE.get(), ModItems.RAW_LUNARIUM.get(), 1,3));
        this.add(ModBlocks.SOLARIUM_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.SOLARIUM_ORE_STONE.get(), ModItems.RAW_SOLARIUM.get(), 1,3));
        this.add(ModBlocks.SUIRYTE_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.SUIRYTE_ORE_STONE.get(), ModItems.RAW_SUIRYTE.get(), 1,3));
        this.add(ModBlocks.SYLPHTHYL_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.SYLPHTHYL_ORE_STONE.get(), ModItems.RAW_SYLPHTHYL.get(), 1,3));
        this.add(ModBlocks.FLORASTEEL_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.FLORASTEEL_ORE_STONE.get(), ModItems.RAW_FLORASTEEl.get(), 1,3));

        this.add(ModBlocks.SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE_STONE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.FIRE_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.FIRE_SILVER_ORE_STONE.get(), ModItems.RAW_FIRE_SILVER.get()));
        this.add(ModBlocks.WATER_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.WATER_SILVER_ORE_STONE.get(), ModItems.RAW_WATER_SILVER.get()));
        this.add(ModBlocks.NATUR_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.NATUR_SILVER_ORE_STONE.get(), ModItems.RAW_NATUR_SILVER.get()));
        this.add(ModBlocks.AIR_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.AIR_SILVER_ORE_STONE.get(), ModItems.RAW_AIR_SILVER.get()));
        this.add(ModBlocks.SOLAR_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.SOLAR_SILVER_ORE_STONE.get(), ModItems.RAW_SOLAR_SILVER.get()));
        this.add(ModBlocks.LUNAR_SILVER_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.LUNAR_SILVER_ORE_STONE.get(), ModItems.RAW_LUNAR_SILVER.get()));

        this.add(ModBlocks.SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_FIRE_SILVER.get()));
        this.add(ModBlocks.WATER_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.WATER_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_WATER_SILVER.get()));
        this.add(ModBlocks.NATUR_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.NATUR_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_NATUR_SILVER.get()));
        this.add(ModBlocks.AIR_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.AIR_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_AIR_SILVER.get()));
        this.add(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_SOLAR_SILVER.get()));
        this.add(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE.get(), ModItems.RAW_LUNAR_SILVER.get()));

        this.add(ModBlocks.FIRE_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.FIRE_GOLD_ORE_STONE.get(), ModItems.RAW_FIRE_GOLD.get()));
        this.add(ModBlocks.WATER_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.WATER_GOLD_ORE_STONE.get(), ModItems.RAW_WATER_GOLD.get()));
        this.add(ModBlocks.NATUR_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.NATUR_GOLD_ORE_STONE.get(), ModItems.RAW_NATUR_GOLD.get()));
        this.add(ModBlocks.AIR_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.AIR_GOLD_ORE_STONE.get(), ModItems.RAW_AIR_GOLD.get()));
        this.add(ModBlocks.SOLAR_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.SOLAR_GOLD_ORE_STONE.get(), ModItems.RAW_SOLAR_GOLD.get()));
        this.add(ModBlocks.LUNAR_GOLD_ORE_STONE.get(),
                block -> createOreDrop(ModBlocks.LUNAR_GOLD_ORE_STONE.get(), ModItems.RAW_LUNAR_GOLD.get()));

        this.add(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_FIRE_GOLD.get()));
        this.add(ModBlocks.WATER_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.WATER_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_WATER_GOLD.get()));
        this.add(ModBlocks.NATUR_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.NATUR_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_NATUR_GOLD.get()));
        this.add(ModBlocks.AIR_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.AIR_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_AIR_GOLD.get()));
        this.add(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_SOLAR_GOLD.get()));
        this.add(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE.get(),
                block -> createOreDrop(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE.get(), ModItems.RAW_LUNAR_GOLD.get()));


        this.add(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get(),
                block -> createMultipleOreDrops(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get(), ModItems.RAW_MYRINIUM.get(), 1,5));
        this.add(ModBlocks.MYRINIUM_ORE_STONE.get(),
                block -> createMultipleOreDrops(ModBlocks.MYRINIUM_ORE_STONE.get(), ModItems.RAW_MYRINIUM.get(), 1,5));

        // WOOD
        // Scarlet Tree
        this.dropSelf(ModBlocks.SCARLET_TREE_LOG.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get());
        this.add(ModBlocks.SCARLET_TREE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.SCARLET_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.SCARLET_TREE_PLANKS.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_STAIR.get());
        this.add(ModBlocks.SCARLET_TREE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SCARLET_TREE_SLAB.get()));
        this.dropSelf(ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_BUTTON.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_FENCE.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_WALL.get());
        this.dropSelf(ModBlocks.SCARLET_TREE_TRAPDOOR.get());
        this.add(ModBlocks.SCARLET_TREE_DOOR.get(),
                block -> createDoorTable(ModBlocks.SCARLET_TREE_DOOR.get()));
        this.dropSelf(ModBlocks.SCARLET_ALCHEMY_SHELF_JAR.get());
        this.dropSelf(ModBlocks.SCARLET_ALCHEMY_SHELF_MIX.get());
        this.dropSelf(ModBlocks.RESEARCH_TABLE_SCARLET.get());

        // Life Tree
        this.dropSelf(ModBlocks.LIFE_TREE_LOG.get());
        this.dropSelf(ModBlocks.LIFE_TREE_SAPLING.get());
        this.dropSelf(ModBlocks.STRIPPED_LIFE_TREE_LOG.get());
        this.dropSelf(ModBlocks.LIFE_TREE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LIFE_TREE_WOOD.get());
        this.add(ModBlocks.LIFE_TREE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.LIFE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.LIFE_TREE_PLANKS.get());
        // FIRETYP
        this.add(ModBlocks.LIFE_TREE_FIRETYP_DOOR.get(),
                block -> createDoorTable(ModBlocks.LIFE_TREE_FIRETYP_DOOR.get()));



    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
