package com.honigdose.abyssmagicmod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.alchemy.ResearchTable.ResearchTableScreen;
import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.particle.custom.crystals.CuteCrystalParticle;
import com.honigdose.abyssmagicmod.particle.custom.crystals.LunarCrystalParticle;
import com.honigdose.abyssmagicmod.particle.custom.ScarletLeavesParticle;
import com.honigdose.abyssmagicmod.particle.custom.crystals.VoidCrystalParticle;
import com.honigdose.abyssmagicmod.recipe.ModRecipes;
import com.honigdose.abyssmagicmod.util.ModCreativeModeTabs;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.screen.ModMenuTypes;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree.LifeTreeTrunkPlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletFoliagePlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTrunkPlacer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.api.distmarker.Dist;
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


        SCARLET_TRUNK_PLACER_TYPE_REGISTER.register(modEventBus);
        SCARLET_FOLIAGE_PLACER_TYPE_REGISTER.register(modEventBus);
        LIFE_TREE_TRUNK_PLACER_TYPE_REGISTER.register(modEventBus);



        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Server starting code
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(ModMenuTypes.RESEARCH_TABLE_MENU.get(), ResearchTableScreen::new);
        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.CUTE_CRYSTAL_PARTICLE.get(), CuteCrystalParticle.Provider::new);
            event.registerSpriteSet(ModParticles.VOID_CRYSTAL_PARTICLE.get(), VoidCrystalParticle.Provider::new);
            event.registerSpriteSet(ModParticles.LUNAR_CRYSTAL_PARTICLE.get(), LunarCrystalParticle.Provider::new);
            event.registerSpriteSet(ModParticles.SCARLET_LEAVES_PARTICLE.get(), ScarletLeavesParticle.Provider::new);
        }
    }

}

