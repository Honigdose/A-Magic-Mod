package com.honigdose.abyssmagicmod.block.essence.bottle.air;

import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class AirEssenceBottleRenderer extends GeoBlockRenderer<AirEssenceBottleEntity> {
    public AirEssenceBottleRenderer() {
        super(new AirEssenceBottleModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
