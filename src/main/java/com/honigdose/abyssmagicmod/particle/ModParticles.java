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

    public static final RegistryObject<SimpleParticleType> SCARLET_LEAVES_PARTICLE = PARTICLES
            .register("scarlet_leaves_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CUTE_CRYSTAL_PARTICLE = PARTICLES
            .register("cute_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> VOID_CRYSTAL_PARTICLE = PARTICLES
            .register("void_crystal_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LUNAR_CRYSTAL_PARTICLE = PARTICLES
            .register("lunar_crystal_particle", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}