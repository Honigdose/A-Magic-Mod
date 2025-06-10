package com.honigdose.abyssmagicmod.block.essence.bottle.water;


import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class WaterEssenceBottleModel extends DefaultedBlockGeoModel<WaterEssenceBottleEntity> {
    public WaterEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "water_essence_bottle"));
    }

}