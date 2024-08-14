package com.honigdose.abyssmagicmod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AbyssMagicMod.MOD_ID)
public class AbyssMagicMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "abyssmagicmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public AbyssMagicMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
//hello
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ABYSSSTEEL);
            event.accept(ModItems.RAW_ABYSSSTEEL);

            event.accept(ModItems.BLOODGOLD);
            event.accept(ModItems.RAW_BLOODGOLD);

            event.accept(ModItems.CELESTIUM);
            event.accept(ModItems.RAW_CELESTIUM);

            event.accept(ModItems.FIRERYTE);
            event.accept(ModItems.RAW_FIRERYTE);

            event.accept(ModItems.FLORASTEEL);
            event.accept(ModItems.RAW_FLORASTEEl);

            event.accept(ModItems.LUNARIUM);
            event.accept(ModItems.RAW_LUNARIUM);

            event.accept(ModItems.SOLARIUM);
            event.accept(ModItems.RAW_SOLARIUM);

            event.accept(ModItems.SUIRYTE);
            event.accept(ModItems.RAW_SUIRYTE);

            event.accept(ModItems.SYLPHTHYL);
            event.accept(ModItems.RAW_SYLPHTHYL);

            event.accept(ModItems.MYRINIUM);
            event.accept(ModItems.RAW_MYRINIUM);

            event.accept(ModItems.MANATHYL);

            event.accept(ModItems.MAGESSENZ);
            event.accept(ModItems.MAGESSENZ_WATERTYP);
            event.accept(ModItems.MAGESSENZ_FIRETYP);
            event.accept(ModItems.MAGESSENZ_AIRTYP);
            event.accept(ModItems.MAGESSENZ_NATURTYP);
            event.accept(ModItems.MAGESSENZ_LUNARTYP);
            event.accept(ModItems.MAGESSENZ_SOLARTYP);

            event.accept(ModItems.RAW_MAGESSENZ);
            event.accept(ModItems.RAW_MAGESSENZ_WATERTYP);
            event.accept(ModItems.RAW_MAGESSENZ_FIRETYP);
            event.accept(ModItems.RAW_MAGESSENZ_AIRTYP);
            event.accept(ModItems.RAW_MAGESSENZ_NATURTYP);
            event.accept(ModItems.RAW_MAGESSENZ_LUNARTYP);
            event.accept(ModItems.RAW_MAGESSENZ_SOLARTYP);

        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){

            event.accept(ModBlocks.ABYSSSTEEL_ORE);
            event.accept(ModBlocks.FIRERYTE_ORE);
            event.accept(ModBlocks.FLORASTEEL_ORE);
            event.accept(ModBlocks.SOLARIUM_ORE);
            event.accept(ModBlocks.LUNARIUM_ORE);
            event.accept(ModBlocks.SUIRYTE_ORE);
            event.accept(ModBlocks.SYLPHTHYL_ORE);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){


    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }
}
