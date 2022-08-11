package fr.lastarria.lastamod.events;

import fr.lastarria.lastamod.Main;
import fr.lastarria.lastamod.command.GenerateKingdomCommand;
import fr.lastarria.lastamod.command.KingdomCommand;
import fr.lastarria.lastamod.containers.KingdomInfoContainer;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
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

    @ObjectHolder("kingdominfo_container")
    public static ContainerType<KingdomInfoContainer> KINGDOM_INFO_CONTAINER = null;

    @SubscribeEvent
    public static void onContainerRegister(final RegistryEvent.Register<ContainerType<?>> event) {

        ContainerType<KingdomInfoContainer> kingdomInfoContainerContainer = IForgeContainerType.create((windowId, inv, data) -> {
            return new KingdomInfoContainer(windowId, inv, null);
        });

    }

}
