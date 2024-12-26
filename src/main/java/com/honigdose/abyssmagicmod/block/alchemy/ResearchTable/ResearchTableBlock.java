package com.honigdose.abyssmagicmod.block.alchemy.ResearchTable;


import com.honigdose.abyssmagicmod.screen.custom.AlchemyBookScreen;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
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


public class ResearchTableBlock extends Block {
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
                .noOcclusion()
                .lightLevel(value -> 5));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, ChestType.RIGHT));
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
        // Wenn der benachbarte Block der gleiche Blocktyp ist, ignoriere das Rendering
        if (adjacentBlockState.getBlock() == this && state.getValue(PART) == ChestType.LEFT) {
            return true; // Der benachbarte Block wird als transparent behandelt
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
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            // Menü öffnen
            Minecraft.getInstance().setScreen(new ResearchTableScreen(Component.literal("Research Table")));
        }
        return InteractionResult.SUCCESS;
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
}