package com.honigdose.abyssmagicmod.block.crystals;


import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


import javax.annotation.Nullable;

public class LargeMagicCrystalBlock extends Block {

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected final VoxelShape lowerShape;
    protected final VoxelShape upperShape;

    public LargeMagicCrystalBlock(Properties p_49795_) {
        super(p_49795_);

        this.lowerShape = Block.box(5, 0, 5, 12.0, 16.0, 12.0);

        // Form für die obere Hälfte
        this.upperShape = Block.box(6, 0, 6, 11.0, 6.0, 11.0);

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(FACING, Direction.UP));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        DoubleBlockHalf half = state.getValue(HALF);
        if (half == DoubleBlockHalf.LOWER) {
            return this.lowerShape;
        } else {
            return this.upperShape;
        }
    }


    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (pFacing.getAxis() != Direction.Axis.Y
                || doubleblockhalf == DoubleBlockHalf.LOWER != (pFacing == Direction.UP)
                || pFacingState.is(this) && pFacingState.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        Direction facing = pContext.getClickedFace();
        return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext)
                ? this.defaultBlockState().setValue(FACING, facing)
                : null;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, pState.getValue(FACING)), 3);
    }

    public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(pPos, pState.setValue(HALF, DoubleBlockHalf.LOWER), pFlags);
        pLevel.setBlock(blockpos, pState.setValue(HALF, DoubleBlockHalf.UPPER), pFlags);
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide) {
            if (pPlayer.isCreative()) {
                preventDropFromBottomPart(pLevel, pPos, pState, pPlayer);
            } else {
                dropResources(pState, pLevel, pPos, null, pPlayer, pPlayer.getMainHandItem());
            }
        }

        return super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pTe, ItemStack pStack) {
        super.playerDestroy(pLevel, pPlayer, pPos, Blocks.AIR.defaultBlockState(), pTe, pStack);
    }

    protected static void preventDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                pLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER && random.nextFloat() < 0.15f) {
            double offsetFactor = 2;
            double xOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double yOffset = (random.nextDouble() - 0.5) * 0.7;
            double zOffset = (random.nextDouble() - 0.5) * offsetFactor;
            double xPos = pos.getX() + 0.5 + xOffset;
            double yPos = pos.getY() + 1.0 + yOffset;
            double zPos = pos.getZ() + 0.5 + zOffset;

            ParticleType<?> particleType;
            // Vergleich anhand der Blockinstanz
            if (this == ModBlocks.LARGE_ARCANA_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_FIRE_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_AIR_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_NATURE_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_WATER_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_SOLAR_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_LUNAR_CRYSTAL.get()) {
                particleType = ModParticles.LUNAR_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_VOID_CRYSTAL.get()) {
                particleType = ModParticles.VOID_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_DEMONIC_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else if (this == ModBlocks.LARGE_CELESTIAL_CRYSTAL.get()) {
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            } else {
                // Fallback, falls keiner passt
                particleType = ModParticles.CUTE_CRYSTAL_PARTICLE.get();
            }

            level.addParticle((ParticleOptions) particleType, xPos, yPos, zPos, 0.0, 0.0, 0.0);
        }
    }





    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HALF, FACING);
    }
}
