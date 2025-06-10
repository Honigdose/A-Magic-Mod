package com.honigdose.abyssmagicmod.block.nature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class CustomVineBlock extends Block {

    private static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final VoxelShape FLOOR_AABB = Block.box(2.0, 0.0, 2.0, 16.0, 8.0, 16.0);

    public static final BooleanProperty WALL_MOUNTED = BooleanProperty.create("wall_mounted");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CustomVineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WALL_MOUNTED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WALL_MOUNTED, FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (!state.getValue(WALL_MOUNTED)) {
            return FLOOR_AABB;
        }

        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case EAST  -> EAST_AABB;
            case WEST  -> WEST_AABB;
            default    -> FLOOR_AABB;
        };
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();


        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        if (!belowState.isFaceSturdy(level, belowPos, Direction.UP)) {
            return null;
        }

        if (clickedFace.getAxis().isHorizontal()) {
            Direction facing = clickedFace;
            return this.defaultBlockState()
                    .setValue(WALL_MOUNTED, true)
                    .setValue(FACING, facing);
        } else {
            return this.defaultBlockState()
                    .setValue(WALL_MOUNTED, false)
                    .setValue(FACING, Direction.NORTH);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        if (!belowState.isFaceSturdy(level, belowPos, Direction.UP)) {
            return false;
        }

        if (state.getValue(WALL_MOUNTED)) {
            Direction facing = state.getValue(FACING);
            BlockPos behind = pos.relative(facing.getOpposite());
            BlockState behindState = level.getBlockState(behind);
            return behindState.isFaceSturdy(level, behind, facing);
        }

        return true;
    }
}
