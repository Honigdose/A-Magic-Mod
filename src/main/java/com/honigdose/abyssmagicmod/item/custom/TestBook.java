package com.honigdose.abyssmagicmod.item.custom;


import com.honigdose.abyssmagicmod.screen.custom.TestBookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class TestBook extends Item {

    public TestBook(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pLevel.isClientSide) {
            // Menü öffnen
            Minecraft.getInstance().setScreen(new TestBookScreen(Component.literal("Test Book")));
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}
