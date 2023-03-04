package com.kiuseii.argonauts.capabilities.attributes;

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
public class AttributesProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
  public static Capability<AttributesCapability> ATTRIBUTES_CAPABILITY = CapabilityManager
      .get(new CapabilityToken<AttributesCapability>() {
      });

  private AttributesCapability attributes = null;
  private final LazyOptional<AttributesCapability> optional = LazyOptional.of(this::createAttributesCapability);

  private AttributesCapability createAttributesCapability() {
    if (this.attributes == null) {
      this.attributes = new AttributesCapability();
    }

    return this.attributes;
  }

  @Override
  public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == ATTRIBUTES_CAPABILITY) {
      return optional.cast();
    }
    return LazyOptional.empty();
  }

  @Override
  public CompoundTag serializeNBT() {
    CompoundTag nbt = new CompoundTag();

    createAttributesCapability().saveNBTData(nbt);

    return nbt;
  }

  @Override
  public void deserializeNBT(CompoundTag nbt) {
    createAttributesCapability().loadNBTData(nbt);
  }
}
