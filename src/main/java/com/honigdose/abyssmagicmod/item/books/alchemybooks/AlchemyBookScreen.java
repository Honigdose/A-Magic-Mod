package com.honigdose.abyssmagicmod.item.books.alchemybooks;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.item.books.bookdata.BookChapter;
import com.honigdose.abyssmagicmod.item.books.bookdata.TransitionsAnimations;
import com.honigdose.abyssmagicmod.item.books.botanica.BotanicaBookPages;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlchemyBookScreen extends Screen {
    private static final int GUI_WIDTH = 256;
    private static final int GUI_HEIGHT = 256;

    private final Map<String, List<BookChapter>> chapters = new HashMap<>();
    private static final List<AlchemyBookPages> pages = List.of(AlchemyBookPages.values());
    private int currentPage = 0;
    private int currentPageTickCount = 0;
    private final Player player;

    private boolean isTransitioning = false;
    private TransitionsAnimations currentTransitionAnimation = null;
    private int transitionTickCount = 0;
    private static final int TRANSITION_DURATION = 11;

    public AlchemyBookScreen(Component title, Player player) {
        super(title);
        this.player = player;
        initializeChapters();
    }

    private final List<TransitionsAnimations> transitionsAnimations = List.of(
            new TransitionsAnimations("next_page", 1,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page1.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page2.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page3.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page4.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page5.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page6.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page7.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page8.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page9.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page10.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page11.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page12.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/next_page/alchemy_book_animated_next_page13.png")
            ),
            new TransitionsAnimations("prev_page", 1,
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page1.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page2.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page3.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page4.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page5.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page6.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page7.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page8.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page9.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page10.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page11.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page12.png"),
                    ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/alchemy_book/prev_page/alchemy_book_animated_prev_page13.png")
            )
    );

    private void initializeChapters() {
        // Kapitel, die auf Seite "introduction" erscheinen:
        chapters.put("table_of_contents", new ArrayList<>(List.of(
                new BookChapter("Introduction", "introduction")
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
        int x = (width  - GUI_WIDTH ) / 2;
        int y = (height - GUI_HEIGHT) / 2;
        AlchemyBookPages current = pages.get(currentPage);

        ResourceLocation tex = current.getCurrentTexture(currentPageTickCount);
        graphics.blit(tex, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);

        String currentPageTag = current.getTag();
        if (chapters.containsKey(currentPageTag)) {
            renderTableOfContents(graphics, x, y + 25, mouseX, mouseY, chapters.get(currentPageTag));
        }

        String pageText = current.getPageText();
        if (!pageText.isEmpty()) {
            pageText = replaceVariables(pageText, player);
            drawFormattedText(graphics, pageText, x, y + 46, 50, 120, 0x343541);
        }
    }

    private String replaceVariables(String text, Player player) {
        return text.replace("[player]", player.getName().getString());
    }

    private void drawFormattedText(GuiGraphics graphics, String text, int x, int y, int maxWidth, int maxHeight, int color) {
        String[] lines = text.split("\n");

        int leftPageX = x + 17;
        int rightPageX = x + 137;
        int lineHeight = 4;
        int maxLinesPerPage = maxHeight / lineHeight;

        int currentX = leftPageX;
        int currentY = y;
        boolean isLeftPage = true;

        for (String line : lines) {
            int imageWidth = 32, imageHeight = 32;
            boolean isImageLine = false;

            if (line.startsWith("[image64:")) {
                imageWidth = 64;
                imageHeight = 64;
                line = line.substring(9, line.length() - 1);
                isImageLine = true;
            } else if (line.startsWith("[image16:")) {
                imageWidth = 16;
                imageHeight = 16;
                line = line.substring(9, line.length() - 1);
                isImageLine = true;
            } else if (line.startsWith("[image80:")) {
                imageWidth = 80;
                imageHeight = 80;
                line = line.substring(9, line.length() - 1);
                isImageLine = true;
            } else if (line.startsWith("[image:")) {
                line = line.substring(7, line.length() - 1);
                isImageLine = true;
            } else {
                line = parseTextFormatting(line);
            }

            if (isImageLine && line.contains("/")) {
                ResourceLocation image =  ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/" + line);

                if (imageWidth == 80) {
                    currentX = isLeftPage ? leftPageX + 10 : rightPageX + 10;
                    currentY += lineHeight;
                } else {
                    currentX = isLeftPage ? leftPageX + 2 : rightPageX + 2;
                    currentY += lineHeight;
                }

                drawImageWithFrame(graphics, image, currentX, currentY, imageWidth, imageHeight);

                currentX += imageWidth + 10;
                continue;
            }

            if (currentX + this.font.width(line) > (isLeftPage ? (leftPageX + maxWidth) : (rightPageX + maxWidth))) {
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

    private void drawImageWithFrame(GuiGraphics graphics, ResourceLocation image, int x, int y, int imageWidth, int imageHeight) {
        ResourceLocation frame =  ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/botanica_book/page_accessories/botanica_image_frame.png");

        graphics.fill(x - 2, y - 2, x + imageWidth + 2, y + imageHeight + 2, 0x343541);

        RenderSystem.setShaderTexture(0, image);
        graphics.blit(image, x, y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);

        int offset;
        int extraSize;
        if (imageWidth == 80 || imageWidth == 64) {
            offset = 5;
            extraSize = 10;
        } else if (imageWidth == 16) {
            offset = 3;
            extraSize = 6;
        } else {
            offset = 4;
            extraSize = 8;
        }

        RenderSystem.setShaderTexture(0, frame);
        graphics.blit(frame, x - offset, y - offset, 0, 0, imageWidth + extraSize, imageHeight + extraSize, imageWidth + extraSize, imageHeight + extraSize);
    }


    private String parseTextFormatting(String text) {
        return text.replace("[b]", "§l").replace("[/b]", "§r")
                .replace("[italic]", "§o").replace("[/italic]", "§r")
                .replace("[red]", "§c").replace("[/red]", "§r")
                .replace("[blue]", "§9").replace("[/blue]", "§r");
    }

    private void renderTableOfContents(GuiGraphics graphics, int x, int y, double mouseX, double mouseY, List<BookChapter> chapters) {
        int maxEntriesPerColumn = 8;
        int leftOffsetX = x + 17;
        int rightOffsetX = x + 137;
        int leftOffsetY = 40;
        int rightOffsetY = 20;
        int clickableX, clickableY;

        int visibleChapterIndex = 0;
        for (int i = 0; i < chapters.size(); i++) {
            BookChapter chapter = chapters.get(i);

            AlchemyBookPages page;
            try {
                page = AlchemyBookPages.getByTag(chapter.getPageTag());
            } catch (IllegalArgumentException e) {
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
            graphics.drawString(this.font, title, clickableX, clickableY, 0x343541, false);

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
            String currentPageTag = pages.get(currentPage).getTag();

            if (chapters.containsKey(currentPageTag)) {
                int maxEntriesPerColumn = 8;
                int leftOffsetX = 147;
                int rightOffsetX = 267;
                int clickableY;
                int visibleChapterIndex = 0;

                List<BookChapter> currentChapters = chapters.get(currentPageTag);
                for (int i = 0; i < currentChapters.size(); i++) {
                    BookChapter chapter = currentChapters.get(i);
                    String title = chapter.getTitle();

                    BotanicaBookPages page;
                    try {
                        page = BotanicaBookPages.getByTag(chapter.getPageTag());
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    int pageIndex = page.getPageIndex();

                    if (pageIndex < 0 || pageIndex >= pages.size()) {
                        continue;
                    }

                    if (visibleChapterIndex < maxEntriesPerColumn) {
                        clickableY = 75 + (visibleChapterIndex * 15);
                        if (isMouseOverEntry(leftOffsetX, clickableY, title, mouseX, mouseY)) {
                            this.currentPage = pageIndex;
                            playPageTurnSound();
                            return true;
                        }
                    } else {
                        clickableY = 55 + ((visibleChapterIndex - maxEntriesPerColumn) * 15);
                        if (isMouseOverEntry(rightOffsetX, clickableY, title, mouseX, mouseY)) {
                            this.currentPage = pageIndex;
                            playPageTurnSound();
                            return true;
                        }
                    }

                    visibleChapterIndex++;
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
        if (currentPage < pages.size() - 1) {
            currentPage++;
            startPageTurnAnimation("next_page");
        }
    }

    private void previousPage() {
        if (currentPage > 0) {
            currentPage--;
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

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}