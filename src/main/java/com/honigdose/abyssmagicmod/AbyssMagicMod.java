package com.honigdose.abyssmagicmod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.alchemy.ResearchTable.ResearchTableScreen;
import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.air.AirEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.fire.FireEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.lunar.LunarEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.lunar.LunarEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.nature.NatureEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.solar.SolarEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleEntity;
import com.honigdose.abyssmagicmod.block.essence.bottle.water.WaterEssenceBottleRenderer;
import com.honigdose.abyssmagicmod.block.nature.glowingmushroom.GlowingTreeMushroomRendere;
import com.honigdose.abyssmagicmod.particle.MagicParticle2;
import com.honigdose.abyssmagicmod.particle.custom.MagicParticle;
import com.honigdose.abyssmagicmod.particle.custom.crystals.*;
import com.honigdose.abyssmagicmod.particle.custom.ScarletLeavesParticle;
import com.honigdose.abyssmagicmod.particle.custom.element_particles.VoidParticles;
import com.honigdose.abyssmagicmod.particle.custom.essence.*;
import com.honigdose.abyssmagicmod.recipe.ModRecipes;
import com.honigdose.abyssmagicmod.util.ModCreativeModeTabs;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.screen.ModMenuTypes;
import com.honigdose.abyssmagicmod.worldgen.biome.ModBiomes;
import com.honigdose.abyssmagicmod.worldgen.biome.ModSurfaceRules;
import com.honigdose.abyssmagicmod.worldgen.features.ModFeatures;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeDecoratorTypes;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree.LifeTreeTrunkPlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletFoliagePlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTrunkPlacer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;


@Mod(AbyssMagicMod.MOD_ID)
public class AbyssMagicMod {

    public static final String MOD_ID = "abyssmagicmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<TrunkPlacerType<?>> SCARLET_TRUNK_PLACER_TYPE_REGISTER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AbyssMagicMod.MOD_ID);
    public static RegistryObject<TrunkPlacerType<ScarletTrunkPlacer>> SCARLET_TRUNK_PLACER = SCARLET_TRUNK_PLACER_TYPE_REGISTER.register("scarlet_trunk_placer", () -> new TrunkPlacerType<>(ScarletTrunkPlacer.CODEC));
    public static final DeferredRegister<FoliagePlacerType<?>> SCARLET_FOLIAGE_PLACER_TYPE_REGISTER = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, AbyssMagicMod.MOD_ID);
    public static RegistryObject<FoliagePlacerType<ScarletFoliagePlacer>> SCARLET_FOLIAGE_PLACER = SCARLET_FOLIAGE_PLACER_TYPE_REGISTER.register("scarlet_foliage_placer", () -> new FoliagePlacerType<>(ScarletFoliagePlacer.CODEC));

    public static final DeferredRegister<TrunkPlacerType<?>> LIFE_TREE_TRUNK_PLACER_TYPE_REGISTER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AbyssMagicMod.MOD_ID);
    public static RegistryObject<TrunkPlacerType<LifeTreeTrunkPlacer>> LIFE_TREE_TRUNK_PLACER = LIFE_TREE_TRUNK_PLACER_TYPE_REGISTER.register("life_tree_trunk_placer", () -> new TrunkPlacerType<>(LifeTreeTrunkPlacer.CODEC));

    public AbyssMagicMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModParticles.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModBlockEntites.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModTreeDecoratorTypes.register(modEventBus);


        SCARLET_TRUNK_PLACER_TYPE_REGISTER.register(modEventBus);
        SCARLET_FOLIAGE_PLACER_TYPE_REGISTER.register(modEventBus);
        LIFE_TREE_TRUNK_PLACER_TYPE_REGISTER.register(modEventBus);



        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.WHITE_BLACK_FLOWER.getId(), ModBlocks.POTTED_WHITE_BLACK_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.VOID_FLOWER.getId(), ModBlocks.POTTED_VOID_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PURE_VOID_FLOWER.getId(), ModBlocks.POTTED_PURE_VOID_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.INK_CAP.getId(), ModBlocks.POTTED_INK_CAP);



            ModBiomes.registerBiomes();


            // Register our surface rules
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeScarletForestRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, ModSurfaceRules.makeGlowstonePlainsRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, MOD_ID, ModSurfaceRules.makeEndRotRules());
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting code
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.RESEARCH_TABLE_MENU.get(), ResearchTableScreen::new);
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
            event.registerSpriteSet(ModParticles.AIR_ESSENCE_PARTICLE.get(), AirEssenceParticle.Provider::new);
            event.registerSpriteSet(ModParticles.NATURE_ESSENCE_PARTICLE.get(), NatureEssenceParticle.Provider::new);
            event.registerSpriteSet(ModParticles.WATER_ESSENCE_PARTICLE.get(), WaterEssenceParticle.Provider::new);
            event.registerSpriteSet(ModParticles.SOLAR_ESSENCE_PARTICLE.get(), SolarEssenceParticle.Provider::new);
            event.registerSpriteSet(ModParticles.LUNAR_ESSENCE_PARTICLE.get(), LunarEssenceParticle.Provider::new);

            event.registerSpriteSet(ModParticles.BOTTLE_ESSENCE_PARTICLE.get(), BottleEssenceParticle.Provider::new);
            event.registerSpriteSet(ModParticles.FIRE_ESSENCE_BOTTLE_PARTICLE.get(), FireEssenceBottleParticle.Provider::new);
            event.registerSpriteSet(ModParticles.WATER_ESSENCE_BOTTLE_PARTICLE.get(), WaterEssenceBottleParticle.Provider::new);
            event.registerSpriteSet(ModParticles.NATURE_ESSENCE_BOTTLE_PARTICLE.get(), NatureEssenceBottleParticle.Provider::new);
            event.registerSpriteSet(ModParticles.LUNAR_ESSENCE_BOTTLE_PARTICLE.get(), LunarEssenceBottleParticle.Provider::new);
            event.registerSpriteSet(ModParticles.SOLAR_ESSENCE_BOTTLE_PARTICLE.get(), SolarEssenceBottleParticle.Provider::new);
            event.registerSpriteSet(ModParticles.AIR_ESSENCE_BOTTLE_PARTICLE.get(), AirEssenceBottleParticle.Provider::new);

            event.registerSpriteSet(ModParticles.MAGIC_PARTICLE.get(), MagicParticle.Provider::new);
            event.registerSpriteSet(ModParticles.MAGIC_PARTICLE2.get(), MagicParticle2.Provider::new);

            event.registerSpriteSet(ModParticles.VOID_PARTICLE.get(), VoidParticles.Provider::new);

        }
    }

}

