package com.honigdose.abyssmagicmod.particle;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AbyssMagicMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> MAGIC_PARTICLE = PARTICLES
            .register("magic_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> MAGIC_PARTICLE2 = PARTICLES
            .register("magic_particle2", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> VOID_PARTICLE = PARTICLES
            .register("void_particles", () -> new SimpleParticleType(true));


    public static final RegistryObject<SimpleParticleType> SCARLET_LEAVES_PARTICLE = PARTICLES
            .register("scarlet_leaves_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ESSENCE_PARTICLE = PARTICLES
            .register("essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> FIRE_ESSENCE_PARTICLE = PARTICLES
            .register("fire_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> AIR_ESSENCE_PARTICLE = PARTICLES
            .register("air_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NATURE_ESSENCE_PARTICLE = PARTICLES
            .register("nature_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> WATER_ESSENCE_PARTICLE = PARTICLES
            .register("water_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOLAR_ESSENCE_PARTICLE = PARTICLES
            .register("solar_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LUNAR_ESSENCE_PARTICLE = PARTICLES
            .register("lunar_essence_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> BOTTLE_ESSENCE_PARTICLE = PARTICLES
            .register("bottle_essence_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> FIRE_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("fire_essence_bottle_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> WATER_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("water_essence_bottle_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NATURE_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("nature_essence_bottle_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LUNAR_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("lunar_essence_bottle_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOLAR_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("solar_essence_bottle_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> AIR_ESSENCE_BOTTLE_PARTICLE = PARTICLES
            .register("air_essence_bottle_particle", () -> new SimpleParticleType(true));



    public static final RegistryObject<SimpleParticleType> CUTE_CRYSTAL_PARTICLE = PARTICLES
            .register("cute_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ARCANA_CRYSTAL_PARTICLE = PARTICLES
            .register("arcana_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> VOID_CRYSTAL_PARTICLE = PARTICLES
            .register("void_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LUNAR_CRYSTAL_PARTICLE = PARTICLES
            .register("lunar_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> FIRE_CRYSTAL_PARTICLE = PARTICLES
            .register("fire_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> WATER_CRYSTAL_PARTICLE = PARTICLES
            .register("water_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> NATUR_CRYSTAL_PARTICLE = PARTICLES
            .register("natur_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> AIR_CRYSTAL_PARTICLE = PARTICLES
            .register("air_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SOLAR_CRYSTAL_PARTICLE = PARTICLES
            .register("solar_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> DEMONIC_CRYSTAL_PARTICLE = PARTICLES
            .register("demonic_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> CELESTIAL_CRYSTAL_PARTICLE = PARTICLES
            .register("celestial_crystal_particle", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}