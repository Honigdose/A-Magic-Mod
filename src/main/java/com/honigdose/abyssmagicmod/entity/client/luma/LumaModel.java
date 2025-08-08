package com.honigdose.abyssmagicmod.entity.client.luma;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LumaModel extends GeoModel<LumaEntity> {
    @Override
    public ResourceLocation getModelResource(LumaEntity lumaEntity) {
        return ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "geo/luma.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LumaEntity lumaEntity) {
        return ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/entity/luma.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LumaEntity lumaEntity) {
        return ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "animations/luma.animation.json");    }
}
