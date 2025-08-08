package com.honigdose.abyssmagicmod.item.books.alchemybooks.book1;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;


public enum AlchemyBook1Pages {
    TABLE_OF_CONTENTS("table_of_contents", 60, null),
    INTRODUCTION     ("introduction",      60, "introduction.txt", "alchemy_book_uwu.png"),
    END              ("end",               60, null);

    private final String tag;
    private final int tickInterval;
    private final ResourceLocation[] textures;
    private final String textFile;
    private String cachedText;

    AlchemyBook1Pages(String tag, int tickInterval, String textFile, String... texturePaths) {
        this.tag = tag;
        this.tickInterval = tickInterval;
        this.textFile = textFile;
        this.textures = Arrays.stream(texturePaths)
                .map(path -> ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,
                        "textures/gui/alchemy_book/" + path))
                .toArray(ResourceLocation[]::new);
    }

    public String getTag() { return tag; }

    public boolean hasOverlay() {
        return textures.length > 0;
    }

    @Nullable
    public ResourceLocation getTexture(int tickCount) {
        if (!hasOverlay()) return null;
        int idx = (tickCount / tickInterval) % textures.length;
        return textures[idx];
    }

    public String getPageText() {
        if (cachedText != null) return cachedText;
        if (textFile == null) return "";
        try {
            ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                    AbyssMagicMod.MOD_ID,
                    "lang/alchemy_book/" + textFile
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

    public static AlchemyBook1Pages getByTag(String t) {
        return Arrays.stream(values())
                .filter(p -> p.tag.equals(t))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown tag: "+t));
    }
}
