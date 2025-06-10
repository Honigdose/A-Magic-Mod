package com.honigdose.abyssmagicmod.block.nature.glowingmushroom;

import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GlowingTreeMushroomRendere extends GeoBlockRenderer<GlowingTreeMushroomEntityBlock> {
    public GlowingTreeMushroomRendere() {
        super(new GlowingTreeMushroomModel());

        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));

    }
}
