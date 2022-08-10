package fr.lastarria.lastamod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.lastarria.lastamod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Random;

public class KingdomsGui extends Screen {

    public KingdomsGui()
    {
        super(new TranslationTextComponent("lastamod.kingdoms_gui.title", "LastaMod"));
    }

    @Override
    protected void init()
    {
        this.addButton(new Button((this.width - 200) / 2, this.height - 50, 200, 20,
                new TranslationTextComponent("lastamod.kingdoms_gui.done_button"), button -> this.onClose()));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        drawCenteredString(matrixStack, this.font, this.title.getString(), this.width / 2, 8, 0xFFFFFF);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen()
    {
        return false;
    }
}
