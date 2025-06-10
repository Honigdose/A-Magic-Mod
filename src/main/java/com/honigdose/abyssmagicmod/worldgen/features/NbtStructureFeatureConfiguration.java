package com.honigdose.abyssmagicmod.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NbtStructureFeatureConfiguration implements FeatureConfiguration {

    public static final Codec<NbtStructureFeatureConfiguration> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("structure").forGetter(cfg -> cfg.structure)
            ).apply(instance, NbtStructureFeatureConfiguration::new));

    public final ResourceLocation structure;

    public NbtStructureFeatureConfiguration(ResourceLocation structure) {
        this.structure = structure;
    }
}
