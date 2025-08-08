package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.EnumSet;

public class LumaSleepGoal extends Goal {
    private final LumaEntity luma;
    private BlockPos sleepPos;
    private boolean sleepInitiated = false;

    public LumaSleepGoal(LumaEntity luma) {
        this.luma = luma;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    private BlockPos findSleepPos() {
        int radius = 4;
        int offsetX = luma.getRandom().nextInt(radius * 2) - radius;
        int offsetZ = luma.getRandom().nextInt(radius * 2) - radius;
        BlockPos basePos = luma.blockPosition().offset(offsetX, 0, offsetZ);
        int groundY = luma.level().getHeight(Heightmap.Types.MOTION_BLOCKING, basePos.getX(), basePos.getZ());
        return new BlockPos(basePos.getX(), groundY, basePos.getZ());
    }

    @Override
    public boolean canUse() {
        if (luma.level().isNight() || luma.isSleepingLuma()) {
            return false;
        }
        if (sleepPos == null) {
            sleepPos = findSleepPos();
        }
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return !sleepInitiated || luma.isSleepingLuma();
    }

    @Override
    public void start() {
        sleepInitiated = false;
        luma.setNoGravity(true);
        luma.getNavigation().moveTo(sleepPos.getX(), sleepPos.getY(), sleepPos.getZ(), 1.0);
    }

    @Override
    public void tick() {
        double targetX = sleepPos.getX() + 0.5;
        double targetY = sleepPos.getY();
        double targetZ = sleepPos.getZ() + 0.5;

        if (!luma.getNavigation().isDone()) {
            return;
        }

        if (!sleepInitiated) {
            sleepInitiated = true;
            luma.getNavigation().stop();
            luma.setNoGravity(false);
            luma.setPos(targetX, targetY, targetZ);
            luma.setSleepingLuma(true);
        }
    }


    @Override
    public void stop() {
        luma.setSleepingLuma(false);
        luma.setNoGravity(true);
        sleepPos = null;
        sleepInitiated = false;
    }
}
