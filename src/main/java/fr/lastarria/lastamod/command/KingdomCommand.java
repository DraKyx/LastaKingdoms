package fr.lastarria.lastamod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fr.lastarria.lastamod.gui.KingdomInfoGui;
import fr.lastarria.lastamod.gui.KingdomJoinGui;
import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.systems.kingdom.KingdomStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.network.NetworkHooks;

public class KingdomCommand {

    public KingdomCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(
            LiteralArgumentBuilder.<CommandSource>literal("kingdom")
                .requires(src -> src.hasPermission(0))
                .executes(ctx -> {

                    KingdomStorage storage = KingdomStorage.get(ctx.getSource().getServer());
                    PlayerEntity player = (PlayerEntity) ctx.getSource().getEntity();

                    if(storage.isPlayerInKingdom(player)) {
                        Minecraft.getInstance().setScreen(new KingdomInfoGui(storage.getPlayerKingdom(player)));

                    } else {
                        Minecraft.getInstance().setScreen(new KingdomJoinGui(storage.DATA));
                    }

                    return 0;
                })
        );
    }
}
