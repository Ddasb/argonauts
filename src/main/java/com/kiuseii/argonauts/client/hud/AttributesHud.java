package com.kiuseii.argonauts.client.hud;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.capabilities.attributes.AttributesProvider;
import com.kiuseii.argonauts.client.data.AttributesData;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class AttributesHud extends Screen {
  private static final ResourceLocation HUD_TEXTURE = new ResourceLocation(Argonauts.MOD_ID,"textures/gui/attributes.png");
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

    int hud_x = (this.width - TEXTURE_WIDTH) / 2;
    int hud_y = (this.height - TEXTURE_HEIGHT) / 2;

    minecraft.getTextureManager().bindForSetup(HUD_TEXTURE);

    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

    RenderSystem.setShaderTexture(0, HUD_TEXTURE);
    blit(poseStack, hud_x, hud_y, 0, 0, TEXTURE_WIDTH, TEXTURE_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);

    MutableComponent[] textListLeft = {
      Component.translatable("gui.attributes.level"),
      Component.translatable("gui.attributes.strength"),
      Component.translatable("gui.attributes.endurance"),
      Component.translatable("gui.attributes.dexterity"),
      Component.translatable("gui.attributes.agility"),
      Component.translatable("gui.attributes.magic"),
    };

    MutableComponent[] textListRight = {
      Component.literal(Integer.toString(AttributesData.getLevel())),
      Component.literal(Integer.toString(AttributesData.getStatistic("strength"))),
      Component.literal(Integer.toString(AttributesData.getStatistic("endurance"))),
      Component.literal(Integer.toString(AttributesData.getStatistic("dexterity"))),
      Component.literal(Integer.toString(AttributesData.getStatistic("agility"))),
      Component.literal(Integer.toString(AttributesData.getStatistic("magic"))),
    };

    for (int i = 0; i < textListLeft.length; i++) {
      drawString(poseStack, minecraft.font,
              textListLeft[i].withStyle(ChatFormatting.WHITE),
              hud_x + 10, hud_y + 15 * i + 10, 10);
    }

    for (int i = 0; i < textListRight.length; i++) {
        drawString(poseStack, minecraft.font,
              textListRight[i].withStyle(ChatFormatting.WHITE),
              hud_x + 70, hud_y + 15 * i + 10, 10);
    }

    super.render(poseStack, mouseX, mouseY, partialTick);
  }
}
