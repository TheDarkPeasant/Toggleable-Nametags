package net.thedarkpeasant.togglenametags.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.thedarkpeasant.togglenametags.ClientVariables;

import java.util.function.Supplier;

public class NametagSyncPacket {
    private final boolean showNametags;

    public NametagSyncPacket(boolean showNametags) {
        this.showNametags = showNametags;
    }

    public static void encode(NametagSyncPacket packet, FriendlyByteBuf buf) {
        buf.writeBoolean(packet.showNametags);
    }

    public static NametagSyncPacket decode(FriendlyByteBuf buf) {
        return new NametagSyncPacket(buf.readBoolean());
    }

    public static void handle(NametagSyncPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> ClientVariables.setShowNametags(packet.showNametags));
        ctx.get().setPacketHandled(true);
    }
}
