package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;


public enum BotanicaBookPages {
    TABLE_OF_CONTENTS( "table_of_contents", true, 60, null, "table_of_contents_image.png"),
    INTRODUCTION( "introduction", true, 60, "introduction.txt", "botanica_book_template.png"),
    TOOLS( "tools", true, 60, "introduction.txt", "botanica_book_template.png"),
    RARITIES( "rarities", true, 60, "introduction.txt", "botanica_book_template.png"),
    MAGIC_INFO( "magic_info", true, 60, "introduction.txt", "botanica_book_template.png"),
    BIOM_INFO( "biom_info", true, 60, "introduction.txt", "botanica_book_template.png"),
    WARNINGS( "warnings", true, 60, "introduction.txt", "botanica_book_template.png"),
    ORES_CHAPTER( "ores_chapter", true, 60, null, "botanica_book_template.png"),
    PLANTS_CHAPTER( "plants_chapter", true, 60, null, "botanica_book_template.png"),
    TREES_CHAPTER( "trees_chapter", true, 60, null, "botanica_book_template.png"),
    BIOMES_CHAPTER( "biomes_chapter", true, 60, null, "botanica_book_template.png"),


    CRYSTAL_CHAPTER( "crystal_chapter", true, 60, null, "botanica_crystal_chapter_template.png"),
    CRYSTAL( "crystal", true, 60,  null, "botanica_book_crystal1.png"),
    CRYSTAL_1( "crystal_1", true, 60, "botanica_book_crystals.txt", "botanica_book_crystal1.png"),
    CRYSTALS( "crystals", true, 60, null, "botanica_book_crystals.png"),
    FIRE_CRYSTAL( "fire_crystal", false, 60, null, "botanica_book_crystal_fire.png"),
    WATER_CRYSTAL("water_crystal", false, 60, null, "botanica_book_crystal_water.png"),
    AIR_CRYSTAL("air_crystal", false, 60, null, "botanica_book_crystal_air.png"),
    NATURE_CRYSTAL("nature_crystal", false, 60, null, "botanica_book_crystal_natur.png"),
    SOLAR_CRYSTAL("solar_crystal", false, 60, null, "botanica_book_crystal_solar.png"),
    LUNAR_CRYSTAL("lunar_crystal", false, 60, null, "botanica_book_crystal_lunar.png"),
    END( "end", true, 60, null, "botanica_book_template.png");


    private final String tag;
    private boolean unlockedPage;
    private final int tickInterval;
    private final ResourceLocation[] textures;
    private final String textFile;
    private String cachedText = null;

    BotanicaBookPages( String tag, boolean unlockedPage, int tickInterval, String textFile, String... texturePaths) {
        this.tag = tag;
        this.unlockedPage = unlockedPage;
        this.tickInterval = tickInterval;
        this.textFile = textFile;
        this.textures = Arrays.stream(texturePaths)
                .map(path -> ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/" + path))
                .toArray(ResourceLocation[]::new);

    }

    public int getPageIndex() {
        return ordinal();
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

    public static BotanicaBookPages getByTag(String tag) {
        return Arrays.stream(values())
                .filter(page -> page.getTag().equals(tag))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid page tag: " + tag));

    }
}