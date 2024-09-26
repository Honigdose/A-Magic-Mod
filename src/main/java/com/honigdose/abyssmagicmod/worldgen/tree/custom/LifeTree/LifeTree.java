package com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.worldgen.ModConfiguredFeatures;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletFoliagePlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTrunkPlacer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class LifeTree {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LIFE_TREE_KEY = ModConfiguredFeatures.registerKey("life_tree");

    public static void registerTree(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, LIFE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.LIFE_TREE_LOG.get()),
                        new LifeTreeTrunkPlacer(20, 0, 0),
                        BlockStateProvider.simple(ModBlocks.LIFE_TREE_LEAVES.get()),
                        new ScarletFoliagePlacer(ConstantInt.of(6), ConstantInt.of(4)),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).build()
        );
    }
}
