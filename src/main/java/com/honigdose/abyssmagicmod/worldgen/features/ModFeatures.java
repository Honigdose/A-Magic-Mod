package com.honigdose.abyssmagicmod.worldgen.features;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, AbyssMagicMod.MOD_ID);

    public static final RegistryObject<Feature<NbtStructureFeatureConfiguration>> NBT_STRUCTURE_FEATURE =
            FEATURES.register("nbt_structure", NbtStructureFeature::new);

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
