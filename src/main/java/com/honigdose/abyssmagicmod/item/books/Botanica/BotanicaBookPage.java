package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class BotanicaBookPage {
    private final int pageIndex;
    private final String tag;
    private final ResourceLocation[] textures;
    private final int tickInterval;

    public BotanicaBookPage(int pageIndex, String tag, int tickInterval, ResourceLocation... textures) {
        this.pageIndex = pageIndex;
        this.tag = tag;
        this.tickInterval = tickInterval;
        this.textures = textures;
    }

    public int getPageIndex() {
        return pageIndex;
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
