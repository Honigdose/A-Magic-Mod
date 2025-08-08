package com.honigdose.abyssmagicmod.light;

import net.minecraft.world.entity.Entity;

public interface  IDynamicLightSource {
        Entity getAttachmentEntity();
        int getLightLevel();
}