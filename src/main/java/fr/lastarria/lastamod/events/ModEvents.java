package fr.lastarria.lastamod.events;

import fr.lastarria.lastamod.Main;
import fr.lastarria.lastamod.command.GenerateKingdomCommand;
import fr.lastarria.lastamod.command.KingdomCommand;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ModEvents
{
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new KingdomCommand(event.getDispatcher());
        new GenerateKingdomCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
