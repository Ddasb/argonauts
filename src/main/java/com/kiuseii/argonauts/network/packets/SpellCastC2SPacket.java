package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.capabilities.attributes.AttributesProvider;
import com.kiuseii.argonauts.spells.FireballSpell;
import com.kiuseii.argonauts.spells.Spell;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class SpellCastC2SPacket {
  public SpellCastC2SPacket() {
  }

  public SpellCastC2SPacket(FriendlyByteBuf buf) {
  }

  public void toBytes(FriendlyByteBuf buf) {
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();

    context.enqueueWork(() -> {
      ServerPlayer player = context.getSender();
      Spell fireballSpell = new FireballSpell();

      player.getCapability(AttributesProvider.ATTRIBUTES_CAPABILITY).ifPresent(attributes -> {
        if (attributes.getMana() > fireballSpell.getMana()) {
          attributes.consumeMana(fireballSpell.getMana(), player);

          fireballSpell.cast(player);
        } else {
          player.sendSystemMessage(Component.literal("Not enought mana !").withStyle(ChatFormatting.RED));
        }
      });
    });

    return true;
  }
}
