package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AbyssMagicMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //Ore
        blockWithItem(ModBlocks.ABYSSSTEEL_ORE);
        blockWithItem(ModBlocks.SYLPHTHYL_ORE);
        blockWithItem(ModBlocks.SUIRYTE_ORE);
        blockWithItem(ModBlocks.FIRERYTE_ORE);
        blockWithItem(ModBlocks.FLORASTEEL_ORE);
        blockWithItem(ModBlocks.LUNARIUM_ORE);
        blockWithItem(ModBlocks.SOLARIUM_ORE);
        blockWithItem(ModBlocks.MYRINIUM_ORE_STONE);
        blockWithItem(ModBlocks.MYRINIUM_ORE_DEEPSLATE);

        blockWithItem(ModBlocks.FIRERYTE_BLOCK);
        blockWithItem(ModBlocks.SUIRYTE_BLOCK);

        blockWithItem(ModBlocks.MAGESSENZ_BLOCK);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_WATERTYP);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_FIRETYPE);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_AIRTYP);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_NATURTYP);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_SOLARTYP);
        blockWithItem(ModBlocks.MAGESSENZ_BLOCK_LUNARTYP);

        blockWithItem(ModBlocks.FIRERYTE_RAW_BLOCK);

        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_LUNARIUM);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_SOLARTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_FIRETYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_WATERTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_NATURTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_STONE_AIRTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_LUNARIUM);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_SOLARTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_FIRETYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_WATERTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_NATURTYP);
        blockWithItem(ModBlocks.MAGESSENZ_ORE_DEEPSLATE_AIRTYP);

        crystalBlock(ModBlocks.FIRE_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.WATER_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.NATUR_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.ARCANA_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.AIR_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.LUNAR_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.SOLAR_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.VOID_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.DEMONIC_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.CELESTIAL_CRYSTAL_BLOCK);

        blockItem(ModBlocks.FIRE_CRYSTAL_BLOCK);
        blockItem(ModBlocks.CELESTIAL_CRYSTAL_BLOCK);
        blockItem(ModBlocks.DEMONIC_CRYSTAL_BLOCK);
        blockItem(ModBlocks.VOID_CRYSTAL_BLOCK);
        blockItem(ModBlocks.SOLAR_CRYSTAL_BLOCK);
        blockItem(ModBlocks.LUNAR_CRYSTAL_BLOCK);
        blockItem(ModBlocks.AIR_CRYSTAL_BLOCK);
        blockItem(ModBlocks.ARCANA_CRYSTAL_BLOCK);
        blockItem(ModBlocks.NATUR_CRYSTAL_BLOCK);
        blockItem(ModBlocks.WATER_CRYSTAL_BLOCK);

        crystalclusterBlock(ModBlocks.DEMONIC_CRYSTAL);
        crystalclusterBlock(ModBlocks.SOLAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.LUNAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.VOID_CRYSTAL);
        crystalclusterBlock(ModBlocks.CELESTIAL_CRYSTAL);
        crystalclusterBlock(ModBlocks.AIR_CRYSTAL);
        crystalclusterBlock(ModBlocks.ARCANA_CRYSTAL);
        crystalclusterBlock(ModBlocks.FIRE_CRYSTAL);
        crystalclusterBlock(ModBlocks.WATER_CRYSTAL);
        crystalclusterBlock(ModBlocks.NATUR_CRYSTAL);


        // TREE
        //SCARLET TREE
        blockWithItem(ModBlocks.SCARLET_TREE_PLANKS);
        logBlock(((RotatedPillarBlock) ModBlocks.SCARLET_TREE_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.SCARLET_TREE_WOOD.get()), blockTexture(ModBlocks.SCARLET_TREE_LOG.get()), blockTexture(ModBlocks.SCARLET_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SCARLET_TREE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get()), blockTexture(ModBlocks.STRIPPED_SCARLET_TREE_LOG.get()));
        slabBlock(((SlabBlock) ModBlocks.SCARLET_TREE_SLAB.get()), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.SCARLET_TREE_STAIR.get()), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.SCARLET_TREE_BUTTON.get(), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.SCARLET_TREE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.SCARLET_TREE_FENCE.get(), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.SCARLET_TREE_FENCE_GATE.get(), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        wallBlock((WallBlock) ModBlocks.SCARLET_TREE_WALL.get(), blockTexture(ModBlocks.SCARLET_TREE_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.SCARLET_TREE_DOOR.get()),modLoc("block/scarlet_tree_door_bottom"),modLoc("block/scarlet_tree_door_top"), "translucent");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SCARLET_TREE_TRAPDOOR.get()),modLoc("block/scarlet_tree_trapdoor"), true, "translucent");
        blockItem(ModBlocks.SCARLET_TREE_LOG);
        blockItem(ModBlocks.STRIPPED_SCARLET_TREE_LOG);
        blockItem(ModBlocks.SCARLET_TREE_WOOD);
        blockItem(ModBlocks.STRIPPED_SCARLET_TREE_WOOD);
        leavesBlock(ModBlocks.SCARLET_TREE_LEAVES);
        saplingBlock(ModBlocks.SCARLET_TREE_SAPLING);
        blockItem(ModBlocks.SCARLET_TREE_SLAB);
        blockItem(ModBlocks.SCARLET_TREE_STAIR);
        blockItem(ModBlocks.SCARLET_TREE_PRESSURE_PLATE);
        blockItem(ModBlocks.SCARLET_TREE_FENCE_GATE);
        blockItem(ModBlocks.SCARLET_TREE_TRAPDOOR, "_bottom");

        //Life Tree
        blockItem(ModBlocks.LIFE_TREE_LOG);
        blockItem(ModBlocks.LIFE_TREE_WOOD);
        blockItem(ModBlocks.STRIPPED_LIFE_TREE_LOG);
        blockItem(ModBlocks.LIFE_TREE_WOOD);
        blockItem(ModBlocks.STRIPPED_LIFE_TREE_WOOD);
        blockWithItem(ModBlocks.LIFE_TREE_PLANKS);
        leavesBlock(ModBlocks.LIFE_TREE_LEAVES);
        saplingBlock(ModBlocks.LIFE_TREE_SAPLING);
        logBlock(((RotatedPillarBlock) ModBlocks.LIFE_TREE_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIFE_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.LIFE_TREE_WOOD.get()), blockTexture(ModBlocks.LIFE_TREE_LOG.get()), blockTexture(ModBlocks.LIFE_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIFE_TREE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_LIFE_TREE_LOG.get()), blockTexture(ModBlocks.STRIPPED_LIFE_TREE_LOG.get()));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("abyssmagicmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("abyssmagicmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void crystalBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("translucent"));
    }
    private void crystalclusterBlock(RegistryObject<Block> blockRegistryObject) {
        // Erstelle die Blockstates mit mehreren Varianten
        getVariantBuilder(blockRegistryObject.get()).forAllStates(state -> {
            Direction direction = state.getValue(BlockStateProperties.FACING);

            // Definiere Rotation basierend auf der Richtung
            int xRotation = 0;
            int yRotation = 0;

            switch (direction) {
                case DOWN:
                    xRotation = 180;
                    break;
                case EAST:
                    xRotation = 90;
                    yRotation = 90;
                    break;
                case NORTH:
                    xRotation = 90;
                    break;
                case SOUTH:
                    xRotation = 90;
                    yRotation = 180;
                    break;
                case UP:
                    break;
                case WEST:
                    xRotation = 90;
                    yRotation = 270;
                    break;
            }

            // Definiere den Render-Typ (zum Beispiel "cutout")
            return ConfiguredModel.builder()
                    .modelFile(models().cross(blockRegistryObject.getId().getPath(), blockTexture(blockRegistryObject.get()))
                            .renderType("cutout"))
                    .rotationX(xRotation)
                    .rotationY(yRotation)
                    .build();
        });
    }
}
