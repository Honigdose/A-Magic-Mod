package com.honigdose.abyssmagicmod.block.essence.bottle.nature;


import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class NatureEssenceBottle extends BaseEntityBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 9, 11);

    public NatureEssenceBottle(Properties properties) {
        super(properties.noCollission().instabreak().lightLevel(value -> 1));

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(WATERLOGGED, false)
                        .setValue(FACING, Direction.NORTH) // ← Standardrichtung setzen!

        );
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite()) // ← Richtung setzen!
                .setValue(WATERLOGGED, flag);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING))); // ← Rotation unterstützen!
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NatureEssenceBottleEntity(pos, state);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        int startHex = 0x276f3c;
        int endHex   = 0xe2f23b;
        if (random.nextFloat() < 0.2f) {
            double offsetFactor = 0.4;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * 0.5;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double xPos = pos.getX() + 0.5 + xOffset;
            double yPos = pos.getY() + 0.5 + yOffset;
            double zPos = pos.getZ() + 0.5 + zOffset;

            level.addParticle(ModParticles.BOTTLE_ESSENCE_PARTICLE.get(), xPos, yPos, zPos, (double) startHex, (double) endHex, 0.0);
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
