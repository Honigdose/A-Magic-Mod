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

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRERYTE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.FIRERYTE.get())
                .unlockedBy("has_fireryte", has(ModItems.FIRERYTE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRERYTE.get(), 9)
                .requires(ModBlocks.FIRERYTE_BLOCK.get())
                .unlockedBy("has_fireryte_block", has(ModBlocks.FIRERYTE_BLOCK.get())).save(recipeOutput);


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
        

    }
    private void planksFromLog(RecipeOutput recipeOutput, Block planks, Block log) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .requires(log)
                .unlockedBy("has_log", has(log))
                .save(recipeOutput);
    }
}
