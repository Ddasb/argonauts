package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.capabilities.mana.ManaProvider;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class SpellCastPacket {
  public SpellCastPacket() {
  }

  public SpellCastPacket(FriendlyByteBuf buf) {
  }

  public void toBytes(FriendlyByteBuf buf) {
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();

    context.enqueueWork(() -> {
      ServerPlayer player = context.getSender();

      player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(mana -> {
        if (mana.getMana() > 100) {
          mana.consumeMana(50);

          player.sendSystemMessage(Component.literal("Your mana : " + mana.getMana()).withStyle(ChatFormatting.AQUA));
        } else {
          player.sendSystemMessage(Component.literal("Not enought mana !").withStyle(ChatFormatting.RED));
        }
      });
    });

    return true;
  }
}
