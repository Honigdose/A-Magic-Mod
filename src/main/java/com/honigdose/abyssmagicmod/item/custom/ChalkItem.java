package com.honigdose.abyssmagicmod.item.custom;

import com.honigdose.abyssmagicmod.block.ModBlocks;
import com.honigdose.abyssmagicmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Map;


public class ChalkItem extends Item {
    private static final Map<Item, Block> SYMBOL_MAP = Map.of(
            ModItems.FIRE_CIRCLE_PAPER.get(), ModBlocks.FIRE_CIRCLE.get(),
            ModItems.WATER_CIRCLE_PAPER.get(), ModBlocks.WATER_CIRCLE.get()
    );

    public ChalkItem(Properties properties) {
        super(properties.stacksTo(1).durability(6));
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 200;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BRUSH;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (!level.getBlockState(pos.below()).isSolid()) {
            return InteractionResult.FAIL;
        }

        ItemStack offhandItem = player.getOffhandItem();
        Block alchemyCircle = SYMBOL_MAP.get(offhandItem.getItem());
        if (alchemyCircle == null) {
            return InteractionResult.FAIL;
        }

        // Alchemiekreis setzen
        if (!level.isClientSide) {
            level.setBlock(pos, alchemyCircle.defaultBlockState(), 3);
        }

        stack.hurtAndBreak(1, player,EquipmentSlot.MAINHAND);


        return InteractionResult.SUCCESS;
    }


    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }
}