package com.honigdose.abyssmagicmod.event;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.alchemy.researchtable.ResearchTableScreen;
import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.lunar.LunarEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.nature.NatureEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.solar.SolarEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.nature.glowingmushroom.GlowingTreeMushroomRendere;
import com.honigdose.abyssmagicmod.entity.ModEntities;
import com.honigdose.abyssmagicmod.entity.client.luma.LumaRenderer;
import com.honigdose.abyssmagicmod.entity.custom.luma.LumaEntity;
import com.honigdose.abyssmagicmod.particle.MagicParticle2;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.particle.custom.MagicParticle;
import com.honigdose.abyssmagicmod.particle.custom.ScarletLeavesParticle;
import com.honigdose.abyssmagicmod.particle.custom.crystals.*;
import com.honigdose.abyssmagicmod.particle.custom.element_particles.VoidParticles;
import com.honigdose.abyssmagicmod.particle.custom.essence.*;
import com.honigdose.abyssmagicmod.particle.custom.mob.luma.*;
import com.honigdose.abyssmagicmod.block.entity.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AbyssMagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LUMA.get(), LumaEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
        event.register(
                ModEntities.LUMA.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                LumaEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.RESEARCH_TABLE_MENU.get(), ResearchTableScreen::new);
        EntityRenderers.register(ModEntities.LUMA.get(), LumaRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.CUTE_CRYSTAL_PARTICLE.get(), CuteCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.ARCANA_CRYSTAL_PARTICLE.get(), ArcanaCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.VOID_CRYSTAL_PARTICLE.get(), VoidCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.LUNAR_CRYSTAL_PARTICLE.get(), LunarCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.FIRE_CRYSTAL_PARTICLE.get(), FireCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.WATER_CRYSTAL_PARTICLE.get(), WaterCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.NATUR_CRYSTAL_PARTICLE.get(), NaturCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.AIR_CRYSTAL_PARTICLE.get(), AirCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.SOLAR_CRYSTAL_PARTICLE.get(), SolarCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.DEMONIC_CRYSTAL_PARTICLE.get(), DemonicCrystalParticle.Provider::new);
        event.registerSpriteSet(ModParticles.CELESTIAL_CRYSTAL_PARTICLE.get(), CelestialCrystalParticle.Provider::new);

        event.registerSpriteSet(ModParticles.SCARLET_LEAVES_PARTICLE.get(), ScarletLeavesParticle.Provider::new);

        event.registerSpriteSet(ModParticles.ESSENCE_PARTICLE.get(), EssenceParticle.Provider::new);
        event.registerSpriteSet(ModParticles.FIRE_ESSENCE_PARTICLE.get(), FireEssenceParticle.Provider::new);
        event.registerSpriteSet(ModParticles.BOTTLE_ESSENCE_PARTICLE.get(), BottleEssenceParticle.Provider::new);

        event.registerSpriteSet(ModParticles.MAGIC_PARTICLE.get(), MagicParticle.Provider::new);
        event.registerSpriteSet(ModParticles.MAGIC_PARTICLE2.get(), MagicParticle2.Provider::new);

        event.registerSpriteSet(ModParticles.VOID_PARTICLE.get(), VoidParticles.Provider::new);

        event.registerSpriteSet(ModParticles.LUMA_PARTICLE.get(), LumaParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntites.FIRE_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new FireEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.WATER_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new WaterEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.NATURE_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new NatureEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.LUNAR_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new LunarEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.SOLAR_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new SolarEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.AIR_ESSENCE_BOTTLE_ENTITY.get(),
                context -> new AirEssenceBottleRenderer());
        event.registerBlockEntityRenderer(ModBlockEntites.GLOWING_TREE_MUSHROOM_ENTITY.get(),
                context -> new GlowingTreeMushroomRendere());

    }

}