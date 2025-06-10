package com.honigdose.abyssmagicmod.block.essence.bottle.fire;

import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class FireEssenceBottleRenderer extends GeoBlockRenderer<FireEssenceBottleEntity> {
    public FireEssenceBottleRenderer() {
        super(new FireEssenceBottleModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
