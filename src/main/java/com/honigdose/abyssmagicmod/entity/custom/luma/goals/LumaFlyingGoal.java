package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class LumaFlyingGoal extends Goal {
    private final LumaEntity luma;
    private final double speed;
    private int cooldown;

    public LumaFlyingGoal(LumaEntity luma, double speed) {
        this.luma = luma;
        this.speed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return !luma.isSleepingLuma() && luma.getTarget() == null && cooldown-- <= 0;
    }

    @Override
    public void start() {
        Vec3 randomPos = getRandomPosition();
        luma.getNavigation().moveTo(randomPos.x, randomPos.y, randomPos.z, speed);
        cooldown = 20 + luma.getRandom().nextInt(40);
    }

    private Vec3 getRandomPosition() {
        BlockPos pos = luma.blockPosition();
        double x = pos.getX() + luma.getRandom().nextGaussian() * 6;
        double y = pos.getY() + luma.getRandom().nextGaussian() * 3;
        double z = pos.getZ() + luma.getRandom().nextGaussian() * 6;
        return new Vec3(x, y, z);
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }
}
