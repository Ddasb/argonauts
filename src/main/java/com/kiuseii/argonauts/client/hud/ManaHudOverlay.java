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
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ManaHudOverlay {
  private static final ResourceLocation EMPTY_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/gui/empty_mana.png");
  private static final ResourceLocation FILLED_MANA = new ResourceLocation(Argonauts.MOD_ID,
      "textures/gui/filled_mana.png");

  public static final IGuiOverlay HUD_MANA = ((gui, poseStack, partialTick, width, height) -> {
    Minecraft minecraft = Minecraft.getInstance();

    int x = width / 2;
    int y = height - 30;
    int empty_width = 125;
    int filled_width = 123;

    RenderSystem.setShader(GameRenderer::getPositionTexShader);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

    RenderSystem.setShaderTexture(0, EMPTY_MANA);
    GuiComponent.blit(poseStack, x + 30, y, 0, 0, empty_width, 4, empty_width, 4);

    int current_mana = AttributesData.getMana();

    RenderSystem.setShaderTexture(0, FILLED_MANA);
    GuiComponent.blit(poseStack, x + 31, y, 0, 0, filled_width * current_mana / 1000, 4,
        filled_width * current_mana / 1000, 4);

    GuiComponent.drawString(poseStack, minecraft.font,
            Component.literal(Integer.toString(current_mana) + " / 1000").withStyle(ChatFormatting.WHITE),
            x + 98, y - 9, 10
    );
  });
}
