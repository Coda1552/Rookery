package coda.rookery.client.screen;

import coda.rookery.Rookery;
import coda.rookery.common.menus.LetterDestinationMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

import javax.annotation.Nullable;

public class LetterDestinationScreen extends AbstractContainerScreen<LetterDestinationMenu> {
    private static final ResourceLocation INV = new ResourceLocation(Rookery.MOD_ID, "textures/gui/letter_destination.png");

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

        Integer integer1 = 19;
        MapItemSavedData data = MapItem.getSavedData(integer1, this.minecraft.level);

        this.renderResultingMap(stack, integer1, data, true);
    }

    private void renderResultingMap(PoseStack pPoseStack, @Nullable Integer pMapId, @Nullable MapItemSavedData pMapData, boolean pHasMap) {
        int i = this.leftPos;
        int j = this.topPos;
        if (pHasMap) {
            RenderSystem.setShaderTexture(0, INV);
            pPoseStack.pushPose();
            pPoseStack.translate(0.0D, 0.0D, 1.0D);
            this.blit(pPoseStack, i + 67, j + 13 + 16, this.imageWidth, 132, 50, 66);
            this.renderMap(pPoseStack, pMapId, pMapData, i + 29, j + 16, 0.925F);
            pPoseStack.popPose();
        }

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


    private void renderMap(PoseStack pPoseStack, @Nullable Integer pMapId, @Nullable MapItemSavedData pMapData, int pX, int pY, float pScale) {
        if (pMapId != null && pMapData != null) {
            pPoseStack.pushPose();
            pPoseStack.translate(pX, pY, 1.0D);
            pPoseStack.scale(pScale, pScale, 1.0F);
            MultiBufferSource.BufferSource multibuffersource$buffersource = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
            this.minecraft.gameRenderer.getMapRenderer().render(pPoseStack, multibuffersource$buffersource, pMapId, pMapData, true, 15728880);
            multibuffersource$buffersource.endBatch();
            pPoseStack.popPose();
        }

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