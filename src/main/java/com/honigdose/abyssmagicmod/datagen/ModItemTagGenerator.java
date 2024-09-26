package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AbyssMagicMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SCARLET_TREE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get().asItem())
                .add(ModBlocks.SCARLET_TREE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get().asItem())

                .add(ModBlocks.LIFE_TREE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_LIFE_TREE_LOG.get().asItem())
                .add(ModBlocks.LIFE_TREE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_LIFE_TREE_WOOD.get().asItem());

    }
}
