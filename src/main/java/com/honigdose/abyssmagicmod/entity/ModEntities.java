package com.honigdose.abyssmagicmod.entity;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AbyssMagicMod.MOD_ID);

    public static final RegistryObject<EntityType<LumaEntity>> LUMA =
            ENTITY_TYPES.register("luma", () -> EntityType.Builder.of(LumaEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.4f).build(String.valueOf(ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "luma"))));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
