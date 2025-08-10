package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.EnumSet;

import javax.annotation.Nullable;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.FluidState;

public class LumaSleepGoal extends Goal {
    private final LumaEntity luma;
    private BlockPos sleepPos;
    private boolean sleepInitiated = false;

    public LumaSleepGoal(LumaEntity luma) {
        this.luma = luma;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    private @Nullable BlockPos findValidSleepPos() {
        int radius = 4;
        int maxAttempts = 16;

        for (int i = 0; i < maxAttempts; i++) {
            int offsetX = this.luma.getRandom().nextInt(radius * 2 + 1) - radius;
            int offsetZ = this.luma.getRandom().nextInt(radius * 2 + 1) - radius;
            BlockPos basePos = this.luma.blockPosition().offset(offsetX, 0, offsetZ);

            int surfaceY = this.luma.level().getHeight(Heightmap.Types.MOTION_BLOCKING, basePos.getX(), basePos.getZ());
            BlockPos potentialPos = new BlockPos(basePos.getX(), surfaceY, basePos.getZ());

            BlockState blockBelow = this.luma.level().getBlockState(potentialPos.below());
            BlockState blockAtPos = this.luma.level().getBlockState(potentialPos);
            FluidState fluidAt = this.luma.level().getFluidState(potentialPos);
            FluidState fluidBelow = this.luma.level().getFluidState(potentialPos.below());

            boolean belowSolid = blockBelow.isSolid();
            boolean posFree = this.luma.level().isEmptyBlock(potentialPos) || blockAtPos.canBeReplaced();
            boolean noWater = fluidAt.isEmpty() && fluidBelow.isEmpty() && !fluidAt.is(FluidTags.WATER) && !fluidBelow.is(FluidTags.WATER);

            if (belowSolid && posFree && noWater) {
                return potentialPos;
            }
        }

        return null;
    }

    private boolean isSleepPosStillValid(BlockPos pos) {
        if (pos == null) return false;
        FluidState fluidAt = this.luma.level().getFluidState(pos);
        FluidState fluidBelow = this.luma.level().getFluidState(pos.below());
        BlockState blockBelow = this.luma.level().getBlockState(pos.below());
        boolean belowSolid = blockBelow.isSolid();
        boolean noWater = fluidAt.isEmpty() && fluidBelow.isEmpty() && !fluidAt.is(FluidTags.WATER) && !fluidBelow.is(FluidTags.WATER);
        boolean posFree = this.luma.level().isEmptyBlock(pos);
        return belowSolid && noWater && posFree;
    }

    @Override
    public boolean canUse() {
        if (this.luma.level().isNight() || this.luma.isSleepingLuma()) {
            return false;
        }

        if (this.sleepPos == null || !isSleepPosStillValid(this.sleepPos)) {
            this.sleepPos = findValidSleepPos();
        }

        return this.sleepPos != null;
    }

    @Override
    public boolean canContinueToUse() {
        return !sleepInitiated || this.luma.isSleepingLuma();
    }

    @Override
    public void start() {
        sleepInitiated = false;
        this.luma.setNoGravity(true);

        if (this.sleepPos != null) {
            this.luma.getNavigation().moveTo(this.sleepPos.getX(), this.sleepPos.getY(), this.sleepPos.getZ(), 1.0);
        }
    }

    @Override
    public void tick() {
        if (this.sleepPos == null) return;

        double targetX = this.sleepPos.getX() + 0.5;
        double targetY = this.sleepPos.getY();
        double targetZ = this.sleepPos.getZ() + 0.5;

        if (!this.luma.getNavigation().isDone()) {
            return;
        }

        if (!sleepInitiated) {
            sleepInitiated = true;
            this.luma.getNavigation().stop();

            this.luma.setPos(targetX, targetY, targetZ);
            this.luma.setNoGravity(false);
            this.luma.setSleepingLuma(true);
        }
    }

    @Override
    public void stop() {
        this.luma.setSleepingLuma(false);
        this.luma.setNoGravity(true);
        this.sleepPos = null;
        this.sleepInitiated = false;
    }
}
