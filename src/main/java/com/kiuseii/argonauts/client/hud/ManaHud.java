package com.kiuseii.argonauts.client.hud;

import com.kiuseii.argonauts.Argonauts;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHud {
  private static final ResourceLocation EMPTY_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/mana/empty_mana.png");
  private static final ResourceLocation FILLED_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/mana/filled_mana.png");

  public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
    int x = width / 2;
    int y = height;

    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    RenderSystem.setShaderTexture(0, EMPTY_MANA);

    GuiComponent.blit(poseStack, x - 91, y - 47, 0, 0, 182, 5, 182, 5);

    RenderSystem.setShaderTexture(0, FILLED_MANA);

    GuiComponent.blit(poseStack, x - 90, y - 47, 0, 0, 90, 5, 90, 5);
  });
}
