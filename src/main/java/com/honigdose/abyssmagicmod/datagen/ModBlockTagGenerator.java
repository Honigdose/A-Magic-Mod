package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AbyssMagicMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ABYSSSTEEL_ORE.get())
                .add(ModBlocks.SYLPHTHYL_ORE.get())
                .add(ModBlocks.SUIRYTE_ORE.get())
                .add(ModBlocks.SOLARIUM_ORE.get())
                .add(ModBlocks.LUNARIUM_ORE.get())
                .add(ModBlocks.FIRERYTE_ORE.get())
                .add(ModBlocks.FLORASTEEL_ORE.get())

                .add(ModBlocks.FIRE_CRYSTAL_BLOCK.get())
                .add(ModBlocks.WATER_CRYSTAL_BLOCK.get())
                .add(ModBlocks.AIR_CRYSTAL_BLOCK.get())
                .add(ModBlocks.NATURE_CRYSTAL_BLOCK.get())
                .add(ModBlocks.SOLAR_CRYSTAL_BLOCK.get())
                .add(ModBlocks.LUNAR_CRYSTAL_BLOCK.get())
                .add(ModBlocks.VOID_CRYSTAL_BLOCK.get())
                .add(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get())
                .add(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get())
                .add(ModBlocks.ARCANA_CRYSTAL_BLOCK.get())

                .add(ModBlocks.VERY_SMALL_FIRE_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_AIR_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_NATURE_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_VOID_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL.get())
                .add(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL.get())

                .add(ModBlocks.SMALL_FIRE_CRYSTAL.get())
                .add(ModBlocks.SMALL_AIR_CRYSTAL.get())
                .add(ModBlocks.SMALL_WATER_CRYSTAL.get())
                .add(ModBlocks.SMALL_NATURE_CRYSTAL.get())
                .add(ModBlocks.SMALL_SOLAR_CRYSTAL.get())
                .add(ModBlocks.SMALL_LUNAR_CRYSTAL.get())
                .add(ModBlocks.SMALL_VOID_CRYSTAL.get())
                .add(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get())
                .add(ModBlocks.SMALL_DEMONIC_CRYSTAL.get())
                .add(ModBlocks.SMALL_ARCANA_CRYSTAL.get())

                .add(ModBlocks.FIRE_CRYSTAL.get())
                .add(ModBlocks.AIR_CRYSTAL.get())
                .add(ModBlocks.WATER_CRYSTAL.get())
                .add(ModBlocks.NATURE_CRYSTAL.get())
                .add(ModBlocks.SOLAR_CRYSTAL.get())
                .add(ModBlocks.LUNAR_CRYSTAL.get())
                .add(ModBlocks.VOID_CRYSTAL.get())
                .add(ModBlocks.CELESTIAL_CRYSTAL.get())
                .add(ModBlocks.DEMONIC_CRYSTAL.get())
                .add(ModBlocks.ARCANA_CRYSTAL.get())

                .add(ModBlocks.BABY_FIRE_CRYSTAL.get())
                .add(ModBlocks.BABY_AIR_CRYSTAL.get())
                .add(ModBlocks.BABY_WATER_CRYSTAL.get())
                .add(ModBlocks.BABY_NATURE_CRYSTAL.get())
                .add(ModBlocks.BABY_SOLAR_CRYSTAL.get())
                .add(ModBlocks.BABY_LUNAR_CRYSTAL.get())
                .add(ModBlocks.BABY_VOID_CRYSTAL.get())
                .add(ModBlocks.BABY_CELESTIAL_CRYSTAL.get())
                .add(ModBlocks.BABY_DEMONIC_CRYSTAL.get())
                .add(ModBlocks.BABY_ARCANA_CRYSTAL.get())

                .add(ModBlocks.LARGE_FIRE_CRYSTAL.get())
                .add(ModBlocks.LARGE_AIR_CRYSTAL.get())
                .add(ModBlocks.LARGE_WATER_CRYSTAL.get())
                .add(ModBlocks.LARGE_NATURE_CRYSTAL.get())
                .add(ModBlocks.LARGE_SOLAR_CRYSTAL.get())
                .add(ModBlocks.LARGE_LUNAR_CRYSTAL.get())
                .add(ModBlocks.LARGE_VOID_CRYSTAL.get())
                .add(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get())
                .add(ModBlocks.LARGE_DEMONIC_CRYSTAL.get())
                .add(ModBlocks.LARGE_ARCANA_CRYSTAL.get())

                .add(ModBlocks.SILVER_ORE_STONE.get())
                .add(ModBlocks.FIRE_SILVER_ORE_STONE.get())
                .add(ModBlocks.WATER_SILVER_ORE_STONE.get())
                .add(ModBlocks.AIR_SILVER_ORE_STONE.get())
                .add(ModBlocks.NATURE_SILVER_ORE_STONE.get())
                .add(ModBlocks.SOLAR_SILVER_ORE_STONE.get())
                .add(ModBlocks.LUNAR_SILVER_ORE_STONE.get())

                .add(ModBlocks.SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.WATER_SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.AIR_SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.NATURE_SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE.get())
                .add(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE.get())

                .add(ModBlocks.FIRE_GOLD_ORE_STONE.get())
                .add(ModBlocks.WATER_GOLD_ORE_STONE.get())
                .add(ModBlocks.AIR_GOLD_ORE_STONE.get())
                .add(ModBlocks.NATURE_GOLD_ORE_STONE.get())
                .add(ModBlocks.SOLAR_GOLD_ORE_STONE.get())
                .add(ModBlocks.LUNAR_GOLD_ORE_STONE.get())

                .add(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE.get())
                .add(ModBlocks.WATER_GOLD_ORE_DEEPSLATE.get())
                .add(ModBlocks.AIR_GOLD_ORE_DEEPSLATE.get())
                .add(ModBlocks.NATURE_GOLD_ORE_DEEPSLATE.get())
                .add(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE.get())
                .add(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)

                .add(ModBlocks.SCARLET_TREE_PLANKS.get())
                .add(ModBlocks.SCARLET_TREE_SLAB.get())
                .add(ModBlocks.SCARLET_TREE_STAIR.get())
                .add(ModBlocks.SCARLET_TREE_BUTTON.get())
                .add(ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get())
                .add(ModBlocks.BLIFE_TREE_PLANKS.get())
                .add(ModBlocks.BLIFE_TREE_SLAB.get())
                .add(ModBlocks.BLIFE_TREE_STAIR.get())
                .add(ModBlocks.BLIFE_TREE_BUTTON.get())
                .add(ModBlocks.BLIFE_TREE_PRESSURE_PLATE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SCARLET_TREE_LOG.get())
                .add(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get())
                .add(ModBlocks.SCARLET_TREE_WOOD.get())
                .add(ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get())

                .add(ModBlocks.BLIFE_TREE_LOG.get())
                .add(ModBlocks.STRIPPED_BLIFE_TREE_LOG.get())
                .add(ModBlocks.BLIFE_TREE_WOOD.get())
                .add(ModBlocks.STRIPPED_BLIFE_TREE_WOOD.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.SCARLET_TREE_FENCE.get())
                .add(ModBlocks.BLIFE_TREE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SCARLET_TREE_FENCE_GATE.get())
                .add(ModBlocks.BLIFE_TREE_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SCARLET_TREE_WALL.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.SCARLET_TREE_LEAVES.get())
                .add(ModBlocks.LIFE_TREE_LEAVES.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ABYSSSTEEL_ORE.get())
                .add(ModBlocks.SYLPHTHYL_ORE.get())
                .add(ModBlocks.SUIRYTE_ORE.get())
                .add(ModBlocks.SOLARIUM_ORE.get())
                .add(ModBlocks.LUNARIUM_ORE.get())
                .add(ModBlocks.FIRERYTE_ORE.get())
                .add(ModBlocks.FLORASTEEL_ORE.get());

        this.tag(ModTags.Blocks.RESEARCH_TABLES)
                .add(ModBlocks.RESEARCH_TABLE_ACACIA.get())
                .add(ModBlocks.RESEARCH_TABLE_CRIMSON.get())
                .add(ModBlocks.RESEARCH_TABLE_SPRUCE.get())
                .add(ModBlocks.RESEARCH_TABLE_CHERRY.get())
                .add(ModBlocks.RESEARCH_TABLE_MANGROVE.get())
                .add(ModBlocks.RESEARCH_TABLE_OAK.get())
                .add(ModBlocks.RESEARCH_TABLE_JUNGLE.get())
                .add(ModBlocks.RESEARCH_TABLE_SCARLET.get())
                .add(ModBlocks.RESEARCH_TABLE_WARPED.get())
                .add(ModBlocks.RESEARCH_TABLE_BIRCH.get())
                .add(ModBlocks.RESEARCH_TABLE_DARK_OAK.get())
                .add(ModBlocks.RESEARCH_TABLE_SCARLET.get())
                .add(ModBlocks.RESEARCH_TABLE_BLIFE_TREE.get());

    }
}
