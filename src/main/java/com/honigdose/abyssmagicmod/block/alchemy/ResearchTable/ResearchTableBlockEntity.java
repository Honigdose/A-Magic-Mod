package com.honigdose.abyssmagicmod.block.alchemy.ResearchTable;

import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.item.books.Botanica.BotanicaBookData;
import com.honigdose.abyssmagicmod.item.books.Botanica.BotanicaUnlockManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ResearchTableBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case INK_SLOT -> stack.getItem() == ModItems.INK_BOTTLE_ITEM.get();
                case QUILL_SLOT -> stack.getItem() == ModItems.QUILL.get();
                case PAPER_SLOT -> stack.getItem() == Items.PAPER;
                default -> true;
            };
        }

    };

    private static final int INK_SLOT = 0;
    private static final int QUILL_SLOT = 1;
    private static final int PAPER_SLOT = 2;
    private static final int INPUT_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 140;
    private final int DEFAULT_MAX_PROGRESS = 140;

    public ResearchTableBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntites.RESEARCH_TABLE_BE.get(), pPos, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ResearchTableBlockEntity.this.progress;
                    case 1 -> ResearchTableBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> ResearchTableBlockEntity.this.progress = value;
                    case 1 -> ResearchTableBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("name.abyssmagicmod.research_table");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ResearchTableMenu(pContainerId, pPlayerInventory, this, this.data);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }
        }

        return super.getCapability(cap, side);
    }



    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("research_table.progress", progress);
        pTag.putInt("research_table.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("research_table.progress");
        maxProgress = pTag.getInt("research_table.max_progress");
        ItemStack inkStack = this.itemHandler.getStackInSlot(INK_SLOT);
        if (!inkStack.isEmpty()) {
            inkStack.setDamageValue(pTag.getInt("InkDamage"));
        }
    }



    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (hasRequiredMaterials() && hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, pPos, pState);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }


    private void resetProgress() {
        progress = 0;
        maxProgress = DEFAULT_MAX_PROGRESS;
    }

    private void craftItem() {
        itemHandler.extractItem(PAPER_SLOT, 1, false);

        ItemStack inkStack = itemHandler.getStackInSlot(INK_SLOT);

        if (!inkStack.isEmpty() && inkStack.isDamageableItem()) {
            int currentDamage = inkStack.getDamageValue();
            int maxDamage = inkStack.getMaxDamage();

            inkStack.setDamageValue(currentDamage + 1);

            if (currentDamage + 1 >= maxDamage) {
                itemHandler.setStackInSlot(INK_SLOT, new ItemStack(ModItems.EMPTY_INK_BOTTLE_ITEM.get()));
            }
        }

        itemHandler.extractItem(INPUT_SLOT, 1, false);

        resetProgress();
    }


    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRequiredMaterials() {
        ItemStack inkStack = itemHandler.getStackInSlot(INK_SLOT);
        ItemStack quillStack = itemHandler.getStackInSlot(QUILL_SLOT);
        ItemStack paperStack = itemHandler.getStackInSlot(PAPER_SLOT);

        return !inkStack.isEmpty() && inkStack.getItem() == ModItems.INK_BOTTLE_ITEM.get() &&
                !quillStack.isEmpty() && quillStack.getItem() == ModItems.QUILL.get() &&
                !paperStack.isEmpty() && paperStack.getItem() == Items.PAPER;
    }


    private boolean hasRecipe() {
        ItemStack quillStack = itemHandler.getStackInSlot(QUILL_SLOT);
        ItemStack inkStack = itemHandler.getStackInSlot(INK_SLOT);
        ItemStack paperStack = itemHandler.getStackInSlot(PAPER_SLOT);

        return !quillStack.isEmpty() && !inkStack.isEmpty() && !paperStack.isEmpty();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}