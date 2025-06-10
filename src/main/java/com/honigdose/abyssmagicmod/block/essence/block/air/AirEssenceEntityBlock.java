package com.honigdose.abyssmagicmod.block.essence.block.air;

import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AirEssenceEntityBlock extends BlockEntity{

    public AirEssenceEntityBlock(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntites.AIR_ESSENCE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }


    private static double currentMovementRadius = 0.05;
    private static double targetMovementRadius = 0.05;
    private static int changeTimer = 0;

    public static void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) {
            RandomSource random = level.getRandom();
            double time = level.getGameTime() * 0.15;

            if (changeTimer-- <= 0) {
                changeTimer = 80;

                int roll = random.nextInt(100);

                if (roll < 70) {
                    targetMovementRadius = 0.05;
                } else if (roll < 90) {
                    targetMovementRadius = 0.1;
                } else if (roll < 99) {
                    targetMovementRadius = 0.2;
                } else {
                    targetMovementRadius = 0.4;
                }
            }

            currentMovementRadius += (targetMovementRadius - currentMovementRadius) * 0.05;

            double movementX = Math.sin(time) * currentMovementRadius;
            double movementZ = Math.cos(time) * currentMovementRadius;

            double offsetFactor = 0.015;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;

            double x = pos.getX() + 0.5 + movementX;
            double y = pos.getY() + 0.4;
            double z = pos.getZ() + 0.5 + movementZ;

            level.addParticle(ModParticles.AIR_ESSENCE_PARTICLE.get(), x, y, z, 0.0, 0.0, 0.0);
        }
    }

}
