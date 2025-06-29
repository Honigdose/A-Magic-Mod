package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    private void registerRareBlockRecipes(RecipeOutput recipeOutput) {

        IngottoBlock(recipeOutput, ModBlocks.ASTRATHYL_BLOCK.get(), ModItems.ASTRATHYL.get());
        IngottoBlock(recipeOutput, ModBlocks.ABYSSSTEEL_BLOCK.get(), ModItems.ABYSSSTEEL.get());
        IngottoBlock(recipeOutput, ModBlocks.BLOODGOLD_BLOCK.get(), ModItems.BLOODGOLD.get());
        IngottoBlock(recipeOutput, ModBlocks.CELESTIUM_BLOCK.get(), ModItems.CELESTIUM.get());
        IngottoBlock(recipeOutput, ModBlocks.FIRERYTE_BLOCK.get(), ModItems.FIRERYTE.get());
        IngottoBlock(recipeOutput, ModBlocks.SUIRYTE_BLOCK.get(), ModItems.SUIRYTE.get());
        IngottoBlock(recipeOutput, ModBlocks.FLORASTEEL_BLOCK.get(), ModItems.FLORASTEEL.get());
        IngottoBlock(recipeOutput, ModBlocks.SYLPHTHYL_BLOCK.get(), ModItems.SYLPHTHYL.get());
        IngottoBlock(recipeOutput, ModBlocks.LUNARIUM_BLOCK.get(), ModItems.LUNARIUM.get());
        IngottoBlock(recipeOutput, ModBlocks.SOLARIUM_BLOCK.get(), ModItems.SOLARIUM.get());
    }

    private void registerRareBlocktoIngotRecipes(RecipeOutput recipeOutput){

        BlocktoIngot(recipeOutput, ModItems.ASTRATHYL.get(), ModBlocks.ASTRATHYL_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.ABYSSSTEEL.get(), ModBlocks.ABYSSSTEEL_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.BLOODGOLD.get(), ModBlocks.BLOODGOLD_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.CELESTIUM.get(), ModBlocks.CELESTIUM_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.FIRERYTE.get(), ModBlocks.FIRERYTE_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.SUIRYTE.get(), ModBlocks.SUIRYTE_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.FLORASTEEL.get(), ModBlocks.FLORASTEEL_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.SYLPHTHYL.get(), ModBlocks.SYLPHTHYL_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.LUNARIUM.get(), ModBlocks.LUNARIUM_BLOCK.get());
        BlocktoIngot(recipeOutput, ModItems.SOLARIUM.get(), ModBlocks.SOLARIUM_BLOCK.get());
    }

    private void registerWoodRecipes(RecipeOutput recipeOutput){

        // TREE
        // Minecraft Wood Typs
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.OAK_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_OAK_LOG, Blocks.OAK_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.OAK_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_OAK_LOG, Blocks.OAK_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.BIRCH_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.BIRCH_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.SPRUCE_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.SPRUCE_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.DARK_OAK_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.DARK_OAK_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.JUNGLE_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.JUNGLE_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.ACACIA_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.ACACIA_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.CHERRY_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.CHERRY_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.MANGROVE_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.MANGROVE_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.CRIMSON_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.CRIMSON_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_PLANKS);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.WARPED_ALCHEMY_SHELF_JAR.get(), Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_PLANKS);
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.WARPED_ALCHEMY_SHELF_MIX.get(), Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_PLANKS);

        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_OAK.get(), Blocks.STRIPPED_OAK_LOG, Blocks.OAK_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_BIRCH.get(), Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_SPRUCE.get(), Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_DARK_OAK.get(), Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_JUNGLE.get(), Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_ACACIA.get(), Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_CHERRY.get(), Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_MANGROVE.get(), Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_CRIMSON.get(), Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_PLANKS);
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_WARPED.get(), Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_PLANKS);

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
        AlchemyShelfJarBlock(recipeOutput,  ModBlocks.SCARLET_ALCHEMY_SHELF_JAR.get(), ModBlocks.STRIPPED_SCARLET_TREE_LOG.get(), ModBlocks.SCARLET_TREE_PLANKS.get());
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.SCARLET_ALCHEMY_SHELF_MIX.get(), ModBlocks.STRIPPED_SCARLET_TREE_LOG.get(), ModBlocks.SCARLET_TREE_PLANKS.get());
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_SCARLET.get(), ModBlocks.STRIPPED_SCARLET_TREE_LOG.get(), ModBlocks.SCARLET_TREE_PLANKS.get());

        // LIFE TREE
        woodFromLogs(recipeOutput, ModBlocks.BLIFE_TREE_WOOD.get(), ModBlocks.BLIFE_TREE_LOG.get());
        planksFromLog(recipeOutput, ModBlocks.BLIFE_TREE_PLANKS.get(), ModBlocks.BLIFE_TREE_LOG.get());
        stairBuilder(ModBlocks.BLIFE_TREE_STAIR.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLIFE_TREE_SLAB.get(), ModBlocks.BLIFE_TREE_PLANKS.get());
        buttonBuilder(ModBlocks.BLIFE_TREE_BUTTON.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.BLIFE_TREE_PRESSURE_PLATE.get(), ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get());
        fenceBuilder(ModBlocks.BLIFE_TREE_FENCE.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLIFE_TREE_FENCE_GATE.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        doorBuilder(ModBlocks.BLIFE_TREE_DOOR.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLIFE_TREE_TRAPDOOR.get(), Ingredient.of(ModBlocks.BLIFE_TREE_PLANKS.get())).group("blife_tree_plank")
                .unlockedBy("has_blife_tree_plank", has(ModBlocks.BLIFE_TREE_PLANKS.get())).save(recipeOutput);
        AlchemyShelfJarBlock(recipeOutput, ModBlocks.BLT_ALCHEMY_SHELF_JAR.get(), ModBlocks.STRIPPED_BLIFE_TREE_LOG.get(), ModBlocks.BLIFE_TREE_PLANKS.get());
        AlchemyShelfMixBlock(recipeOutput, ModBlocks.BLT_ALCHEMY_SHELF_MIX.get(), ModBlocks.STRIPPED_BLIFE_TREE_LOG.get(), ModBlocks.BLIFE_TREE_PLANKS.get());
        ResearchTableBlock(recipeOutput, ModBlocks.RESEARCH_TABLE_BLIFE_TREE.get(), ModBlocks.STRIPPED_BLIFE_TREE_LOG.get(), ModBlocks.BLIFE_TREE_PLANKS.get());
    }


    private void registerAlchemyRecipes(RecipeOutput recipeOutput){

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INK_BOTTLE.get())
                .pattern(" B ")
                .pattern("ACA")
                .pattern(" A ")
                .define('A', Blocks.GLASS)
                .define('B', ItemTags.PLANKS)
                .define('C', Items.INK_SAC)
                .unlockedBy("has_ink_bottle", has(ModBlocks.INK_BOTTLE.get())).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMPTY_INK_BOTTLE.get())
                .pattern(" B ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', Blocks.GLASS)
                .define('B', ItemTags.PLANKS)
                .unlockedBy("has_empty_ink_bottle", has(ModBlocks.EMPTY_INK_BOTTLE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.INK_BOTTLE.get())
                .requires(ModBlocks.EMPTY_INK_BOTTLE.get())
                .requires(Items.INK_SAC)
                .unlockedBy("has_ink_bottle2", has(ModBlocks.INK_BOTTLE.get())).save(recipeOutput, "abyssmagicmod:ink_bottle2");


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CHALK.get(), 1)
                .requires(ModBlocks.MORTAR_AND_PESTLE.get())
                .requires(Items.WATER_BUCKET)
                .requires(Blocks.CALCITE)
                .unlockedBy("has_raw_chalk", has(ModItems.RAW_CHALK.get())).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.INK_SAC, 1)
                .requires(ModBlocks.INK_CAP.get())
                .unlockedBy("has_ink_cap", has(Items.INK_SAC)).save(recipeOutput);

    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        registerRareBlockRecipes(recipeOutput);
        registerRareBlocktoIngotRecipes(recipeOutput);
        registerWoodRecipes(recipeOutput);
        registerAlchemyRecipes(recipeOutput);


    }
    private void planksFromLog(RecipeOutput recipeOutput, Block planks, Block log) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                .requires(log)
                .unlockedBy("has_log", has(log))
                .save(recipeOutput);
    }

    private void IngottoBlock(RecipeOutput recipeOutput, Block ingotblock, Item ingot) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ingotblock)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ingot)
                .unlockedBy("has_ingot", has(ingot))
                .save(recipeOutput);

    }

    private void BlocktoIngot(RecipeOutput recipeOutput, Item ingot, Block ingotblock) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(ingotblock)
                .unlockedBy("has_ingotblock", has(ingotblock))
                .save(recipeOutput);

    }

    private void AlchemyShelfJarBlock(RecipeOutput recipeOutput, Block shelf, Block strippedlogs, Block planks) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shelf)
                .pattern("BAB")
                .pattern("ACA")
                .pattern("BAB")
                .define('A', planks)
                .define('B', strippedlogs)
                .define('C', ModTags.Items.BOTTLES)
                .unlockedBy("has_planksa", has(planks))
                .save(recipeOutput);

    }

    private void AlchemyShelfMixBlock(RecipeOutput recipeOutput, Block shelf, Block strippedlogs, Block planks) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shelf)
                .pattern("BAB")
                .pattern("ACA")
                .pattern("BAB")
                .define('A', planks)
                .define('B', strippedlogs)
                .define('C', Items.BOOK)
                .unlockedBy("has_planksb", has(planks))
                .save(recipeOutput);

    }

    private void ResearchTableBlock(RecipeOutput recipeOutput, Block shelf, Block strippedlogs, Block planks) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, shelf)
                .pattern("DCE")
                .pattern("AAA")
                .pattern("B B")
                .define('A', planks)
                .define('B', strippedlogs)
                .define('C', Items.BOOK)
                .define('D', ModBlocks.MORTAR_AND_PESTLE.get())
                .define('E', ModTags.Items.BOTTLES)
                .unlockedBy("has_planksc", has(planks))
                .save(recipeOutput);

    }


}
