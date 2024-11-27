package com.honigdose.abyssmagicmod.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class CuteCrystalParticle extends TextureSheetParticle {
    private static final Random RANDOM = new Random();
    private final float ageOffset;

    protected CuteCrystalParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                                  SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;

        this.hasPhysics = false;

        this.gravity = 0.0f; // Keine Schwerkraft für schwebendes Verhalten
        this.quadSize = 0.2F;
        this.lifetime = 50 + RANDOM.nextInt(20); // zufällige Lebenszeit, hier zwischen 50 und 70 Ticks

        this.ageOffset = RANDOM.nextFloat() * this.lifetime;
        this.setSpriteFromAge(spriteSet);

        // Setzen Sie den Anfangsalpha-Wert auf 0 (komplett transparent)
        this.alpha = 0.0f;
    }

    @Override
    public void tick() {
        super.tick();

        // Berechnen des Alpha-Werts (Fading)
        float fadeInDuration = 0.2f * this.lifetime; // 20% der Lebenszeit für das Fade-In
        float fadeOutDuration = 0.8f * this.lifetime; // Die restlichen 80% für das Fade-Out

        if (this.age < fadeInDuration) {
            // Fade-In Phase
            this.alpha = (float) this.age / fadeInDuration;
        } else if (this.age > fadeOutDuration) {
            // Fade-Out Phase
            this.alpha = 1.0f - ((float) (this.age - fadeOutDuration) / (this.lifetime - fadeOutDuration));
        } else {
            // Bleibt vollständig sichtbar
            this.alpha = 1.0f;
        }

        // Optionale Animation für leichtes Schweben
        double hoverAmplitude = 0.01; // Amplitude der Bewegung
        this.yd = Math.sin(this.age * 0.1) * hoverAmplitude;
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
            return new CuteCrystalParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}

