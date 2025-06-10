package com.honigdose.abyssmagicmod.block.essence.bottle.nature;


import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NatureEssenceBottleEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public NatureEssenceBottleEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntites.NATURE_ESSENCE_BOTTLE_ENTITY.get(), pos, state);
    }

    public Direction getFacing() {
        return this.getBlockState().getValue(NatureEssenceBottle.FACING);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
