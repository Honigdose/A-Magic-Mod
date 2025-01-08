package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.books.BookData.BookChapter;
import com.honigdose.abyssmagicmod.item.books.BookData.TransitionsAnimations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;




import java.util.List;

public class BotanicaBookScreen extends Screen {

    private static final int GUI_WIDTH = 256;
    private static final int GUI_HEIGHT = 256;

    private int currentPage = 0;
    private int currentPageTickCount = 0;


    private boolean isTransitioning = false;
    private TransitionsAnimations currentTransitionAnimation = null;
    private int transitionTickCount = 0;
    private static final int TRANSITION_DURATION = 11;

    public BotanicaBookScreen(Component pTitle) {
        super(pTitle);
    }

    private final List<TransitionsAnimations> transitionsAnimations = List.of(
            new TransitionsAnimations("next_page", 1,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page1.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page2.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page3.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page4.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page5.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page6.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page7.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page8.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page9.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page10.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/next_page/botanica_book_animated_next_page11.png")
            ),
            new TransitionsAnimations("prev_page", 1,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page1.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page2.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page3.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page4.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page5.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page6.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page7.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page8.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page9.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page10.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/prev_page/botanica_book_animated_prev_page11.png")
            )
    );

    private final List<BotanicaBookPage> pages = List.of(
            new BotanicaBookPage(0, "template", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_template.png")
            ),
            new BotanicaBookPage(1, "uwu", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_template_page1.png")
            ),
            new BotanicaBookPage(2, "owo", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_template_page2.png")
            ),
            new BotanicaBookPage(3, "animatedPage", 3,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_template_page3.1.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_template_page3.2.png")
            ),
            new BotanicaBookPage(4, "crystal", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_crystal.png")
            ),
            new BotanicaBookPage(5, "crystal_2", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_crystal2.png")
            ),
            new BotanicaBookPage(6, "fire_crystal", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_crystal_fire.png")
            ),
            new BotanicaBookPage(7, "water_crystal", 60,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/botanica_book_crystal_water.png")
            )
    );

    private final List<BookChapter> chapters = List.of(
            new BookChapter("Introduction", 0),
            new BookChapter("Test", 2),
            new BookChapter("Crystals", 4)
    );

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        if (isTransitioning) {
            renderTransition(graphics);
        } else {
            renderBook(graphics, mouseX, mouseY);
        }
    }

    private void renderTransition(GuiGraphics graphics) {
        if (currentTransitionAnimation != null) {
            int x = (this.width - GUI_WIDTH) / 2;
            int y = (this.height - GUI_HEIGHT) / 2;

            ResourceLocation texture = currentTransitionAnimation.getCurrentTexture(transitionTickCount);
            graphics.blit(texture, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        }
    }

    private void renderBook(GuiGraphics graphics, int mouseX, int mouseY) {
        int x = (this.width - GUI_WIDTH) / 2;
        int y = (this.height - GUI_HEIGHT) / 2;

        BotanicaBookPage current = pages.get(currentPage);

        ResourceLocation currentTexture = current.getCurrentTexture(this.currentPageTickCount);

        graphics.blit(currentTexture, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);

        if (currentPage == 0) {
            renderTableOfContents(graphics, x, y + 25, mouseX, mouseY);
        }
    }

    private void renderTableOfContents(GuiGraphics graphics, int x, int y, double mouseX, double mouseY) {
        int offsetY = 20;
        int clickableX = x + 20;
        int clickableY = y + offsetY;

        for (int i = 0; i < chapters.size(); i++) {
            BookChapter chapter = chapters.get(i);
            String title = chapter.getTitle();
            int pageIndex = chapter.getPageIndex();

            graphics.drawString(this.font, title, clickableX, clickableY, 0x6e3c31, false);

            if (isMouseOverEntry(clickableX, clickableY, title, mouseX, mouseY)) {
                graphics.fill(clickableX - 2, clickableY - 2, clickableX + this.font.width(title) + 2, clickableY + this.font.lineHeight + 2, 0x80FFFFFF);
            }

            offsetY += 15;
            clickableY = y + offsetY;
        }
    }

    private boolean isMouseOverEntry(int x, int y, String text, double mouseX, double mouseY) {
        int width = this.font.width(text);
        int height = this.font.lineHeight;

        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int centerX = this.width / 2;

            if (mouseX < centerX) {
                previousPage();
            } else {
                nextPage();
            }
            return true;
        } else if (button == 1) {
            if (currentPage == 0) {
                for (int i = 0; i < chapters.size(); i++) {
                    BookChapter chapter = chapters.get(i);
                    String title = chapter.getTitle();
                    int pageIndex = chapter.getPageIndex();

                    if (isMouseOverEntry(145, 55 + (i * 15), title, mouseX, mouseY)) {
                        this.currentPage = pageIndex;
                        playPageTurnSound();
                        return true;
                    }
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void playPageTurnSound() {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.playSound(SoundEvents.BOOK_PAGE_TURN, 2.0F, 1.0F);
    }

    private void nextPage() {
        if (currentPage < pages.size() - 1 && !isTransitioning) {
            currentTransitionAnimation = transitionsAnimations.stream()
                    .filter(animation -> "next_page".equals(animation.getTag()))
                    .findFirst()
                    .orElse(null);

            isTransitioning = true;
            transitionTickCount = 0;
            playPageTurnSound();
        }
    }

    private void previousPage() {
        if (currentPage > 0 && !isTransitioning) {
            currentTransitionAnimation = transitionsAnimations.stream()
                    .filter(animation -> "prev_page".equals(animation.getTag()))
                    .findFirst()
                    .orElse(null);

            isTransitioning = true;
            transitionTickCount = 0;
            playPageTurnSound();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (isTransitioning) {
            transitionTickCount++;
            if (transitionTickCount >= TRANSITION_DURATION) {
                isTransitioning = false;

                if ("next_page".equals(currentTransitionAnimation.getTag())) {
                    currentPage++;
                } else if ("prev_page".equals(currentTransitionAnimation.getTag())) {
                    currentPage--;
                }

                currentTransitionAnimation = null;
                currentPageTickCount = 0;
            }
        } else {
            currentPageTickCount++;
        }
    }
}