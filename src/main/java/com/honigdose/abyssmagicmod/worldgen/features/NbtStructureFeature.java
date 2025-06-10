package com.honigdose.abyssmagicmod.worldgen.features;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;

public class NbtStructureFeature extends Feature<NbtStructureFeatureConfiguration> {

    public NbtStructureFeature() {
        super(NbtStructureFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NbtStructureFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        StructureTemplateManager manager = ((ServerLevel) level.getLevel()).getStructureManager();
        ResourceLocation structureId = context.config().structure;

        Optional<StructureTemplate> templateOpt = manager.get(structureId);
        if (templateOpt.isEmpty()) {
            return false;
        }

        StructureTemplate template = templateOpt.get();

        // Finde festen Boden von oben nach unten
        BlockPos.MutableBlockPos checkPos = origin.mutable();
        while (checkPos.getY() > level.getMinBuildHeight() + 5) {
            BlockState state = level.getBlockState(checkPos);
            if (!state.isAir() && !state.is(BlockTags.LEAVES)) {
                break;
            }
            checkPos.move(Direction.DOWN);
        }

        // Erlaube nur GRASS_BLOCK als Boden
        BlockState groundState = level.getBlockState(checkPos);
        if (!groundState.is(ModBlocks.SCARLET_FOREST_GRASS.get())) {
            return false;
        }

        // Platziere die Struktur genau OBEN auf dem Bodenblock
        BlockPos placement = checkPos;

        Rotation rotation = Rotation.getRandom(random);
        Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotation(rotation)
                .setMirror(mirror)
                .setIgnoreEntities(false)
                .setKnownShape(true);

        return template.placeInWorld(level, placement, placement, settings, random, 2);
    }
}
