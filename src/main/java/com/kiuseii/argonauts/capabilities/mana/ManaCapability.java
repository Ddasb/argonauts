package com.kiuseii.argonauts.capabilities.mana;

import com.kiuseii.argonauts.network.PacketHandler;
import com.kiuseii.argonauts.network.packets.ManaDataSyncS2CPacket;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

public class ManaCapability {
  private final int MIN_MANA = 0;
  private final int MAX_MANA = 1000;

  private int mana;

  public int getMana() {
    return mana;
  }

  public void refillMana(int amount, ServerPlayer player) {
    this.mana = Math.min(mana + amount, MAX_MANA);

    PacketHandler.sendToPlayer(new ManaDataSyncS2CPacket(mana), player);
  }

  public void consumeMana(int amount, ServerPlayer player) {
    this.mana = Math.max(mana - amount, MIN_MANA);

    PacketHandler.sendToPlayer(new ManaDataSyncS2CPacket(mana), player);
  }

  public void copyFrom(ManaCapability source) {
    this.mana = source.mana;
  }

  public void saveNBTData(CompoundTag nbt) {
    nbt.putInt("mana", mana);
  }

  public void loadNBTData(CompoundTag nbt) {
    mana = nbt.getInt("mana");
  }
}
