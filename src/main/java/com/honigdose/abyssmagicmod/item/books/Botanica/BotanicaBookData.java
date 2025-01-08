package com.honigdose.abyssmagicmod.item.books.Botanica;


import java.util.HashSet;
import java.util.Set;

public class BotanicaBookData {

    private static final Set<Integer> unlockedPages = new HashSet<>();

    public static void unlockPage(int page) {
        unlockedPages.add(page);
    }

    public static boolean isPageUnlocked(int page) {
        return unlockedPages.contains(page);
    }

    public static void resetUnlocks() {
        unlockedPages.clear();
    }
}
