package com.kiuseii.argonauts.network;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.network.packets.SpellCastC2SPacket;
import com.kiuseii.argonauts.network.packets.AttributesDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
  private static String PROTOCOL_VERSION = "1";
  private static int packetId = 0;

  private static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
      new ResourceLocation(Argonauts.MOD_ID, "messages"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
      PROTOCOL_VERSION::equals);

  public static void init() {
    CHANNEL.registerMessage(packetId++, AttributesDataSyncS2CPacket.class, AttributesDataSyncS2CPacket::toBytes,
            AttributesDataSyncS2CPacket::new,
            AttributesDataSyncS2CPacket::handle);

    CHANNEL.registerMessage(packetId++, SpellCastC2SPacket.class, SpellCastC2SPacket::toBytes, SpellCastC2SPacket::new,
        SpellCastC2SPacket::handle);
  }

  public static <MSG> void sendToServer(MSG message) {
    CHANNEL.sendToServer(message);
  }

  public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
    CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
  }
}
