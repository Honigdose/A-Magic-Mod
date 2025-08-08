package com.honigdose.abyssmagicmod.light;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.custom.LightAirBlock;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class DynamicLightSource {
    private final IDynamicLightSource source;
    private final BlockPos.MutableBlockPos activePos = new BlockPos.MutableBlockPos();
    private final BlockPos.MutableBlockPos lastSourcePos = new BlockPos.MutableBlockPos();
    private final int yOffset;

    public DynamicLightSource(IDynamicLightSource src) {
        source = src;
        yOffset = (int) Math.floor(src.getAttachmentEntity().getEyeHeight());
    }

    public boolean onUpdate(ClientLevel world) {
        Entity ent = source.getAttachmentEntity();
        if (!ent.isAlive()) {
            removeLight(world);
            return true;
        }

        // neue Entity-BlockPos auf Augenhöhe
        BlockPos newSrcPos = ent.blockPosition().offset(0, yOffset, 0);
        if (!newSrcPos.equals(lastSourcePos)) {
            lastSourcePos.set(newSrcPos);
            BlockPos found = findValidPos(world, newSrcPos);
            if (found != null && !found.equals(activePos)) {
                removeLight(world);
                placeLight(world, found, source.getLightLevel());
            }
        }
        return false;
    }

    private void placeLight(ClientLevel world, BlockPos pos, int level) {
        world.setBlock(pos,
                ModBlocks.LIGHT_AIR_BLOCK.get().defaultBlockState().setValue(LightAirBlock.LIGHT, level),
                3);
        world.scheduleTick(pos, ModBlocks.LIGHT_AIR_BLOCK.get(), 10);
        activePos.set(pos);
    }

    private void removeLight(ClientLevel world) {
        if (!world.isEmptyBlock(activePos)
                && world.getBlockState(activePos).getBlock() == ModBlocks.LIGHT_AIR_BLOCK.get()) {
            world.setBlock(activePos, Blocks.AIR.defaultBlockState(), 3);
        }
    }

    private BlockPos findValidPos(Level world, BlockPos src) {
        int[][] offsets = {{0,0,0},{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
        for (int[] o : offsets) {
            BlockPos p = src.offset(o[0], o[1], o[2]);
            if (world.getBlockState(p).canBeReplaced()) {
                return p;
            }
        }
        return null;
    }

}
