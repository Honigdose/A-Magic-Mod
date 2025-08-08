package com.honigdose.abyssmagicmod.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Random;

public class LightAirBlock extends AirBlock {
    public static final IntegerProperty LIGHT = BlockStateProperties.LEVEL;

    public LightAirBlock(Properties properties) {
        super(BlockBehaviour.Properties
                .ofFullCopy(Blocks.AIR)
                .noCollission()
                .instabreak()
                .strength(0)
                .lightLevel(state -> state.getValue(LIGHT))
                .noLootTable()
        );
        this.registerDefaultState(defaultBlockState().setValue(LIGHT, 15));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIGHT);
    }


    @Override
    protected boolean useShapeForLightOcclusion(BlockState pState) {
        return false;
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
    }
}