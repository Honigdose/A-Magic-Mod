package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Calendar;
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

                .add(ModBlocks.BLIFE_TREE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BLIFE_TREE_LOG.get().asItem())
                .add(ModBlocks.BLIFE_TREE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BLIFE_TREE_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add((ModBlocks.BLIFE_TREE_PLANKS.get().asItem()))
                .add((ModBlocks.SCARLET_TREE_PLANKS.get().asItem()));

        this.tag(ItemTags.SAPLINGS)
                .add((ModBlocks.SCARLET_TREE_SAPLING.get().asItem()))
                .add((ModBlocks.LIFE_TREE_SAPLING.get().asItem()));

        this.tag(ItemTags.LEAVES)
                .add((ModBlocks.BLIFE_TREE_WATER_LEAVES.get().asItem()))
                .add((ModBlocks.BLIFE_TREE_FIRE_LEAVES.get().asItem()))
                .add((ModBlocks.SCARLET_TREE_LEAVES.get().asItem()));

        this.tag(ModTags.Items.BOTTLES)
                .add((ModBlocks.MAGIC_ROUND_BOTTLE.get().asItem()))
                .add((ModBlocks.MAGIC_SQUARE_BOTTLE.get().asItem()))
                .add((ModBlocks.MAGIC_TRIANGLE_BOTTLE.get().asItem()))
                .add((Items.GLASS_BOTTLE.asItem()));

        this.tag(ModTags.Items.CRYSTALS)
                .add(Item.byBlock(ModBlocks.WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.WATER_CRYSTAL_BLOCK.get()))
                .add(ModItems.WATER_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.FIRE_CRYSTAL_BLOCK.get()))
                .add(ModItems.FIRE_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.AIR_CRYSTAL_BLOCK.get()))
                .add(ModItems.AIR_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.NATURE_CRYSTAL_BLOCK.get()))
                .add(ModItems.NATURE_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SOLAR_CRYSTAL_BLOCK.get()))
                .add(ModItems.SOLAR_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LUNAR_CRYSTAL_BLOCK.get()))
                .add(ModItems.LUNAR_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get()))
                .add(ModItems.CELESTIAL_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get()))
                .add(ModItems.DEMONIC_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.VOID_CRYSTAL_BLOCK.get()))
                .add(ModItems.VOID_CRYSTAL_SHARD.get())
                .add(Item.byBlock(ModBlocks.ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.ARCANA_CRYSTAL_BLOCK.get()))
                .add(ModItems.ARCANA_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.WATER_CRYSTALS)
                .add(Item.byBlock(ModBlocks.WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_WATER_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.WATER_CRYSTAL_BLOCK.get()))
                .add(ModItems.WATER_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.FIRE_CRYSTALS)
                .add(Item.byBlock(ModBlocks.FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_FIRE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.FIRE_CRYSTAL_BLOCK.get()))
                .add(ModItems.FIRE_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.CELESTIAL_CRYSTALS)
                .add(Item.byBlock(ModBlocks.CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get()))
                .add(ModItems.CELESTIAL_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.AIR_CRYSTALS)
                .add(Item.byBlock(ModBlocks.AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_AIR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.AIR_CRYSTAL_BLOCK.get()))
                .add(ModItems.AIR_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.NATURE_CRYSTALS)
                .add(Item.byBlock(ModBlocks.NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_NATURE_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.NATURE_CRYSTAL_BLOCK.get()))
                .add(ModItems.NATURE_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.LUNAR_CRYSTALS)
                .add(Item.byBlock(ModBlocks.LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_LUNAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LUNAR_CRYSTAL_BLOCK.get()))
                .add(ModItems.LUNAR_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.SOLAR_CRYSTALS)
                .add(Item.byBlock(ModBlocks.SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_SOLAR_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SOLAR_CRYSTAL_BLOCK.get()))
                .add(ModItems.SOLAR_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.DEMONIC_CRYSTALS)
                .add(Item.byBlock(ModBlocks.DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_DEMONIC_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get()))
                .add(ModItems.DEMONIC_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.VOID_CRYSTALS)
                .add(Item.byBlock(ModBlocks.VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_VOID_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.VOID_CRYSTAL_BLOCK.get()))
                .add(ModItems.VOID_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.ARCANA_CRYSTALS)
                .add(Item.byBlock(ModBlocks.ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.BABY_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.SMALL_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.LARGE_ARCANA_CRYSTAL.get()))
                .add(Item.byBlock(ModBlocks.ARCANA_CRYSTAL_BLOCK.get()))
                .add(ModItems.ARCANA_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.CRYSTAL_SHARDS)
                .add(ModItems.WATER_CRYSTAL_SHARD.get())
                .add(ModItems.AIR_CRYSTAL_SHARD.get())
                .add(ModItems.NATURE_CRYSTAL_SHARD.get())
                .add(ModItems.SOLAR_CRYSTAL_SHARD.get())
                .add(ModItems.LUNAR_CRYSTAL_SHARD.get())
                .add(ModItems.CELESTIAL_CRYSTAL_SHARD.get())
                .add(ModItems.DEMONIC_CRYSTAL_SHARD.get())
                .add(ModItems.VOID_CRYSTAL_SHARD.get())
                .add(ModItems.ARCANA_CRYSTAL_SHARD.get())
                .add(ModItems.FIRE_CRYSTAL_SHARD.get());

        this.tag(ModTags.Items.FUEL)
                .addTag(ItemTags.COALS)
                .addTag(ItemTags.PLANKS)
                .addTag(ItemTags.SAPLINGS)
                .addTag(ItemTags.LOGS)
                .addTag(ItemTags.LOGS_THAT_BURN);

    }


}
