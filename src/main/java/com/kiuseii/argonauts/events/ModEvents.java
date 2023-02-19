package com.kiuseii.argonauts.events;

import com.kiuseii.argonauts.Argonauts;
import com.kiuseii.argonauts.capabilities.mana.ManaProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Argonauts.MOD_ID)
public class ModEvents {
  @SubscribeEvent
  public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
    if (event.getObject() instanceof Player) {
      if (!event.getObject().getCapability(ManaProvider.MANA_CAPABILITY).isPresent()) {
        event.addCapability(new ResourceLocation(Argonauts.MOD_ID, "properties"), new ManaProvider());
      }
    }
  }

  @SubscribeEvent
  public static void onPlayerCloned(PlayerEvent.Clone event) {
    if (event.isWasDeath()) {
      event.getOriginal().getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(oldStore -> {
        event.getEntity().getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(newStore -> {
          newStore.copyFrom(oldStore);
        });
      });
    }
  }

  @SubscribeEvent
  public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
    if (event.side == LogicalSide.SERVER) {
      event.player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(mana -> {
        mana.refillMana(1, (ServerPlayer) event.player);
      });
    }
  }
}
