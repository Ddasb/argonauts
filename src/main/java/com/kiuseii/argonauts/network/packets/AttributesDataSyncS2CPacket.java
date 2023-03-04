package com.kiuseii.argonauts.network.packets;

import java.util.function.Supplier;

import com.kiuseii.argonauts.client.data.AttributesData;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class AttributesDataSyncS2CPacket {
  private final int level;

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

  public AttributesDataSyncS2CPacket(int level, int excelia, int strength,
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
    buf.readerIndex(0);
    this.level = buf.readInt();

    buf.readerIndex(1);
    this.excelia = buf.readInt();

    buf.readerIndex(2);
    this.strength = buf.readInt();
    buf.readerIndex(3);
    this.endurance = buf.readInt();
    buf.readerIndex(4);
    this.dexterity = buf.readInt();
    buf.readerIndex(5);
    this.agility = buf.readInt();
    buf.readerIndex(6);
    this.magic = buf.readInt();

    buf.readerIndex(7);
    this.strength_progression = buf.readInt();
    buf.readerIndex(8);
    this.endurance_progression = buf.readInt();
    buf.readerIndex(9);
    this.dexterity_progression = buf.readInt();
    buf.readerIndex(10);
    this.agility_progression = buf.readInt();
    buf.readerIndex(11);
    this.magic_progression = buf.readInt();
  }

  public void toBytes(FriendlyByteBuf buf) {
    buf.readerIndex(0);
    buf.writeInt(level);

    buf.readerIndex(1);
    buf.writeInt(excelia);

    buf.readerIndex(2);
    buf.writeInt(strength);
    buf.readerIndex(3);
    buf.writeInt(endurance);
    buf.readerIndex(4);
    buf.writeInt(dexterity);
    buf.readerIndex(5);
    buf.writeInt(agility);
    buf.readerIndex(6);
    buf.writeInt(magic);

    buf.readerIndex(7);
    buf.writeInt(strength_progression);
    buf.readerIndex(8);
    buf.writeInt(endurance_progression);
    buf.readerIndex(9);
    buf.writeInt(dexterity_progression);
    buf.readerIndex(10);
    buf.writeInt(agility_progression);
    buf.readerIndex(11);
    buf.writeInt(magic_progression);
  }

  public boolean handle(Supplier<NetworkEvent.Context> supplier) {
    NetworkEvent.Context context = supplier.get();

    context.enqueueWork(() -> {
      AttributesData.setLevel(level);

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
