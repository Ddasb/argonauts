package com.kiuseii.argonauts;

import com.kiuseii.argonauts.init.ArgonautsBlocks;
import com.kiuseii.argonauts.init.ArgonautsItems;
import com.kiuseii.argonauts.network.PacketHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Argonauts.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Argonauts {
    public static final String MOD_ID = "argonauts";

    public Argonauts() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();

        ArgonautsItems.ITEMS.register(modbus);
        ArgonautsBlocks.BLOCKS.register(modbus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        PacketHandler.init();
    }
}
