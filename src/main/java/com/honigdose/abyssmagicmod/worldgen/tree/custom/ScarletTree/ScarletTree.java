package com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree;


import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.worldgen.ModConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;


public class ScarletTree {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_KEY = ModConfiguredFeatures.registerKey("scarlet");

    public static void registerTree(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, SCARLET_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.SCARLET_TREE_LOG.get()),
                        new ScarletTrunkPlacer(10, 0, 0),
                        BlockStateProvider.simple(ModBlocks.SCARLET_TREE_LEAVES.get()),
                        new ScarletFoliagePlacer(ConstantInt.of(6), ConstantInt.of(4)),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(List.of(new ScarletTreeDecorator()))
                        .build()

        );
    }
}
