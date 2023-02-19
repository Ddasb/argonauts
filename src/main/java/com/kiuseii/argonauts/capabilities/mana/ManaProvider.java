package com.kiuseii.argonauts.capabilities.mana;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

@AutoRegisterCapability
public class ManaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
  public static Capability<ManaCapability> MANA_CAPABILITY = CapabilityManager
      .get(new CapabilityToken<ManaCapability>() {
      });

  private ManaCapability mana = null;
  private final LazyOptional<ManaCapability> optional = LazyOptional.of(this::createManaCapability);

  private ManaCapability createManaCapability() {
    if (this.mana == null) {
      this.mana = new ManaCapability();
    }

    return this.mana;
  }

  @Override
  public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == MANA_CAPABILITY) {
      return optional.cast();
    }
    return LazyOptional.empty();
  }

  @Override
  public CompoundTag serializeNBT() {
    CompoundTag nbt = new CompoundTag();

    createManaCapability().saveNBTData(nbt);

    return nbt;
  }

  @Override
  public void deserializeNBT(CompoundTag nbt) {
    createManaCapability().loadNBTData(nbt);
  }
}
