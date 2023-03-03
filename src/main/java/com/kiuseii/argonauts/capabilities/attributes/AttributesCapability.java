package com.kiuseii.argonauts.capabilities.attributes;

public class AttributesCapability {
    private int level;

    private int excelia;

    private int strength;
    private int endurance;
    private int dexterity;
    private int agility;
    private int magic;

    public int getLevel() {
        return level;
    }

    public int getExcelia() {
        return excelia;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getMagic() {
        return magic;
    }

    public void increaseLevel(int amount) {
        level = level + amount;
    }

    public void increaseExcelia(int amount) {
        excelia = excelia + amount;
    }

    public void increaseStrength(int amount) {
        strength = strength + amount;
    }

    public void increaseDexterity(int amount) {
        dexterity = dexterity + amount;
    }

    public void increaseAgility(int amount) {
        agility = agility + amount;
    }

    public void increaseMagic(int amount) {
        magic = magic + amount;
    }
}
