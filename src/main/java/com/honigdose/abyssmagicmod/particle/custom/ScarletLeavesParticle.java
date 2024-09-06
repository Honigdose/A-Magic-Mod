package com.honigdose.abyssmagicmod.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ScarletLeavesParticle extends TextureSheetParticle {
    protected ScarletLeavesParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                    SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.xd *= 0.1F;
        this.yd *= 0.1F;
        this.zd *= 0.1F;

        this.gravity = 0.05F;

        this.friction = 0.98F;
        this.quadSize *= 1.2F;
        this.lifetime = 40 + level.random.nextInt(20);
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.alpha = 1.0F;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age > this.lifetime * 0.5) {
            fadeOut();
        }

        if (this.onGround) {
            this.xd *= 0.7F;
            this.zd *= 0.7F;
        }
    }

    private void fadeOut() {
        this.alpha = 1.0F - ((float) this.age / (float) this.lifetime);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Override
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new ScarletLeavesParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
