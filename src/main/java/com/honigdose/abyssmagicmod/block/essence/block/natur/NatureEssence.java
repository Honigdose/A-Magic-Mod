package com.honigdose.abyssmagicmod.block.essence.block.natur;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class NatureEssence extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Block.box(2, 2, 2, 14, 14, 14);
    public NatureEssence(Properties properties) {
        super(Properties.of()
                .noOcclusion()
                .strength(-1.0F, 3600000.0F)
                .lightLevel(value -> 5));


    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.hurt(pLevel.damageSources().cactus(), 4.0F);
    }


    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player != null) {
            if (stack.is(ModBlocks.MAGIC_ROUND_BOTTLE.get().asItem())) {
                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    ItemStack essenceBottle = new ItemStack(ModBlocks.NATURE_ESSENCE_BOTTLE.get());
                    if (!player.getInventory().add(essenceBottle)) {
                        player.drop(essenceBottle, false);
                    }
                    level.removeBlock(pos, false);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }

            else if (stack.is(ModBlocks.MAGIC_TRIANGLE_BOTTLE.get().asItem())) { // Zweites Item prüfen
                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    ItemStack essenceBottle = new ItemStack(ModBlocks.NATURE_ESSENCE_BOTTLE.get());
                    if (!player.getInventory().add(essenceBottle)) {
                        player.drop(essenceBottle, false);
                    }
                    level.removeBlock(pos, false);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);


            } else if (stack.is(ModBlocks.MAGIC_SQUARE_BOTTLE.get().asItem())) { // Zweites Item prüfen
                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    ItemStack essenceBottle = new ItemStack(ModBlocks.NATURE_ESSENCE_BOTTLE.get());
                    if (!player.getInventory().add(essenceBottle)) {
                        player.drop(essenceBottle, false);
                    }
                    level.removeBlock(pos, false);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }


    @Override
    public @org.jetbrains.annotations.Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new NatureEssenceEntityBlock(pPos,pState);
    }


    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (!pLevel.isClientSide()) {
            return null;
        }
        return createTickerHelper(pBlockEntityType, ModBlockEntites.NATURE_ESSENCE_BLOCK_ENTITY.get(),
                (level, blockPos, blockState, naturessenceBlockEntity) -> NatureEssenceEntityBlock.tick(level, blockPos, blockState));
    }

}

