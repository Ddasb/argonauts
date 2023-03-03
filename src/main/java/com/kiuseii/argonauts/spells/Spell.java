package com.kiuseii.argonauts.spells;

import net.minecraft.world.entity.Entity;

public abstract class Spell {
  protected int power;
  protected int range;
  protected int mana;
  protected int duration;
  protected String name;

  public Spell(int power, int range, int mana, int duration, String name) {
    this.power = power;
    this.range = range;
    this.mana = mana;
    this.duration = duration;
    this.name = name;
  }

  public abstract void cast(Entity target);

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public int getRange() {
    return range;
  }

  public void setRange(int range) {
    this.range = range;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
