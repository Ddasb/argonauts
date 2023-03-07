package com.kiuseii.argonauts.events;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.capabilities.attributes.AttributesCapability;
import com.kiuseii.argonauts.capabilities.attributes.AttributesProvider;
import com.kiuseii.argonauts.client.hud.AttributesHud;
import com.kiuseii.argonauts.network.PacketHandler;
import com.kiuseii.argonauts.network.packets.SpellCastC2SPacket;
import com.kiuseii.argonauts.util.KeyBindings;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Argonauts.MOD_ID, value = Dist.CLIENT)
public class ClientForgeEvents {
  static ResourceLocation FOOD_LEVEL_ELEMENT = new ResourceLocation("minecraft", "food_level");
  static ResourceLocation PLAYER_HEALTH_ELEMENT = new ResourceLocation("minecraft", "player_health");
  static ResourceLocation PLAYER_EXPERIENCE_ELEMENT = new ResourceLocation("minecraft", "experience_bar");

  @SubscribeEvent
  public static void onKeyInput(InputEvent.Key event) {
    if (KeyBindings.SPELL_ONE_KEY.consumeClick()) {
      PacketHandler.sendToServer(new SpellCastC2SPacket());
    }

    if (KeyBindings.SHOW_STATS_KEY.consumeClick()) {
      AttributesHud hud = new AttributesHud(Component.translatable("gui.attributes.title"));
      Minecraft.getInstance().setScreen(hud);
    }
  }

  @SubscribeEvent
  public static void onRenderGameOverlay(RenderGuiOverlayEvent.Pre event) {
    if(event.getOverlay() == GuiOverlayManager.findOverlay(FOOD_LEVEL_ELEMENT) ||
      event.getOverlay() == GuiOverlayManager.findOverlay(PLAYER_HEALTH_ELEMENT) ||
      event.getOverlay() == GuiOverlayManager.findOverlay(PLAYER_EXPERIENCE_ELEMENT)
    ) {
      event.setCanceled(true);
    }
  }

  @SubscribeEvent
  public static void onPlayerCloned(PlayerEvent.Clone event) {
    Player oldPlayer = event.getOriginal();
    Player newPlayer = event.getEntity();

    if (event.isWasDeath()) {
      Capability<AttributesCapability> cap = AttributesProvider.ATTRIBUTES_CAPABILITY;
      AttributesCapability oldCap = oldPlayer.getCapability(cap).orElse(null);

      if(oldCap == null) {
        return;
      }

      AttributesCapability newCap = new AttributesCapability();
      newCap.copyFrom(oldCap);

      newPlayer.getCapability(cap).ifPresent(c -> c.copyFrom(newCap));
    }
  }
}
