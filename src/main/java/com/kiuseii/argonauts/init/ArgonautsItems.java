package com.kiuseii.argonauts.init;

import com.kiuseii.argonauts.Argonauts;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArgonautsItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Argonauts.MOD_ID);

  public static final RegistryObject<Item> ADAMANTITE_INGOT = ITEMS.register("adamantite_ingot",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));
}
