package com.honigdose.abyssmagicmod.block.alchemy.ResearchTable;


import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class ResearchTableScreen extends AbstractContainerScreen<ResearchTableMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/research_table_gui.png");
    private static final ResourceLocation POTION_TEXTURE = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/research_table_progress.png");
    private static final int GUI_WIDTH = 237;
    private static final int GUI_HEIGHT = 195;

    public ResearchTableScreen(ResearchTableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    private void renderProgressPotion(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            int progress = menu.getPotionProgress();
            int textureHeight = 87;
            int yOffset = textureHeight - progress;

            guiGraphics.blit(POTION_TEXTURE, x, y + yOffset, 0, yOffset, 15, progress, 128, 128);
        }
    }



    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int x = (width - GUI_WIDTH) / 2 - 2;
        int y = (height - GUI_HEIGHT) / 2 - 13;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);

        renderProgressPotion(guiGraphics, 142, 120);

    }



    @Override
    public boolean isPauseScreen() {
        return false;
    }
}