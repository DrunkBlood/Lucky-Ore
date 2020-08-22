package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> REG = DeferredRegister.create(ForgeRegistries.ITEMS, LuckyOre.MODID);
	BlockItem i = new BlockItem(ModBlocks.LUCKY_ORE.get(), new Item.Properties());
	// ITEMS
	public static final RegistryObject<Item> LUCKY_DUST = REG.register("lucky_dust",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	// BLOCK_ITEMS
	public static final RegistryObject<Item> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockItem(ModBlocks.LUCKY_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockItem(ModBlocks.NETHER_LUCKY_ORE.get(),
					new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new BlockItem(ModBlocks.LUCKY_DIAMOND_ORE.get(),
					new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new BlockItem(ModBlocks.LUCKY_EMERALD_ORE.get(),
					new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new BlockItem(ModBlocks.LUCKY_REDSTONE_ORE.get(),
					new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new BlockItem(ModBlocks.LUCKY_LAPIS_ORE.get(),
					new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
}
