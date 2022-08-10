package fr.lastarria.lastamod.systems.kingdom;

import fr.lastarria.lastamod.Main;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;

import java.util.*;

public class KingdomStorage extends WorldSavedData {

    private static final String NAME = Main.MODID + "_players_kingdoms";
    private static final String S_UUID = "id";
    private static final String S_PERM = "perm";
    public List<Kingdom> DATA = new ArrayList<>();


    public KingdomStorage(String s) {
        super(s);
    }

    public static KingdomStorage get(MinecraftServer server) {
        return server.getLevel(World.OVERWORLD).getDataStorage().computeIfAbsent(() -> new KingdomStorage(), Main.MODID);
    }

    public KingdomStorage() {
        this(NAME);
    }

    @Override
    public void load(CompoundNBT nbt) {
        this.DATA.clear();
        final ListNBT kingdomsList = nbt.getList("kingdoms", 10);

        for(int i = 0, l = kingdomsList.size() ; i < l ; i++) {

            CompoundNBT curKing = kingdomsList.getCompound(i);

            DATA.get(i).setMoney(curKing.getInt("money"));
            DATA.get(i).setOwner(curKing.getUUID("owner"));

            ListNBT members = curKing.getList("members", 10);
            for(int i2 = 0 ; i < members.size() ; i++) {
                CompoundNBT tag = members.getCompound(i);
                DATA.get(i).addMember(tag.getUUID(S_UUID), tag.getInt(S_PERM));
            }

            ListNBT wars = curKing.getList("wars", 8);
            for(int i3 = 0 ; i < wars.size() ; i++) {
                DATA.get(i).addWarKingdom(wars.getString(i3));
            }

        }
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {

        final ListNBT kingdoms = new ListNBT();

        for(int i = 0 ; i < DATA.size() ; i++) {

            ListNBT kingTag = new ListNBT();
            Kingdom curKing = DATA.get(i);

            CompoundNBT money = new CompoundNBT();
            money.putInt("money", curKing.getMoney());
            kingTag.add(money);

            CompoundNBT owner = new CompoundNBT();
            owner.putUUID("owner", curKing.getOwner());
            kingTag.add(owner);

            ListNBT members = new ListNBT();
            for(final Map.Entry<UUID, Integer> entry : curKing.getMembers().entrySet()) {
                CompoundNBT member = new CompoundNBT();
                member.putUUID(S_UUID, entry.getKey());
                member.putInt(S_PERM, entry.getValue());
                members.add(member);
            }
            kingTag.add(members);
            CompoundNBT kingdom = new CompoundNBT();
            kingdom.put(DATA.get(i).getName(), kingTag);
            kingdoms.add(kingdom);
        }
        nbt.put("kingdoms", kingdoms);
        return nbt;
    }


}
