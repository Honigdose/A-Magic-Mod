package com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.block.state.BlockState;


public class ScarletFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<ScarletFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance).apply(instance, ScarletFoliagePlacer::new)
    );

    public ScarletFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return AbyssMagicMod.SCARLET_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        // Starte die Baumkrone auf der Höhe des FoliageAttachment, sodass sie direkt um den Stamm liegt
        BlockPos foliageCenter = pAttachment.pos().below(3);

        for (int y = 0; y <= pFoliageHeight; y++) {
            int adjustedRadius = pFoliageRadius - y / 2;

            for (int x = -adjustedRadius; x <= adjustedRadius; x++) {
                for (int z = -adjustedRadius; z <= adjustedRadius; z++) {
                    BlockPos leafPos = foliageCenter.offset(x, y, z);

                    if (!pLevel.isStateAtPosition(leafPos, state -> state.is(pConfig.trunkProvider.getState(pRandom, leafPos).getBlock()))) {
                        if (x * x + z * z <= adjustedRadius * adjustedRadius + pRandom.nextInt(6)) {
                            BlockState leafState = pConfig.foliageProvider.getState(pRandom, leafPos).setValue(LeavesBlock.PERSISTENT, false);
                            pBlockSetter.set(leafPos, leafState);

                            // Hängende Blätter setzen
                            if (pRandom.nextFloat() < 0.4F) {
                                int hangingLength = 1 + pRandom.nextInt(4);
                                for (int i = 1; i <= hangingLength; i++) {
                                    BlockPos hangingLeafPos = leafPos.below(i);
                                    if (pLevel.isStateAtPosition(hangingLeafPos, BlockState::isAir)) {
                                        BlockState hangingLeafState = pConfig.foliageProvider.getState(pRandom, hangingLeafPos).setValue(LeavesBlock.PERSISTENT, false);
                                        pBlockSetter.set(hangingLeafPos, hangingLeafState);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return pRandom.nextInt(2) + 4;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pRandom.nextFloat() > 0.8F && (pLocalX * pLocalX + pLocalZ * pLocalZ > (pRange * pRange) / 2);
    }

}
