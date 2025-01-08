package com.honigdose.abyssmagicmod.block.entity;

import com.honigdose.abyssmagicmod.AbyssMagicMod;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.alchemy.ResearchTable.ResearchTableBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AbyssMagicMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<ResearchTableBlockEntity>> RESEARCH_TABLE_BE =
            BLOCK_ENTITIES.register("research_table_be", () -> BlockEntityType.Builder.of(
                    ResearchTableBlockEntity::new,
                    ModBlocks.RESEARCH_TABLE_ACACIA.get(),
                    ModBlocks.RESEARCH_TABLE_OAK.get(),
                    ModBlocks.RESEARCH_TABLE_BIRCH.get(),
                    ModBlocks.RESEARCH_TABLE_SPRUCE.get(),
                    ModBlocks.RESEARCH_TABLE_CRIMSON.get(),
                    ModBlocks.RESEARCH_TABLE_CHERRY.get(),
                    ModBlocks.RESEARCH_TABLE_MANGROVE.get(),
                    ModBlocks.RESEARCH_TABLE_JUNGLE.get(),
                    ModBlocks.RESEARCH_TABLE_SCARLET.get(),
                    ModBlocks.RESEARCH_TABLE_WARPED.get(),
                    ModBlocks.RESEARCH_TABLE_DARK_OAK.get()
            ).build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
