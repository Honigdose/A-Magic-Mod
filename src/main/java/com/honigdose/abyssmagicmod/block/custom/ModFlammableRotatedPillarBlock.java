package com.honigdose.abyssmagicmod.block.custom;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    // Map für die Zuordnung von normalen Holzblöcken zu ihren gestrippten Versionen
    private static final Map<Block, Block> STRIPPABLES = new HashMap<>();

    static {
        // Zuweisungen für deine Blöcke


        // Hier kannst du weitere Blöcke hinzufügen
        // STRIPPABLES.put(ModBlocks.ANDERE_HOLZ_LOG.get(), ModBlocks.GESTRIPPTER_ANDERER_HOLZ_LOG.get());
    }

    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            // Überprüfe, ob der Block in der STRIPPABLES-Map enthalten ist
            Block strippedBlock = STRIPPABLES.get(state.getBlock());
            if (strippedBlock != null) {
                // Wenn der Block existiert, gib den gestrippten Block mit derselben Achse zurück
                return strippedBlock.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}