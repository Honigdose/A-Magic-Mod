package com.honigdose.abyssmagicmod.particle.custom.crystals;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;


public class CuteCrystalParticle extends TextureSheetParticle {
    private static final Random RANDOM = new Random();
    private final int startHex;
    private final int endHex;


    protected CuteCrystalParticle(ClientLevel level, double x, double y, double z,
                                  SpriteSet pSprites, double dx, double dy, double dz,
                                  int startHex, int endHex) {
        super(level, x, y, z, dx, dy, dz);

        this.startHex = startHex;
        this.endHex = endHex;

        this.setSpriteFromAge(pSprites);
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.hasPhysics = false;
        this.gravity = 0.0f;
        this.quadSize = 0.04F + RANDOM.nextFloat(0.09F);
        this.lifetime = 200 + RANDOM.nextInt(40);
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();

        // Berechnung von alpha wie gehabt
        float fadeInDuration = 0.2f * this.lifetime;
        float fadeOutDuration = 0.8f * this.lifetime;
        if (this.age < fadeInDuration) {
            this.alpha = (float) this.age / fadeInDuration;
        } else if (this.age > fadeOutDuration) {
            this.alpha = 1.0f - ((float) (this.age - fadeOutDuration) / (this.lifetime - fadeOutDuration));
        } else {
            this.alpha = 1.0f;
        }

        // Interpolationsfaktor: 0 am Anfang, 1 am Ende
        float t = (float) this.age / (float) this.lifetime;

        // Startfarbe in RGB zerlegen
        float startR = ((startHex >> 16) & 0xFF) / 255f;
        float startG = ((startHex >> 8) & 0xFF) / 255f;
        float startB = (startHex & 0xFF) / 255f;

        // Endfarbe in RGB zerlegen
        float endR = ((endHex >> 16) & 0xFF) / 255f;
        float endG = ((endHex >> 8) & 0xFF) / 255f;
        float endB = (endHex & 0xFF) / 255f;

        // Lineare Interpolation der Farbkanäle
        this.rCol = startR * (1 - t) + endR * t;
        this.gCol = startG * (1 - t) + endG * t;
        this.bCol = startB * (1 - t) + endB * t;

        double hoverAmplitude = 0.007;
        this.yd = Math.sin(this.age * 0.04) * hoverAmplitude;
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
            int startHex = 0xFF0000; // Beispiel: Rot als Startfarbe
            int endHex = 0x0000FF;   // Beispiel: Blau als Endfarbe
            return new CuteCrystalParticle(level, x, y, z, this.sprite, dx, dy, dz, startHex, endHex);
        }
    }

}