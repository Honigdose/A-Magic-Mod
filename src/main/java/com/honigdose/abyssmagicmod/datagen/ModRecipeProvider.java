package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    private void registerBlockRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ.get())
                .unlockedBy("has_magessenz", has(ModItems.MAGESSENZ.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_AIRTYP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_AIRTYP.get())
                .unlockedBy("has_magessenz_airtyp", has(ModItems.MAGESSENZ_AIRTYP.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_WATERTYP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_WATERTYP.get())
                .unlockedBy("has_magessenz_watertyp", has(ModItems.MAGESSENZ_WATERTYP.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_FIRETYPE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_FIRETYP.get())
                .unlockedBy("has_magessenz_firetype", has(ModItems.MAGESSENZ_FIRETYP.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_NATURTYP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_NATURTYP.get())
                .unlockedBy("has_magessenz_naturtyp", has(ModItems.MAGESSENZ_NATURTYP.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_LUNARTYP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_LUNARTYP.get())
                .unlockedBy("has_magessenz_lunartyp", has(ModItems.MAGESSENZ_LUNARTYP.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGESSENZ_BLOCK_SOLARTYP.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MAGESSENZ_SOLARTYP.get())
                .unlockedBy("has_magessenz_solartyp", has(ModItems.MAGESSENZ_SOLARTYP.get()))
                .save(recipeOutput);
    }

    private void registerBlocktoIngotRecipes(RecipeOutput recipeOutput){

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK.get())
                .unlockedBy("has_magessenz_block", has(ModBlocks.MAGESSENZ_BLOCK.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_WATERTYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_WATERTYP.get())
                .unlockedBy("has_magessenz_block_watertyp", has(ModBlocks.MAGESSENZ_BLOCK_WATERTYP.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_AIRTYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_AIRTYP.get())
                .unlockedBy("has_magessenz_block_airtyp", has(ModBlocks.MAGESSENZ_BLOCK_AIRTYP.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_FIRETYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_FIRETYPE.get())
                .unlockedBy("has_magessenz_block_firetyp", has(ModBlocks.MAGESSENZ_BLOCK_FIRETYPE.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_NATURTYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_NATURTYP.get())
                .unlockedBy("has_magessenz_block_naturtyp", has(ModBlocks.MAGESSENZ_BLOCK_NATURTYP.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_SOLARTYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_SOLARTYP.get())
                .unlockedBy("has_magessenz_block_solartyp", has(ModBlocks.MAGESSENZ_BLOCK_SOLARTYP.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGESSENZ_LUNARTYP.get(), 9)
                .requires(ModBlocks.MAGESSENZ_BLOCK_LUNARTYP.get())
                .unlockedBy("has_magessenz_block_lunartyp", has(ModBlocks.MAGESSENZ_BLOCK_LUNARTYP.get()))
                .save(recipeOutput);
    }

    private void registerWoodRecipes(RecipeOutput recipeOutput){

        // TREE
        // SCARLET TREE
        woodFromLogs(recipeOutput, ModBlocks.SCARLET_TREE_WOOD.get(), ModBlocks.SCARLET_TREE_LOG.get());
        planksFromLog(recipeOutput, ModBlocks.SCARLET_TREE_PLANKS.get(), ModBlocks.SCARLET_TREE_LOG.get());
        stairBuilder(ModBlocks.SCARLET_TREE_STAIR.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCARLET_TREE_SLAB.get(), ModBlocks.SCARLET_TREE_PLANKS.get());
        buttonBuilder(ModBlocks.SCARLET_TREE_BUTTON.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get(), ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get());
        fenceBuilder(ModBlocks.SCARLET_TREE_FENCE.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.SCARLET_TREE_FENCE_GATE.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCARLET_TREE_WALL.get(), ModBlocks.SCARLET_TREE_PLANKS.get());
        doorBuilder(ModBlocks.SCARLET_TREE_DOOR.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.SCARLET_TREE_TRAPDOOR.get(), Ingredient.of(ModBlocks.SCARLET_TREE_PLANKS.get())).group("scarlet_tree_plank")
                .unlockedBy("has_scarlet_tree_plank", has(ModBlocks.SCARLET_TREE_PLANKS.get())).save(recipeOutput);

        // LIFE TREE
        woodFromLogs(recipeOutput, ModBlocks.LIFE_TREE_WOOD.get(), ModBlocks.LIFE_TREE_LOG.get());
        planksFromLog(recipeOutput, ModBlocks.LIFE_TREE_PLANKS.get(), ModBlocks.LIFE_TREE_LOG.get());
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        registerBlockRecipes(recipeOutput);
        registerBlocktoIngotRecipes(recipeOutput);
        registerWoodRecipes(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRERYTE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.FIRERYTE.get())
                .unlockedBy("has_fireryte", has(ModItems.FIRERYTE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRERYTE.get(), 9)
                .requires(ModBlocks.FIRERYTE_BLOCK.get())
                .unlockedBy("has_fireryte_block", has(ModBlocks.FIRERYTE_BLOCK.get())).save(recipeOutput);



    }
    private void planksFromLog(RecipeOutput recipeOutput, Block planks, Block log) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .requires(log)
                .unlockedBy("has_log", has(log))
                .save(recipeOutput);
    }
}
