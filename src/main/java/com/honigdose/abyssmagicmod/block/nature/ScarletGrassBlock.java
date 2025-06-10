package com.honigdose.abyssmagicmod.block.nature;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;


public class ScarletGrassBlock extends SpreadingSnowyDirtBlock {
    public ScarletGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends SpreadingSnowyDirtBlock> codec() {
        return null;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = level.getBlockState(abovePos);
        FluidState fluidState = aboveState.getFluidState();

        boolean isSolidAbove = aboveState.blocksMotion();
        boolean isWaterAbove = fluidState.is(FluidTags.WATER);

        if (isSolidAbove || isWaterAbove) {
            level.setBlock(pos, ModBlocks.SCARLET_FOREST_DIRT.get().defaultBlockState(), 3);
        }

    }


}
