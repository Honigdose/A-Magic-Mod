package com.honigdose.abyssmagicmod.block.essence.bottle.water;

import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class WaterEssenceBottleRenderer extends GeoBlockRenderer<WaterEssenceBottleEntity> {
    public WaterEssenceBottleRenderer() {
        super(new WaterEssenceBottleModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
