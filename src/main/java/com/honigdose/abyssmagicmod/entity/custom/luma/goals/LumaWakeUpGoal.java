package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class LumaWakeUpGoal extends Goal {
    private final LumaEntity luma;

    public LumaWakeUpGoal(LumaEntity luma) {
        this.luma = luma;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        return luma.level().isNight() && luma.isSleepingLuma();
    }

    @Override
    public void start() {
        luma.setSleepingLuma(false);
        luma.setNoGravity(true);

    }
}
