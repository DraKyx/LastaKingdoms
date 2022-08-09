package fr.lastarria.lastamod.init;

import fr.lastarria.lastamod.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabs {

    public static final ItemGroup VLADINITE_TAB = new ItemGroup("vladinite") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.VLADINITE_INGOT.get());
        }
    };
}
