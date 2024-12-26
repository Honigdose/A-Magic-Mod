package com.honigdose.abyssmagicmod.screen.custom;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

public class ForgeBookScreen extends Screen {
    private static final ResourceLocation[] BOOK_TEXTURES = {
            ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/forge_book/forge_book_template.png"),
    };
    private static final int GUI_WIDTH = 256;
    private static final int GUI_HEIGHT = 256;

    private int currentPage = 0;

    public ForgeBookScreen(Component pTitle) {
        super(pTitle);
    }



    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        renderBook(graphics);
    }

    private void renderBook(GuiGraphics graphics) {
        int x = (this.width - GUI_WIDTH) / 2;
        int y = (this.height - GUI_HEIGHT) / 2;


        // Textur rendern
        graphics.blit(BOOK_TEXTURES[currentPage], x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
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