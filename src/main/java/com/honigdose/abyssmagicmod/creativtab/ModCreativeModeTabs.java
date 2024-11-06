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



                        output.accept(ModBlocks.ASTRATHYL_BLOCK.get());
                        output.accept(ModBlocks.ABYSSSTEEL_BLOCK.get());
                        output.accept(ModBlocks.BLOODGOLD_BLOCK.get());
                        output.accept(ModBlocks.CELESTIUM_BLOCK.get());
                        output.accept(ModBlocks.FIRERYTE_BLOCK.get());
                        output.accept(ModBlocks.SUIRYTE_BLOCK.get());
                        output.accept(ModBlocks.FLORASTEEL_BLOCK.get());
                        output.accept(ModBlocks.SYLPHTHYL_BLOCK.get());
                        output.accept(ModBlocks.LUNARIUM_BLOCK.get());
                        output.accept(ModBlocks.SOLARIUM_BLOCK.get());

                        output.accept(ModItems.RAW_ABYSSSTEEL.get());
                        output.accept(ModItems.RAW_ASTRATHYL.get());
                        output.accept(ModItems.RAW_BLOODGOLD.get());
                        output.accept(ModItems.RAW_CELESTIUM.get());
                        output.accept(ModItems.RAW_FIRERYTE.get());
                        output.accept(ModItems.RAW_FLORASTEEl.get());
                        output.accept(ModItems.RAW_LUNARIUM.get());
                        output.accept(ModItems.RAW_SOLARIUM.get());
                        output.accept(ModItems.RAW_SUIRYTE.get());
                        output.accept(ModItems.RAW_SYLPHTHYL.get());
                        output.accept(ModItems.RAW_MYRINIUM.get());


                        output.accept(ModBlocks.FIRERYTE_ORE_STONE.get());
                        output.accept(ModBlocks.SOLARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.LUNARIUM_ORE_STONE.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE_STONE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE_STONE.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE_STONE.get());

                        output.accept(ModBlocks.ABYSSSTEEL_ORE.get());
                        output.accept(ModBlocks.FIRERYTE_ORE.get());
                        output.accept(ModBlocks.FLORASTEEL_ORE.get());
                        output.accept(ModBlocks.LUNARIUM_ORE.get());
                        output.accept(ModBlocks.SOLARIUM_ORE.get());
                        output.accept(ModBlocks.SUIRYTE_ORE.get());
                        output.accept(ModBlocks.SYLPHTHYL_ORE.get());

                        output.accept(ModBlocks.MYRINIUM_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.MYRINIUM_ORE_STONE.get());

                        output.accept(ModBlocks.SILVER_ORE_STONE.get());

                        output.accept(ModBlocks.SILVER_ORE_DEEPSLATE.get());


                        // CRYSTALS
                        output.accept(ModBlocks.FIRE_CRYSTAL.get());
                        output.accept(ModBlocks.AIR_CRYSTAL.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL.get());
                        output.accept(ModBlocks.WATER_CRYSTAL.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL.get());
                        output.accept(ModBlocks.VOID_CRYSTAL.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL.get());

                        output.accept(ModBlocks.FIRE_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.AIR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.NATUR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.WATER_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.SOLAR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.LUNAR_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.DEMONIC_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.VOID_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.CELESTIAL_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.ARCANA_CRYSTAL_BLOCK.get());

                        output.accept(ModItems.AIR_CRYSTAL_SHARD.get());
                        output.accept(ModItems.NATUR_CRYSTAL_SHARD.get());
                        output.accept(ModItems.WATER_CRYSTAL_SHARD.get());
                        output.accept(ModItems.FIRE_CRYSTAL_SHARD.get());
                        output.accept(ModItems.SOLAR_CRYSTAL_SHARD.get());
                        output.accept(ModItems.LUNAR_CRYSTAL_SHARD.get());
                        output.accept(ModItems.VOID_CRYSTAL_SHARD.get());
                        output.accept(ModItems.DEMONIC_CRYSTAL_SHARD.get());
                        output.accept(ModItems.CELESTIAL_CRYSTAL_SHARD.get());
                        output.accept(ModItems.ARCANA_CRYSTAL_SHARD.get());

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




    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}