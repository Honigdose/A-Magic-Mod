package com.honigdose.abyssmagicmod.block.essence.bottle.lunar;

import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;


public class LunarEssenceBottleRenderer extends GeoBlockRenderer<LunarEssenceBottleEntity> {
    public LunarEssenceBottleRenderer() {
        super(new LunarEssenceBottleModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
