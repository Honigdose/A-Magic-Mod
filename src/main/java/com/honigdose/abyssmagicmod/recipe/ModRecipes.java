package com.honigdose.abyssmagicmod.recipe;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AbyssMagicMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, AbyssMagicMod.MOD_ID);


    public static final RegistryObject<RecipeSerializer<ResearchTableRecipe>> RESEARCH_SERIALIZER =
            SERIALIZERS.register("researching", ResearchTableRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<ResearchTableRecipe>> RESEARCH_TYPE =
            TYPES.register("researching", () -> new RecipeType<ResearchTableRecipe>() {
                @Override
                public String toString() {
                    return "researching";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}