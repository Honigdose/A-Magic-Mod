package com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree;


import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeDecoratorTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ScarletTreeDecorator extends TreeDecorator {

    public static final MapCodec<ScarletTreeDecorator> CODEC = MapCodec.unit(new ScarletTreeDecorator());

    private static final List<Block> WEIGHTED_DECORATION_POOL = new ArrayList<>();

    static {
        WEIGHTED_DECORATION_POOL.addAll(Collections.nCopies(4, ModBlocks.GLOWING_BROWN_MUSHROOM.get()));
        WEIGHTED_DECORATION_POOL.addAll(Collections.nCopies(6, ModBlocks.BROWN_TREE_MUSHROOM.get()));
        WEIGHTED_DECORATION_POOL.addAll(Collections.nCopies(1, ModBlocks.GLOWING_RED_MUSHROOM.get()));
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecoratorTypes.SCARLET_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        List<BlockPos> logs = context.logs();
        WorldGenLevel level = (WorldGenLevel) context.level();

        int minY = logs.stream().mapToInt(BlockPos::getY).min().orElse(0);
        int maxY = logs.stream().mapToInt(BlockPos::getY).max().orElse(0);
        int trunkHeight = maxY - minY;

        int maxDecorateY = minY + (int) (trunkHeight * 0.5);

        for (BlockPos logPos : logs) {
            if (logPos.getY() <= maxDecorateY && random.nextFloat() < 0.02f) {
                for (Direction direction : Direction.Plane.HORIZONTAL) { // Alle vier Seiten durchgehen
                    BlockPos offset = logPos.relative(direction);

                    // Stelle sicher, dass der Block leer ist und der Pilz korrekt ausgerichtet wird
                    if (level.isEmptyBlock(offset)) {
                        Block chosenBlock = WEIGHTED_DECORATION_POOL.get(random.nextInt(WEIGHTED_DECORATION_POOL.size()));

                        // BlockState mit richtiger Facing-Rotation setzen
                        level.setBlock(offset, chosenBlock.defaultBlockState().setValue(BlockStateProperties.FACING, direction), 2);
                    }
                }
            }
        }


    }

}
