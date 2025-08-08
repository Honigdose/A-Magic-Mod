package com.honigdose.abyssmagicmod.entity.client.luma;

import com.google.common.collect.Maps;
import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import com.honigdose.abyssmagicmod.entity.custom.luma.LumaVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

import java.awt.*;
import java.util.Map;

public class LumaRenderer extends GeoEntityRenderer<LumaEntity> {

    private static final Map<LumaVariant, ResourceLocation> NORMAL_TEXTURES =
            Util.make(Maps.newEnumMap(LumaVariant.class), map -> {
                map.put(LumaVariant.SOLAR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/solar_luma.png"));
                map.put(LumaVariant.LUNAR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/lunar_luma.png"));
                map.put(LumaVariant.FIRE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/fire_luma.png"));
                map.put(LumaVariant.WATER,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/water_luma.png"));
                map.put(LumaVariant.NATURE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/natur_luma.png"));
                map.put(LumaVariant.AIR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/air_luma.png"));
                map.put(LumaVariant.DEMONIC,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/demonic_luma.png"));
                map.put(LumaVariant.CELESTIAL,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/celestial_luma.png"));
                map.put(LumaVariant.BASE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/base_luma.png"));
            });

    private static final Map<LumaVariant, ResourceLocation> SLEEP_TEXTURES =
            Util.make(Maps.newEnumMap(LumaVariant.class), map -> {
                map.put(LumaVariant.SOLAR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/solar_luma_sleep.png"));
                map.put(LumaVariant.LUNAR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/lunar_luma_sleep.png"));
                map.put(LumaVariant.FIRE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/fire_luma_sleep.png"));
                map.put(LumaVariant.WATER,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/water_luma_sleep.png"));
                map.put(LumaVariant.NATURE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/natur_luma_sleep.png"));
                map.put(LumaVariant.AIR,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/air_luma_sleep.png"));
                map.put(LumaVariant.DEMONIC,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/demonic_luma_sleep.png"));
                map.put(LumaVariant.CELESTIAL,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/celestial_luma_sleep.png"));
                map.put(LumaVariant.BASE,
                        ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma/base_luma_sleep.png"));
            });


    public LumaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LumaModel());
        this.addRenderLayer(new ConditionalGlowingLayer(this));


    }

    @Override
    public ResourceLocation getTextureLocation(LumaEntity luma) {
        LumaVariant variant = luma.getVariant();
        return luma.isCurrentlyDay() ? SLEEP_TEXTURES.get(variant) : NORMAL_TEXTURES.get(variant);
    }

    @Override
    public void render(LumaEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }


}
