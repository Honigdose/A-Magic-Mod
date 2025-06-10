package com.honigdose.abyssmagicmod.block.essence.bottle.fire;


import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class FireEssenceBottleModel extends DefaultedBlockGeoModel<FireEssenceBottleEntity> {
    public FireEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "fire_essence_bottle"));
    }

}