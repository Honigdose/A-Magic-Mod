package com.honigdose.abyssmagicmod.worldgen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TREE_SCARLET = registerKey("add_tree_scarlet");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // context.register(ADD_TREE_SCARLET, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
        //        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SCARLET_PLACED_KEY)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));



    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
    }
}
