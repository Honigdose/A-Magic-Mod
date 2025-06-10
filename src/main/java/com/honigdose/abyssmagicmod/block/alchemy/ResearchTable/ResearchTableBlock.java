package com.honigdose.abyssmagicmod.block.alchemy.ResearchTable;


import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.screen.custom.AlchemyBookScreen;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


import javax.annotation.Nullable;
import java.util.List;


public class ResearchTableBlock extends BaseEntityBlock {
    public static final EnumProperty<ChestType> PART = BlockStateProperties.CHEST_TYPE;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);
    public static final VoxelShape SHAPE_TABLETOP = Block.box(0, 15, 0, 16, 16, 16);
    public static final VoxelShape SHAPE_TABLEBOTTOM = Block.box(0, 0, 0, 16, 1, 16);
    public static final VoxelShape SHAPE_TABLE_SIDE_NORTH = Block.box(0, 0, 15, 16, 16, 16);
    public static final VoxelShape SHAPE_TABLE_SIDE_WEST= Block.box(15, 0, 0, 16, 16, 16);
    public static final VoxelShape SHAPE_TABLE_SIDE_EAST = Block.box(0, 0, 0, 1, 16, 16);
    public static final VoxelShape SHAPE_TABLE_SIDE_SOUTH = Block.box(0, 0, 0, 16, 16, 1);
    public static final VoxelShape SHAPE_TABLE_SIDEX= Block.box(0, 0, 7, 16, 16, 9);
    public static final VoxelShape SHAPE_TABLE_SIDEY = Block.box(7, 0, 0, 9, 16, 16);


    public static final VoxelShape SHAPE_NORTH = Shapes.or(SHAPE_TABLE_SIDE_EAST,SHAPE_TABLE_SIDE_WEST, SHAPE_TABLEBOTTOM, SHAPE_TABLETOP, SHAPE_TABLE_SIDEX);
    public static final VoxelShape SHAPE_SOUTH = Shapes.or(SHAPE_TABLE_SIDE_WEST,SHAPE_TABLE_SIDE_EAST, SHAPE_TABLEBOTTOM, SHAPE_TABLETOP, SHAPE_TABLE_SIDEX);
    public static final VoxelShape SHAPE_EAST = Shapes.or(SHAPE_TABLE_SIDE_SOUTH, SHAPE_TABLE_SIDE_NORTH, SHAPE_TABLEBOTTOM, SHAPE_TABLETOP, SHAPE_TABLE_SIDEY);
    public static final VoxelShape SHAPE_WEST = Shapes.or(SHAPE_TABLE_SIDE_SOUTH, SHAPE_TABLE_SIDE_NORTH, SHAPE_TABLEBOTTOM, SHAPE_TABLETOP, SHAPE_TABLE_SIDEY);




    public ResearchTableBlock(Properties properties) {
        super(BlockBehaviour.Properties.of()
                .strength(2.5F)
                .sound(SoundType.WOOD)
                .noOcclusion());
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, ChestType.RIGHT));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getHorizontalDirection();
        BlockPos blockpos = pContext.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(direction.getCounterClockWise());
        Level level = pContext.getLevel();
        if (level.getBlockState(blockpos1).canBeReplaced(pContext) && level.getWorldBorder().isWithinBounds(blockpos1)) {
            return this.defaultBlockState().setValue(FACING, direction.getOpposite());
        }

        return null;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(PART).equals(ChestType.RIGHT) ? pState.getValue(FACING) : pState.getValue(FACING).getOpposite();
        return switch (direction) {
            case NORTH -> SHAPE_NORTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_SOUTH;
        };
    }


    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (adjacentBlockState.getBlock() == this && state.getValue(PART) == ChestType.LEFT) {
            return true;
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }


    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        // Add a simple tooltip
        pTooltipComponents.add(Component.literal("Study plants, crystals and other Items to uncover their secrets."));
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            Direction direction = state.getValue(FACING);
            BlockPos neighborPos = pos.relative(direction.getClockWise());

            if (level.getBlockState(neighborPos).canBeReplaced()) {
                level.setBlock(neighborPos, state.setValue(PART, ChestType.LEFT), 3);
                level.setBlock(pos, state.setValue(PART, ChestType.RIGHT), 3);
            } else {
                level.removeBlock(pos, false);
            }
        }
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ResearchTableBlockEntity researchTableBlockEntity) {
                researchTableBlockEntity.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }



    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof ResearchTableBlockEntity researchTableBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(researchTableBlockEntity, Component.literal("Research Table")), pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        ChestType part = state.getValue(PART);
        Direction requiredNeighborDirection = (part == ChestType.RIGHT) ? state.getValue(FACING).getClockWise() : state.getValue(FACING).getCounterClockWise();
        BlockPos requiredNeighborPos = pos.relative(requiredNeighborDirection);

        if (neighborPos.equals(requiredNeighborPos)) {
            if (!neighborState.is(this) || neighborState.getValue(PART) == state.getValue(PART)) {
                return Blocks.AIR.defaultBlockState();
            }
        }
        return state;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return state.getValue(PART) == ChestType.LEFT ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    @Override
    public @org.jetbrains.annotations.Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ResearchTableBlockEntity(pPos,pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntites.RESEARCH_TABLE_BE.get(),
                (level, blockPos, blockState, researchTableBlockEntity) -> researchTableBlockEntity.tick(level, blockPos, blockState));
    }
}