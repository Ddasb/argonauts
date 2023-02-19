package com.kiuseii.argonauts.client.data;

public class ManaData {
  private static int mana;

  public static void set(int amount) {
    ManaData.mana = amount;
  }

  public static int getMana() {
    return mana;
  }
}
