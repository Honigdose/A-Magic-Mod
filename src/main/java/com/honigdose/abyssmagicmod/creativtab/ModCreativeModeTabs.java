package com.honigdose.abyssmagicmod.creativtab;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbyssMagicMod.MOD_ID);



    public static final RegistryObject<CreativeModeTab> ABYSSMAGIC_ITEMS_TAB = CREATIVE_MODE_TABS.register("abyssmagicmod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ABYSSSTEEL.get()))
                    .title(Component.translatable("creativetab.abyssmagicmod.abyssmagic_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.ABYSSSTEEL.get());
                        output.accept(ModItems.BLOODGOLD.get());
                        output.accept(ModItems.CELESTIUM.get());
                        output.accept(ModItems.FIRERYTE.get());
                        output.accept(ModItems.FLORASTEEL.get());
                        output.accept(ModItems.LUNARIUM.get());
                        output.accept(ModItems.SOLARIUM.get());
                        output.accept(ModItems.SUIRYTE.get());
                        output.accept(ModItems.SYLPHTHYL.get());
                        output.accept(ModItems.MYRINIUM.get());
                        output.accept(ModItems.MANATHYL.get());
                        output.accept(ModItems.MAGESSENZ.get());
                        output.accept(ModItems.MAGESSENZ_AIRTYP.get());
                        output.accept(ModItems.MAGESSENZ_FIRETYP.get());
                        output.accept(ModItems.MAGESSENZ_LUNARTYP.get());
                        output.accept(ModItems.MAGESSENZ_WATERTYP.get());
                        output.accept(ModItems.MAGESSENZ_NATURTYP.get());
                        output.accept(ModItems.MAGESSENZ_NATURTYP.get());

                        output.accept(ModBlocks.FIRERYTE_BLOCK.get());
                        output.accept(ModBlocks.SUIRYTE_BLOCK.get());

                        output.accept(ModItems.RAW_ABYSSSTEEL.get());
                        output.accept(ModItems.RAW_BLOODGOLD.get());
                        output.accept(ModItems.RAW_CELESTIUM.get());
                        output.accept(ModItems.RAW_FIRERYTE.get());
                        output.accept(ModItems.RAW_FLORASTEEl.get());
                        output.accept(ModItems.RAW_LUNARIUM.get());
                        output.accept(ModItems.RAW_SOLARIUM.get());
                        output.accept(ModItems.RAW_SUIRYTE.get());
                        output.accept(ModItems.RAW_SYLPHTHYL.get());
                        output.accept(ModItems.RAW_MYRINIUM.get());
                        output.accept(ModItems.RAW_MAGESSENZ.get());
                        output.accept(ModItems.RAW_MAGESSENZ_AIRTYP.get());
                        output.accept(ModItems.RAW_MAGESSENZ_FIRETYP.get());
                        output.accept(ModItems.RAW_MAGESSENZ_LUNARTYP.get());
                        output.accept(ModItems.RAW_MAGESSENZ_WATERTYP.get());
                        output.accept(ModItems.RAW_MAGESSENZ_NATURTYP.get());
                        output.accept(ModItems.RAW_MAGESSENZ_SOLARTYP.get());

                        output.accept(ModBlocks.FIRERYTE_RAW_BLOCK.get());


                        output.accept(ModBlocks.ABYSSSTEEL_ORE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE.get());
                        output.accept(ModBlocks.LUNARIUM_ORE.get());
                        output.accept(ModBlocks.SOLARIUM_ORE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_STONE.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_AIRTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_AIRTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_FIRETYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_FIRETYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_LUNARIUM.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_LUNARIUM.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_WATERTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_WATERTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_NATURTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_NATURTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_SOLARTYP.get());
                        output.accept(ModBlocks.MAGESSENZ_ORE_STONE_SOLARTYP.get());

                        output.accept(ModBlocks.FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.FIRE_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.AIR_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.WATER_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL_BLOCK.get());


                    }).build());




    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
