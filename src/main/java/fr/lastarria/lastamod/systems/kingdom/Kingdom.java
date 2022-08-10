package fr.lastarria.lastamod.systems.kingdom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Kingdom {

    private String name;
    private Map<UUID, Integer> members;
    private int money;
    private UUID owner;
    private List<String> wars;

    public Kingdom(String name, Map<UUID, Integer> members, int money, UUID owner, List<String> wars) {

        this.name = name;
        this.members = members;
        this.money = money;
        this.owner = owner;
        this.wars = wars;



    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int value) {
        this.money = value;
    }

    public Map<UUID, Integer> getMembers() {
        return members;
    }

    public void addMember(UUID id, Integer perm) {
        this.members.put(id, perm);
    }

    public void removeMember(UUID id) {
        this.members.remove(id);
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID id) {
        this.owner = id;
    }

    public List<String> getWars() {
        return wars;
    }

    public void addWarKingdom(String kingdomName) {
        this.wars.add(kingdomName);
    }


}
