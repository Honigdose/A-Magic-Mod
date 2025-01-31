package com.honigdose.abyssmagicmod.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class InkBottleItem extends BlockItem {
    public InkBottleItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }



    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack(this);
    }

}

