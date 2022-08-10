package fr.lastarria.lastamod.systems.kingdom;

import fr.lastarria.lastamod.Main;
import net.minecraft.entity.player.PlayerEntity;
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
        CompoundNBT testTag = new CompoundNBT();

        for(int i = 0 ; i < DATA.size() ; i++) {

            CompoundNBT kingTag = new CompoundNBT();
            Kingdom curKing = DATA.get(i);

            kingTag.putInt("money", curKing.getMoney());
            kingTag.putUUID("owner", curKing.getOwner());

            ListNBT members = new ListNBT();
            for(final Map.Entry<UUID, Integer> entry : curKing.getMembers().entrySet()) {
                CompoundNBT member = new CompoundNBT();
                member.putUUID(S_UUID, entry.getKey());
                member.putInt(S_PERM, entry.getValue());
                members.add(member);
            }
            kingTag.put("members", members);
            kingdoms.add(kingTag);
        }
        nbt.put("kingdoms", kingdoms);
        return nbt;
    }

    public boolean isPlayerInKingdom(PlayerEntity player) {
        boolean returning = false;

        for(int i = 0 ; i < DATA.size() ; i++) {
            if(DATA.get(i).getMembers().containsKey(player.getUUID())) returning = true;
        }

        return returning;
    }

    public Kingdom getPlayerKingdom(PlayerEntity player) {
        Kingdom returning = null;

        for(int i = 0 ; i < DATA.size() ; i++) {
            if(DATA.get(i).getMembers().containsKey(player.getUUID())) returning = DATA.get(i);
        }

        return returning;
    }

    public Kingdom getKingdomByName(String name) {
        Kingdom returning = null;

        for(int i = 0 ; i < DATA.size() ; i++) {
            if(DATA.get(i).getName().toLowerCase().equals(name.toLowerCase())) returning = DATA.get(i);
        }

        return returning;
    }

    public void joinKingdom(PlayerEntity player, String kingdomName) {
        if(this.isPlayerInKingdom(player)) return;

        Kingdom kingdom = this.getKingdomByName(kingdomName);
        int perm = kingdom.getMembers().isEmpty() ? 0 : 10;

        kingdom.addMember(player.getUUID(), perm);
        if(perm == 10) {
            kingdom.setOwner(player.getUUID());
        }
        this.setDirty();
    }

}
