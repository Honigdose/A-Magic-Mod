package com.honigdose.abyssmagicmod.block.entity.screen.custom;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

public class TestBookScreen extends Screen {
    private static final ResourceLocation[] BOOK_TEXTURES = {
            ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/test_book/test_book_page1.png"),
            ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/test_book/test_book_page2.png"),
    };
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    private int currentPage = 0;

    public TestBookScreen(Component pTitle) {
        super(pTitle);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        // Hintergrund rendern
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);

        // Buch-Textur rendern
        renderBook(graphics);
    }

    private void renderBackground(GuiGraphics graphics) {
    }

    private void renderBook(GuiGraphics graphics) {
        int x = (this.width - TEXTURE_WIDTH) / 2;
        int y = (this.height - TEXTURE_HEIGHT) / 2;

        graphics.blit(BOOK_TEXTURES[currentPage], x, y, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int centerX = this.width / 2;

            if (mouseX < centerX) {
                previousPage();
            }
            else {
                nextPage();
            }
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void nextPage() {
        if (currentPage < BOOK_TEXTURES.length - 1) {
            currentPage++;
            playPageTurnSound();
        }
    }

    private void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            playPageTurnSound();
        }
    }

    private void playPageTurnSound() {
        Minecraft.getInstance().player.playSound(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.0F);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}


