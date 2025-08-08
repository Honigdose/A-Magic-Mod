package com.honigdose.abyssmagicmod.entity.client.luma;

import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ConditionalGlowingLayer extends AutoGlowingGeoLayer<LumaEntity> {
    public ConditionalGlowingLayer(GeoRenderer<LumaEntity> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, LumaEntity animatable, BakedGeoModel bakedModel,
                       @Nullable RenderType renderType, MultiBufferSource bufferSource,
                       @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        if (!animatable.isCurrentlyDay()) {
            super.render(poseStack, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
        }
    }

}
