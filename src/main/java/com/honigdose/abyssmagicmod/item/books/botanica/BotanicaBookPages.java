package com.honigdose.abyssmagicmod.item.books.botanica;

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
    TABLE_OF_CONTENTS("table_of_contents", 60, null,                     "table_of_contents_image.png"),
    INTRODUCTION     ("introduction",      60, "introduction.txt",       "botanica_book_template.png"),
    TOOLS            ("tools",             60, "introduction.txt",       "botanica_book_template.png"),
    RARITIES         ("rarities",          60, "introduction.txt",       "botanica_book_template.png"),
    MAGIC_INFO       ("magic_info",        60, "introduction.txt",       "botanica_book_template.png"),
    BIOM_INFO        ("biom_info",         60, "introduction.txt",       "botanica_book_template.png"),
    WARNINGS         ("warnings",          60, "introduction.txt",       "botanica_book_template.png"),
    ORES_CHAPTER     ("ores_chapter",      60, null,                     "botanica_book_template.png"),
    PLANTS_CHAPTER   ("plants_chapter",    60, null,                     "botanica_book_template.png"),
    TREES_CHAPTER    ("trees_chapter",     60, null,                     "botanica_book_template.png"),
    BIOMES_CHAPTER   ("biomes_chapter",    60, null,                     "botanica_book_template.png"),

    CRYSTAL_CHAPTER  ("crystal_chapter",   60, null,                     "botanica_crystal_chapter_template.png"),
    CRYSTAL          ("crystal",           60, null,                     "botanica_book_crystal1.png"),
    CRYSTAL_1        ("crystal_1",         60, "botanica_book_crystals.txt","botanica_book_crystal1.png"),
    CRYSTALS         ("crystals",          60, null,                     "botanica_book_crystals.png"),
    FIRE_CRYSTAL     ("fire_crystal",      60, null,                     "botanica_book_crystal_fire.png"),
    WATER_CRYSTAL    ("water_crystal",     60, null,                     "botanica_book_crystal_water.png"),
    AIR_CRYSTAL      ("air_crystal",       60, null,                     "botanica_book_crystal_air.png"),
    NATURE_CRYSTAL   ("nature_crystal",    60, null,                     "botanica_book_crystal_natur.png"),
    SOLAR_CRYSTAL    ("solar_crystal",     60, null,                     "botanica_book_crystal_solar.png"),
    LUNAR_CRYSTAL    ("lunar_crystal",     60, null,                     "botanica_book_crystal_lunar.png"),
    END              ("end",               60, null,                     "botanica_book_template.png");

    private final String tag;
    private final int tickInterval;
    private final ResourceLocation[] textures;
    private final String textFile;
    private String cachedText;

    BotanicaBookPages(String tag, int tickInterval, String textFile, String... texturePaths) {
        this.tag = tag;
        this.tickInterval = tickInterval;
        this.textFile = textFile;
        this.textures = Arrays.stream(texturePaths)
                .map(path -> ResourceLocation.fromNamespaceAndPath(
                        AbyssMagicMod.MOD_ID,
                        "textures/gui/botanica_book/" + path
                ))
                .toArray(ResourceLocation[]::new);
    }

    public String getTag() {
        return tag;
    }

    public ResourceLocation getCurrentTexture(int tickCount) {
        int idx = (tickCount / tickInterval) % textures.length;
        return textures[idx];
    }

    public String getPageText() {
        if (cachedText != null) return cachedText;
        if (textFile == null) return "";
        try {
            ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                    AbyssMagicMod.MOD_ID,
                    "lang/botanica/" + textFile
            );
            InputStream in = Minecraft.getInstance()
                    .getResourceManager()
                    .open(loc);
            cachedText = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            cachedText = "Text not found!";
        }
        return cachedText;
    }

    public int getPageIndex() {
        return this.ordinal();
    }

    public static BotanicaBookPages getByTag(String t) {
        return Arrays.stream(values())
                .filter(p -> p.tag.equals(t))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown tag: "+t));
    }
}
