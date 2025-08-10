package com.honigdose.abyssmagicmod.entity.custom.luma.goals;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.RandomPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class LumaFleeGoal extends Goal {
    private final LumaEntity luma;
    private final double speed;
    private int recalcCooldown = 0;

    public LumaFleeGoal(LumaEntity luma, double speed) {
        this.luma = luma;
        this.speed = speed;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }
    @Override
    public boolean canUse() {
        return this.luma.getFleeTicks() > 0;
    }
    @Override
    public void start() {
        this.recalcCooldown = 0;
        this.updateDestination();
    }

    @Override
    public void tick() {
        if (this.recalcCooldown-- <= 0) {
            this.recalcCooldown = 8 + this.luma.getRandom().nextInt(8); // alle ~8-15 Ticks neu
            this.updateDestination();
        }
    }

    private void updateDestination() {
        double sx = luma.getX();
        double sy = luma.getY();
        double sz = luma.getZ();

        double tx;
        double ty;
        double tz;

        LivingEntity attacker = luma.getLastAttacker();

        if (attacker != null) {
            double dx = sx - attacker.getX();
            double dz = sz - attacker.getZ();
            double dist = Math.sqrt(dx * dx + dz * dz);
            if (dist < 0.0001) dist = 0.0001;

            double factor = 4.0; // horizontale Distanz
            tx = sx + (dx / dist) * factor + (luma.getRandom().nextDouble() - 0.5);
            tz = sz + (dz / dist) * factor + (luma.getRandom().nextDouble() - 0.5);

            // keine oder nur winzige Y-Änderung (bleibt in etwa auf gleicher Höhe)
            ty = sy + (luma.getRandom().nextDouble() - 0.5) * 0.4;
        } else {
            tx = sx + (luma.getRandom().nextDouble() - 0.5) * 8.0;
            tz = sz + (luma.getRandom().nextDouble() - 0.5) * 8.0;
            ty = sy + (luma.getRandom().nextDouble() - 0.5) * 0.4;
        }

        ty = Math.max(0.0, Math.min((double) (luma.level().getMaxBuildHeight() - 1), ty));
        this.luma.getNavigation().moveTo(tx, ty, tz, this.speed);
    }

    @Override
    public boolean canContinueToUse() {
        // Weiterfliehen, solange fleeTicks > 0
        return this.luma.getFleeTicks() > 0;
    }

    @Override
    public void stop() {
        // Flucht beendet — Angreifer vergessen und Navigation stoppen
        this.luma.setLastAttacker(null);
        this.luma.getNavigation().stop();
    }
}
