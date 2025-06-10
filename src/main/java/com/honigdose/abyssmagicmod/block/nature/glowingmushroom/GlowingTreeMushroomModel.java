package com.honigdose.abyssmagicmod.block.nature.glowingmushroom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

import static com.honigdose.abyssmagicmod.AbyssMagicMod.MOD_ID;

public class GlowingTreeMushroomModel extends DefaultedBlockGeoModel<GlowingTreeMushroomEntityBlock> {
    public GlowingTreeMushroomModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "glowing_brown_mushroom"));
    }


    @Override
    public ResourceLocation getTextureResource(GlowingTreeMushroomEntityBlock animatable) {
        Block block = animatable.getBlockState().getBlock();
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);

        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/block/" + key.getPath() + ".png");
    }

}
