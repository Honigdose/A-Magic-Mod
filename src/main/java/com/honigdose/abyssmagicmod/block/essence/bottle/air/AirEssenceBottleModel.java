package com.honigdose.abyssmagicmod.block.essence.bottle.air;


import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class AirEssenceBottleModel extends DefaultedBlockGeoModel<AirEssenceBottleEntity> {
    public AirEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "air_essence_bottle"));
    }

}