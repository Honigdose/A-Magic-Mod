package com.honigdose.abyssmagicmod.block.essence.bottle.lunar;


import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class LunarEssenceBottleModel extends DefaultedBlockGeoModel<LunarEssenceBottleEntity> {
    public LunarEssenceBottleModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "lunar_essence_bottle"));
    }

}