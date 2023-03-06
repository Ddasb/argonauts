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

public class HealthHudOverylay {
    private static final ResourceLocation EMPTY_HEALTH = new ResourceLocation(Argonauts.MOD_ID,
            "textures/gui/empty_health.png");
    private static final ResourceLocation FILLED_HEALTH = new ResourceLocation(Argonauts.MOD_ID,
            "textures/gui/filled_health.png");

    public static final IGuiOverlay HUD_HEALTH = ((gui, poseStack, partialTick, width, height) -> {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        int x = width / 2;
        int y = height - 30;
        int empty_width = 125;
        int filled_width = 123;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, EMPTY_HEALTH);
        GuiComponent.blit(poseStack, x - 155, y, 0, 0, empty_width, 4, empty_width, 4);

        int current_health = (int) player.getHealth();
        int max_health = (int) player.getMaxHealth();

        RenderSystem.setShaderTexture(0, FILLED_HEALTH);
        GuiComponent.blit(poseStack, x - 154, y, 0, 0, filled_width * current_health / max_health, 4,
                filled_width * current_health / max_health, 4);

        GuiComponent.drawString(poseStack, minecraft.font,
            Component.translatable("gui.health.title").withStyle(ChatFormatting.WHITE),
            x - 154, y - 9, 10
        );
    });
}
