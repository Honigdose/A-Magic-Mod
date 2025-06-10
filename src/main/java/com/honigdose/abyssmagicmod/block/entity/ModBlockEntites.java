package com.honigdose.abyssmagicmod.block.entity;

import com.honigdose.abyssmagicmod.AbyssMagicMod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.alchemy.ResearchTable.ResearchTableBlockEntity;
import com.honigdose.abyssmagicmod.block.essence.block.air.AirEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.fire.FireEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.lunar.LunarEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.natur.NatureEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.solar.SolarEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.test.EssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.block.water.WaterEssenceEntityBlock;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.lunar.LunarEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.nature.NatureEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.solar.SolarEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.nature.glowingmushroom.GlowingTreeMushroomEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AbyssMagicMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<ResearchTableBlockEntity>> RESEARCH_TABLE_BE =
            BLOCK_ENTITIES.register("research_table_be", () -> BlockEntityType.Builder.of(
                    ResearchTableBlockEntity::new,
                    ModBlocks.RESEARCH_TABLE_ACACIA.get(),
                    ModBlocks.RESEARCH_TABLE_OAK.get(),
                    ModBlocks.RESEARCH_TABLE_BIRCH.get(),
                    ModBlocks.RESEARCH_TABLE_SPRUCE.get(),
                    ModBlocks.RESEARCH_TABLE_CRIMSON.get(),
                    ModBlocks.RESEARCH_TABLE_CHERRY.get(),
                    ModBlocks.RESEARCH_TABLE_MANGROVE.get(),
                    ModBlocks.RESEARCH_TABLE_JUNGLE.get(),
                    ModBlocks.RESEARCH_TABLE_SCARLET.get(),
                    ModBlocks.RESEARCH_TABLE_WARPED.get(),
                    ModBlocks.RESEARCH_TABLE_DARK_OAK.get(),
                    ModBlocks.RESEARCH_TABLE_BLIFE_TREE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<FireEssenceBottleEntity>> FIRE_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("fire_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(FireEssenceBottleEntity::new,
                            ModBlocks.FIRE_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<WaterEssenceBottleEntity>> WATER_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("water_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(WaterEssenceBottleEntity::new,
                            ModBlocks.WATER_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<NatureEssenceBottleEntity>> NATURE_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("nature_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(NatureEssenceBottleEntity::new,
                            ModBlocks.NATURE_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<LunarEssenceBottleEntity>> LUNAR_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("lunar_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(LunarEssenceBottleEntity::new,
                            ModBlocks.LUNAR_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<SolarEssenceBottleEntity>> SOLAR_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("solar_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(SolarEssenceBottleEntity::new,
                            ModBlocks.SOLAR_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<AirEssenceBottleEntity>> AIR_ESSENCE_BOTTLE_ENTITY =
            BLOCK_ENTITIES.register("air_essence_bottle_be", () ->
                    BlockEntityType.Builder.of(AirEssenceBottleEntity::new,
                            ModBlocks.AIR_ESSENCE_BOTTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<EssenceEntityBlock>> ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("essence_be", () -> BlockEntityType.Builder.of(
                    EssenceEntityBlock::new,
                    ModBlocks.ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<FireEssenceEntityBlock>> FIRE_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fire_essence_be", () -> BlockEntityType.Builder.of(
                    FireEssenceEntityBlock::new,
                    ModBlocks.FIRE_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<AirEssenceEntityBlock>> AIR_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("air_essence_be", () -> BlockEntityType.Builder.of(
                    AirEssenceEntityBlock::new,
                    ModBlocks.AIR_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<NatureEssenceEntityBlock>> NATURE_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("natur_essence_be", () -> BlockEntityType.Builder.of(
                    NatureEssenceEntityBlock::new,
                    ModBlocks.NATURE_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<WaterEssenceEntityBlock>> WATER_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("water_essence_be", () -> BlockEntityType.Builder.of(
                    WaterEssenceEntityBlock::new,
                    ModBlocks.WATER_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<SolarEssenceEntityBlock>> SOLAR_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("solar_essence_be", () -> BlockEntityType.Builder.of(
                    SolarEssenceEntityBlock::new,
                    ModBlocks.SOLAR_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<LunarEssenceEntityBlock>> LUNAR_ESSENCE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("lunar_essence_be", () -> BlockEntityType.Builder.of(
                    LunarEssenceEntityBlock::new,
                    ModBlocks.LUNAR_ESSENCE.get()
            ).build(null));

    public static final RegistryObject<BlockEntityType<GlowingTreeMushroomEntityBlock>> GLOWING_TREE_MUSHROOM_ENTITY =
            BLOCK_ENTITIES.register("glowing_mushroom_be", () -> BlockEntityType.Builder.of(
                    GlowingTreeMushroomEntityBlock::new,
                    ModBlocks.GLOWING_BROWN_MUSHROOM.get(),
                    ModBlocks.GLOWING_DARK_BLUE_MUSHROOM.get(),
                    ModBlocks.GLOWING_RED_MUSHROOM.get(),
                    ModBlocks.GLOWING_WHITE_RED_MUSHROOM.get()
            ).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
