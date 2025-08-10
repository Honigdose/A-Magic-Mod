package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Random;

public class LumaSeekLightSourceGoal extends Goal {
    private final LumaEntity luma;
    private BlockPos lightCenter = null;
    private double angle = 0;
    private final Random random = new Random();
    private int changeTimer = 0;

    private double currentRadius = 1.2 + random.nextDouble() * 0.8; // 1.2 – 2.0
    private double verticalOffset = 1.2 + random.nextDouble() * 0.6;

    public LumaSeekLightSourceGoal(LumaEntity luma) {
        this.luma = luma;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {

        if (!luma.level().isDay()) {
            return false;
        }

        lightCenter = findBrightestLightSource(luma.blockPosition());

        return lightCenter != null;
    }

    @Override
    public void tick() {
        if (lightCenter != null) {
            BlockState state = luma.level().getBlockState(lightCenter);
            int currentLight = luma.level().getBrightness(LightLayer.BLOCK, lightCenter);

            boolean isDangerous = state.is(Blocks.LAVA)
                    || state.getFluidState().is(FluidTags.LAVA)
                    || state.is(Blocks.FIRE)
                    || state.is(Blocks.SOUL_FIRE)
                    || state.is(Blocks.MAGMA_BLOCK);

            if (isDangerous || currentLight < 5) {
                lightCenter = null;
                return;
            }
        }


        if (lightCenter == null || luma.distanceToSqr(Vec3.atCenterOf(lightCenter)) > 10) {
            lightCenter = findBrightestLightSource(luma.blockPosition());
            angle = luma.getId() * 45;
            if(lightCenter == null){
                return;
            }
        }

        angle += 5 + random.nextDouble() * 3;

        if (changeTimer-- <= 0) {
            currentRadius = 0.8 + random.nextDouble() * 1.2;
            verticalOffset = 1.0 + random.nextDouble() * 0.8;
            changeTimer = 40 + random.nextInt(40);
        }

        double radians = Math.toRadians(angle);

        double offsetX = Math.cos(radians) * currentRadius + (random.nextDouble() - 0.5) * 0.2;
        double offsetZ = Math.sin(radians) * currentRadius + (random.nextDouble() - 0.5) * 0.2;
        double offsetY = Math.sin(radians * 2 + luma.tickCount * 0.2) * 1.3;

        double targetX = lightCenter.getX() + 0.5 + offsetX;
        double targetZ = lightCenter.getZ() + 0.5 + offsetZ;
        double targetY = lightCenter.getY() + verticalOffset + offsetY;

        luma.getNavigation().moveTo(targetX, targetY, targetZ, 1.15);
    }

    private BlockPos findBrightestLightSource(BlockPos origin) {
        BlockPos brightestPos = null;
        int maxLight = -1;

        for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-8, -4, -8), origin.offset(8, 4, 8))) {
            BlockState state = luma.level().getBlockState(pos);

            if (state.is(Blocks.LAVA) || state.getFluidState().is(FluidTags.LAVA)
                    || state.is(Blocks.FIRE) || state.is(Blocks.SOUL_FIRE)
                    || state.is(Blocks.MAGMA_BLOCK)) {
                continue;
            }

            int light = luma.level().getBrightness(LightLayer.BLOCK, pos);
            if (light > maxLight) {
                maxLight = light;
                brightestPos = pos.immutable();
            }
        }
        return (maxLight >= 5) ? brightestPos : null;
    }
}

