package com.honigdose.abyssmagicmod.block.alchemy.alchemy_circle;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;


public class FireCircle extends Block {

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 3.5, 16);
    private static final int REQUIRED_ITEMS = 3; // Anzahl der benötigten Items


    public FireCircle(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof ItemEntity) {
            // Zähle alle gültigen Items im AABB
            List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos));
            int totalItems = items.stream()
                    .filter(i -> isValidItem(i.getItem()))
                    .mapToInt(i -> i.getItem().getCount())
                    .sum();

            if (totalItems >= REQUIRED_ITEMS) {
                transformationParticles((ServerLevel) level, pos); // <<< Partikel hinzufügen
                level.setBlock(pos, ModBlocks.SCARLET_TREE_SAPLING.get().defaultBlockState(), 3);
                removeItemsAt(level, pos);
            }

        }
        super.stepOn(level, pos, state, entity);
    }

    private void transformationParticles(ServerLevel level, BlockPos pos) {
        double centerX = pos.getX() + 0.5;
        double centerY = pos.getY() + 0.0;
        double centerZ = pos.getZ() + 0.5;

        for (int angle = 0; angle < 360; angle += 20) {
            double radians = Math.toRadians(angle);
            double speed = 0.4; // Geschwindigkeit des Partikels

            double vx = Math.cos(radians) * speed;
            double vz = Math.sin(radians) * speed;
            double vy = 0.1; // leicht nach oben

            // Erstes Partikel: Flamme
            level.sendParticles(ModParticles.MAGIC_PARTICLE.get(),
                    centerX, centerY, centerZ,
                    0, vx, vy, vz, 1.0);

            // Zweites Partikel: Dein eigenes (z. B. MAGIC_SPARK)
            level.sendParticles(ModParticles.MAGIC_PARTICLE2.get(),
                    centerX, centerY, centerZ,
                    0, vx * 0.4, vy, vz * 0.4, 1.0);
        }
    }


    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.FUEL);
    }

    private void removeItemsAt(Level level, BlockPos pos) {
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos));
        for (ItemEntity item : items) {
            if (isValidItem(item.getItem())) {
                item.discard();
            }
        }
    }
}
