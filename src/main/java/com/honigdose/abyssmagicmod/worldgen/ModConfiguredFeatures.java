package com.honigdose.abyssmagicmod.worldgen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.worldgen.features.ModFeatures;
import com.honigdose.abyssmagicmod.worldgen.features.NbtStructureFeatureConfiguration;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree.LifeTree;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

import java.util.List;
import java.util.Optional;


public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_KEY = registerKey("scarlet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIFE_TREE_KEY = registerKey("life_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_FLOWER_KEY = registerKey("void_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_VOID_FLOWER_KEY = registerKey("white_void_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BLACK_FLOWER_KEY = registerKey("white_black_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_WHITE_BLACK_FLOWER_KEY = registerKey("tall_white_black_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_VINE_KEY = registerKey("void_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_VOID_VINE_KEY = registerKey("small_void_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_VOID_VINE_KEY = registerKey("tall_void_vine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INK_CAP_KEY = registerKey("ink_cap");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_KEY = registerKey("boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_BOULDER_KEY = registerKey("small_boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_BOULDER_KEY = registerKey("scarlet_boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_SMALL_BOULDER_KEY = registerKey("scarlet_small_boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_MUD_BOULDER_KEY = registerKey("scarlet_mud_boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_SMALL_MUD_BOULDER_KEY = registerKey("scarlet_mud_small_boulder");



    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        ScarletTree.registerTree(context);
        LifeTree.registerTree(context);

        register(context, INK_CAP_KEY, Feature.FLOWER, new RandomPatchConfiguration(40, 4, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.INK_CAP.get())))));

        register(context, VOID_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(75, 7, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VOID_FLOWER.get())))));

        register(context, WHITE_VOID_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(25, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_VOID_FLOWER.get())))));

        register(context, WHITE_BLACK_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(100, 10, 8, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WHITE_BLACK_FLOWER.get())))));
        register(context, TALL_WHITE_BLACK_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(75, 10, 8, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TALL_WHITE_BLACK_FLOWER.get())))));

        register(context, VOID_VINE_KEY, Feature.FLOWER, new RandomPatchConfiguration(50, 12, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VOID_VINE.get())))));

        register(context, SMALL_VOID_VINE_KEY, Feature.FLOWER, new RandomPatchConfiguration(75, 12, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SMALL_VOID_VINE.get())))));

        register(context, TALL_VOID_VINE_KEY, Feature.FLOWER, new RandomPatchConfiguration(5, 1, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TALL_VOID_VINE.get())))));

        register(context, BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "boulder")));
        register(context, SMALL_BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "small_boulder")));

        register(context, SCARLET_BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "scarlet_boulder")));
        register(context, SCARLET_SMALL_BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "scarlet_small_boulder")));
        register(context, SCARLET_MUD_BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "scarlet_mud_boulder")));
        register(context, SCARLET_SMALL_MUD_BOULDER_KEY, ModFeatures.NBT_STRUCTURE_FEATURE.get(),
                new NbtStructureFeatureConfiguration( ResourceLocation.fromNamespaceAndPath("abyssmagicmod", "scarlet_mud_small_boulder")));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

