package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum BotanicaBookPages {
    TABLE_OF_CONTENTS(0, "table_of_contents", true, 60, "table_of_contents.txt","botanica_book_template.png"),
    INTRODUCTION(1, "introduction", true, 60, "introduction.txt","botanica_book_template.png"),
    UWU(2, "uwu", true, 60,"uwu.txt", "botanica_book_template_page1.png"),
    OWO(3, "owo", true, 60, null,"botanica_book_template_page2.png"),
    ANIMATED_PAGE(4, "animatedPage", true, 3,null, "botanica_book_template_page3.1.png", "botanica_book_template_page3.2.png"),
    CRYSTAL_2(5, "crystal_2", true, 60,null, "botanica_book_crystal2.png"),
    CRYSTAL(6, "crystal", true, 60,null, "botanica_book_crystal.png"),
    FIRE_CRYSTAL(7, "fire_crystal", false, 60,null, "botanica_book_crystal_fire.png"),
    WATER_CRYSTAL(8, "water_crystal", false, 60,null, "botanica_book_crystal_water.png"),
    END(9, "end", true, 60,null, "botanica_book_template.png");

    private final int pageIndex;
    private final String tag;
    private boolean unlockedPage;
    private final int tickInterval;
    private final ResourceLocation[] textures;
    private final String textFile ;
    private String cachedText = null;

    BotanicaBookPages(int pageIndex, String tag, boolean unlockedPage, int tickInterval,  String textFile, String... texturePaths) {
        this.pageIndex = pageIndex;
        this.tag = tag;
        this.unlockedPage = unlockedPage;
        this.tickInterval = tickInterval;
        this.textFile = textFile;
        this.textures = Arrays.stream(texturePaths)
                .map(path -> ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/" + path))
                .toArray(ResourceLocation[]::new);

    }

    public int getPageIndex() {
        return pageIndex;
    }

    public String getPageText() {
        if (cachedText != null) return cachedText;

        if (textFile == null) return "";

        try {
            ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "lang/botanica/" + textFile);
            InputStream inputStream = Minecraft.getInstance().getResourceManager().open(location);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            cachedText = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
        } catch (IOException e) {
            cachedText = "Text not found!";
        }
        return cachedText;
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