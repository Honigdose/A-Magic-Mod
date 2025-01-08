package com.honigdose.abyssmagicmod.item.books.ForgeBook;


import com.honigdose.abyssmagicmod.screen.custom.ForgeBookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;


public class ForgeBook extends BlockItem {


    public ForgeBook(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pLevel.isClientSide) {
            // Menü öffnen
            Minecraft.getInstance().setScreen(new ForgeBookScreen(Component.literal("Forge Book")));
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && !player.isShiftKeyDown()) {
            // Platzierung verhindern, wenn Shift nicht gedrückt wird
            return InteractionResult.FAIL;
        }

        // Standardplatzierung des Blocks erlauben
        return super.useOn(context);
    }
}
