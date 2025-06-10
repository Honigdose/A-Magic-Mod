package com.honigdose.abyssmagicmod.block.crystals;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BabyCrystalClusterBlock extends AmethystClusterBlock {
    public BabyCrystalClusterBlock(float p_313148_, float p_309607_, Properties p_152017_) {
        super(p_313148_, p_309607_, p_152017_);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.05f) {
            double offsetFactor = 2;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * 1.2;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double xPos = pos.getX() + 0.5 + xOffset;
            double yPos = pos.getY() + 1.0 + yOffset;
            double zPos = pos.getZ() + 0.5 + zOffset;

            ParticleType<?> particleType;
            if (this == ModBlocks.BABY_ARCANA_CRYSTAL.get()) {
                particleType = ModParticles.ARCANA_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_FIRE_CRYSTAL.get()) {
                particleType = ModParticles.FIRE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_AIR_CRYSTAL.get()) {
                particleType = ModParticles.AIR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_NATURE_CRYSTAL.get()) {
                particleType = ModParticles.NATUR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_WATER_CRYSTAL.get()) {
                particleType = ModParticles.WATER_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_SOLAR_CRYSTAL.get()) {
                particleType = ModParticles.SOLAR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_LUNAR_CRYSTAL.get()) {
                particleType = ModParticles.LUNAR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_VOID_CRYSTAL.get()) {
                particleType = ModParticles.VOID_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_DEMONIC_CRYSTAL.get()) {
                particleType = ModParticles.DEMONIC_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.BABY_DEMONIC_CRYSTAL.get()) {
                particleType = ModParticles.CELESTIAL_CRYSTAL_PARTICLE.get();
            } else {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            }

            level.addParticle((ParticleOptions) particleType, xPos, yPos, zPos, 0.0, 0.0, 0.0);
        }
    }
}
