package com.kiuseii.argonauts.client.data;

import org.w3c.dom.Attr;

public class AttributesData {
  private static int level;

  private static int mana;

  private static int excelia;

  private static int strength;
  private static int endurance;
  private static int dexterity;
  private static int agility;
  private static int magic;

  private static int strength_progression;
  private static int endurance_progression;
  private static int dexterity_progression;
  private static int agility_progression;
  private static int magic_progression;

  public static int getLevel() {
    return level;
  }

  public static void setLevel(int newLevel) {
    AttributesData.level = newLevel;
  }

  public static int getMana() {
    return mana;
  }

  public static void setMana(int amount) {
    mana = amount;
  }

  public static int getExcelia() {
    return excelia;
  }

  public static void setExcelia(int newExcelia) {
    AttributesData.excelia = newExcelia;
  }

  public static int getStatistic(String statisticName) {
    switch (statisticName) {
      case "strength":
        return strength + strength_progression;
      case "endurance":
        return endurance + endurance_progression;
      case "dexterity":
        return dexterity + dexterity_progression;
      case "agility":
        return agility + agility_progression;
      case "magic":
        return magic + magic_progression;
      default:
        return 0;
    }
  }

  public static void setStatistic(String statisticName, int newValue) {
    switch (statisticName) {
      case "strength":
        AttributesData.strength = newValue;
        break;
      case "endurance":
        AttributesData.endurance = newValue;
        break;
      case "dexterity":
        AttributesData.dexterity = newValue;
        break;
      case "agility":
        AttributesData.agility = newValue;
        break;
      case "magic":
        AttributesData.magic = newValue;
        break;
    }
  }

  public static void setStatisticProgression(String statisticName, int newValue) {
    switch (statisticName) {
      case "strength":
        AttributesData.strength_progression = newValue;
        break;
      case "endurance":
        AttributesData.endurance_progression = newValue;
        break;
      case "dexterity":
        AttributesData.dexterity_progression = newValue;
        break;
      case "agility":
        AttributesData.agility_progression = newValue;
        break;
      case "magic":
        AttributesData.magic_progression = newValue;
        break;
    }
  }
}
