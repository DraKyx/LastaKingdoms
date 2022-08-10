package fr.lastarria.lastamod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fr.lastarria.lastamod.gui.KingdomsGui;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.NetworkHooks;

public class KingdomCommand {

    public KingdomCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(
                LiteralArgumentBuilder.<CommandSource>literal("kingdom")
                        .requires(src -> src.hasPermission(0))
                        .executes(ctx -> {
                            Minecraft.getInstance().setScreen(new KingdomsGui());
                            return 0;
                        })
        );
    }
}
