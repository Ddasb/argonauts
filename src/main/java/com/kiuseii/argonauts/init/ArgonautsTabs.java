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
    event.registerCreativeModeTab(new ResourceLocation("argonauts_items"), builder -> builder
        .title(Component.translatable("itemGroup.argonauts.items"))
        .icon(() -> new ItemStack(ArgonautsItems.ADAMANTITE_INGOT.get()))
        .displayItems((featuredFlag, output, operator) -> {
          output.accept(ArgonautsItems.ADAMANTITE_INGOT.get());
        }));
  }
}
