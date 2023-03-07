package com.kiuseii.argonauts.events;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.capabilities.attributes.AttributesProvider;
import com.kiuseii.argonauts.client.hud.AttributesHudOverlay;
import com.kiuseii.argonauts.util.KeyBindings;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Argonauts.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusEvents {
  @SubscribeEvent
  public static void onKeyRegister(RegisterKeyMappingsEvent event) {
    event.register(KeyBindings.SPELL_ONE_KEY);
    event.register(KeyBindings.SHOW_STATS_KEY);
  }

  @SubscribeEvent
  public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
    event.registerAboveAll("mana", AttributesHudOverlay.HUD_MANA);
  }
}
