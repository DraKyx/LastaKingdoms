package fr.lastarria.lastamod.init;

import fr.lastarria.lastamod.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> VLADINITE_B = createBlock("vladinite_b", () -> new Block(AbstractBlock.Properties.of(Material.METAL).strength(6f,12f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VLADINITEORE = createBlock("vladiniteore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 10f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));


    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeTabs.VLADINITE_TAB)));
        return block;
    }
}
