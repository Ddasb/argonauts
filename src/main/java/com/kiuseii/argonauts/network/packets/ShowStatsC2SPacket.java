package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.capabilities.attributes.AttributesProvider;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ShowStatsC2SPacket {
  public ShowStatsC2SPacket() {
  }

  public ShowStatsC2SPacket(FriendlyByteBuf buf) {
  }

  public void toBytes(FriendlyByteBuf buf) {
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();

    context.enqueueWork(() -> {
      ServerPlayer player = context.getSender();

      player.getCapability(AttributesProvider.ATTRIBUTES_CAPABILITY).ifPresent(attributes -> {
        player.sendSystemMessage(Component.literal("Level : " + attributes.getLevel()).withStyle(ChatFormatting.RED));

        player.sendSystemMessage(Component.literal("Mana : " + attributes.getMana()).withStyle(ChatFormatting.BLUE));

        player
            .sendSystemMessage(Component.literal("Excelia : " + attributes.getExcelia()).withStyle(ChatFormatting.RED));

        player.sendSystemMessage(
            Component.literal("Strength : " + attributes.getStatistic("strength")).withStyle(ChatFormatting.RED));
        player.sendSystemMessage(
            Component.literal("Endurance : " + attributes.getStatistic("endurance")).withStyle(ChatFormatting.RED));
        player.sendSystemMessage(
            Component.literal("Dexterity : " + attributes.getStatistic("dexterity")).withStyle(ChatFormatting.RED));
        player.sendSystemMessage(
            Component.literal("Agility : " + attributes.getStatistic("agility")).withStyle(ChatFormatting.RED));
        player.sendSystemMessage(
            Component.literal("Magic : " + attributes.getStatistic("magic")).withStyle(ChatFormatting.RED));
      });
    });

    return true;
  }
}
