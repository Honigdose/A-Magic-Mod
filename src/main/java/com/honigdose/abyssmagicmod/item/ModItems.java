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

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    // Eine Methode für das Registrieren von Items mit benutzerdefinierter Logik (z.B. Tooltip)
    private static RegistryObject<Item> registerItemWithTooltip(String name, String tooltipTranslationKey) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                pTooltipComponents.add(Component.translatable(tooltipTranslationKey));
                super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
            }
        });
    }

    //INGOTS AND RAW ORE
    public static final RegistryObject<Item> ABYSSSTEEL = registerItemWithTooltip("abysssteel", "tooltip.abyssmagicmod.abysssteel.tooltip.1");
    public static final RegistryObject<Item> RAW_ABYSSSTEEL = registerItem("raw_abysssteel");

    public static final RegistryObject<Item> BLOODGOLD = registerItem("bloodgold");
    public static final RegistryObject<Item> RAW_BLOODGOLD = registerItem("raw_bloodgold");

    public static final RegistryObject<Item> CELESTIUM = registerItem("celestium");
    public static final RegistryObject<Item> RAW_CELESTIUM = registerItem("raw_celestium");

    public static final RegistryObject<Item> FIRERYTE = registerItem("fireryte");
    public static final RegistryObject<Item> RAW_FIRERYTE = registerItem("raw_fireryte");

    public static final RegistryObject<Item> FLORASTEEL = registerItem("florasteel");
    public static final RegistryObject<Item> RAW_FLORASTEEl = registerItem("raw_florasteel");

    public static final RegistryObject<Item> LUNARIUM = registerItem("lunarium");
    public static final RegistryObject<Item> RAW_LUNARIUM = registerItem("raw_lunarium");

    public static final RegistryObject<Item> SOLARIUM = registerItem("solarium");
    public static final RegistryObject<Item> RAW_SOLARIUM = registerItem("raw_solarium");

    public static final RegistryObject<Item> SUIRYTE = registerItem("suiryte");
    public static final RegistryObject<Item> RAW_SUIRYTE = registerItem("raw_suiryte");

    public static final RegistryObject<Item> SYLPHTHYL = registerItem("sylphthyl");
    public static final RegistryObject<Item> RAW_SYLPHTHYL = registerItem("raw_sylphthyl");

    public static final RegistryObject<Item> MYRINIUM = registerItem("myrinium");
    public static final RegistryObject<Item> RAW_MYRINIUM = registerItem("raw_myrinium");

    public static final RegistryObject<Item> MANATHYL = registerItem("manathyl");

    public static final RegistryObject<Item> MAGESSENZ = registerItem("magessenz");
    public static final RegistryObject<Item> MAGESSENZ_FIRETYP = registerItem("magessenz_firetyp");
    public static final RegistryObject<Item> MAGESSENZ_AIRTYP = registerItem("magessenz_airtyp");
    public static final RegistryObject<Item> MAGESSENZ_WATERTYP = registerItem("magessenz_watertyp");
    public static final RegistryObject<Item> MAGESSENZ_NATURTYP = registerItem("magessenz_naturtyp");
    public static final RegistryObject<Item> MAGESSENZ_LUNARTYP = registerItem("magessenz_lunartyp");
    public static final RegistryObject<Item> MAGESSENZ_SOLARTYP = registerItem("magessenz_solartyp");

    public static final RegistryObject<Item> RAW_MAGESSENZ = registerItem("raw_magessenz");
    public static final RegistryObject<Item> RAW_MAGESSENZ_FIRETYP = registerItem("raw_magessenz_firetyp");
    public static final RegistryObject<Item> RAW_MAGESSENZ_AIRTYP = registerItem("raw_magessenz_airtyp");
    public static final RegistryObject<Item> RAW_MAGESSENZ_WATERTYP = registerItem("raw_magessenz_watertyp");
    public static final RegistryObject<Item> RAW_MAGESSENZ_NATURTYP = registerItem("raw_magessenz_naturtyp");
    public static final RegistryObject<Item> RAW_MAGESSENZ_LUNARTYP = registerItem("raw_magessenz_lunartyp");
    public static final RegistryObject<Item> RAW_MAGESSENZ_SOLARTYP = registerItem("raw_magessenz_solartyp");

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





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
