package fr.lastarria.lastamod.network;

import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.systems.kingdom.KingdomStorage;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class JoinKingdomPacket {

    public String kingdomName;

    public JoinKingdomPacket(String kingdomName) {
        this.kingdomName = kingdomName;
    }

    public static void encode(JoinKingdomPacket joinKingdomPacket, PacketBuffer packetBuffer) {
        packetBuffer.writeUtf(joinKingdomPacket.kingdomName);
    }

    public static JoinKingdomPacket decode(PacketBuffer packetBuffer) {
        String kingdomName = packetBuffer.readUtf();
        return new JoinKingdomPacket(kingdomName);
    }

    public static <MSG> void handle(JoinKingdomPacket packet, Supplier<NetworkEvent.Context> ctx) {

        ServerPlayerEntity player = ctx.get().getSender();
        MinecraftServer server = ctx.get().getSender().getServer();

        KingdomStorage storage = KingdomStorage.get(server);

        storage.joinKingdom(player, packet.kingdomName);

        player.sendMessage(new StringTextComponent("Tu as rejoint le kingdom " + packet.kingdomName), player.getUUID());
        System.out.println("Le joueur " + player.getName() + " a été ajouté au royaume " + packet.kingdomName);

    }


}
