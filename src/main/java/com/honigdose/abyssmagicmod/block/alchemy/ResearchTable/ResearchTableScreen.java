package com.honigdose.abyssmagicmod.block.alchemy.ResearchTable;


import com.honigdose.abyssmagicmod.AbyssMagicMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;


public class ResearchTableScreen extends Screen {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(AbyssMagicMod.MOD_ID, "textures/gui/research_table_gui.png");
    private static final int GUI_WIDTH = 256;
    private static final int GUI_HEIGHT = 256;

    protected ResearchTableScreen(Component pTitle) {
        super(pTitle);
    }



    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);
        rendergui(graphics);
    }

    private void rendergui(GuiGraphics guiGraphics) {

        int x = (width - GUI_WIDTH) / 2;
        int y = (height - GUI_HEIGHT) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}