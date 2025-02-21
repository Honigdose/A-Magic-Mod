package com.honigdose.abyssmagicmod.data.BookData;

import net.minecraft.resources.ResourceLocation;

public class TransitionsAnimations{
    private final String tag;
    private final ResourceLocation[] textures;
    private final int tickInterval;

    public TransitionsAnimations( String tag, int tickInterval, ResourceLocation... textures) {
        this.tag = tag;
        this.tickInterval = tickInterval;
        this.textures = textures;
    }

    public String getTag() {
        return tag;
    }

    public ResourceLocation[] getTextures() {
        return textures;
    }

    public ResourceLocation getCurrentTexture(int tickCount) {
        if (textures.length == 0) {
            throw new IllegalStateException("No textures available for this page.");
        }
        int textureIndex = (tickCount / tickInterval) % textures.length; // Zyklisch wechseln
        return textures[textureIndex];
    }

}
