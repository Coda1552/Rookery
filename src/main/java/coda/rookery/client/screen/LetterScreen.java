package coda.rookery.client.screen;

import coda.rookery.Rookery;
import coda.rookery.common.menus.LetterMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LetterScreen extends AbstractContainerScreen<LetterMenu> {
    private static final ResourceLocation INV = new ResourceLocation(Rookery.MOD_ID, "textures/gui/letter.png");
    private final Component title = Component.translatable("menu.rookery.letter");

    public LetterScreen(LetterMenu menu, Inventory inv, Component component) {
        super(menu, inv, component);
    }

    @Override
    protected void renderBg(PoseStack stack, float partialTick, int x, int y) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, INV);

        int i = this.leftPos;
        int j = this.topPos;

        this.blit(stack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int x, int y) {
        this.font.draw(matrixStack, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);

        this.titleLabelY = (this.imageWidth - this.font.width(this.title)) / 2;

        this.font.draw(matrixStack, this.title, (float) this.titleLabelY, (float) this.titleLabelX - 2, 4210752);
    }
}