package net.thedarkpeasant.togglenametags;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thedarkpeasant.togglenametags.network.NetworkHandler;

@Mod(ToggleNametags.MOD_ID)
public class ToggleNametags {
    public static final String MOD_ID = "togglenametags";

    public ToggleNametags() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        NetworkHandler.registerPackets();
    }
}