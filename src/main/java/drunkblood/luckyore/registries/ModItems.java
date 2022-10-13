package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> REG = DeferredRegister.create(ForgeRegistries.ITEMS, LuckyOre.MODID);
	// ITEMS
	public static final RegistryObject<Item> LUCKY_DUST = REG.register("lucky_dust",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	// BLOCK_ITEMS
	public static final RegistryObject<Item> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockItem(ModBlocks.LUCKY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_LUCKY_ORE = REG.register("deepslate_lucky_ore",
			() -> new BlockItem(ModBlocks.DEEPSLATE_LUCKY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_DIORITE_ORE = REG.register("lucky_diorite_ore",
		() -> new BlockItem(ModBlocks.LUCKY_DIORITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_ANDERSITE_ORE = REG.register("lucky_andersite_ore",
		() -> new BlockItem(ModBlocks.LUCKY_ANDERSITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_GRANITE_ORE = REG.register("lucky_granite_ore",
		() -> new BlockItem(ModBlocks.LUCKY_GRANITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockItem(ModBlocks.NETHER_LUCKY_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new BlockItem(ModBlocks.LUCKY_DIAMOND_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DIAMOND_DIORITE_ORE = REG.register("diamond_diorite_ore",
		() -> new BlockItem(ModBlocks.DIAMOND_DIORITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DIAMOND_ANDERSITE_ORE = REG.register("diamond_andersite_ore",
		() -> new BlockItem(ModBlocks.DIAMOND_ANDERSITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DIAMOND_GRANITE_ORE = REG.register("diamond_granite_ore",
		() -> new BlockItem(ModBlocks.DIAMOND_GRANITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new BlockItem(ModBlocks.LUCKY_REDSTONE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> REDSTONE_DIORITE_ORE = REG.register("redstone_diorite_ore",
		() -> new BlockItem(ModBlocks.REDSTONE_DIORITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> REDSTONE_ANDERSITE_ORE = REG.register("redstone_andersite_ore",
		() -> new BlockItem(ModBlocks.REDSTONE_ANDERSITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> REDSTONE_GRANITE_ORE = REG.register("redstone_granite_ore",
		() -> new BlockItem(ModBlocks.REDSTONE_GRANITE_ORE.get(),
			new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new BlockItem(ModBlocks.LUCKY_LAPIS_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LAPIS_DIORITE_ORE = REG.register("lapis_diorite_ore",
		() -> new BlockItem(ModBlocks.LAPIS_DIORITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LAPIS_ANDERSITE_ORE = REG.register("lapis_andersite_ore",
		() -> new BlockItem(ModBlocks.LAPIS_ANDERSITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LAPIS_GRANITE_ORE = REG.register("lapis_granite_ore",
		() -> new BlockItem(ModBlocks.LAPIS_GRANITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_IRON_ORE = REG.register("lucky_iron_ore",
			() -> new BlockItem(ModBlocks.LUCKY_IRON_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> IRON_DIORITE_ORE = REG.register("iron_diorite_ore",
		() -> new BlockItem(ModBlocks.IRON_DIORITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> IRON_ANDERSITE_ORE = REG.register("iron_andersite_ore",
		() -> new BlockItem(ModBlocks.IRON_ANDERSITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> IRON_GRANITE_ORE = REG.register("iron_granite_ore",
		() -> new BlockItem(ModBlocks.IRON_GRANITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_COPPER_ORE = REG.register("lucky_copper_ore",
			() -> new BlockItem(ModBlocks.LUCKY_COPPER_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> COPPER_DIORITE_ORE = REG.register("copper_diorite_ore",
		() -> new BlockItem(ModBlocks.COPPER_DIORITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> COPPER_ANDERSITE_ORE = REG.register("copper_andersite_ore",
		() -> new BlockItem(ModBlocks.COPPER_ANDERSITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> COPPER_GRANITE_ORE = REG.register("copper_granite_ore",
		() -> new BlockItem(ModBlocks.COPPER_GRANITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_GOLD_ORE = REG.register("lucky_gold_ore",
			() -> new BlockItem(ModBlocks.LUCKY_GOLD_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> GOLD_DIORITE_ORE = REG.register("gold_diorite_ore",
		() -> new BlockItem(ModBlocks.GOLD_DIORITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GOLD_ANDERSITE_ORE = REG.register("gold_andersite_ore",
		() -> new BlockItem(ModBlocks.GOLD_ANDERSITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GOLD_GRANITE_ORE = REG.register("gold_granite_ore",
		() -> new BlockItem(ModBlocks.GOLD_GRANITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public static final RegistryObject<Item> COAL_DIORITE_ORE = REG.register("coal_diorite_ore",
		() -> new BlockItem(ModBlocks.COAL_DIORITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> COAL_ANDERSITE_ORE = REG.register("coal_andersite_ore",
		() -> new BlockItem(ModBlocks.COAL_ANDERSITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> COAL_GRANITE_ORE = REG.register("coal_granite_ore",
		() -> new BlockItem(ModBlocks.COAL_GRANITE_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new BlockItem(ModBlocks.LUCKY_EMERALD_ORE.get(),
					new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
