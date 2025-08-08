package com.honigdose.abyssmagicmod.particle.custom.mob.luma;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaVariant;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.awt.*;

public class LumaParticle extends TextureSheetParticle {
    protected LumaParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                           SpriteSet spriteSet, double xd, double yd, double zd,
                           Color color) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.85F;
        this.gravity = 0.01F;
        this.lifetime = 30 + this.random.nextInt(20);
        this.quadSize *= 0.6F;

        this.setSpriteFromAge(spriteSet);

        this.setColor(color);

        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
    }

    private void setColor(Color color) {
        this.rCol = color.getRed() / 255f;
        this.gCol = color.getGreen() / 255f;
        this.bCol = color.getBlue() / 255f;
    }


    @Override
    public void tick() {
        super.tick();

        this.xd += (this.random.nextFloat() - 0.5f) * 0.02f;
        this.yd += (this.random.nextFloat() - 0.5f) * 0.02f;
        this.zd += (this.random.nextFloat() - 0.5f) * 0.02f;

        this.xd *= 0.95;
        this.yd *= 0.95;
        this.zd *= 0.95;

        fadeOut();
    }

    private void fadeOut() {
        float baseAlpha = (-(1f / lifetime) * age + 1);
        this.alpha = baseAlpha * (0.9f + random.nextFloat() * 0.1f);
    }

    protected int getLightColor(float pPartialTick) {
        return 15728880;
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            int variantId = (int) dx;
            LumaVariant variant = LumaVariant.byId(variantId);
            return new LumaParticle(level, x, y, z, this.sprites, 0, 0, 0, variant.getColor());
        }
    }

}
