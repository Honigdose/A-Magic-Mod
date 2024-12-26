package com.honigdose.abyssmagicmod.item;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.custom.books.AlchemyBook;
import com.honigdose.abyssmagicmod.item.custom.books.BestiaryBook;
import com.honigdose.abyssmagicmod.item.custom.MortarAndPestleItem;
import com.honigdose.abyssmagicmod.item.custom.TestBook;
import com.honigdose.abyssmagicmod.item.custom.books.BotanicumBook;
import com.honigdose.abyssmagicmod.item.custom.books.ForgeBook;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static com.honigdose.abyssmagicmod.block.ModBlocks.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AbyssMagicMod.MOD_ID);

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<Item> registerItemStacks(String name, int maxStacks) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<Item> registerEssenceItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().stacksTo(3)));
    }
    private static RegistryObject<Item> registerItemWithTooltip(String name, String tooltipTranslationKey) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                pTooltipComponents.add(Component.translatable(tooltipTranslationKey));
                super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
            }
        });
    }



    public static final RegistryObject<Item> CHALK = registerItemStacks("chalk", 3);
    public static final RegistryObject<Item> RAW_CHALK = registerItem("raw_chalk");

    public static final RegistryObject<Item> QUILL = registerItem("quill");

    public static final RegistryObject<Item> MAGIC_ROUND_BOTTLE_ITEM = ITEMS.register("magic_round_bottle",
            () -> new BlockItem(ModBlocks.MAGIC_ROUND_BOTTLE.get() ,new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAGIC_TRIANGLE_BOTTLE_ITEM = ITEMS.register("magic_triangle_bottle",
            () -> new BlockItem(ModBlocks.MAGIC_TRIANGLE_BOTTLE.get() ,new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAGIC_SQUARE_BOTTLE_ITEM = ITEMS.register("magic_square_bottle",
            () -> new BlockItem(ModBlocks.MAGIC_SQUARE_BOTTLE.get() ,new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> MORTAR_AND_PESTLE_ITEM = ITEMS.register("mortar_and_pestle",
            () -> new MortarAndPestleItem(ModBlocks.MORTAR_AND_PESTLE.get() ,new Item.Properties().stacksTo(1).craftRemainder(Item.byBlock(MORTAR_AND_PESTLE.get()))));

    public static final RegistryObject<Item> INK_BOTTLE_ITEM = ITEMS.register("ink_bottle",
            () -> new BlockItem(ModBlocks.INK_BOTTLE.get() ,new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> EMPTY_INK_BOTTLE = ITEMS.register("empty_ink_bottle",
            () -> new BlockItem(ModBlocks.EMPTY_INK_BOTTLE.get() ,new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> TEST_BOOK = ITEMS.register("test_book",
            () -> new TestBook(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ALCHEMY_BOOK_ITEM = ITEMS.register("alchemy_book",
            () -> new AlchemyBook(ModBlocks.ALCHEMY_BOOK.get() ,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BESTIARY_BOOK_ITEM = ITEMS.register("bestiary_book",
            () -> new BestiaryBook(BESTIARY_BOOK.get() ,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FORGE_BOOK_ITEM = ITEMS.register("forge_book",
            () -> new ForgeBook(FORGE_BOOK.get() ,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BOTANICUM_BOOK_ITEM = ITEMS.register("botanicum_book",
            () -> new BotanicumBook(BOTANICUM_BOOK.get() ,new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ROUND_FIRE_ESSENZ = registerEssenceItem("round_fire_essenz");
    public static final RegistryObject<Item> SQUARE_FIRE_ESSENZ = registerEssenceItem("square_fire_essenz");
    public static final RegistryObject<Item> TRIANGLE_FIRE_ESSENZ = registerEssenceItem("triangle_fire_essenz");
    public static final RegistryObject<Item> ROUND_WATER_ESSENZ = registerEssenceItem("round_water_essenz");
    public static final RegistryObject<Item> SQUARE_WATER_ESSENZ = registerEssenceItem("square_water_essenz");
    public static final RegistryObject<Item> TRIANGLE_WATER_ESSENZ = registerEssenceItem("triangle_water_essenz");
    public static final RegistryObject<Item> ROUND_NATUR_ESSENZ = registerEssenceItem("round_natur_essenz");
    public static final RegistryObject<Item> SQUARE_NATUR_ESSENZ = registerEssenceItem("square_natur_essenz");
    public static final RegistryObject<Item> TRIANGLE_NATUR_ESSENZ = registerEssenceItem("triangle_natur_essenz");
    public static final RegistryObject<Item> ROUND_AIR_ESSENZ = registerEssenceItem("round_air_essenz");
    public static final RegistryObject<Item> SQUARE_AIR_ESSENZ = registerEssenceItem("square_air_essenz");
    public static final RegistryObject<Item> TRIANGLE_AIR_ESSENZ = registerEssenceItem("triangle_air_essenz");
    public static final RegistryObject<Item> ROUND_SOLAR_ESSENZ = registerEssenceItem("round_solar_essenz");
    public static final RegistryObject<Item> SQUARE_SOLAR_ESSENZ = registerEssenceItem("square_solar_essenz");
    public static final RegistryObject<Item> TRIANGLE_SOLAR_ESSENZ = registerEssenceItem("triangle_solar_essenz");
    public static final RegistryObject<Item> ROUND_LUNAR_ESSENZ = registerEssenceItem("round_lunar_essenz");
    public static final RegistryObject<Item> SQUARE_LUNAR_ESSENZ = registerEssenceItem("square_lunar_essenz");
    public static final RegistryObject<Item> TRIANGLE_LUNAR_ESSENZ = registerEssenceItem("triangle_lunar_essenz");
    public static final RegistryObject<Item> ROUND_DEMONIC_ESSENZ = registerEssenceItem("round_demonic_essenz");
    public static final RegistryObject<Item> SQUARE_DEMONIC_ESSENZ = registerEssenceItem("square_demonic_essenz");
    public static final RegistryObject<Item> TRIANGLE_DEMONIC_ESSENZ = registerEssenceItem("triangle_demonic_essenz");
    public static final RegistryObject<Item> ROUND_CELESTIAL_ESSENZ = registerEssenceItem("round_celestial_essenz");
    public static final RegistryObject<Item> SQUARE_CELESTIAL_ESSENZ = registerEssenceItem("square_celestial_essenz");
    public static final RegistryObject<Item> TRIANGLE_CELESTIAL_ESSENZ = registerEssenceItem("triangle_celestial_essenz");
    public static final RegistryObject<Item> ROUND_VOID_ESSENZ = registerEssenceItem("round_void_essenz");
    public static final RegistryObject<Item> SQUARE_VOID_ESSENZ = registerEssenceItem("square_void_essenz");
    public static final RegistryObject<Item> TRIANGLE_VOID_ESSENZ = registerEssenceItem("triangle_void_essenz");
    public static final RegistryObject<Item> ROUND_ARCANA_ESSENZ = registerEssenceItem("round_arcana_essenz");
    public static final RegistryObject<Item> SQUARE_ARCANA_ESSENZ = registerEssenceItem("square_arcana_essenz");
    public static final RegistryObject<Item> TRIANGLE_ARCANA_ESSENZ = registerEssenceItem("triangle_arcana_essenz");

    //INGOTS AND RAW ORE
    public static final RegistryObject<Item> ASTRATHYL = registerItem("astrathyl");
    public static final RegistryObject<Item> ABYSSSTEEL = registerItemWithTooltip("abysssteel", "tooltip.abyssmagicmod.abysssteel.tooltip.1");
    public static final RegistryObject<Item> BLOODGOLD = registerItem("bloodgold");
    public static final RegistryObject<Item> CELESTIUM = registerItem("celestium");
    public static final RegistryObject<Item> FIRERYTE = registerItem("fireryte");
    public static final RegistryObject<Item> FLORASTEEL = registerItem("florasteel");
    public static final RegistryObject<Item> LUNARIUM = registerItem("lunarium");
    public static final RegistryObject<Item> SOLARIUM = registerItem("solarium");
    public static final RegistryObject<Item> SUIRYTE = registerItem("suiryte");
    public static final RegistryObject<Item> SYLPHTHYL = registerItem("sylphthyl");



    public static final RegistryObject<Item> RAW_ASTRATHYL = registerItem("raw_astrathyl");
    public static final RegistryObject<Item> RAW_ABYSSSTEEL = registerItem("raw_abysssteel");
    public static final RegistryObject<Item> RAW_BLOODGOLD = registerItem("raw_bloodgold");
    public static final RegistryObject<Item> RAW_CELESTIUM = registerItem("raw_celestium");
    public static final RegistryObject<Item> RAW_FIRERYTE = registerItem("raw_fireryte");
    public static final RegistryObject<Item> RAW_FLORASTEEl = registerItem("raw_florasteel");
    public static final RegistryObject<Item> RAW_LUNARIUM = registerItem("raw_lunarium");
    public static final RegistryObject<Item> RAW_SOLARIUM = registerItem("raw_solarium");
    public static final RegistryObject<Item> RAW_SUIRYTE = registerItem("raw_suiryte");
    public static final RegistryObject<Item> RAW_SYLPHTHYL = registerItem("raw_sylphthyl");

    public static final RegistryObject<Item> MYRINIUM = registerItem("myrinium");
    public static final RegistryObject<Item> RAW_MYRINIUM = registerItem("raw_myrinium");

    public static final RegistryObject<Item> MANATHYL = registerItem("manathyl");


    public static final RegistryObject<Item> PURE_SILVER  = registerItem("pure_silver");

    public static final RegistryObject<Item> SILVER  = registerItem("silver");
    public static final RegistryObject<Item> AIR_SILVER  = registerItem("air_silver");
    public static final RegistryObject<Item> FIRE_SILVER  = registerItem("fire_silver");
    public static final RegistryObject<Item> WATER_SILVER  = registerItem("water_silver");
    public static final RegistryObject<Item> NATUR_SILVER  = registerItem("natur_silver");
    public static final RegistryObject<Item> SOLAR_SILVER  = registerItem("solar_silver");
    public static final RegistryObject<Item> LUNAR_SILVER  = registerItem("lunar_silver");

    public static final RegistryObject<Item> RAW_SILVER  = registerItem("raw_silver");
    public static final RegistryObject<Item> RAW_AIR_SILVER  = registerItem("raw_air_silver");
    public static final RegistryObject<Item> RAW_FIRE_SILVER  = registerItem("raw_fire_silver");
    public static final RegistryObject<Item> RAW_WATER_SILVER  = registerItem("raw_water_silver");
    public static final RegistryObject<Item> RAW_NATUR_SILVER  = registerItem("raw_natur_silver");
    public static final RegistryObject<Item> RAW_SOLAR_SILVER  = registerItem("raw_solar_silver");
    public static final RegistryObject<Item> RAW_LUNAR_SILVER  = registerItem("raw_lunar_silver");

    public static final RegistryObject<Item> PURE_GOLD  = registerItem("pure_gold");

    public static final RegistryObject<Item> AIR_GOLD  = registerItem("air_gold");
    public static final RegistryObject<Item> FIRE_GOLD  = registerItem("fire_gold");
    public static final RegistryObject<Item> WATER_GOLD  = registerItem("water_gold");
    public static final RegistryObject<Item> NATUR_GOLD  = registerItem("natur_gold");
    public static final RegistryObject<Item> SOLAR_GOLD  = registerItem("solar_gold");
    public static final RegistryObject<Item> LUNAR_GOLD  = registerItem("lunar_gold");

    public static final RegistryObject<Item> RAW_AIR_GOLD  = registerItem("raw_air_gold");
    public static final RegistryObject<Item> RAW_FIRE_GOLD  = registerItem("raw_fire_gold");
    public static final RegistryObject<Item> RAW_WATER_GOLD  = registerItem("raw_water_gold");
    public static final RegistryObject<Item> RAW_NATUR_GOLD  = registerItem("raw_natur_gold");
    public static final RegistryObject<Item> RAW_SOLAR_GOLD  = registerItem("raw_solar_gold");
    public static final RegistryObject<Item> RAW_LUNAR_GOLD  = registerItem("raw_lunar_gold");



    //CRYSTAL SHARD
    public static final RegistryObject<Item> FIRE_CRYSTAL_SHARD = registerItem("fire_crystal_shard");
    public static final RegistryObject<Item> WATER_CRYSTAL_SHARD = registerItem("water_crystal_shard");
    public static final RegistryObject<Item> NATUR_CRYSTAL_SHARD = registerItem("natur_crystal_shard");
    public static final RegistryObject<Item> AIR_CRYSTAL_SHARD = registerItem("air_crystal_shard");
    public static final RegistryObject<Item> SOLAR_CRYSTAL_SHARD = registerItem("solar_crystal_shard");
    public static final RegistryObject<Item> LUNAR_CRYSTAL_SHARD = registerItem("lunar_crystal_shard");
    public static final RegistryObject<Item> VOID_CRYSTAL_SHARD = registerItem("void_crystal_shard");
    public static final RegistryObject<Item> CELESTIAL_CRYSTAL_SHARD = registerItem("celestial_crystal_shard");
    public static final RegistryObject<Item> DEMONIC_CRYSTAL_SHARD = registerItem("demonic_crystal_shard");
    public static final RegistryObject<Item> ARCANA_CRYSTAL_SHARD = registerItem("arcana_crystal_shard");

    //Tools
    public static final RegistryObject<Item> FIRERYTE_PICKAXE_STAGE1 = ITEMS.register("fireryte_pickaxe_stage1",
            () -> new PickaxeItem(ModToolTiers.FIRERYTE , new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.FIRERYTE, 1, -2))));





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
