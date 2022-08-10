package fr.lastarria.lastamod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import fr.lastarria.lastamod.systems.kingdom.KingdomStorage;
import fr.lastarria.lastamod.utils.KingdomsEnum;
import net.minecraft.command.CommandSource;

import java.util.*;

public class GenerateKingdomCommand {

    public GenerateKingdomCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(
            LiteralArgumentBuilder.<CommandSource>literal("generatekingdoms")
                .requires(src -> src.hasPermission(0))
                .executes(ctx -> {
                    KingdomStorage storage = KingdomStorage.get(ctx.getSource().getServer());
                    storage.DATA.clear();

                    Map<UUID, Integer> map = new HashMap<>();
                    List<String> list = new ArrayList<>();

                    storage.DATA.add(new Kingdom(KingdomsEnum.DESERT.name(), map, 1000, null, list));
                    storage.DATA.add(new Kingdom(KingdomsEnum.SWAMPS.name(), map, 0, null, list));
                    storage.DATA.add(new Kingdom(KingdomsEnum.MOUNTAINS.name(), map, 0, null, list));
                    storage.DATA.add(new Kingdom(KingdomsEnum.FROST_PLAINS.name(), map, 0, null, list));
                    storage.DATA.add(new Kingdom(KingdomsEnum.JUNGLE.name(), map, 0, null, list));
                    storage.DATA.add(new Kingdom(KingdomsEnum.FOREST.name(), map, 0, null, list));

                    return 0;
                })
        );
    }

}
