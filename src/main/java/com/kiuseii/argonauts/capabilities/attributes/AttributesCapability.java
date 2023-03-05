package com.kiuseii.argonauts.capabilities.attributes;

import java.util.Arrays;

import com.kiuseii.argonauts.network.PacketHandler;
import com.kiuseii.argonauts.network.packets.AttributesDataSyncS2CPacket;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

public class AttributesCapability {
    private int level = 0;

    private final int MIN_MANA = 0;
    private final int MAX_MANA = 1000;
    private int mana;

    private int excelia = 0;

    private int strength = 0;
    private int endurance = 0;
    private int dexterity = 0;
    private int agility = 0;
    private int magic = 0;

    private int strength_progression = 0;
    private int endurance_progression = 0;
    private int dexterity_progression = 0;
    private int agility_progression = 0;
    private int magic_progression = 0;

    public int getLevel() {
        return level;
    }

    public void levelUp(int amount, ServerPlayer player) {
        this.strength = strength + strength_progression;
        this.endurance = endurance + endurance_progression;
        this.dexterity = dexterity + dexterity_progression;
        this.agility = agility + agility_progression;
        this.magic = magic + magic_progression;

        int[] exceliaArray = { strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression };
        int maxProgression = Arrays.stream(exceliaArray).max().getAsInt();

        if (maxProgression == strength_progression) {
            this.strength = strength + 50;
        } else if (maxProgression == endurance_progression) {
            this.endurance = endurance + 50;
        } else if (maxProgression == dexterity_progression) {
            this.dexterity = dexterity + 50;
        } else if (maxProgression == agility_progression) {
            this.agility = agility + 50;
        } else {
            this.magic = magic + 50;
        }

        this.strength_progression = 0;
        this.endurance_progression = 0;
        this.dexterity_progression = 0;
        this.agility_progression = 0;
        this.magic_progression = 0;

        this.level = level + amount;

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public int getMana() {
        return mana;
    }

    public void refillMana(int amount, ServerPlayer player) {
        this.mana = Math.min(mana + amount, MAX_MANA);

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public void consumeMana(int amount, ServerPlayer player) {
        this.mana = Math.max(mana - amount, MIN_MANA);

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public int getExcelia() {
        return excelia;
    }

    public void increaseExcelia(int amount, ServerPlayer player) {
        this.excelia = excelia + amount;

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public void consumeExcelia(int amount, ServerPlayer player) {
        this.excelia = Math.max(0, excelia - amount);

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public int getStatistic(String statisticName) {
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

    public void increaseProgression(String statisticName, int amount, ServerPlayer player) {
        switch (statisticName) {
            case "strength":
                this.strength_progression = strength_progression + amount;
                break;
            case "endurance":
                this.endurance_progression = endurance_progression + amount;
                break;
            case "dexterity":
                this.dexterity_progression = dexterity_progression + amount;
                break;
            case "agility":
                this.agility_progression = agility_progression + amount;
                break;
            case "magic":
                this.magic_progression = magic_progression + amount;
                break;
        }

        PacketHandler.sendToPlayer(new AttributesDataSyncS2CPacket(level, mana, excelia, strength, endurance, dexterity,
                agility, magic, strength_progression, endurance_progression, dexterity_progression, agility_progression,
                magic_progression), player);
    }

    public void copyFrom(AttributesCapability source) {
        this.level = source.level;

        this.mana = source.mana;

        this.excelia = source.excelia;

        this.strength = source.strength;
        this.endurance = source.endurance;
        this.dexterity = source.dexterity;
        this.agility = source.agility;
        this.magic = source.magic;

        this.strength_progression = source.strength_progression;
        this.endurance_progression = source.endurance_progression;
        this.dexterity_progression = source.dexterity_progression;
        this.agility_progression = source.agility_progression;
        this.magic_progression = source.magic_progression;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("level", level);

        nbt.putInt("mana", mana);

        nbt.putInt("excelia", excelia);

        nbt.putInt("strength", strength);
        nbt.putInt("endurance", endurance);
        nbt.putInt("dexterity", dexterity);
        nbt.putInt("agility", agility);
        nbt.putInt("magic", magic);

        nbt.putInt("strength_progression", strength_progression);
        nbt.putInt("endurance_progression", endurance_progression);
        nbt.putInt("dexterity_progression", dexterity_progression);
        nbt.putInt("agility_progression", agility_progression);
        nbt.putInt("magic_progression", magic_progression);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.level = nbt.getInt("level");

        this.mana = nbt.getInt("mana");

        this.excelia = nbt.getInt("excelia");

        this.strength = nbt.getInt("strength");
        this.endurance = nbt.getInt("endurance");
        this.dexterity = nbt.getInt("dexterity");
        this.agility = nbt.getInt("agility");
        this.magic = nbt.getInt("magic");

        this.strength_progression = nbt.getInt("strength_progression");
        this.endurance_progression = nbt.getInt("endurance_progression");
        this.dexterity_progression = nbt.getInt("dexterity_progression");
        this.agility_progression = nbt.getInt("agility_progression");
        this.magic_progression = nbt.getInt("magic_progression");
    }
}
