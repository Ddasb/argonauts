package com.kiuseii.argonauts.network;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.network.packets.SpellCastC2SPacket;
import com.kiuseii.argonauts.network.packets.AttributesDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
  private static String PROTOCOL_VERSION = "1";
  private static int packetId = 0;

  private static SimpleChannel CHANNEL;

  public static void init() {
    SimpleChannel net = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Argonauts.MOD_ID, "simple_channel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    CHANNEL = net;

    //net.registerMessage(packetId++, AttributesDataSyncS2CPacket.class, AttributesDataSyncS2CPacket::toBytes,
       //     AttributesDataSyncS2CPacket::new,
     //       AttributesDataSyncS2CPacket::handle);

    //net.registerMessage(packetId++, SpellCastC2SPacket.class, SpellCastC2SPacket::toBytes, SpellCastC2SPacket::new,
      //  SpellCastC2SPacket::handle);

    net.messageBuilder(AttributesDataSyncS2CPacket.class, packetId++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(AttributesDataSyncS2CPacket::new)
            .encoder(AttributesDataSyncS2CPacket::toBytes)
            .consumerMainThread(AttributesDataSyncS2CPacket::handle)
            .add();

    net.messageBuilder(SpellCastC2SPacket.class, packetId++, NetworkDirection.PLAY_TO_SERVER)
            .decoder(SpellCastC2SPacket::new)
            .encoder(SpellCastC2SPacket::toBytes)
            .consumerMainThread(SpellCastC2SPacket::handle)
            .add();
  }

  public static <MSG> void sendToServer(MSG message) {
    CHANNEL.sendToServer(message);
  }

  public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
    CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
  }
}
