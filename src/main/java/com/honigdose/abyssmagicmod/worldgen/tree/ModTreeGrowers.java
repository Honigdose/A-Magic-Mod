package com.honigdose.abyssmagicmod.worldgen.tree;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.worldgen.ModConfiguredFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;


import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower SCARLET = new TreeGrower(AbyssMagicMod.MOD_ID + ":scarlet",
            Optional.of(ModConfiguredFeatures.SCARLET_KEY), Optional.empty(), Optional.empty());


    public static final TreeGrower LIFE_TREE = new TreeGrower(AbyssMagicMod.MOD_ID + ":life_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LIFE_TREE_KEY), Optional.empty());
}
