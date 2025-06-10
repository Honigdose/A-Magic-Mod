package com.honigdose.abyssmagicmod.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;



public class EssenceRenderType implements ParticleRenderType {
    private static final EssenceRenderType INSTANCE = new EssenceRenderType();

    public static ParticleRenderType getInstance() {
        return INSTANCE;
    }

    @Override
    public BufferBuilder begin(Tesselator tesselator, TextureManager textureManager) {
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        return tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
    }


    @Override
    public String toString() {
        return "ESSENCE_RENDER_TYPE";
    }
}
