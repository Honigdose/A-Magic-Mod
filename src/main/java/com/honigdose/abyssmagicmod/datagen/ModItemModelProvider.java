package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AbyssMagicMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.ASTRATHYL.get());
        basicItem(ModItems.ABYSSSTEEL.get());
        basicItem(ModItems.FIRERYTE.get());
        basicItem(ModItems.SYLPHTHYL.get());
        basicItem(ModItems.SUIRYTE.get());
        basicItem(ModItems.FLORASTEEL.get());
        basicItem(ModItems.LUNARIUM.get());
        basicItem(ModItems.SOLARIUM.get());
        basicItem(ModItems.MYRINIUM.get());
        basicItem(ModItems.MANATHYL.get());
        basicItem(ModItems.BLOODGOLD.get());
        basicItem(ModItems.CELESTIUM.get());

        basicItem(ModItems.RAW_ASTRATHYL.get());
        basicItem(ModItems.RAW_ABYSSSTEEL.get());
        basicItem(ModItems.RAW_FIRERYTE.get());
        basicItem(ModItems.RAW_SYLPHTHYL.get());
        basicItem(ModItems.RAW_SUIRYTE.get());
        basicItem(ModItems.RAW_FLORASTEEl.get());
        basicItem(ModItems.RAW_LUNARIUM.get());
        basicItem(ModItems.RAW_SOLARIUM.get());
        basicItem(ModItems.RAW_CELESTIUM.get());
        basicItem(ModItems.RAW_BLOODGOLD.get());
        basicItem(ModItems.RAW_MYRINIUM.get());

        basicItem(ModItems.SILVER.get());
        basicItem(ModItems.RAW_SILVER.get());

        basicItem(ModItems.AIR_CRYSTAL_SHARD.get());
        basicItem(ModItems.NATUR_CRYSTAL_SHARD.get());
        basicItem(ModItems.WATER_CRYSTAL_SHARD.get());
        basicItem(ModItems.FIRE_CRYSTAL_SHARD.get());
        basicItem(ModItems.SOLAR_CRYSTAL_SHARD.get());
        basicItem(ModItems.LUNAR_CRYSTAL_SHARD.get());
        basicItem(ModItems.VOID_CRYSTAL_SHARD.get());
        basicItem(ModItems.CELESTIAL_CRYSTAL_SHARD.get());
        basicItem(ModItems.DEMONIC_CRYSTAL_SHARD.get());
        basicItem(ModItems.ARCANA_CRYSTAL_SHARD.get());

        saplingItem(ModBlocks.FIRE_CRYSTAL);
        saplingItem(ModBlocks.WATER_CRYSTAL);
        saplingItem(ModBlocks.AIR_CRYSTAL);
        saplingItem(ModBlocks.NATUR_CRYSTAL);
        saplingItem(ModBlocks.LUNAR_CRYSTAL);
        saplingItem(ModBlocks.SOLAR_CRYSTAL);
        saplingItem(ModBlocks.DEMONIC_CRYSTAL);
        saplingItem(ModBlocks.CELESTIAL_CRYSTAL);
        saplingItem(ModBlocks.VOID_CRYSTAL);
        saplingItem(ModBlocks.ARCANA_CRYSTAL);

        // Tree
        // Scarlet Tree
        buttonItem(ModBlocks.SCARLET_TREE_BUTTON, ModBlocks.SCARLET_TREE_PLANKS);
        fenceItem(ModBlocks.SCARLET_TREE_FENCE, ModBlocks.SCARLET_TREE_PLANKS);
        wallItem(ModBlocks.SCARLET_TREE_WALL, ModBlocks.SCARLET_TREE_PLANKS);
        simpleBlockItem(ModBlocks.SCARLET_TREE_DOOR);
        saplingItem(ModBlocks.SCARLET_TREE_SAPLING);

        // Life Tree
        saplingItem(ModBlocks.LIFE_TREE_SAPLING);
        simpleBlockItem(ModBlocks.LIFE_TREE_FIRETYP_DOOR);
        //Tools
        //Stage 1
        handheldItem(ModItems.FIRERYTE_PICKAXE_STAGE1);



    }


    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,"block/" + item.getId().getPath()));

    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));

    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
