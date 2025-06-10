package com.honigdose.abyssmagicmod.particle.custom.essence;

import com.honigdose.abyssmagicmod.particle.EssenceRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class FireEssenceParticle extends TextureSheetParticle {
    private static final Random RANDOM = new Random();
    private final int startHex;
    private final int middleHex;
    private final int endHex;
    private final float initialSize;
    private final float finalSize;

    protected FireEssenceParticle(ClientLevel level, double x, double y, double z,
                                  SpriteSet pSprites, double dx, double dy, double dz,
                                  int startHex, int middleHex, int endHex) {
        super(level, x, y, z, dx, dy, dz);

        this.startHex = startHex;
        this.middleHex = middleHex;
        this.endHex = endHex;
        this.initialSize = 0.3F;
        this.finalSize = this.initialSize / 10.0f;
        this.quadSize = this.initialSize;

        this.setSpriteFromAge(pSprites);
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.hasPhysics = false;
        this.gravity = 0.0f;
        this.lifetime = 30 + RANDOM.nextInt(20);
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        float t = (float) this.age / (float) this.lifetime;
        this.yd = 0.005f + (0.02f - 0.005f) * t;
        super.tick();

        float fadeInDuration = 0.005f * this.lifetime;
        if (this.age < fadeInDuration) {
            this.alpha = (float) this.age / fadeInDuration;
        } else {
            this.alpha = 1.0f;
        }

        this.quadSize = initialSize * (1 - t) + finalSize * t;

        float midPoint = 0.5f; // Übergangspunkt zwischen startHex -> middleHex -> endHex
        float colorT;
        int fromHex, toHex;

        if (t < midPoint) {
            colorT = t / midPoint;
            fromHex = startHex;
            toHex = middleHex;
        } else {
            colorT = (t - midPoint) / (1.0f - midPoint);
            fromHex = middleHex;
            toHex = endHex;
        }

        float fromR = ((fromHex >> 16) & 0xFF) / 255f;
        float fromG = ((fromHex >> 8) & 0xFF) / 255f;
        float fromB = (fromHex & 0xFF) / 255f;

        float toR = ((toHex >> 16) & 0xFF) / 255f;
        float toG = ((toHex >> 8) & 0xFF) / 255f;
        float toB = (toHex & 0xFF) / 255f;

        this.rCol = fromR * (1 - colorT) + toR * colorT;
        this.gCol = fromG * (1 - colorT) + toG * colorT;
        this.bCol = fromB * (1 - colorT) + toB * colorT;
    }

    @Override
    protected int getLightColor(float pPartialTick) {
        return 15728880;
    }

    public ParticleRenderType getRenderType() {
        return EssenceRenderType.getInstance();
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
            int startHex = 0xffa069;
            int middleHex = 0xc4264c;
            int endHex = 0x41002b;
            return new FireEssenceParticle(level, x, y, z, this.sprite, dx, dy, dz, startHex, middleHex, endHex);
        }
    }
}
