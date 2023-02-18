package com.kiuseii.argonauts.init;

import com.kiuseii.argonauts.Argonauts;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Argonauts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArgonautsTabs {

  @SubscribeEvent
  public static void registerArgonautsTabs(CreativeModeTabEvent.Register event) {
    event.registerCreativeModeTab(new ResourceLocation("argonauts_blocks"), builder -> builder
        .title(Component.translatable("itemGroup.argonauts.blocks"))
        .icon(() -> new ItemStack(ArgonautsItems.ADAMANTITE.get()))
        .displayItems((featuredFlag, output, operator) -> {
        }));

    event.registerCreativeModeTab(new ResourceLocation("argonauts_items"), builder -> builder
        .title(Component.translatable("itemGroup.argonauts.items"))
        .icon(() -> new ItemStack(ArgonautsItems.ADAMANTITE.get()))
        .displayItems((featuredFlag, output, operator) -> {
          output.accept(ArgonautsItems.ADAMANTITE.get());
          output.accept(ArgonautsItems.BLOOD_ONYX.get());
          output.accept(ArgonautsItems.DAMASCUS.get());
          output.accept(ArgonautsItems.DIR_ADAMANTITE.get());
          output.accept(ArgonautsItems.HEROIC_ALLOY.get());
          output.accept(ArgonautsItems.HIHIIROKANE.get());
          output.accept(ArgonautsItems.HOLYDITE.get());
          output.accept(ArgonautsItems.LIGHT_METAL.get());
          output.accept(ArgonautsItems.MITHRIL.get());
          output.accept(ArgonautsItems.NOSTEEL.get());
          output.accept(ArgonautsItems.OATHTREE_WALNUT.get());
          output.accept(ArgonautsItems.ORICALCHUM.get());
          output.accept(ArgonautsItems.SEIROS.get());
          output.accept(ArgonautsItems.THOUSAND_YEAR_TREE_SAP.get());
          output.accept(ArgonautsItems.UNDER_CORAL.get());
          output.accept(ArgonautsItems.VALMARTH.get());
          output.accept(ArgonautsItems.WHITE_WOOD.get());
          output.accept(ArgonautsItems.MAGIC_CRYSTAL.get());
        }));
  }
}
