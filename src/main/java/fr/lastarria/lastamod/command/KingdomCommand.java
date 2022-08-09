package fr.lastarria.lastamod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fr.lastarria.lastamod.gui.KingdomsGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;

public class KingdomCommand {

    public KingdomCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(
                LiteralArgumentBuilder.<CommandSource>literal("kingdom")
                        .requires(src -> src.hasPermission(0))
                        .executes(ctx -> {
                            Minecraft.getInstance().setScreen(new InventoryScreen((PlayerEntity) ctx.getSource().getEntity()));
                            return 0;
                        })
        );
    }
}
