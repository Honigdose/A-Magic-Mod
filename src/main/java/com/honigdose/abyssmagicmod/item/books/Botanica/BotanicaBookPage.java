package com.honigdose.abyssmagicmod.item.books.Botanica;

import net.minecraft.resources.ResourceLocation;

public class BotanicaBookPage {
    private final int pageIndex;
    private final String tag;
    private boolean unlockedpage;
    private final ResourceLocation[] textures;
    private final int tickInterval;

    public BotanicaBookPage(int pageIndex, String tag, Boolean unlockedpage ,int tickInterval, ResourceLocation... textures) {
        this.pageIndex = pageIndex;
        this.tag = tag;
        this.unlockedpage = unlockedpage;
        this.tickInterval = tickInterval;
        this.textures = textures;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public String getTag() {
        return tag;
    }

    public boolean isUnlockedPage() {
        return unlockedpage;
    }

    public void setUnlockedPage(boolean unlocked) {
        this.unlockedpage = unlocked;
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

