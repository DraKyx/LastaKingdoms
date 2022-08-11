package fr.lastarria.lastamod.containers;

import fr.lastarria.lastamod.events.ModEvents;
import fr.lastarria.lastamod.systems.kingdom.Kingdom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class KingdomInfoContainer extends Container {

    private Kingdom kingdom;

    public KingdomInfoContainer(final int windowId, final PlayerInventory playerInv, final Kingdom kingdom) {
        super(ModEvents.KINGDOM_INFO_CONTAINER, windowId);
        this.kingdom = kingdom;
    }

    @Override
    public boolean stillValid(PlayerEntity playerEntity) {
        return true;
    }

    public Kingdom getKingdom() {
        return this.kingdom;
    }

}
