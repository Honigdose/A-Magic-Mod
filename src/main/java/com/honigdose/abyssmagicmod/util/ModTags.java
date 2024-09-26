package com.honigdose.abyssmagicmod.util;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_FIRERYTE_TOOL = createTag("needs_fireryte_tool");
        public static final TagKey<Block> INCORRECT_FOR_FIRERYTE_TOOL = createTag("incorrect_for_fireryte_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> MOD_WOOD = createTag("mod_wood");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, name));
        }


    }
}
