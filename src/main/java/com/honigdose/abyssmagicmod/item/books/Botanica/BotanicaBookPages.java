package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.resources.ResourceLocation;

import java.util.Arrays;

public enum BotanicaBookPages {
    TEMPLATE(0, "template", true, 60, "botanica_book_template.png"),
    UWU(1, "uwu", false, 60, "botanica_book_template_page1.png"),
    OWO(2, "owo", false, 60, "botanica_book_template_page2.png"),
    ANIMATED_PAGE(3, "animatedPage", false, 3, "botanica_book_template_page3.1.png", "botanica_book_template_page3.2.png"),
    CRYSTAL_2(4, "crystal_2", true, 60, "botanica_book_crystal2.png"),
    CRYSTAL(5, "crystal", true, 60, "botanica_book_crystal.png"),
    FIRE_CRYSTAL(6, "fire_crystal", false, 60, "botanica_book_crystal_fire.png"),
    WATER_CRYSTAL(7, "water_crystal", false, 60, "botanica_book_crystal_water.png"),
    END(8, "end", true, 60, "botanica_book_template.png");

    private final int pageIndex;
    private final String tag;
    private boolean unlockedPage;
    private final int tickInterval;
    private final ResourceLocation[] textures;

    BotanicaBookPages(int pageIndex, String tag, boolean unlockedPage, int tickInterval, String... texturePaths) {
        this.pageIndex = pageIndex;
        this.tag = tag;
        this.unlockedPage = unlockedPage;
        this.tickInterval = tickInterval;
        this.textures = Arrays.stream(texturePaths)
                .map(path -> ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/" + path))
                .toArray(ResourceLocation[]::new);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public String getTag() {
        return tag;
    }

    public boolean isUnlockedPage() {
        return unlockedPage;
    }

    public void setUnlockedPage(boolean unlocked) {
        this.unlockedPage = unlocked;
    }

    public ResourceLocation getCurrentTexture(int tickCount) {
        if (textures.length == 0) {
            throw new IllegalStateException("No textures available for this page.");
        }
        int textureIndex = (tickCount / tickInterval) % textures.length;
        return textures[textureIndex];
    }

    public static BotanicaBookPages getByIndex(int index) {
        return Arrays.stream(values())
                .filter(page -> page.getPageIndex() == index)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid page index: " + index));
    }
}
