package com.honigdose.abyssmagicmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;



public record ResearchTableRecipe(ResourceLocation id, Ingredient inputItem) implements Recipe<ResearchTableRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public boolean matches(ResearchTableRecipeInput researchTableRecipeInput, Level level) {
        if(level.isClientSide()) {
            return false;
        }
        return inputItem.test(researchTableRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(ResearchTableRecipeInput researchTableRecipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.RESEARCH_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.RESEARCH_TYPE.get();
    }


    public static class Serializer implements RecipeSerializer<ResearchTableRecipe> {
        public static final MapCodec<ResearchTableRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                ResourceLocation.CODEC.fieldOf("id").forGetter(ResearchTableRecipe::id),
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(ResearchTableRecipe::inputItem)
        ).apply(inst, ResearchTableRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ResearchTableRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, ResearchTableRecipe::id,
                        Ingredient.CONTENTS_STREAM_CODEC, ResearchTableRecipe::inputItem                                                                                                                                                                                                                                                                ,
                        ResearchTableRecipe::new);
        @Override
        public MapCodec<ResearchTableRecipe> codec() {
            return CODEC;
        }
        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ResearchTableRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}