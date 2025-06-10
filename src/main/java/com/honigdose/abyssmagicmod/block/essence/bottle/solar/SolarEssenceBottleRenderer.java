package com.honigdose.abyssmagicmod.block.essence.bottle.solar;

import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class SolarEssenceBottleRenderer extends GeoBlockRenderer<SolarEssenceBottleEntity> {
    public SolarEssenceBottleRenderer() {
        super(new SolarEssenceBottleModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
