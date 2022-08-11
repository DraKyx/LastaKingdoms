package fr.lastarria.lastamod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.lastarria.lastamod.Main;
import fr.lastarria.lastamod.network.JoinKingdomPacket;
import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.utils.KingdomsEnum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class KingdomJoinGui extends Screen {

    private KingdomsEnum[] kingdoms;
    private int x;
    private int y;

    public KingdomJoinGui() {
        super(new TranslationTextComponent("lastamod.gui.kingdom_join_gui"));
        this.kingdoms = KingdomsEnum.values();
        this.x = this.width / 2;
        this.y = this.height / 2;
    }

    @Override
    public void init(Minecraft p_231158_1_, int p_231158_2_, int p_231158_3_) {
        super.init(p_231158_1_, p_231158_2_, p_231158_3_);

        for(int i = 0, posX = this.x - 300, s = kingdoms.length ; i < s ; i++, posX += 100) {
            String kingdomName = kingdoms[i].getName();

            this.addButton(new Button(posX, this.y - 50, 80, 20, new StringTextComponent(this.kingdoms[i].getName()), action -> {
                Main.NETWORK.sendToServer(new JoinKingdomPacket(kingdomName));
                Minecraft.getInstance().setScreen(null);
            }));
        }

    }

    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);
        drawCenteredString(stack, this.font, new TranslationTextComponent("lastarria.gui.kingdom_join.choose_text"), this.x, this.y - 150, 0xFFFFFF);
    }
}
