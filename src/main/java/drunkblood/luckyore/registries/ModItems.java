package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> REG = DeferredRegister.create(ForgeRegistries.ITEMS, LuckyOre.MODID);
	BlockItem i = new BlockItem(ModBlocks.LUCKY_ORE.get(), new Item.Properties());
	// ITEMS
	public static final RegistryObject<Item> LUCKY_DUST = REG.register("lucky_dust",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	// BLOCK_ITEMS
	public static final RegistryObject<Item> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockItem(ModBlocks.LUCKY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_LUCKY_ORE = REG.register("deepslate_lucky_ore",
			() -> new BlockItem(ModBlocks.DEEPSLATE_LUCKY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockItem(ModBlocks.NETHER_LUCKY_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new BlockItem(ModBlocks.LUCKY_DIAMOND_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new BlockItem(ModBlocks.LUCKY_EMERALD_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new BlockItem(ModBlocks.LUCKY_REDSTONE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new BlockItem(ModBlocks.LUCKY_LAPIS_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_IRON_ORE = REG.register("lucky_iron_ore",
			() -> new BlockItem(ModBlocks.LUCKY_IRON_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_COPPER_ORE = REG.register("lucky_copper_ore",
			() -> new BlockItem(ModBlocks.LUCKY_COPPER_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_GOLD_ORE = REG.register("lucky_gold_ore",
			() -> new BlockItem(ModBlocks.LUCKY_GOLD_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
