package com.honigdose.abyssmagicmod.block.alchemy.researchtable;

import com.honigdose.abyssmagicmod.block.entity.ModBlockEntites;
import com.honigdose.abyssmagicmod.data.ModDataComponentTypes;
import com.honigdose.abyssmagicmod.item.ModItems;
import com.honigdose.abyssmagicmod.item.books.botanica.BotanicaBook;
import com.honigdose.abyssmagicmod.recipe.ModRecipes;
import com.honigdose.abyssmagicmod.recipe.ResearchTableRecipe;
import com.honigdose.abyssmagicmod.recipe.ResearchTableRecipeInput;
import com.honigdose.abyssmagicmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
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

import java.util.*;


public class ResearchTableBlockEntity extends BlockEntity implements MenuProvider {
    private ServerPlayer player;

    private final Map<Object, List<String>> item_to_pages = Map.of(
            ModItems.FIRE_CRYSTAL_SHARD.get(), List.of("fire_crystal"),
            ModItems.LUNAR_CRYSTAL_SHARD.get(), List.of("lunar_crystal"),
            ModTags.Items.WATER_CRYSTALS, List.of("water_crystal"),
            ModTags.Items.CRYSTALS, List.of("crystal_chapter","crystal","crystal_1","crystals")
    );

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
                case BOOK_SLOT  -> stack.getItem() instanceof BotanicaBook;
                default -> true;
            };
        }
        @Override
        public int getSlotLimit(int slot) {
            if (slot == INPUT_SLOT) {
                return 1;
            }
            return super.getSlotLimit(slot);
        }
    };

    private static final int INK_SLOT = 0;
    private static final int QUILL_SLOT = 1;
    private static final int BOOK_SLOT = 2;  // Updated here
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
        if (pPlayer instanceof ServerPlayer) {
            this.player = (ServerPlayer) pPlayer;
        }
        return new ResearchTableMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
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
        ItemStack inkStack = this.itemHandler.getStackInSlot(INK_SLOT);
        if (!inkStack.isEmpty() && inkStack.isDamageableItem()) {
            pTag.putInt("InkDamage", inkStack.getDamageValue());
        }

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

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (hasRequiredMaterials() && hasInputItem()) {
            increaseCraftingProgress();
            setChanged(level, pos, state);
            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean hasNewPages(ItemStack bookStack, List<String> pages) {
        List<String> unlocked = bookStack.getOrDefault(
                ModDataComponentTypes.UNLOCKED_PAGES.get(), List.of()
        );
        return pages.stream().anyMatch(tag -> !unlocked.contains(tag));
    }


    private void resetProgress() {
        progress = 0;
        maxProgress = DEFAULT_MAX_PROGRESS;
    }

    private List<String> getPagesFor(ItemStack stack) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Object, List<String>> entry : item_to_pages.entrySet()) {
            Object key = entry.getKey();
            if (key instanceof Item itemKey) {
                if (stack.getItem() == itemKey) {
                    result.addAll(entry.getValue());
                }
            } else if (key instanceof TagKey<?> tagKey) {

                if (stack.is((TagKey<Item>) tagKey)) {
                    result.addAll(entry.getValue());
                }
            }
        }
        return result;
    }


    private void craftItem() {
        ItemStack inkStack = itemHandler.getStackInSlot(INK_SLOT);
        if (!inkStack.isEmpty() && inkStack.isDamageableItem()) {
            int damage = inkStack.getDamageValue() + 1;
            if (damage >= inkStack.getMaxDamage()) {
                itemHandler.setStackInSlot(INK_SLOT, new ItemStack(ModItems.EMPTY_INK_BOTTLE_ITEM.get()));
            } else {
                inkStack.setDamageValue(damage);
            }
        }

        ItemStack inputStack = itemHandler.getStackInSlot(INPUT_SLOT);
        if (inputStack.isEmpty()) return;
        itemHandler.extractItem(INPUT_SLOT, 1, false);

        ItemStack bookStack = itemHandler.getStackInSlot(BOOK_SLOT);
        if (bookStack.isEmpty() || !(bookStack.getItem() instanceof BotanicaBook)) return;

        List<String> pages = getPagesFor(inputStack);
        if (pages == null || pages.isEmpty()) return;

        List<String> unlocked = new ArrayList<>(bookStack.getOrDefault(
                ModDataComponentTypes.UNLOCKED_PAGES.get(), List.of()
        ));

        boolean newPageAdded = false;

        for (String tag : pages) {
            if (!unlocked.contains(tag)) {
                unlocked.add(tag);
                newPageAdded = true;

            }
        }

        if (newPageAdded) {
            bookStack.set(ModDataComponentTypes.UNLOCKED_PAGES.get(), List.copyOf(unlocked));

            if (player.containerMenu != null) {
                player.containerMenu.broadcastChanges();
            }
        }
    }


    public Optional<RecipeHolder<ResearchTableRecipe>> getCurrentRecipe() {
        ItemStack inputStack = itemHandler.getStackInSlot(INPUT_SLOT);
        Optional<RecipeHolder<ResearchTableRecipe>> recipe = this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.RESEARCH_TYPE.get(), new ResearchTableRecipeInput(inputStack), level);
        return recipe;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRequiredMaterials() {
        ItemStack inkStack   = itemHandler.getStackInSlot(INK_SLOT);
        ItemStack quillStack = itemHandler.getStackInSlot(QUILL_SLOT);
        ItemStack bookStack  = itemHandler.getStackInSlot(BOOK_SLOT);

        return !inkStack.isEmpty() && inkStack.getItem() == ModItems.INK_BOTTLE_ITEM.get() &&
                !quillStack.isEmpty() && quillStack.getItem() == ModItems.QUILL.get() &&
                !bookStack.isEmpty() && bookStack.getItem() instanceof BotanicaBook;
    }

    private boolean hasInputItem() {
        ItemStack input = itemHandler.getStackInSlot(INPUT_SLOT);
        if (input.isEmpty()) return false;
        List<String> pages = getPagesFor(input);
        if (pages.isEmpty()) return false;

        ItemStack book = itemHandler.getStackInSlot(BOOK_SLOT);
        if (book.isEmpty() || !(book.getItem() instanceof BotanicaBook)) return false;

        return hasNewPages(book, pages);
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