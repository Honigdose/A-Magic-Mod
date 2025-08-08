package com.honigdose.abyssmagicmod.worldgen.biome;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource SCARLET_DIRT = makeStateRule(ModBlocks.SCARLET_FOREST_DIRT.get());
    private static final SurfaceRules.RuleSource SCARLET_GRASS = makeStateRule(ModBlocks.SCARLET_FOREST_GRASS.get());
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);

    private static final SurfaceRules.RuleSource OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);

    private static final SurfaceRules.RuleSource GLOWSTONE = makeStateRule(Blocks.GLOWSTONE);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);



    public static SurfaceRules.RuleSource makeScarletForestRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SCARLET_FOREST),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SCARLET_GRASS), SCARLET_DIRT)),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MUD)
        );
    }

    public static SurfaceRules.RuleSource makeGlowstonePlainsRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),

                // Then apply biome-specific rules
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.GLOWSTONE_PLAIN),
                        SurfaceRules.sequence(
                                // Obsidian on the undersides of ceilings
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, OBSIDIAN),
                                // Obsidian on the undersides of floors (though less common in Nether caves)
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, GLOWSTONE),
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, OBSIDIAN),
                                // Default to glowstone if not under a ceiling or floor
                                GLOWSTONE))
        );
    }

    public static SurfaceRules.RuleSource makeEndRotRules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.END_ROT), OBSIDIAN),
                // Default to end stone
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, END_STONE)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
