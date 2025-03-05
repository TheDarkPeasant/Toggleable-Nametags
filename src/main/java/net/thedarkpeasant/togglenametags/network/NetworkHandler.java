package net.thedarkpeasant.togglenametags.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.thedarkpeasant.togglenametags.network.packet.NametagSyncPacket;
import net.thedarkpeasant.togglenametags.ToggleNametags;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ToggleNametags.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int packetId = 0;
    
    public static void registerPackets() {
        INSTANCE.registerMessage(packetId++, NametagSyncPacket.class, NametagSyncPacket::encode, NametagSyncPacket::decode, NametagSyncPacket::handle);
    }
}
