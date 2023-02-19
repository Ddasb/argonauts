package com.kiuseii.argonauts.capabilities.mana;

import net.minecraft.nbt.CompoundTag;

public class ManaCapability {
  private final int MIN_MANA = 0;
  private final int MAX_MANA = 1000;

  private int mana;

  public int getMana() {
    return mana;
  }

  public void refillMana(int amount) {
    this.mana = Math.min(mana + amount, MAX_MANA);
  }

  public void consumeMana(int amount) {
    this.mana = Math.max(mana - amount, MIN_MANA);
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
