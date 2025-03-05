package net.thedarkpeasant.togglenametags.event;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import net.thedarkpeasant.togglenametags.GameRulesRegister;
import net.thedarkpeasant.togglenametags.ToggleNametags;
import net.thedarkpeasant.togglenametags.network.NetworkHandler;
import net.thedarkpeasant.togglenametags.network.packet.NametagSyncPacket;

@Mod.EventBusSubscriber(modid = ToggleNametags.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    private static boolean lastShowNametags = true;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        
        MinecraftServer server = event.getServer();
        if (server == null) {
            return;
        }

        boolean currentShowNametags = server.getGameRules().getBoolean(GameRulesRegister.SHOW_NAMETAGS);

        if (currentShowNametags != lastShowNametags) {
            lastShowNametags = currentShowNametags;
            
            NetworkHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new NametagSyncPacket(currentShowNametags));
        }
    }
}
