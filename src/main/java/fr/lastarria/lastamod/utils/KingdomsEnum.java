package fr.lastarria.lastamod.utils;

public enum KingdomsEnum
{

    DESERT("Desert", 100, 100, 0, 0),
    SWAMPS("Swamps", 100, 100, 0, 0),
    MOUNTAINS("Moutains", 100, 100, 0, 0),
    FROST_PLAINS("Frost Plains", 100, 100, 0, 0),
    JUNGLE("Jungle", 100, 100, 0, 0),
    FOREST("Forest", 100, 100, 0, 0);

    private String name;
    private int x1;
    private int x2;
    private int z1;
    private int z2;

    KingdomsEnum(String name, int x1, int z1, int x2, int z2)
    {
        this.name = name;
        this.x1 = x1;
        this.x2 = x2;
        this.z1 = z1;
        this.z2 = z2;
    }

}
