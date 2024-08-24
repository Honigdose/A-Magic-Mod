package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AbyssMagicMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FIRERYTE_ORE);
        blockWithItem(ModBlocks.ABYSSSTEEL_ORE);
        blockWithItem(ModBlocks.FLORASTEEL_ORE);
        blockWithItem(ModBlocks.LUNARIUM_ORE);
        blockWithItem(ModBlocks.SOLARIUM_ORE);
        blockWithItem(ModBlocks.SUIRYTE_ORE);
        blockWithItem(ModBlocks.SYLPHTHYL_ORE);

        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_WATERTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_AIRTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_FIRETYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_NATURTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_SOLARTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_LUNARIUM);

        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_WATERTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_AIRTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_FIRETYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_NATURTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_SOLARTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_LUNARIUM);

        blockWithItem(ModBlocks.FIRE_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.WATER_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.NATUR_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.AIR_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.SOLAR_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.LUNAR_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.ARCANA_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.VOID_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.CELESTIAL_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.DEMONIC_CRYSTAL_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
