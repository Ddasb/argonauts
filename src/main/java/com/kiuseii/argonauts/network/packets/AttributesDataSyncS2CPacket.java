package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.client.data.AttributesData;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class AttributesDataSyncS2CPacket {
  private final int level;

  private final int mana;

  private final int excelia;

  private final int strength;
  private final int endurance;
  private final int dexterity;
  private final int agility;
  private final int magic;

  private final int strength_progression;
  private final int endurance_progression;
  private final int dexterity_progression;
  private final int agility_progression;
  private final int magic_progression;

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

    level = nbt.getInt("level");

    mana = nbt.getInt("mana");

    excelia = nbt.getInt("excelia");

    strength = nbt.getInt("strength");
    endurance = nbt.getInt("endurance");
    dexterity = nbt.getInt("dexterity");
    agility = nbt.getInt("agility");
    magic = nbt.getInt("magic");

    strength_progression = nbt.getInt("strength_progression");
    endurance_progression = nbt.getInt("endurance_progression");
    dexterity_progression = nbt.getInt("dexterity_progression");
    agility_progression = nbt.getInt("agility_progression");
    magic_progression = nbt.getInt("magic_progression");
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
