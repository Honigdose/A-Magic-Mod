package com.honigdose.abyssmagicmod.block;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AbyssMagicMod.MOD_ID);


    public static final RegistryObject<Block> ABYSSSTEEL_ORE = registerBlock("abysssteel_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,2), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FIRERYTE_ORE = registerBlock("fireryte_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SOLARIUM_ORE = registerBlock("solarium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().lightLevel(value -> 8)));
    public static final RegistryObject<Block> LUNARIUM_ORE = registerBlock("lunarium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUIRYTE_ORE = registerBlock("suiryte_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FLORASTEEL_ORE = registerBlock("florasteel_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SYLPHTHYL_ORE = registerBlock("sylphthyl_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FIRERYTE_RAW_BLOCK = registerBlock("fireryte_raw_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FIRERYTE_BLOCK = registerBlock("fireryte_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUIRYTE_BLOCK = registerBlock("suiryte_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE = registerBlock("magessenz_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_FIRETYP = registerBlock("magessenz_ore_deepslate_firetyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_SOLARTYP = registerBlock("magessenz_ore_deepslate_solartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_LUNARIUM = registerBlock("magessenz_ore_deepslate_lunartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_WATERTYP = registerBlock("magessenz_ore_deepslate_watertyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_NATURTYP = registerBlock("magessenz_ore_deepslate_naturtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_AIRTYP = registerBlock("magessenz_ore_deepslate_airtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE = registerBlock("magessenz_ore_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_FIRETYP = registerBlock("magessenz_ore_stone_firetyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_SOLARTYP = registerBlock("magessenz_ore_stone_solartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_LUNARIUM = registerBlock("magessenz_ore_stone_lunartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_WATERTYP = registerBlock("magessenz_ore_stone_watertyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_NATURTYP = registerBlock("magessenz_ore_stone_naturtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_AIRTYP = registerBlock("magessenz_ore_stone_airtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MYRINIUM_ORE_DEEPSLATE = registerBlock("myrinium_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MYRINIUM_ORE_STONE = registerBlock("myrinium_ore_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> FIRE_CRYSTAL = registerBlock("fire_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> FIRE_CRYSTAL_BLOCK = registerBlock("fire_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> AIR_CRYSTAL = registerBlock("air_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> AIR_CRYSTAL_BLOCK = registerBlock("air_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> NATUR_CRYSTAL = registerBlock("natur_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> NATUR_CRYSTAL_BLOCK = registerBlock("natur_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> WATER_CRYSTAL = registerBlock("water_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> WATER_CRYSTAL_BLOCK = registerBlock("water_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> SOLAR_CRYSTAL = registerBlock("solar_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> SOLAR_CRYSTAL_BLOCK = registerBlock("solar_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> LUNAR_CRYSTAL = registerBlock("lunar_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> LUNAR_CRYSTAL_BLOCK = registerBlock("lunar_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> VOID_CRYSTAL = registerBlock("void_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> VOID_CRYSTAL_BLOCK = registerBlock("void_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> DEMONIC_CRYSTAL = registerBlock("demonic_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> DEMONIC_CRYSTAL_BLOCK = registerBlock("demonic_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> CELESTIAL_CRYSTAL = registerBlock("celestial_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> CELESTIAL_CRYSTAL_BLOCK = registerBlock("celestial_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));

    public static final RegistryObject<Block> ARCANA_CRYSTAL = registerBlock("arcana_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 6).noOcclusion()));
    public static final RegistryObject<Block> ARCANA_CRYSTAL_BLOCK = registerBlock("arcana_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST).lightLevel(value -> 8).noOcclusion()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
