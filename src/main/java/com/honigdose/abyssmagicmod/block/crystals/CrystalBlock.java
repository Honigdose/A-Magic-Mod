package com.honigdose.abyssmagicmod.block.crystals;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TintedGlassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalBlock extends TintedGlassBlock {
    public CrystalBlock(Properties p_154822_) {
        super(p_154822_);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.1f) {
            double offsetFactor = 2;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * 1.2;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double xPos = pos.getX() + 0.5 + xOffset;
            double yPos = pos.getY() + 1.0 + yOffset;
            double zPos = pos.getZ() + 0.5 + zOffset;

            ParticleType<?> particleType;
            if (this == ModBlocks.ARCANA_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.ARCANA_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.FIRE_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.FIRE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.AIR_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.AIR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.NATURE_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.NATUR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.WATER_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.WATER_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.SOLAR_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.SOLAR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LUNAR_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.LUNAR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.VOID_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.VOID_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.DEMONIC_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.DEMONIC_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get()) {
                particleType = ModParticles.CELESTIAL_CRYSTAL_PARTICLE.get();
            } else {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            }

            level.addParticle((ParticleOptions) particleType, xPos, yPos, zPos, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState p_154824_, BlockGetter p_154825_, BlockPos p_154826_) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }


}
