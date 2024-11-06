package com.honigdose.abyssmagicmod.block;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.custom.customblockclass.ModFlammableRotatedPillarBlock;
import com.honigdose.abyssmagicmod.block.custom.customblockclass.ModFlammableWoodBlock;
import com.honigdose.abyssmagicmod.block.custom.customblockclass.ModRotatedBlock;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public static final RegistryObject<Block> SILVER_ORE_DEEPSLATE = registerOreStone("silver_ore_deepslate", 10);

    public static final RegistryObject<Block> MYRINIUM_ORE_DEEPSLATE = registerBlock("myrinium_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final RegistryObject<Block> MYRINIUM_ORE_STONE = registerBlock("myrinium_ore_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));


// CRYSTALS
    public static final RegistryObject<Block> FIRE_CRYSTAL = registerBlock("fire_crystal",
            () -> new AmethystClusterBlock(6,4,(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).lightLevel(value -> 12).noOcclusion())));
    public static final RegistryObject<Block> FIRE_CRYSTAL_BLOCK = registerBlock("fire_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> AIR_CRYSTAL = registerBlock("air_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> AIR_CRYSTAL_BLOCK = registerBlock("air_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> NATUR_CRYSTAL = registerBlock("natur_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> NATUR_CRYSTAL_BLOCK = registerBlock("natur_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> WATER_CRYSTAL = registerBlock("water_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> WATER_CRYSTAL_BLOCK = registerBlock("water_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> SOLAR_CRYSTAL = registerBlock("solar_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> SOLAR_CRYSTAL_BLOCK = registerBlock("solar_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> LUNAR_CRYSTAL = registerBlock("lunar_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> LUNAR_CRYSTAL_BLOCK = registerBlock("lunar_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> VOID_CRYSTAL = registerBlock("void_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> VOID_CRYSTAL_BLOCK = registerBlock("void_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> DEMONIC_CRYSTAL = registerBlock("demonic_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> DEMONIC_CRYSTAL_BLOCK = registerBlock("demonic_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> CELESTIAL_CRYSTAL = registerBlock("celestial_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> CELESTIAL_CRYSTAL_BLOCK = registerBlock("celestial_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    public static final RegistryObject<Block> ARCANA_CRYSTAL = registerBlock("arcana_crystal",
            () -> new AmethystClusterBlock(6,4,BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));
    public static final RegistryObject<Block> ARCANA_CRYSTAL_BLOCK = registerBlock("arcana_crystal_block",
            () -> new TintedGlassBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.AMETHYST).lightLevel(value -> 12).noOcclusion()));

    // WOOD / TREE
    // Scarlet Tree
    public static final RegistryObject<Block> SCARLET_TREE_LOG = registerBlock("scarlet_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> SCARLET_TREE_WOOD = registerBlock("scarlet_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_SCARLET_TREE_LOG = registerBlock("stripped_scarlet_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_SCARLET_TREE_WOOD = registerBlock("stripped_scarlet_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SCARLET_TREE_LEAVES = registerBlock("scarlet_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> SCARLET_TREE_SAPLING = registerBlock("scarlet_tree_sapling",
            () -> new SaplingBlock(ModTreeGrowers.SCARLET,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> SCARLET_TREE_PLANKS = registerBlock("scarlet_tree_planks",
            () -> new ModFlammableWoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SCARLET_TREE_SLAB = registerBlock("scarlet_tree_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));


    public static final RegistryObject<Block> SCARLET_TREE_STAIR = registerBlock("scarlet_tree_stair",
            () -> new StairBlock(ModBlocks.SCARLET_TREE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> SCARLET_TREE_PRESSURE_PLATE = registerBlock("scarlet_tree_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> SCARLET_TREE_BUTTON = registerBlock("scarlet_tree_button",
            () -> new ButtonBlock(BlockSetType.OAK, 15, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> SCARLET_TREE_FENCE = registerBlock("scarlet_tree_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> SCARLET_TREE_FENCE_GATE = registerBlock("scarlet_tree_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryObject<Block> SCARLET_TREE_WALL = registerBlock("scarlet_tree_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> SCARLET_TREE_DOOR = registerBlock("scarlet_tree_door",
            () -> new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> SCARLET_TREE_TRAPDOOR = registerBlock("scarlet_tree_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

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

    private static RegistryObject<Block> registerIngotBlock(String name, float strength) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, () ->
                new ModRotatedBlock(BlockBehaviour.Properties.of().strength(strength)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.COPPER)));

        registerBlockItem(name, toReturn);
        return toReturn;
    }





    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}