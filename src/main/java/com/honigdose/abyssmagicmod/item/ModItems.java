package com.honigdose.abyssmagicmod.item;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AbyssMagicMod.MOD_ID);

    public static final RegistryObject<Item> ABYSSSTEEL = ITEMS.register("abysssteel",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.abyssmagicmod.abysssteel.tooltip.1"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> RAW_ABYSSSTEEL = ITEMS.register("raw_abysssteel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOODGOLD = ITEMS.register("bloodgold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_BLOODGOLD = ITEMS.register("raw_bloodgold",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CELESTIUM = ITEMS.register("celestium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CELESTIUM = ITEMS.register("raw_celestium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIRERYTE = ITEMS.register("fireryte",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FIRERYTE = ITEMS.register("raw_fireryte",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLORASTEEL = ITEMS.register("florasteel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FLORASTEEl = ITEMS.register("raw_florasteel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LUNARIUM = ITEMS.register("lunarium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LUNARIUM = ITEMS.register("raw_lunarium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOLARIUM = ITEMS.register("solarium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SOLARIUM = ITEMS.register("raw_solarium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUIRYTE = ITEMS.register("suiryte",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SUIRYTE = ITEMS.register("raw_suiryte",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SYLPHTHYL = ITEMS.register("sylphthyl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SYLPHTHYL = ITEMS.register("raw_sylphthyl",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MYRINIUM = ITEMS.register("myrinium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MYRINIUM = ITEMS.register("raw_myrinium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MANATHYL = ITEMS.register("manathyl",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGESSENZ = ITEMS.register("magessenz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_FIRETYP = ITEMS.register("magessenz_firetyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_AIRTYP = ITEMS.register("magessenz_airtyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_WATERTYP = ITEMS.register("magessenz_watertyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_NATURTYP = ITEMS.register("magessenz_naturtyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_LUNARTYP = ITEMS.register("magessenz_lunartyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGESSENZ_SOLARTYP = ITEMS.register("magessenz_solartyp",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_MAGESSENZ = ITEMS.register("raw_magessenz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_FIRETYP = ITEMS.register("raw_magessenz_firetyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_AIRTYP = ITEMS.register("raw_magessenz_airtyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_WATERTYP = ITEMS.register("raw_magessenz_watertyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_NATURTYP = ITEMS.register("raw_magessenz_naturtyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_LUNARTYP = ITEMS.register("raw_magessenz_lunartyp",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_MAGESSENZ_SOLARTYP = ITEMS.register("raw_magessenz_solartyp",
            () -> new Item(new Item.Properties()));





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
