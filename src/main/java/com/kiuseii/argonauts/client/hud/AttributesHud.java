package com.kiuseii.argonauts.client.hud;

import com.kiuseii.argonauts.Argonauts;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class AttributesHud extends Screen {
  private static final ResourceLocation HUD_TEXTURE = new ResourceLocation(Argonauts.MOD_ID,
      "textures/gui/attributes.png");
  private final int TEXTURE_HEIGHT = 166;
  private final int TEXTURE_WIDTH = 98;

  public AttributesHud(Component title) {
    super(title);
  }

  @Override
  protected void init() {
    super.init();
  }

  @Override
  public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
    this.renderBackground(poseStack);

    int x = (this.width - TEXTURE_WIDTH) / 2;
    int y = (this.height - TEXTURE_HEIGHT) / 2;

    Minecraft.getInstance().getTextureManager().bindForSetup(HUD_TEXTURE);

    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

    RenderSystem.setShaderTexture(0, HUD_TEXTURE);
    blit(poseStack, x, y, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    super.render(poseStack, mouseX, mouseY, partialTick);
  }
}
