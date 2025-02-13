package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.sun.jdi.event.ModificationWatchpointEvent;
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

        blockWithItem(ModBlocks.SILVER_ORE_STONE);
        blockWithItem(ModBlocks.AIR_SILVER_ORE_STONE);
        blockWithItem(ModBlocks.FIRE_SILVER_ORE_STONE);
        blockWithItem(ModBlocks.NATURE_SILVER_ORE_STONE);
        blockWithItem(ModBlocks.WATER_SILVER_ORE_STONE);
        blockWithItem(ModBlocks.SOLAR_SILVER_ORE_STONE);
        blockWithItem(ModBlocks.LUNAR_SILVER_ORE_STONE);

        blockWithItem(ModBlocks.SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.AIR_SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.FIRE_SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.WATER_SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.NATURE_SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.LUNAR_SILVER_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.SOLAR_SILVER_ORE_DEEPSLATE);

        blockWithItem(ModBlocks.AIR_GOLD_ORE_STONE);
        blockWithItem(ModBlocks.FIRE_GOLD_ORE_STONE);
        blockWithItem(ModBlocks.NATURE_GOLD_ORE_STONE);
        blockWithItem(ModBlocks.WATER_GOLD_ORE_STONE);
        blockWithItem(ModBlocks.SOLAR_GOLD_ORE_STONE);
        blockWithItem(ModBlocks.LUNAR_GOLD_ORE_STONE);

        blockWithItem(ModBlocks.AIR_GOLD_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.FIRE_GOLD_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.WATER_GOLD_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.NATURE_GOLD_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.LUNAR_GOLD_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.SOLAR_GOLD_ORE_DEEPSLATE);

        blockWithItem(ModBlocks.FIRERYTE_ORE_STONE);
        blockWithItem(ModBlocks.SOLARIUM_ORE_STONE);
        blockWithItem(ModBlocks.LUNARIUM_ORE_STONE);
        blockWithItem(ModBlocks.SYLPHTHYL_ORE_STONE);
        blockWithItem(ModBlocks.FLORASTEEL_ORE_STONE);
        blockWithItem(ModBlocks.SUIRYTE_ORE_STONE);

        ingotBlock(ModBlocks.FIRERYTE_BLOCK);
        blockItem(ModBlocks.FIRERYTE_BLOCK);
        ingotBlock(ModBlocks.SUIRYTE_BLOCK);
        blockItem(ModBlocks.SUIRYTE_BLOCK);
        ingotBlock(ModBlocks.FLORASTEEL_BLOCK);
        blockItem(ModBlocks.FLORASTEEL_BLOCK);
        ingotBlock(ModBlocks.SYLPHTHYL_BLOCK);
        blockItem(ModBlocks.SYLPHTHYL_BLOCK);
        ingotBlock(ModBlocks.SOLARIUM_BLOCK);
        blockItem(ModBlocks.SOLARIUM_BLOCK);
        ingotBlock(ModBlocks.LUNARIUM_BLOCK);
        blockItem(ModBlocks.LUNARIUM_BLOCK);
        ingotBlock(ModBlocks.ASTRATHYL_BLOCK);
        blockItem(ModBlocks.ASTRATHYL_BLOCK);
        ingotBlock(ModBlocks.ABYSSSTEEL_BLOCK);
        blockItem(ModBlocks.ABYSSSTEEL_BLOCK);
        ingotBlock(ModBlocks.BLOODGOLD_BLOCK);
        blockItem(ModBlocks.BLOODGOLD_BLOCK);
        ingotBlock(ModBlocks.CELESTIUM_BLOCK);
        blockItem(ModBlocks.CELESTIUM_BLOCK);



        crystalBlock(ModBlocks.FIRE_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.WATER_CRYSTAL_BLOCK);
        crystalBlock(ModBlocks.NATURE_CRYSTAL_BLOCK);
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
        blockItem(ModBlocks.NATURE_CRYSTAL_BLOCK);
        blockItem(ModBlocks.WATER_CRYSTAL_BLOCK);

        crystalclusterBlock(ModBlocks.VERY_SMALL_DEMONIC_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_SOLAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_LUNAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_VOID_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_CELESTIAL_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_AIR_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_ARCANA_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_FIRE_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_WATER_CRYSTAL);
        crystalclusterBlock(ModBlocks.VERY_SMALL_NATURE_CRYSTAL);

        crystalclusterBlock(ModBlocks.SMALL_DEMONIC_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_SOLAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_LUNAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_VOID_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_CELESTIAL_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_AIR_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_ARCANA_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_FIRE_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_WATER_CRYSTAL);
        crystalclusterBlock(ModBlocks.SMALL_NATURE_CRYSTAL);

        crystalclusterBlock(ModBlocks.DEMONIC_CRYSTAL);
        crystalclusterBlock(ModBlocks.SOLAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.LUNAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.VOID_CRYSTAL);
        crystalclusterBlock(ModBlocks.CELESTIAL_CRYSTAL);
        crystalclusterBlock(ModBlocks.AIR_CRYSTAL);
        crystalclusterBlock(ModBlocks.ARCANA_CRYSTAL);
        crystalclusterBlock(ModBlocks.FIRE_CRYSTAL);
        crystalclusterBlock(ModBlocks.WATER_CRYSTAL);
        crystalclusterBlock(ModBlocks.NATURE_CRYSTAL);

        crystalclusterBlock(ModBlocks.BABY_DEMONIC_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_SOLAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_LUNAR_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_VOID_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_CELESTIAL_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_AIR_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_ARCANA_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_FIRE_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_WATER_CRYSTAL);
        crystalclusterBlock(ModBlocks.BABY_NATURE_CRYSTAL);



        // TREE
        // Minecraft Wood Typ

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
        saplingBlock(ModBlocks.LIFE_TREE_SAPLING);

        blockWithItem(ModBlocks.BLIFE_TREE_PLANKS);
        logBlock(((RotatedPillarBlock) ModBlocks.BLIFE_TREE_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLIFE_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BLIFE_TREE_WOOD.get()), blockTexture(ModBlocks.BLIFE_TREE_LOG.get()), blockTexture(ModBlocks.BLIFE_TREE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLIFE_TREE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BLIFE_TREE_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLIFE_TREE_LOG.get()));
        slabBlock(((SlabBlock) ModBlocks.BLIFE_TREE_SLAB.get()), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.BLIFE_TREE_STAIR.get()), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.BLIFE_TREE_BUTTON.get(), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.BLIFE_TREE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.BLIFE_TREE_FENCE.get(), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BLIFE_TREE_FENCE_GATE.get(), blockTexture(ModBlocks.BLIFE_TREE_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLIFE_TREE_DOOR.get()),modLoc("block/blife_tree_door_bottom"),modLoc("block/blife_tree_door_top"), "translucent");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLIFE_TREE_TRAPDOOR.get()),modLoc("block/blife_tree_trapdoor"), true, "translucent");
        blockItem(ModBlocks.BLIFE_TREE_LOG);
        blockItem(ModBlocks.STRIPPED_BLIFE_TREE_LOG);
        blockItem(ModBlocks.BLIFE_TREE_WOOD);
        blockItem(ModBlocks.STRIPPED_BLIFE_TREE_WOOD);
        blockItem(ModBlocks.BLIFE_TREE_SLAB);
        blockItem(ModBlocks.BLIFE_TREE_STAIR);
        blockItem(ModBlocks.BLIFE_TREE_PRESSURE_PLATE);
        blockItem(ModBlocks.BLIFE_TREE_FENCE_GATE);
        blockItem(ModBlocks.BLIFE_TREE_TRAPDOOR, "_bottom");

        //FIRE
        leavesBlock(ModBlocks.BLIFE_TREE_FIRE_LEAVES);
        saplingBlock(ModBlocks.BLIFE_TREE_FIRE_SAPLING);
        saplingBlock(ModBlocks.BLT_FIRE_HLEAVES);
        saplingBlock(ModBlocks.BLT_FIRE_HLEAVES_PLANT);
        blockWithItem(ModBlocks.BLIFE_TREE_FIRE_RESIN);

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
        getVariantBuilder(blockRegistryObject.get())
                .forAllStates(state -> {
            Direction direction = state.getValue(BlockStateProperties.FACING);

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

            return ConfiguredModel.builder()
                    .modelFile(models().cross(blockRegistryObject.getId().getPath(), blockTexture(blockRegistryObject.get()))
                            .renderType("cutout"))
                    .rotationX(xRotation)
                    .rotationY(yRotation)
                    .build();
        });

    }

    private void largecrystalclusterBlock(RegistryObject<Block> blockRegistryObject,  ResourceLocation bottom, ResourceLocation top) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    private void ingotBlock(RegistryObject<Block> blockRegistryObject) {
        getVariantBuilder(blockRegistryObject.get()).forAllStates(state -> {
            Direction direction = state.getValue(BlockStateProperties.FACING);

            int xRotation = 0;
            int yRotation = 0;

            switch (direction) {
                case DOWN:
                    xRotation = 180; // Unterseite nach unten
                    yRotation = 0;
                    break;
                case UP:
                    xRotation = 0;   // Oberseite nach oben, keine Rotation
                    yRotation = 0;
                    break;
                case NORTH:
                    xRotation = 0;  // Vorderseite nach Norden
                    yRotation = 180;
                    break;
                case SOUTH:
                    xRotation = 0;  // Vorderseite nach Süden
                    yRotation = 0;
                    break;
                case EAST:
                    xRotation = 0;  // Vorderseite nach Osten
                    yRotation = 270;
                    break;
                case WEST:
                    xRotation = 0;  // Vorderseite nach Westen
                    yRotation = 90;
                    break;
            }


            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(blockRegistryObject.getId().getPath(), blockTexture(blockRegistryObject.get()))
                            .renderType("solid"))
                    .rotationX(xRotation)
                    .rotationY(yRotation)
                    .build();
        });
    }
}
