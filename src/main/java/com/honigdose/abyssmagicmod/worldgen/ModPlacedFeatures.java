package com.honigdose.abyssmagicmod.worldgen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SCARLET_PLACED_KEY = registerKey("scarlet_placed");
    public static final ResourceKey<PlacedFeature> LIFE_PLACED_KEY = registerKey("life_tree_placed");
    public static final ResourceKey<PlacedFeature> VOID_FLOWER_PLACED_KEY = registerKey("void_flower_placed");
    public static final ResourceKey<PlacedFeature> WHITE_VOID_FLOWER_PLACED_KEY = registerKey("white_void_flower_placed");
    public static final ResourceKey<PlacedFeature> WHITE_BLACK_FLOWER_PLACED_KEY = registerKey("white_black_flower_placed");
    public static final ResourceKey<PlacedFeature> TALL_WHITE_BLACK_FLOWER_PLACED_KEY = registerKey("tall_white_black_flower_placed");
    public static final ResourceKey<PlacedFeature> VOID_VINE_PLACED_KEY = registerKey("void_vine_placed");
    public static final ResourceKey<PlacedFeature> SMALL_VOID_VINE_PLACED_KEY = registerKey("small_void_vine_placed");
    public static final ResourceKey<PlacedFeature> TALL_VOID_VINE_PLACED_KEY = registerKey("tall_void_vine_placed");
    public static final ResourceKey<PlacedFeature> INK_CAP_PLACED_KEY = registerKey("ink_cap_placed");

    public static final ResourceKey<PlacedFeature> BOULDER_PLACED_KEY = registerKey("boulder_placed");
    public static final ResourceKey<PlacedFeature> SMALL_BOULDER_PLACED_KEY = registerKey("small_boulder_placed");
    public static final ResourceKey<PlacedFeature> SCARLET_BOULDER_PLACED_KEY = registerKey("scarlet_boulder_placed");
    public static final ResourceKey<PlacedFeature> SCARLET_SMALL_BOULDER_PLACED_KEY = registerKey("scarlet_small_boulder_placed");
    public static final ResourceKey<PlacedFeature> SCARLET_MUD_BOULDER_PLACED_KEY = registerKey("scarlet_mud_boulder_placed");
    public static final ResourceKey<PlacedFeature> SCARLET_SMALL_MUD_BOULDER_PLACED_KEY = registerKey("scarlet_small_mud_boulder_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SCARLET_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCARLET_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.SCARLET_TREE_SAPLING.get()));

        register(context, LIFE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIFE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2),
                        ModBlocks.LIFE_TREE_SAPLING.get()));

        register(context, INK_CAP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INK_CAP_KEY),
                List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, VOID_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VOID_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, WHITE_VOID_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WHITE_VOID_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, WHITE_BLACK_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WHITE_BLACK_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, TALL_WHITE_BLACK_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TALL_WHITE_BLACK_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, VOID_VINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VOID_VINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, SMALL_VOID_VINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_VOID_VINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, TALL_VOID_VINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TALL_VOID_VINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(30), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );
        register(context, SMALL_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );
        register(context, SCARLET_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCARLET_BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );
        register(context, SCARLET_SMALL_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCARLET_SMALL_BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );
        register(context, SCARLET_MUD_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCARLET_MUD_BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );
        register(context, SCARLET_SMALL_MUD_BOULDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCARLET_SMALL_MUD_BOULDER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()
                )
        );


    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
