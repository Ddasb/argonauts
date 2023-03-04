package com.kiuseii.argonauts.events;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.network.PacketHandler;
import com.kiuseii.argonauts.network.packets.ShowStatsC2SPacket;
import com.kiuseii.argonauts.network.packets.SpellCastC2SPacket;
import com.kiuseii.argonauts.util.KeyBindings;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Argonauts.MOD_ID, value = Dist.CLIENT)
public class ClientForgeEvents {
  @SubscribeEvent
  public static void onKeyInput(InputEvent.Key event) {
    if (KeyBindings.SPELL_ONE_KEY.consumeClick()) {
      PacketHandler.sendToServer(new SpellCastC2SPacket());
    }

    if (KeyBindings.SHOW_STATS_KEY.consumeClick()) {
      PacketHandler.sendToServer(new ShowStatsC2SPacket());
    }
  }
}
