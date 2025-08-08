package com.honigdose.abyssmagicmod.worldgen.biome;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.worldgen.biome.region.NetherRegion;
import com.honigdose.abyssmagicmod.worldgen.biome.region.OverworldRegion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.EndBiomeRegistry;
import terrablender.api.Regions;


public class ModBiomes {
    public static final ResourceKey<Biome> SCARLET_FOREST = registerBiomeKey("scarlet_forest");
    public static final ResourceKey<Biome> GLOWSTONE_PLAIN = registerBiomeKey("glowstone_plain");
    public static final ResourceKey<Biome> END_ROT = registerBiomeKey("end_rot");

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "scarlet_forest"), 20));
        Regions.register(new NetherRegion(ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "abyssmagicmod_nether"), 20));

        EndBiomeRegistry.registerHighlandsBiome(END_ROT, 20);
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        var carver = context.lookup(Registries.CONFIGURED_CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, SCARLET_FOREST, ModOverworldBiomes.scarletforest(placedFeatures, carver));

        register(context, GLOWSTONE_PLAIN, ModNetherBiomes.glowstonePlains(placedFeatures, carver));
        register(context, END_ROT, ModEndBiomes.endRot(placedFeatures, carver));
    }


    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static ResourceKey<Biome> registerBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
    }
}
