package com.honigdose.abyssmagicmod.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ScarletLeavesParticle extends TextureSheetParticle {
    private static final double WIND_STRENGTH = 0.001;
    private static final double WIND_VARIANCE = 0.0002;
    private final float rotationSpeed;

    protected ScarletLeavesParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                    SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.xd *= 0.0008;
        this.yd *= -0.0001;
        this.zd *= 0;

        this.gravity = 0.05F;
        this.quadSize = 0.2F;
        this.lifetime = 120;
        this.setSprite(spriteSet.get(this.random.nextInt(12), 12));

        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.alpha = 1.0F;

        this.roll = random.nextFloat() * (float) Math.PI * 2.0F;
        this.rotationSpeed = (random.nextFloat() - 0.5F) * 0.2F;
    }


    @Override
    public void tick() {
        super.tick();

        double windX = WIND_STRENGTH + (random.nextDouble() * WIND_VARIANCE * 2 - WIND_VARIANCE);


        this.xd += windX;

        this.oRoll = this.roll;
        this.roll += this.rotationSpeed;

    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new ScarletLeavesParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}

