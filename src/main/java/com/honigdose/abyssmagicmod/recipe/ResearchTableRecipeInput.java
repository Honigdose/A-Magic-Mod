package com.honigdose.abyssmagicmod.recipe;

import com.honigdose.abyssmagicmod.item.books.Botanica.BotanicaBookPage;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ResearchTableRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int pIndex) {
        return input;
    }

    @Override
    public int size() {
        return 0;
    }

}