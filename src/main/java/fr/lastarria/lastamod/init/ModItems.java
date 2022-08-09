package fr.lastarria.lastamod.init;

import fr.lastarria.lastamod.Main;
import fr.lastarria.lastamod.utils.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> VLADINITE_INGOT = ITEMS.register("vladinite_ingot", () -> new Item(new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));
    public static final RegistryObject<Item> VLADINITE_STICK = ITEMS.register("vladinite_stick", () -> new Item(new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));

    public static final RegistryObject<Item> VLADINITE_PICKAXE = ITEMS.register("vladinite_pickaxe", () -> new PickaxeItem(CustomItemTiersPickaxe.VLADINITE_PICKAXE, 0, -3.2f, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> VLADINITE_SWORD = ITEMS.register("vladinite_sword", () -> new SwordItem(CustomItemTiersSword.VLADINITE_SWORD, 0, -2.4f, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> VLADINITE_AXE = ITEMS.register("vladinite_axe", () -> new AxeItem(CustomItemTiersAxe.VLADINITE_AXE, 0, -3.2f, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB).stacksTo(1)));
    public static final RegistryObject<Item> VLADINITE_SHOVEL = ITEMS.register("vladinite_shovel", () -> new ShovelItem(CustomItemTiersShovel.VLADINITE_SHOVEL, 0, -2.4f, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB).stacksTo(1)));

    public static final RegistryObject<Item> VLADINITE_HELMET = ITEMS.register("vladinite_helmet", () -> new ArmorItem(CustomArmorMaterials.VLADINITE_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));
    public static final RegistryObject<Item> VLADINITE_CHESTPLATE = ITEMS.register("vladinite_chestplate", () -> new ArmorItem(CustomArmorMaterials.VLADINITE_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));
    public static final RegistryObject<Item> VLADINITE_LEGGINGS = ITEMS.register("vladinite_leggings", () -> new ArmorItem(CustomArmorMaterials.VLADINITE_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));
    public static final RegistryObject<Item> VLADINITE_BOOTS = ITEMS.register("vladinite_boots", () -> new ArmorItem(CustomArmorMaterials.VLADINITE_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));

    public static final RegistryObject<Item> BLUE_APPLE = ITEMS.register("blue_apple", ()-> new Item(new Item.Properties().tab(CreativeTabs.VLADINITE_TAB).food(new Food.Builder().nutrition(9).saturationMod(1.4F).fast().effect(()-> new EffectInstance(Effects.REGENERATION, 20*10, 1), 1.0f).effect(()-> new EffectInstance(Effects.ABSORPTION, 20*150, 2), 1.0f).effect(()-> new EffectInstance(Effects.INVISIBILITY, 20*10, 1), 1.0f).build())));

}