package com.honigdose.abyssmagicmod.item;

import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier FIRERYTE = new ForgeTier(1400, 4, 3f, 18,
            ModTags.Blocks.NEEDS_FIRERYTE_TOOL, () -> Ingredient.of(ModItems.FIRERYTE.get()), ModTags.Blocks.INCORRECT_FOR_FIRERYTE_TOOL);
}
