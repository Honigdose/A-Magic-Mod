package com.honigdose.abyssmagicmod.worldgen.biome.region;

import com.mojang.datafixers.util.Pair;
import com.honigdose.abyssmagicmod.worldgen.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class OverworldRegion extends Region {
    public OverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL)
                .humidity(Humidity.ARID, Humidity.DRY)
                .continentalness(Continentalness.span(Continentalness.MID_INLAND, Continentalness.INLAND))
                .erosion(Erosion.EROSION_5)
                .depth(Depth.SURFACE)
                .weirdness(Weirdness.HIGH_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, ModBiomes.SCARLET_FOREST));

        builder.build().forEach(mapper);
    }


}