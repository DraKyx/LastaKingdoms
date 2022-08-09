package fr.lastarria.lastamod.utils.storage;

import fr.lastarria.lastamod.Main;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldSavedData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KingdomStorage extends WorldSavedData {

    public static final String NAME = Main.MODID + "_kingdoms";

    private static final List<KingdomStorageObject> DATA = new ArrayList<>();

    public KingdomStorage(String text) {
        super(text);
    }

    public KingdomStorage() {
        this(NAME);
    }

    @Override
    public void load(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        return null;
    }

    static class KingdomStorageObject {
        private final int randomInt;
        private final BlockPos blockPos;
        private final UUID id;

        KingdomStorageObject(int randomInt, BlockPos blockPos, UUID id) {
            this.randomInt = randomInt;
            this.blockPos = blockPos;
            this.id = id;
        }

        public CompoundNBT deserializer() {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("randomInt", randomInt);
            nbt.putLong("pos", blockPos.asLong());
            nbt.putUUID("id", id);

            return nbt;
        }
    }

}
