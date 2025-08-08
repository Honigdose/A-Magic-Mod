package com.honigdose.abyssmagicmod.entity.custom.luma;

import com.honigdose.abyssmagicmod.entity.ModEntities;
import com.honigdose.abyssmagicmod.entity.custom.luma.goals.LumaFlyingGoal;
import com.honigdose.abyssmagicmod.entity.custom.luma.goals.LumaSeekLightSourceGoal;
import com.honigdose.abyssmagicmod.entity.custom.luma.goals.LumaSleepGoal;
import com.honigdose.abyssmagicmod.entity.custom.luma.goals.LumaWakeUpGoal;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;


public class LumaEntity extends Animal implements GeoAnimatable, FlyingAnimal{
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(LumaEntity.class, EntityDataSerializers.INT);

    public LumaEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);

    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(2, new LumaWakeUpGoal(this));
        this.goalSelector.addGoal(3, new LumaSleepGoal(this));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.25, (p_332367_) -> {
            return p_332367_.is(Items.BROWN_MUSHROOM);
        }, false));
        //this.goalSelector.addGoal(6, new LumaSeekLightSourceGoal(this));
        this.goalSelector.addGoal(7, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(8, new LumaFlyingGoal(this, 1.0));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 2D)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.FLYING_SPEED, 0.3);

    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.BROWN_MUSHROOM);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        LumaEntity child = ModEntities.LUMA.get().create(serverLevel);

        if (child != null && ageableMob instanceof LumaEntity otherParent) {
            LumaVariant variantFromThis = this.getVariant();
            LumaVariant variantFromOther = otherParent.getVariant();

            LumaVariant inheritedVariant = this.random.nextBoolean() ? variantFromThis : variantFromOther;

            child.setVariant(inheritedVariant);
        }
        return child;
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel pLevel, DamageSource pDamageSource, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pLevel, pDamageSource, pRecentlyHit);

        if (!this.level().isClientSide) {
            this.spawnAtLocation(Items.GLOWSTONE_DUST, 1);
        }
    }

    private static final EntityDataAccessor<Boolean> IS_SLEEPING =
            SynchedEntityData.defineId(LumaEntity.class, EntityDataSerializers.BOOLEAN);

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(IS_SLEEPING, false);
        builder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public LumaVariant getVariant() {
        return LumaVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(LumaVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }


    public boolean isSleepingLuma() {
        return this.entityData.get(IS_SLEEPING);
    }

    public void setSleepingLuma(boolean sleeping) {
        this.entityData.set(IS_SLEEPING, sleeping);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> state) {
        if (this.isSleepingLuma()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.luma.sleep", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (this.isCurrentlyDay()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.luma.sleep_flying", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.luma.fly", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }


        state.getController().setAnimation(RawAnimation.begin().then("animation.luma.fly", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object object) {
        return this.tickCount;
    }

    @Override
    public void tick() {
        super.tick();
        this.setNoGravity(true);

        if (!level().isClientSide) return;
        if (this.isCurrentlyDay() || this.isSleepingLuma()) return;

        if (this.random.nextFloat() < 0.1f) {
            int variantId = this.getVariant().getId();

            level().addParticle(ModParticles.LUMA_PARTICLE.get(),  // Nur ein Partikeltyp für alle Varianten
                    getX() + (random.nextDouble() - 0.5) * 0.3,
                    getY() + (random.nextDouble() - 0.5) * 0.3,
                    getZ() + (random.nextDouble() - 0.5) * 0.3,
                    variantId, 0, 0); // dx = Variant-ID, dy/dz ungenutzt
        }
    }


    public boolean isCurrentlyDay() {
        long time = this.level().getDayTime() % 24000L;
        return time >= 0 && time < 12000;
    }

    @Override
    public boolean isFlying() {
        return true;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new FlyingPathNavigation(this, level);
    }

    public boolean setNoGravity() {
        return true;
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty,
                                        MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        LumaVariant variant = Util.getRandom(LumaVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    public static boolean canSpawn(EntityType<LumaEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        boolean isNight = !level.getLevel().isDay();
        int lightLevel = level.getLevel().getBrightness(LightLayer.BLOCK, pos);

        boolean validBlock = level.getBlockState(pos.below()).isValidSpawn(level, pos.below(), entityType);

        return (isNight || lightLevel <= 7) && validBlock;
    }
}