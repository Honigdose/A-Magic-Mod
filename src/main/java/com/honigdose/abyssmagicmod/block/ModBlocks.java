package com.honigdose.abyssmagicmod.block;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AbyssMagicMod.MOD_ID);


    public static final RegistryObject<Block> ABYSSSTEEL_ORE = registerBlock("abysssteel_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FIRERYTE_ORE = registerBlock("fireryte_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SOLARIUM_ORE = registerBlock("solarium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LUNARIUM_ORE = registerBlock("lunarium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUIRYTE_ORE = registerBlock("suiryte_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FLORASTEEL_ORE = registerBlock("florasteel_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SYLPHTHYL_ORE = registerBlock("sylphthyl_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE = registerBlock("magessenz_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_FIRETYP = registerBlock("magessenz_ore_deepslate_firetyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_SOLARTYP = registerBlock("magessenz_ore_deepslate_solartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_LUNARIUM = registerBlock("magessenz_ore_deepslate_lunartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_WATERTYP = registerBlock("magessenz_ore_deepslate_watertyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_NATURTYP = registerBlock("magessenz_ore_deepslate_naturtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_DEEPSLATE_AIRTYP = registerBlock("magessenz_ore_deepslate_airtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE = registerBlock("magessenz_ore_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_FIRETYP = registerBlock("magessenz_ore_stone_firetyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_SOLARTYP = registerBlock("magessenz_ore_stone_solartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_LUNARIUM = registerBlock("magessenz_ore_stone_lunartyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_WATERTYP = registerBlock("magessenz_ore_stone_watertyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_NATURTYP = registerBlock("magessenz_ore_stone_naturtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGESSENZ_ORE_STONE_AIRTYP = registerBlock("magessenz_ore_stone_airtyp",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MYRINIUM_ORE_DEEPSLATE = registerBlock("myrinium_ore_deepslate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MYRINIUM_ORE_STONE = registerBlock("myrinium_ore_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
