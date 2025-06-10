package com.honigdose.abyssmagicmod.block.essence.block.test;

import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EssenceEntityBlock extends BlockEntity{

    public EssenceEntityBlock(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntites.ESSENCE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }


    public static void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) {
            RandomSource random = level.getRandom();

            double time = level.getGameTime() * 0.15;
            double movementRadius = 0.15;
            double movementX = Math.sin(time) * movementRadius;
            double movementZ = Math.cos(time) * movementRadius;

            double offsetFactor = 0.01;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;

            double x = pos.getX() + 0.5 + movementX ;
            double y = pos.getY() + 0.4 ;
            double z = pos.getZ() + 0.5 + movementZ ;

            level.addParticle(ModParticles.ESSENCE_PARTICLE.get(), x, y, z, 0.0, 0.0, 0.0);
        }
    }

}
