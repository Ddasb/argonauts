package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.client.data.AttributesData;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class AttributesDataSyncS2CPacket {
  private int level;

  private int mana;

  private int excelia;

  private int strength;
  private int endurance;
  private int dexterity;
  private int agility;
  private int magic;

  private int strength_progression;
  private int endurance_progression;
  private int dexterity_progression;
  private int agility_progression;
  private int magic_progression;

  public AttributesDataSyncS2CPacket(int level, int mana, int excelia, int strength,
      int endurance,
      int dexterity,
      int agility,
      int magic,
      int strength_progression,
      int endurance_progression,
      int dexterity_progression,
      int agility_progression,
      int magic_progression) {
    this.level = level;

    this.mana = mana;

    this.excelia = excelia;

    this.strength = strength;
    this.endurance = endurance;
    this.dexterity = dexterity;
    this.agility = agility;
    this.magic = magic;

    this.strength_progression = strength_progression;
    this.endurance_progression = endurance_progression;
    this.dexterity_progression = dexterity_progression;
    this.agility_progression = agility_progression;
    this.magic_progression = magic_progression;
  }

  public AttributesDataSyncS2CPacket(FriendlyByteBuf buf) {
    CompoundTag nbt = buf.readNbt();

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

  public void toBytes(FriendlyByteBuf buf) {
    CompoundTag nbt = new CompoundTag();

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

    buf.writeNbt(nbt);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();

    context.enqueueWork(() -> {
      AttributesData.setLevel(level);

      AttributesData.setMana(mana);

      AttributesData.setExcelia(excelia);

      AttributesData.setStatistic("strength", strength);
      AttributesData.setStatistic("endurance", endurance);
      AttributesData.setStatistic("dexterity", dexterity);
      AttributesData.setStatistic("agility", agility);
      AttributesData.setStatistic("magic", magic);

      AttributesData.setStatistic("strength_progression", strength_progression);
      AttributesData.setStatistic("endurance_progression", endurance_progression);
      AttributesData.setStatistic("dexterity_progression", dexterity_progression);
      AttributesData.setStatistic("agility_progression", agility_progression);
      AttributesData.setStatistic("magic_progression", magic_progression);
    });

    return true;
  }
}
