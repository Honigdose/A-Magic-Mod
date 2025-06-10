package com.honigdose.abyssmagicmod.worldgen.tree;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.worldgen.tree.custom.ScarletTree.ScarletTreeDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTreeDecoratorTypes {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, AbyssMagicMod.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<ScarletTreeDecorator>> SCARLET_DECORATOR =
            TREE_DECORATORS.register("scarlet_decorator",
                    () -> new TreeDecoratorType<>(ScarletTreeDecorator.CODEC));

    public static void register(IEventBus bus) {
        TREE_DECORATORS.register(bus);
    }
}