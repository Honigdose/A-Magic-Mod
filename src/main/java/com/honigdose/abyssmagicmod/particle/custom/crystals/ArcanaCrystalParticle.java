package com.honigdose.abyssmagicmod.particle.custom.crystals;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;


public class ArcanaCrystalParticle extends TextureSheetParticle {
    private static final Random RANDOM = new Random();

    private final int startHex;
    private final int endHex;

    protected ArcanaCrystalParticle(ClientLevel level, double x, double y, double z,
                                    SpriteSet pSprites, double dx, double dy, double dz,
                                    int startHex, int endHex) {
        super(level, x, y, z, dx, dy, dz);


        this.setSprite(pSprites.get(this.random.nextInt(4), 4));

        this.startHex = startHex;
        this.endHex = endHex;

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.hasPhysics = false;
        this.gravity = 0.0f;
        this.quadSize = 0.02F + RANDOM.nextFloat(0.1F);
        this.lifetime = 140 + RANDOM.nextInt(40);
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();

        float fadeInDuration = 0.2f * this.lifetime;
        float fadeOutDuration = 0.8f * this.lifetime;
        if (this.age < fadeInDuration) {
            this.alpha = (float) this.age / fadeInDuration;
        } else if (this.age > fadeOutDuration) {
            this.alpha = 1.0f - ((float) (this.age - fadeOutDuration) / (this.lifetime - fadeOutDuration));
        } else {
            this.alpha = 1.0f;
        }

        float t = (float) this.age / (float) this.lifetime;

        float startR = ((startHex >> 16) & 0xFF) / 255f;
        float startG = ((startHex >> 8) & 0xFF) / 255f;
        float startB = (startHex & 0xFF) / 255f;

        float endR = ((endHex >> 16) & 0xFF) / 255f;
        float endG = ((endHex >> 8) & 0xFF) / 255f;
        float endB = (endHex & 0xFF) / 255f;

        this.rCol = startR * (1 - t) + endR * t;
        this.gCol = startG * (1 - t) + endG * t;
        this.bCol = startB * (1 - t) + endB * t;

        double hoverAmplitude = 0.007;
        this.yd = Math.sin(this.age * 0.04) * hoverAmplitude;
    }

    @Override
    protected int getLightColor(float partialTick) {
        return 0xF000F0;
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            int startHex = 0xf2f8ff;
            int endHex   = 0xf4f2ff;
            return new ArcanaCrystalParticle(level, x, y, z, this.sprite, dx, dy, dz, startHex, endHex);
        }
    }

}