package com.honigdose.abyssmagicmod.block.essence.bottle.nature;


import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class NatureEssenceBottleModel extends DefaultedBlockGeoModel<NatureEssenceBottleEntity> {
    public NatureEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "nature_essence_bottle"));
    }

}