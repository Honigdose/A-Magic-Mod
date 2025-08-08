package com.honigdose.abyssmagicmod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.data.ModDataComponentTypes;
import com.honigdose.abyssmagicmod.entity.ModEntities;

import com.honigdose.abyssmagicmod.recipe.ModRecipes;
import com.honigdose.abyssmagicmod.util.ModCreativeModeTabs;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.block.entity.screen.ModMenuTypes;
import com.honigdose.abyssmagicmod.worldgen.biome.ModBiomes;
import com.honigdose.abyssmagicmod.worldgen.biome.ModSurfaceRules;
import com.honigdose.abyssmagicmod.worldgen.features.ModFeatures;
import com.honigdose.abyssmagicmod.worldgen.tree.ModTreeDecoratorTypes;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.LifeTree.LifeTreeTrunkPlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletFoliagePlacer;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTrunkPlacer;
import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;


import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


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
        ModEntities.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);


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


}

