package com.kiuseii.argonauts.init;

import com.kiuseii.argonauts.Argonauts;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArgonautsItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Argonauts.MOD_ID);

  public static final RegistryObject<Item> ADAMANTITE = ITEMS.register("adamantite",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

  public static final RegistryObject<Item> DIR_ADAMANTITE = ITEMS.register("dir_adamantite",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

  public static final RegistryObject<Item> SEIROS = ITEMS.register("seiros",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

  public static final RegistryObject<Item> THOUSAND_YEAR_TREE_SAP = ITEMS.register("thousand_year_tree_sap",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

  public static final RegistryObject<Item> BLOOD_ONYX = ITEMS.register("blood_onyx",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> NOSTEEL = ITEMS.register("nosteel",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> ORICALCHUM = ITEMS.register("oricalchum",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

  public static final RegistryObject<Item> UNDER_CORAL = ITEMS.register("under_coral",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> HOLYDITE = ITEMS.register("holydite",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> OATHTREE_WALNUT = ITEMS.register("oathree_walnut",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

  public static final RegistryObject<Item> HEROIC_ALLOY = ITEMS.register("heroic_alloy",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

  public static final RegistryObject<Item> VALMARTH = ITEMS.register("valmarth",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

  public static final RegistryObject<Item> DAMASCUS = ITEMS.register("damascus",
      () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

  public static final RegistryObject<Item> LIGHT_METAL = ITEMS.register("light_metal",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> WHITE_WOOD = ITEMS.register("white_wood",
      () -> new Item(new Item.Properties().rarity(Rarity.COMMON).fireResistant()));

  public static final RegistryObject<Item> HIHIIROKANE = ITEMS.register("hihiirokane",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));

  public static final RegistryObject<Item> MAGIC_CRYSTAL = ITEMS.register("magic_crystal",
      () -> new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
}
