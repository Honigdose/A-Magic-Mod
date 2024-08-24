package com.honigdose.abyssmagicmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CHERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(2)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 100),0.25f).build();
}
