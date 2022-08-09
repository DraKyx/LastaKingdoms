package fr.lastarria.lastamod.init;

import fr.lastarria.lastamod.Main;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class ModKeybindings {

    public static final KeyBinding SPELLS_KEY = new KeyBinding("key." + Main.MODID + ".spells", GLFW.GLFW_KEY_G, "key.categories." + Main.MODID);

    public static void register()
    {
        ClientRegistry.registerKeyBinding(SPELLS_KEY);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent e)
    {
        if (SPELLS_KEY.isDown())
        {
            System.out.println("Test");
        }
    }
}
