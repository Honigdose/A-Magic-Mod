package com.honigdose.abyssmagicmod.block.essence.bottle.nature;

import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.Direction;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class NatureEssenceBottleRenderer extends GeoBlockRenderer<NatureEssenceBottleEntity> {
    public NatureEssenceBottleRenderer() {
        super(new NatureEssenceBottleModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
