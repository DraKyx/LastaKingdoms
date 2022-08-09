package fr.lastarria.lastamod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;

public class KingdomCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {

        dispatcher.register(
                LiteralArgumentBuilder.<CommandSource>literal("kingdom")
                .requires(src -> src.hasPermission(0))
                .executes(ctx -> {
                    //Minecraft.getInstance()
                    return 0;
                })
        );
    }

}
