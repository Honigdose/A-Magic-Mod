package com.honigdose.abyssmagicmod.particle.custom.element_particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class VoidParticles extends TextureSheetParticle {
    private static final Random RANDOM = new Random();


    private final float moveAmplitude;
    private final float moveSpeed;
    private float timeX;
    private float timeY;

    protected VoidParticles(ClientLevel level, double x, double y, double z,
                                         SpriteSet pSprites, double dx, double dy, double dz, int hex) {
        super(level, x, y, z, dx, dy, dz);

        this.setSprite(pSprites.get(this.random.nextInt(4), 4));
        this.setColor((hex >> 16 & 0xFF) / 255.0F, (hex >> 8 & 0xFF) / 255.0F, (hex & 0xFF) / 255.0F);


        this.timeX = RANDOM.nextFloat() * (float) Math.PI * 2;
        this.timeY = RANDOM.nextFloat() * (float) Math.PI * 2;

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.hasPhysics = false;
        this.gravity = 0.0f;
        this.quadSize = 0.05F + RANDOM.nextFloat(0.02F);
        this.lifetime = 140 + RANDOM.nextInt(40);
        this.alpha = 1.0f;

        this.moveAmplitude = 0.0015f + RANDOM.nextFloat() * 0.0015f;
        this.moveSpeed = 0.0025f + RANDOM.nextFloat() * 0.0025f;
    }

    @Override
    public void tick() {
        super.tick();
        this.timeX += this.moveSpeed;
        this.timeY += this.moveSpeed * 0.8f;

        this.x += Math.sin(this.timeX) * this.moveAmplitude;
        this.y += Math.sin(this.timeY) * this.moveAmplitude;

        float t = (float) this.age / (float) this.lifetime;

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
            int hex = 0x000000;
            return new VoidParticles(level, x, y, z, this.sprite, dx, dy, dz, hex);
        }
    }
}
