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

                        // ORE/INGOTS/RAW ORE
                        output.accept(ModItems.ASTRATHYL.get());
                        output.accept(ModItems.RAW_ASTRATHYL.get());
                        output.accept(ModBlocks.ASTRATHYL_BLOCK.get());

                        output.accept(ModItems.ABYSSSTEEL.get());
                        output.accept(ModItems.RAW_ABYSSSTEEL.get());
                        output.accept(ModBlocks.ABYSSSTEEL_ORE.get());
                        output.accept(ModBlocks.ABYSSSTEEL_BLOCK.get());

                        output.accept(ModItems.BLOODGOLD.get());
                        output.accept(ModItems.RAW_BLOODGOLD.get());
                        output.accept(ModBlocks.BLOODGOLD_BLOCK.get());

                        output.accept(ModItems.CELESTIUM.get());
                        output.accept(ModItems.RAW_CELESTIUM.get());
                        output.accept(ModBlocks.CELESTIUM_BLOCK.get());

                        output.accept(ModItems.FIRERYTE.get());
                        output.accept(ModItems.RAW_FIRERYTE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE_STONE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE.get());
                        output.accept(ModBlocks.FIRERYTE_BLOCK.get());

                        output.accept(ModItems.SUIRYTE.get());
                        output.accept(ModItems.RAW_SUIRYTE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE_STONE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE.get());
                        output.accept(ModBlocks.SUIRYTE_BLOCK.get());

                        output.accept(ModItems.FLORASTEEL.get());
                        output.accept(ModItems.RAW_FLORASTEEl.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE_STONE.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE.get());
                        output.accept(ModBlocks.FLORASTEEL_BLOCK.get());

                        output.accept(ModItems.SYLPHTHYL.get());
                        output.accept(ModItems.RAW_SYLPHTHYL.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE_STONE.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE.get());
                        output.accept(ModBlocks.SYLPHTHYL_BLOCK.get());

                        output.accept(ModItems.SOLARIUM.get());
                        output.accept(ModItems.RAW_SOLARIUM.get());
                        output.accept(ModBlocks.SOLARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.SOLARIUM_ORE.get());
                        output.accept(ModBlocks.SOLARIUM_BLOCK.get());

                        output.accept(ModItems.LUNARIUM.get());
                        output.accept(ModItems.RAW_LUNARIUM.get());
                        output.accept(ModBlocks.LUNARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.LUNARIUM_ORE.get());
                        output.accept(ModBlocks.LUNARIUM_BLOCK.get());

                        output.accept(ModItems.MYRINIUM.get());
                        output.accept(ModItems.RAW_MYRINIUM.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_STONE.get());

                        output.accept(ModItems.MANATHYL.get());

                        output.accept(ModItems.PURE_SILVER.get());

                        output.accept(ModItems.SILVER.get());
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModBlocks.SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.FIRE_SILVER.get());
                        output.accept(ModItems.RAW_FIRE_SILVER.get());
                        output.accept(ModBlocks.FIRE_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.WATER_SILVER.get());
                        output.accept(ModItems.RAW_WATER_SILVER.get());
                        output.accept(ModBlocks.WATER_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.WATER_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.NATUR_SILVER.get());
                        output.accept(ModItems.RAW_NATUR_SILVER.get());
                        output.accept(ModBlocks.NATUR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.NATUR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.AIR_SILVER.get());
                        output.accept(ModItems.RAW_AIR_SILVER.get());
                        output.accept(ModBlocks.AIR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.AIR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.SOLAR_SILVER.get());
                        output.accept(ModItems.RAW_SOLAR_SILVER.get());
                        output.accept(ModBlocks.SOLAR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.LUNAR_SILVER.get());
                        output.accept(ModItems.RAW_LUNAR_SILVER.get());
                        output.accept(ModBlocks.LUNAR_SILVER_ORE_STONE.get());
                        output.accept(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE.get());

                        output.accept(ModItems.PURE_GOLD.get());

                        output.accept(ModItems.FIRE_GOLD.get());
                        output.accept(ModItems.RAW_FIRE_GOLD.get());
                        output.accept(ModBlocks.FIRE_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.WATER_GOLD.get());
                        output.accept(ModItems.RAW_WATER_GOLD.get());
                        output.accept(ModBlocks.WATER_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.WATER_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.NATUR_GOLD.get());
                        output.accept(ModItems.RAW_NATUR_GOLD.get());
                        output.accept(ModBlocks.NATUR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.NATUR_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.AIR_GOLD.get());
                        output.accept(ModItems.RAW_AIR_GOLD.get());
                        output.accept(ModBlocks.AIR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.AIR_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.SOLAR_GOLD.get());
                        output.accept(ModItems.RAW_SOLAR_GOLD.get());
                        output.accept(ModBlocks.SOLAR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE.get());

                        output.accept(ModItems.LUNAR_GOLD.get());
                        output.accept(ModItems.RAW_LUNAR_GOLD.get());
                        output.accept(ModBlocks.LUNAR_GOLD_ORE_STONE.get());
                        output.accept(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE.get());


                        // CRYSTALS
                        output.accept(ModItems.ARCANA_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_ARCANA_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.VOID_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_VOID_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.DEMONIC_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.CELESTIAL_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.FIRE_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.FIRE_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.WATER_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_WATER_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.NATUR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.AIR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_AIR_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.SOLAR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.LUNAR_CRYSTAL_SHARD.get());
                        output.accept(ModBlocks.BABY_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.SMALL_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LARGE_LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL_BLOCK.get());

                        // WOOD
                        // Scarlet Tree
                        output.accept(ModBlocks.SCARLET_TREE_SAPLING.get());
                        output.accept(ModBlocks.SCARLET_TREE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get());
                        output.accept(ModBlocks.SCARLET_TREE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get());
                        output.accept(ModBlocks.SCARLET_TREE_LEAVES.get());
                        output.accept(ModBlocks.SCARLET_TREE_PLANKS.get());
                        output.accept(ModBlocks.SCARLET_TREE_STAIR.get());
                        output.accept(ModBlocks.SCARLET_TREE_SLAB.get());
                        output.accept(ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SCARLET_TREE_BUTTON.get());
                        output.accept(ModBlocks.SCARLET_TREE_FENCE.get());
                        output.accept(ModBlocks.SCARLET_TREE_FENCE_GATE.get());
                        output.accept(ModBlocks.SCARLET_TREE_WALL.get());
                        output.accept(ModBlocks.SCARLET_TREE_DOOR.get());
                        output.accept(ModBlocks.SCARLET_TREE_TRAPDOOR.get());

                        // Life Tree
                        output.accept(ModBlocks.LIFE_TREE_SAPLING.get());
                        output.accept(ModBlocks.LIFE_TREE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_LIFE_TREE_LOG.get());
                        output.accept(ModBlocks.LIFE_TREE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_LIFE_TREE_WOOD.get());
                        output.accept(ModBlocks.LIFE_TREE_LEAVES.get());
                        output.accept(ModBlocks.LIFE_TREE_PLANKS.get());
                        //FIRE TYP
                        output.accept(ModBlocks.LIFE_TREE_FIRETYP_DOOR.get());


                        //Tools
                        //Stage 1
                        output.accept(ModItems.FIRERYTE_PICKAXE_STAGE1.get());




                    }).build());


    public static final RegistryObject<CreativeModeTab> ABYSSMAGIC_ALCHEMY_TAB = CREATIVE_MODE_TABS.register("abyssmagicmod_alchemy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROUND_FIRE_ESSENZ.get())).withTabsBefore(ABYSSMAGIC_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.abyssmagicmod.alchemy_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MAGIC_ROUND_BOTTLE.get());
                        output.accept(ModBlocks.MAGIC_SQUARE_BOTTLE.get());
                        output.accept(ModBlocks.MAGIC_TRIANGLE_BOTTLE.get());

                        output.accept(ModItems.ROUND_ARCANA_ESSENZ.get());
                        output.accept(ModItems.SQUARE_ARCANA_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_ARCANA_ESSENZ.get());
                        output.accept(ModItems.ROUND_VOID_ESSENZ.get());
                        output.accept(ModItems.SQUARE_VOID_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_VOID_ESSENZ.get());
                        output.accept(ModItems.ROUND_CELESTIAL_ESSENZ.get());
                        output.accept(ModItems.SQUARE_CELESTIAL_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_CELESTIAL_ESSENZ.get());
                        output.accept(ModItems.ROUND_DEMONIC_ESSENZ.get());
                        output.accept(ModItems.SQUARE_DEMONIC_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_DEMONIC_ESSENZ.get());
                        output.accept(ModItems.ROUND_FIRE_ESSENZ.get());
                        output.accept(ModItems.SQUARE_FIRE_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_FIRE_ESSENZ.get());
                        output.accept(ModItems.ROUND_WATER_ESSENZ.get());
                        output.accept(ModItems.SQUARE_WATER_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_WATER_ESSENZ.get());
                        output.accept(ModItems.ROUND_NATUR_ESSENZ.get());
                        output.accept(ModItems.SQUARE_NATUR_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_NATUR_ESSENZ.get());
                        output.accept(ModItems.ROUND_AIR_ESSENZ.get());
                        output.accept(ModItems.SQUARE_AIR_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_AIR_ESSENZ.get());
                        output.accept(ModItems.ROUND_SOLAR_ESSENZ.get());
                        output.accept(ModItems.SQUARE_SOLAR_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_SOLAR_ESSENZ.get());
                        output.accept(ModItems.ROUND_LUNAR_ESSENZ.get());
                        output.accept(ModItems.SQUARE_LUNAR_ESSENZ.get());
                        output.accept(ModItems.TRIANGLE_LUNAR_ESSENZ.get());

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}