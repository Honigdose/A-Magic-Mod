package com.honigdose.abyssmagicmod.worldgen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree.LifeTree;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;


public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCARLET_KEY = registerKey("scarlet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIFE_TREE_KEY = registerKey("life_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        ScarletTree.registerTree(context);
        LifeTree.registerTree(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

