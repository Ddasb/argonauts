package com.kiuseii.argonauts.client.hud;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.client.data.AttributesData;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class AttributesHudOverlay {
  private static final ResourceLocation EMPTY_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/gui/empty_mana.png");
  private static final ResourceLocation FILLED_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/gui/filled_mana.png");
  private static final ResourceLocation EMPTY_HEALTH = new ResourceLocation(Argonauts.MOD_ID,
          "textures/gui/empty_health.png");
  private static final ResourceLocation FILLED_HEALTH = new ResourceLocation(Argonauts.MOD_ID,
          "textures/gui/filled_health.png");

  public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

    Minecraft minecraft = Minecraft.getInstance();
    Player player = minecraft.player;

    int x = width / 2;
    int y = height - 30;
    int empty_width = 125;
    int filled_width = 123;

    // HANDLING MANA HUD
    RenderSystem.setShaderTexture(0, EMPTY_MANA);
    GuiComponent.blit(poseStack, x + 30, y, 0, 0, empty_width, 4, empty_width, 4);

    int current_mana = AttributesData.getMana();

    RenderSystem.setShaderTexture(0, FILLED_MANA);
    GuiComponent.blit(poseStack, x + 31, y, 0, 0, filled_width * current_mana / 1000, 4,
            filled_width * current_mana / 1000, 4);

    GuiComponent.drawString(poseStack, minecraft.font,
            Component.literal(Integer.toString(current_mana) + " / 1000").withStyle(ChatFormatting.WHITE),
            x + 96, y - 9, 10);

    // HANDLING HEALTH HUD
    RenderSystem.setShaderTexture(0, EMPTY_HEALTH);
    GuiComponent.blit(poseStack, x - 155, y, 0, 0, empty_width, 4, empty_width, 4);

    int current_health = (int) player.getHealth();
    int max_health = (int) player.getMaxHealth();

    RenderSystem.setShaderTexture(0, FILLED_HEALTH);
    GuiComponent.blit(poseStack, x - 154, y, 0, 0, filled_width * current_health / max_health, 4,
            filled_width * current_health / max_health, 4);

    GuiComponent.drawString(poseStack, minecraft.font,
            Component.literal(Integer.toString(current_health) + " / " + Integer.toString(max_health))
                    .withStyle(ChatFormatting.WHITE),
            x - 154, y - 9, 10);

    // HANDLING LEVEL HUD
    int current_level = AttributesData.getLevel();
    String level_text = "O";

    if(current_level == 1) {
      level_text = "I";
    } else if(current_level == 2) {
      level_text = "II";
    } else if(current_level == 3) {
      level_text = "III";
    } else if(current_level == 4) {
      level_text = "IV";
    } else if(current_level == 5) {
      level_text = "V";
    } else if(current_level == 6) {
      level_text = "VI";
    } else if(current_level == 7) {
      level_text = "VII";
    }

    GuiComponent.drawCenteredString(poseStack, minecraft.font,
            Component.literal(level_text).withStyle(ChatFormatting.WHITE),
            x, y - 9, 10);
  });
}
