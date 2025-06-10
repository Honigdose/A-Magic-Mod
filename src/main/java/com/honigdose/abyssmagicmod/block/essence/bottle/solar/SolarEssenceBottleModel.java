package com.honigdose.abyssmagicmod.block.essence.bottle.solar;


import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class SolarEssenceBottleModel extends DefaultedBlockGeoModel<SolarEssenceBottleEntity> {
    public SolarEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "solar_essence_bottle"));
    }

}