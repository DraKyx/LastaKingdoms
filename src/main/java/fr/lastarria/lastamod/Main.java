package fr.lastarria.lastamod;

import fr.lastarria.lastamod.command.KingdomCommand;
import fr.lastarria.lastamod.init.ModFeatures;
import fr.lastarria.lastamod.init.ModItems;
import fr.lastarria.lastamod.init.ModKeybindings;
import fr.lastarria.lastamod.init.ModBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MODID)
public class Main {

    public static final String MODID = "lastamod";

    public Main()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientsetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    private void setup(FMLCommonSetupEvent e)
    {
        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
    }

    private void clientsetup(FMLClientSetupEvent e)
    {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        ModKeybindings.register();
        bus.addListener(ModKeybindings::onKeyPress);
    }
}
