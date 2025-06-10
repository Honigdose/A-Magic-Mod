package com.honigdose.abyssmagicmod.particle.custom.essence;

import com.honigdose.abyssmagicmod.particle.EssenceRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class LunarEssenceParticle extends TextureSheetParticle {
    private static final Random RANDOM = new Random();
    private final int startHex;
    private final int endHex;
    private final float initialSize;
    private final float finalSize;


    protected LunarEssenceParticle(ClientLevel level, double x, double y, double z,
                                   SpriteSet pSprites, double dx, double dy, double dz,
                                   int startHex, int endHex) {
        super(level, x, y, z, dx, dy, dz);

        this.startHex = startHex;
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


        float startR = ((startHex >> 16) & 0xFF) / 255f;
        float startG = ((startHex >> 8) & 0xFF) / 255f;
        float startB = (startHex & 0xFF) / 255f;

        float endR = ((endHex >> 16) & 0xFF) / 255f;
        float endG = ((endHex >> 8) & 0xFF) / 255f;
        float endB = (endHex & 0xFF) / 255f;

        this.rCol = startR * (1 - t) + endR * t;
        this.gCol = startG * (1 - t) + endG * t;
        this.bCol = startB * (1 - t) + endB * t;
    }

    public ParticleRenderType getRenderType() {
        return EssenceRenderType.getInstance();
    }

    @Override
    protected int getLightColor(float pPartialTick) {
        return 15728880;
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
            int startHex = 0x9302fa;
            int endHex = 0x000f30;
            return new LunarEssenceParticle(level, x, y, z, this.sprite, dx, dy, dz, startHex, endHex);
        }
    }

}