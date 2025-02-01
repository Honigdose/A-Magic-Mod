package com.honigdose.abyssmagicmod.item.books.Botanica;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.books.BookData.BookChapter;
import com.honigdose.abyssmagicmod.item.books.BookData.TransitionsAnimations;
import com.honigdose.abyssmagicmod.recipe.ResearchTableRecipeInput;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Player;


import java.util.*;

public class BotanicaBookScreen extends Screen {

    private static final int GUI_WIDTH = 256;
    private static final int GUI_HEIGHT = 256;

    private final Map<Integer, List<BookChapter>> chapters = new HashMap<>();
    private static final List<BotanicaBookPages> pages = List.of(BotanicaBookPages.values());
    private int currentPage = 0;
    private int currentPageTickCount = 0;
    private final Player player;

    private boolean isTransitioning = false;
    private TransitionsAnimations currentTransitionAnimation = null;
    private int transitionTickCount = 0;
    private static final int TRANSITION_DURATION = 11;

    public BotanicaBookScreen(Component Title, Player player) {
        super(Title);
        this.player = player;
        initializeChapters();
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

    private void initializeChapters() {
        chapters.put(0, new ArrayList<>(List.of(
                new BookChapter("Introduction", 0),
                new BookChapter("Test", 2)
        )));

        chapters.put(2, new ArrayList<>(List.of(
                new BookChapter("Magical Crystals", 4),
                new BookChapter("Crystal Energies", 6)
        )));
    }


    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        if (isTransitioning) {
            renderTransition(graphics);
        } else {
            renderBook(graphics, mouseX, mouseY, player);
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

    private void renderBook(GuiGraphics graphics, int mouseX, int mouseY, Player player) {
        int x = (this.width - GUI_WIDTH) / 2;
        int y = (this.height - GUI_HEIGHT) / 2;
        BotanicaBookPages current = pages.get(currentPage);

        boolean unlocked = current.isUnlockedPage();
        System.out.println("Seite freigeschaltet: " + unlocked);

        if (unlocked) {
            ResourceLocation currentTexture = current.getCurrentTexture(this.currentPageTickCount);
            System.out.println("Rendering Seite: " + currentTexture.toString());
            graphics.blit(currentTexture, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        }

        if (chapters.containsKey(currentPage)) {
            renderCustomTableOfContents(graphics, x, y + 25, mouseX, mouseY, chapters.get(currentPage));
        }

        String pageText = current.getPageText();
        if (!pageText.isEmpty()) {
            pageText = replaceVariables(pageText, player);
            drawFormattedText(graphics, pageText, x, y + 50, 100, 130, 0x6e3c31);
        }

    }

    private String replaceVariables(String text, Player player) {
        return text.replace("[player]", player.getName().getString());
    }


    private void drawFormattedText(GuiGraphics graphics, String text, int x, int y, int maxWidth, int maxHeight, int color) {
        String[] lines = text.split("\n");

        int leftPageX = x + 17;
        int rightPageX = x + 137;
        int lineHeight = 10;
        int maxLinesPerPage = maxHeight / lineHeight;

        int lineIndex = 0;
        int currentX = leftPageX;
        int currentY = y;
        boolean isLeftPage = true;

        for (String line : lines) {
            int imageWidth = 32, imageHeight = 32; // Standardgröße

            if (line.startsWith("[image64:")) {
                imageWidth = 64;
                imageHeight = 64;
                line = line.substring(9, line.length() - 1);
            } else if (line.startsWith("[image16:")) {
                imageWidth = 16;
                imageHeight = 16;
                line = line.substring(9, line.length() - 1);
            } else if (line.startsWith("[image80:")) {
                imageWidth = 80;
                imageHeight = 80;
                line = line.substring(9, line.length() - 1);
            } else if (line.startsWith("[image:")) {
                line = line.substring(7, line.length() - 1);
            } else {
                line = parseTextFormatting(line);
            }

            if (line.contains("/")) {
                ResourceLocation image = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, line);
                ResourceLocation frame = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/page_accessories/botanica_image_frame.png");
                ResourceLocation background = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/page_accessories/botanica_image_backround.png");

                if (imageWidth == 80) {
                    currentX = isLeftPage ? leftPageX + 10 : rightPageX + 10;
                    currentY += lineHeight;
                } else if (currentX + imageWidth > (isLeftPage ? rightPageX : rightPageX + maxWidth)) {
                    currentX = isLeftPage ? leftPageX : rightPageX;
                    currentY += lineHeight;
                }

                graphics.fill(currentX - 2, currentY - 2, currentX + imageWidth + 2 , currentY + imageHeight + 2, 0x406e3c31);


                RenderSystem.setShaderTexture(0, image);
                graphics.blit(image, currentX, currentY, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

                //graphics.fill(currentX, currentY, currentX + imageWidth, currentY + imageHeight, 0x406e3c31);

                if (imageWidth == 80){
                    RenderSystem.setShaderTexture(0, frame);
                    graphics.blit(frame, currentX - 5, currentY - 5, 0, 0, imageWidth + 10, imageHeight + 10, imageWidth + 10, imageHeight + 10);
                } else if (imageWidth == 64 ) {
                    RenderSystem.setShaderTexture(0, frame);
                    graphics.blit(frame, currentX - 5, currentY - 5, 0, 0, imageWidth + 10, imageHeight + 10, imageWidth + 10, imageHeight + 10);
                } else if (imageWidth == 16) {
                    RenderSystem.setShaderTexture(0, frame);
                    graphics.blit(frame, currentX - 3, currentY - 3, 0, 0, imageWidth + 6, imageHeight + 6, imageWidth + 6, imageHeight + 6);
                } else {
                    RenderSystem.setShaderTexture(0, frame);
                    graphics.blit(frame, currentX - 4, currentY - 4, 0, 0, imageWidth + 8, imageHeight + 8, imageWidth + 8, imageHeight + 8);
                }


                currentX += imageWidth + 5;
                continue;
            }

            // Für den Text, falls die Zeile zu lang wird, gehen wir in die nächste Zeile
            if (currentX + this.font.width(line) > (isLeftPage ? rightPageX : rightPageX + maxWidth)) {
                currentX = isLeftPage ? leftPageX : rightPageX;
                currentY += lineHeight;
            }

            graphics.drawString(this.font, line, currentX, currentY, color, false);
            currentY += lineHeight;

            if ((currentY - y) / lineHeight >= maxLinesPerPage) {
                isLeftPage = !isLeftPage;
                currentX = isLeftPage ? leftPageX : rightPageX;
                currentY = y;
            }
        }
    }

    private String parseTextFormatting(String text) {
        return text.replace("[b]", "§l").replace("[/b]", "§r")
                .replace("[italic]", "§o").replace("[/italic]", "§r")
                .replace("[red]", "§c").replace("[/red]", "§r")
                .replace("[blue]", "§9").replace("[/blue]", "§r");
    }


    private void renderCustomTableOfContents(GuiGraphics graphics, int x, int y, double mouseX, double mouseY, List<BookChapter> chapters) {
        int maxEntriesPerColumn = 8;
        int leftOffsetX = x + 17;
        int rightOffsetX = x + 137;
        int leftOffsetY = 40;
        int rightOffsetY = 20;
        int clickableX, clickableY;

        int visibleChapterIndex = 0;
        for (int i = 0; i < chapters.size(); i++) {
            BookChapter chapter = chapters.get(i);
            int pageIndex = chapter.getPageIndex();

            if (pageIndex < 0 || pageIndex >= pages.size() || !pages.get(pageIndex).isUnlockedPage()) {
                continue;
            }

            if (visibleChapterIndex < maxEntriesPerColumn) {
                clickableX = leftOffsetX;
                clickableY = y + leftOffsetY + (visibleChapterIndex * 15);
            } else {
                clickableX = rightOffsetX;
                clickableY = y + rightOffsetY + ((visibleChapterIndex - maxEntriesPerColumn) * 15);
            }

            String title = chapter.getTitle();
            graphics.drawString(this.font, title, clickableX, clickableY, 0x6e3c31, false);

            if (isMouseOverEntry(clickableX, clickableY, title, mouseX, mouseY)) {
                graphics.fill(clickableX - 2, clickableY - 2, clickableX + this.font.width(title) + 2, clickableY + this.font.lineHeight + 2, 0x80FFFFFF);
            }

            visibleChapterIndex++;
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
            // Kapitelbereich für die erste Seite
            if (chapters.containsKey(currentPage)) {
                int maxEntriesPerColumn = 8;
                int leftOffsetX = 147;
                int rightOffsetX = 267;
                int clickableY;
                int visibleChapterIndex = 0;

                // Prüfen, ob die Liste für den aktuellen Page Index vorhanden ist
                if (chapters.containsKey(currentPage)) {
                    List<BookChapter> currentChapters = chapters.get(currentPage);
                    for (int i = 0; i < currentChapters.size(); i++) {
                        BookChapter chapter = currentChapters.get(i);
                        String title = chapter.getTitle();
                        int pageIndex = chapter.getPageIndex();

                        if (pageIndex < 0 || pageIndex >= pages.size() || !pages.get(pageIndex).isUnlockedPage()) {
                            continue;
                        }

                        if (visibleChapterIndex < maxEntriesPerColumn) {
                            clickableY = 75 + (visibleChapterIndex * 15);
                            if (isMouseOverEntry(leftOffsetX, clickableY, title, mouseX, mouseY)) {
                                this.currentPage = pageIndex; // Wechsle zur entsprechenden Seite
                                playPageTurnSound();
                                return true;
                            }
                        } else {
                            clickableY = 55 + ((visibleChapterIndex - maxEntriesPerColumn) * 15);
                            if (isMouseOverEntry(rightOffsetX, clickableY, title, mouseX, mouseY)) {
                                this.currentPage = pageIndex; // Wechsle zur entsprechenden Seite
                                playPageTurnSound();
                                return true;
                            }
                        }

                        visibleChapterIndex++;
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
        int startPage = currentPage;
        do {
            currentPage++;
            if (currentPage >= pages.size()) {
                currentPage = pages.size() - 1; // Begrenzung auf letzte Seite
                break;
            }
        } while (!pages.get(currentPage).isUnlockedPage());

        if (pages.get(currentPage).isUnlockedPage() && currentPage != startPage) {
            startPageTurnAnimation("next_page");
        }
    }

    private void previousPage() {
        int startPage = currentPage;
        do {
            currentPage--;
            if (currentPage < 0) {
                currentPage = 0; // Begrenzung auf erste Seite
                break;
            }
        } while (!pages.get(currentPage).isUnlockedPage());

        if (pages.get(currentPage).isUnlockedPage() && currentPage != startPage) {
            startPageTurnAnimation("prev_page");
        }
    }

    private void startPageTurnAnimation(String animationTag) {
        if (!isTransitioning) {
            currentTransitionAnimation = transitionsAnimations.stream()
                    .filter(animation -> animationTag.equals(animation.getTag()))
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
                currentTransitionAnimation = null;
                currentPageTickCount = 0;
            }
        } else {
            currentPageTickCount++;
        }
    }

    public void unlockPage(BotanicaBookPages page) {
        CompoundTag playerData = player.getPersistentData();
        playerData.putBoolean("botanica_unlocked_" + page.name(), true);
        System.out.println("Seite " + page.name() + " wurde freigeschaltet!");
    }


}
