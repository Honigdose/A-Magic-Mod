package com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.*;
import java.util.function.BiConsumer;

public class ScarletTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ScarletTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            trunkPlacerParts(instance).apply(instance, ScarletTrunkPlacer::new)
    );

    public ScarletTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return AbyssMagicMod.SCARLET_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        List<FoliagePlacer.FoliageAttachment> foliageAttachments = new ArrayList<>();

        // Generiere Baumstamm in die Höhe (3x3 Stamm)
        for (int y = 0; y < pFreeTreeHeight; y++) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos pos = pPos.offset(x, y, z);
                    pBlockSetter.accept(pos, pConfig.trunkProvider.getState(pRandom, pos));
                }
            }
        }

        // Fundament unter jedem Stammblock auf Y = 0
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int dy = -1; dy >= -5; dy--) {
                    BlockPos supportPos = pPos.offset(x, dy, z);
                    if (pLevel.isStateAtPosition(supportPos, state -> state.isAir())) {
                        pBlockSetter.accept(supportPos, pConfig.trunkProvider.getState(pRandom, supportPos));
                    } else {
                        break; // Stoppe, wenn kein Luftblock mehr
                    }
                }
            }
        }


        BlockPos LogPos = pPos.offset(0, 10, 0);
        BlockPos LogPos2 = pPos.offset(-1, 10, 0);
        BlockPos LogPos3 = pPos.offset(0, 10, 1);
        BlockPos LogPos4 = pPos.offset(-1, 10, 1);
        pBlockSetter.accept(LogPos, pConfig.trunkProvider.getState(pRandom, LogPos));
        pBlockSetter.accept(LogPos2, pConfig.trunkProvider.getState(pRandom, LogPos2));
        pBlockSetter.accept(LogPos3, pConfig.trunkProvider.getState(pRandom, LogPos3));
        pBlockSetter.accept(LogPos4, pConfig.trunkProvider.getState(pRandom, LogPos4));

        // Wurzeln generieren
        BlockState rootBlock = pConfig.trunkProvider.getState(pRandom, pPos);
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if ((Math.abs(x) > 1 || Math.abs(z) > 1) && !(Math.abs(x) == 2 && Math.abs(z) == 2)) {
                    if (pRandom.nextFloat() < 0.4F) {
                        BlockPos rootPos = pPos.offset(x, 0, z);
                        pBlockSetter.accept(rootPos, rootBlock);

                        // Fundament unter der Wurzel
                        for (int dy = -1; dy >= -5; dy--) {
                            BlockPos supportPos = rootPos.offset(0, dy, 0);
                            if (pLevel.isStateAtPosition(supportPos, state -> state.isAir() || state.getFluidState().isSource())) {
                                pBlockSetter.accept(supportPos, rootBlock);
                            } else {
                                break;
                            }
                        }

                        if (pRandom.nextFloat() < 0.4F) {
                            BlockPos secondRootPos = rootPos.above();
                            pBlockSetter.accept(secondRootPos, rootBlock);

                            // Fundament auch unter dieser Wurzelverlängerung
                            for (int dy = -1; dy >= -10; dy--) {
                                BlockPos supportPos = secondRootPos.offset(0, dy, 0);
                                if (pLevel.isStateAtPosition(supportPos, state -> state.isAir() || state.getFluidState().isSource())) {
                                    pBlockSetter.accept(supportPos, rootBlock);
                                } else {
                                    break;
                                }
                            }

                            if (pRandom.nextFloat() < 0.2F) {
                                BlockPos thirdRootPos = secondRootPos.above();
                                pBlockSetter.accept(thirdRootPos, rootBlock);

                                for (int dy = -1; dy >= -10; dy--) {
                                    BlockPos supportPos = thirdRootPos.offset(0, dy, 0);
                                    if (pLevel.isStateAtPosition(supportPos, state -> state.isAir() || state.getFluidState().isSource())) {
                                        pBlockSetter.accept(supportPos, rootBlock);
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        // Äste
        //North
        BlockPos LogBranchNorthPos = pPos.offset(0, 7, -2);
        BlockPos LogBranchNorthPos1 = pPos.offset(0, 8, -3);
        BlockPos LogBranchNorthPos2 = pPos.offset(0, 9, -4);

        BlockPos LogBranchNorthPos3 = pPos.offset(0, 4, -2);
        BlockPos LogBranchNorthPos4 = pPos.offset(0, 5, -3);
        BlockPos LogBranchNorthPos5 = pPos.offset(0, 6, -4);
        BlockPos LogBranchNorthPos6 = pPos.offset(0, 6, -5);
        pBlockSetter.accept(LogBranchNorthPos, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos));
        pBlockSetter.accept(LogBranchNorthPos1, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos1));
        pBlockSetter.accept(LogBranchNorthPos2, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos2));
        pBlockSetter.accept(LogBranchNorthPos3, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos3));
        pBlockSetter.accept(LogBranchNorthPos4, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos4));
        pBlockSetter.accept(LogBranchNorthPos5, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos5));
        pBlockSetter.accept(LogBranchNorthPos6, pConfig.trunkProvider.getState(pRandom, LogBranchNorthPos6));
        //East
        BlockPos LogBranchEastPos = pPos.offset(2, 8, 0);
        BlockPos LogBranchEastPos1 = pPos.offset(3, 9, 0);
        BlockPos LogBranchEastPos2 = pPos.offset(4, 9, 0);

        BlockPos LogBranchEastPos3 = pPos.offset(2, 3, 0);
        BlockPos LogBranchEastPos4 = pPos.offset(3, 4, 0);
        BlockPos LogBranchEastPos5 = pPos.offset(4, 5, 0);
        BlockPos LogBranchEastPos6 = pPos.offset(5, 5, 0);
        pBlockSetter.accept(LogBranchEastPos, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos));
        pBlockSetter.accept(LogBranchEastPos1, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos1));
        pBlockSetter.accept(LogBranchEastPos2, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos2));
        pBlockSetter.accept(LogBranchEastPos3, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos3));
        pBlockSetter.accept(LogBranchEastPos4, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos4));
        pBlockSetter.accept(LogBranchEastPos5, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos5));
        pBlockSetter.accept(LogBranchEastPos6, pConfig.trunkProvider.getState(pRandom, LogBranchEastPos6));
        //South
        BlockPos LogBranchSouthPos = pPos.offset(0, 7, 2);
        BlockPos LogBranchSouthPos2 = pPos.offset(0, 8, 3);
        BlockPos LogBranchSouthPos3 = pPos.offset(0, 9, 4);

        BlockPos LogBranchSouthPos4 = pPos.offset(0, 4, 2);
        BlockPos LogBranchSouthPos5 = pPos.offset(0, 5, 3);
        BlockPos LogBranchSouthPos6 = pPos.offset(0, 6, 4);
        BlockPos LogBranchSouthPos7 = pPos.offset(0, 6, 5);
        pBlockSetter.accept(LogBranchSouthPos, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos));
        pBlockSetter.accept(LogBranchSouthPos2, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos2));
        pBlockSetter.accept(LogBranchSouthPos3, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos3));
        pBlockSetter.accept(LogBranchSouthPos4, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos4));
        pBlockSetter.accept(LogBranchSouthPos5, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos5));
        pBlockSetter.accept(LogBranchSouthPos6, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos6));
        pBlockSetter.accept(LogBranchSouthPos7, pConfig.trunkProvider.getState(pRandom, LogBranchSouthPos7));

        //West
        BlockPos LogBranchWestPos = pPos.offset(-2, 6, 0);
        BlockPos LogBranchWestPos1 = pPos.offset(-3, 7, 0);
        BlockPos LogBranchWestPos2 = pPos.offset(-4, 7, 0);
        BlockPos LogBranchWestPos3 = pPos.offset(-5, 8, 0);

        BlockPos LogBranchWestPos4 = pPos.offset(-2, 3, 0);
        BlockPos LogBranchWestPos5 = pPos.offset(-3, 4, 0);
        BlockPos LogBranchWestPos6 = pPos.offset(-4, 5, 0);
        BlockPos LogBranchWestPos7 = pPos.offset(-5, 5, 0);
        pBlockSetter.accept(LogBranchWestPos, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos));
        pBlockSetter.accept(LogBranchWestPos1, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos1));
        pBlockSetter.accept(LogBranchWestPos2, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos2));
        pBlockSetter.accept(LogBranchWestPos3, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos3));
        pBlockSetter.accept(LogBranchWestPos4, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos4));
        pBlockSetter.accept(LogBranchWestPos5, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos5));
        pBlockSetter.accept(LogBranchWestPos6, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos6));
        pBlockSetter.accept(LogBranchWestPos7, pConfig.trunkProvider.getState(pRandom, LogBranchWestPos7));


        foliageAttachments.add(new FoliagePlacer.FoliageAttachment(pPos.above(pFreeTreeHeight), 0, false));
        return foliageAttachments;
    }
}
