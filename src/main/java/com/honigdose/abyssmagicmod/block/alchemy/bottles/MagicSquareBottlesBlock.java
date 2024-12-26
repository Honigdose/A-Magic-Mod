package com.honigdose.abyssmagicmod.block.alchemy.bottles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MagicSquareBottlesBlock extends Block {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final int MIN_BOTTLES = 1;
    public static final int MAX_BOTTLES = 3;

    public static final IntegerProperty ROUNDBOTTLES = IntegerProperty.create("roundbottles", 1, 3);
    public static final IntegerProperty TRIANGLEBOTTLES = IntegerProperty.create("trianglebottles", 1, 3);
    public static final IntegerProperty SQUAREBOTTLES = IntegerProperty.create("squarebottles", 1, 3);

    public static final VoxelShape SHAPE_ONE = Block.box(5, 0, 5, 11, 9, 11);
    public static final VoxelShape SHAPE_TWO = Block.box(3, 0, 3, 14, 9, 14);
    public static final VoxelShape SHAPE_THREE = Block.box(2, 0, 2, 14, 9, 14);
    public MagicSquareBottlesBlock(Properties p_49795_) {

        super(p_49795_);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(SQUAREBOTTLES, Integer.valueOf(1))
                        .setValue(WATERLOGGED, Boolean.valueOf(false))
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos());
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        if (blockstate.is(this)) {
            blockstate = blockstate.setValue(FACING, direction)
                    .setValue(FACING, pContext.getHorizontalDirection());
            return blockstate.cycle(SQUAREBOTTLES);
        } else {
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(pContext).setValue(WATERLOGGED, Boolean.valueOf(flag));
        }
    }


    @Override
    protected BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(SQUAREBOTTLES)) {
            case 1:
            default:
                return SHAPE_ONE;
            case 2:
                return SHAPE_TWO;
            case 3:
                return SHAPE_THREE;
        }
    }
    @Override
    protected boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        return !pUseContext.isSecondaryUseActive() && pUseContext.getItemInHand().getItem() == this.asItem() && pState.getValue(SQUAREBOTTLES) < 3
                || super.canBeReplaced(pState, pUseContext);
    }

    @Override
    protected BlockState updateShape(
            BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos
    ) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SQUAREBOTTLES, WATERLOGGED, FACING);
    }


}
