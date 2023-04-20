package coda.rookery.client.screen;

import coda.rookery.Rookery;
import coda.rookery.common.menus.LetterDestinationMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LetterDestinationScreen extends AbstractContainerScreen<LetterDestinationMenu> {
    private static final ResourceLocation INV = new ResourceLocation(Rookery.MOD_ID, "textures/gui/letter_destination.png");
    private final Component title = Component.translatable("menu.rookery.letter_destination");

    public LetterDestinationScreen(LetterDestinationMenu menu, Inventory inv, Component component) {
        super(menu, inv, component);

        this.imageHeight = 228;
        this.imageWidth = 176;
    }

    @Override
    public void removed() {
        super.removed();
        this.minecraft.keyboardHandler.setSendRepeatsToGui(false);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == 256) {
            this.minecraft.player.closeContainer();
        }

        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    protected void renderBg(PoseStack stack, float partialTick, int x, int y) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, INV);

        int i = this.leftPos;
        int j = this.topPos;

        this.blit(stack, i, j, 0, 0, this.imageWidth, this.imageHeight);

        this.blit(stack, i + 33, j + 14, 0, this.imageHeight, 110, 16);

    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;

        int xMin = i + 35;
        int xMax = i + 141;

        int yMin = j + 16;
        int yMax = j + 28;

        if (pMouseX > xMin && pMouseX < xMax && pMouseY > yMin && pMouseY < yMax) {
        }

        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int x, int y) {
        this.font.draw(matrixStack, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY + 61.0F, 4210752);
    }
}