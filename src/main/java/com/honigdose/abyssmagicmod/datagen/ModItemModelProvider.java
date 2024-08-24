package com.honigdose.abyssmagicmod.datagen;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AbyssMagicMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ABYSSSTEEL.get());
        basicItem(ModItems.FIRERYTE.get());
        basicItem(ModItems.SUIRYTE.get());
        basicItem(ModItems.SYLPHTHYL.get());
        basicItem(ModItems.FLORASTEEL.get());
        basicItem(ModItems.SOLARIUM.get());
        basicItem(ModItems.LUNARIUM.get());

        basicItem(ModItems.RAW_ABYSSSTEEL.get());
        basicItem(ModItems.RAW_FIRERYTE.get());
        basicItem(ModItems.RAW_SUIRYTE.get());
        basicItem(ModItems.RAW_SYLPHTHYL.get());
        basicItem(ModItems.RAW_FLORASTEEl.get());
        basicItem(ModItems.RAW_SOLARIUM.get());
        basicItem(ModItems.RAW_LUNARIUM.get());

        basicItem(ModItems.MAGESSENZ.get());
        basicItem(ModItems.MAGESSENZ_NATURTYP.get());
        basicItem(ModItems.MAGESSENZ_WATERTYP.get());
        basicItem(ModItems.MAGESSENZ_AIRTYP.get());
        basicItem(ModItems.MAGESSENZ_FIRETYP.get());
        basicItem(ModItems.MAGESSENZ_SOLARTYP.get());
        basicItem(ModItems.MAGESSENZ_LUNARTYP.get());

        basicItem(ModItems.RAW_MAGESSENZ.get());
        basicItem(ModItems.RAW_MAGESSENZ_NATURTYP.get());
        basicItem(ModItems.RAW_MAGESSENZ_AIRTYP.get());
        basicItem(ModItems.RAW_MAGESSENZ_AIRTYP.get());
        basicItem(ModItems.RAW_MAGESSENZ_FIRETYP.get());
        basicItem(ModItems.RAW_MAGESSENZ_SOLARTYP.get());
        basicItem(ModItems.RAW_MAGESSENZ_LUNARTYP.get());


    }
}
