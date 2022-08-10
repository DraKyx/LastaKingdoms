package fr.lastarria.lastamod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.systems.kingdom.KingdomStorage;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;

public class KingdomInfoGui extends Screen {

    private Kingdom kingdom;

    public KingdomInfoGui(Kingdom kingdom)
    {
        super(new TranslationTextComponent("lastamod.gui.kingdom_info.title", "LastaMod"));
        this.kingdom = kingdom;
    }

    @Override
    protected void init()
    {
        this.addButton(new Button((this.width - 200) / 2, this.height - 50, 200, 20,
                new TranslationTextComponent("lastamod.gui.kingdom_info.done_button"), button -> this.onClose()));
    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks)
    {
        drawCenteredString(stack, this.font, this.kingdom.getName()+ " money: " + this.kingdom.getMoney(), this.width / 2, 8, 0xFFFFFF);
        super.render(stack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen()
    {
        return false;
    }

}
