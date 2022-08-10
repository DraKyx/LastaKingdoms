package fr.lastarria.lastamod.network;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class KingdomPacket {

    public KingdomPacket() {

    }

    public static void encode(KingdomPacket kingdomPacket, PacketBuffer packetBuffer) {
    }

    public static KingdomPacket decode(PacketBuffer packetBuffer) {
        return new KingdomPacket();
    }

    public static <MSG> void handle(KingdomPacket packet, Supplier<NetworkEvent.Context> ctx) {

    }


}
