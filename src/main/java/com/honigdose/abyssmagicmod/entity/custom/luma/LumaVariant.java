package com.honigdose.abyssmagicmod.entity.custom.luma;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public enum LumaVariant {
    SOLAR(0, new Color(255, 220, 0)),
    LUNAR(1, new Color(180, 60, 255)),
    FIRE(2, new Color(255, 151, 60)),
    WATER(3, new Color(60, 122, 255)),
    NATURE(4, new Color(161, 255, 60)),
    AIR(5, new Color(60, 255, 196)),
    DEMONIC(6, new Color(221, 22, 22)),
    CELESTIAL(7, new Color(247, 159, 255)),
    BASE(7, new Color(255, 255, 255));

    private static final LumaVariant[] BY_ID = Arrays.stream(values())
            .sorted(Comparator.comparingInt(LumaVariant::getId))
            .toArray(LumaVariant[]::new);

    private final int id;
    private final Color color;

    LumaVariant(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public Color getColor() {
        return this.color;
    }

    public static LumaVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
