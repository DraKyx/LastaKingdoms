package fr.lastarria.lastamod.network;

import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.systems.kingdom.KingdomStorage;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.function.Supplier;

public class KingdomInfosPacket {

    public Kingdom kingdom;

    public KingdomInfosPacket(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public static void encode(KingdomInfosPacket kingdomInfosPacket, PacketBuffer packetBuffer) {
        packetBuffer.writeUtf(kingdomInfosPacket.kingdom.getName());
        packetBuffer.writeInt(kingdomInfosPacket.kingdom.getMoney());
        packetBuffer.writeUUID(kingdomInfosPacket.kingdom.getOwner());

    }

    public static KingdomInfosPacket decode(PacketBuffer packetBuffer) {
        String kingdomName = packetBuffer.readUtf();
        return new KingdomInfosPacket(kingdomName);
    }

    public static <MSG> void handle(KingdomInfosPacket packet, Supplier<NetworkEvent.Context> ctx) {

        ServerPlayerEntity player = ctx.get().getSender();
        MinecraftServer server = ctx.get().getSender().getServer();

        KingdomStorage storage = KingdomStorage.get(server);

        storage.joinKingdom(player, packet.kingdomName);

        player.sendMessage(new StringTextComponent("Tu as rejoint le kingdom " + packet.kingdomName), player.getUUID());
        System.out.println("Le joueur " + player.getName() + " a été ajouté au royaume " + packet.kingdomName);

    }

    private List<String> encodeMembers(Map<UUID, Integer> map) {
        List<String> returning = new ArrayList<>();

        for(final Map.Entry<UUID, Integer> entry : map.entrySet()) {
            returning.add(entry.getKey() + "/" + entry.getValue());
        }
        return returning;
    }

    private Map<UUID, Integer> decodeMembers(List<String> list) {
        Map<UUID, Integer> returning = new HashMap<>();

        for(int i = 0 ; i < list.size() ; i++) {

        }

    }

}
