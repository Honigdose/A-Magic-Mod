package com.honigdose.abyssmagicmod.block.alchemy.alchemy_circle;

import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

public class WaterCircle extends Block {

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 3.5, 16);

    private static final int REQUIRED_ITEM_A = 1;
    private static final int REQUIRED_ITEM_B = 1;

    public WaterCircle(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof ItemEntity) {
            List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos));
            int countA = 0;
            int countB = 0;

            for (ItemEntity item : items) {
                ItemStack stack = item.getItem();
                if (isItemA(stack)) {
                    countA += stack.getCount();
                } else if (isItemB(stack)) {
                    countB += stack.getCount();
                }
            }

            if (countA >= REQUIRED_ITEM_A && countB >= REQUIRED_ITEM_B) {
                level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
                removeItemsAt(level, pos);
            }

        }
        super.stepOn(level, pos, state, entity);
    }

    private boolean isItemA(ItemStack item) {
        return item.getItem() == Items.POPPY;
    }

    private boolean isItemB(ItemStack item) {
        return item.is(ItemTags.LEAVES);
    }

    private void removeItemsAt(Level level, BlockPos pos) {
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos));
        for (ItemEntity item : items) {
            if (isItemA(item.getItem()) || isItemB(item.getItem())) {
                item.discard();
            }
        }
    }
}
