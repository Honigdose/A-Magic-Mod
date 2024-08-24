package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
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
                .add(ModBlocks.FLORASTEEL_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ABYSSSTEEL_ORE.get())
                .add(ModBlocks.SYLPHTHYL_ORE.get())
                .add(ModBlocks.SUIRYTE_ORE.get())
                .add(ModBlocks.SOLARIUM_ORE.get())
                .add(ModBlocks.LUNARIUM_ORE.get())
                .add(ModBlocks.FIRERYTE_ORE.get())
                .add(ModBlocks.FLORASTEEL_ORE.get());
    }
}
