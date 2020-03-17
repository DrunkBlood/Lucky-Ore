package drunkblood.luckyore;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import drunkblood.luckyore.block.BlockLuckyOre;
import drunkblood.luckyore.block.BlockNetherLuckyOre;
import drunkblood.luckyore.enchantment.EnchantmentLucky;
import drunkblood.luckyore.loot.function.ApplyLuckyBonus;
import net.minecraft.block.Block;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraft.world.storage.loot.functions.LootFunctionManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

@Mod(LuckyOre.MODID)
public class LuckyOre {
	public static final String MODID = "luckyore";
	public static final String NAME = "Lucky Ore";
	public static final String VERSION = "1.0.0";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
	public static final class ModEventSubscriber{
		@SubscribeEvent
		public static void onRegisterItems(RegistryEvent.Register<Item> event) {
			//Items
			event.getRegistry().registerAll(
					setup(new Item(new Item.Properties().group(ItemGroup.MISC)), "lucky_dust")
					);
			// ItemBlocks
			event.getRegistry().registerAll(
					new BlockItem(ModBlocks.lucky_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.lucky_ore.getRegistryName()),
					new BlockItem(ModBlocks.nether_lucky_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.nether_lucky_ore.getRegistryName()),
					new BlockItem(ModBlocks.lucky_diamond_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.lucky_diamond_ore.getRegistryName()),
					new BlockItem(ModBlocks.lucky_redstone_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.lucky_redstone_ore.getRegistryName()),
					new BlockItem(ModBlocks.lucky_lapis_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.lucky_lapis_ore.getRegistryName()),
					new BlockItem(ModBlocks.lucky_emerald_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.lucky_emerald_ore.getRegistryName())
					);

		}
		@SubscribeEvent
		public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
					setup(new BlockLuckyOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "lucky_ore"),
					setup(new BlockNetherLuckyOre(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).hardnessAndResistance(3.0F, 3.0F)), "nether_lucky_ore"),
					setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2)), "lucky_diamond_ore"),
					setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1)), "lucky_lapis_ore"),
					setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2)), "lucky_emerald_ore"),
					setup(new RedstoneOreBlock(Block.Properties.create(Material.ROCK).tickRandomly().lightValue(9).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2)), "lucky_redstone_ore")
					);
		}
		@SubscribeEvent
		public static void onRegisterEnchantments(RegistryEvent.Register<Enchantment> event) {
			event.getRegistry().registerAll(
					setup(new EnchantmentLucky(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND),"ench_lucky")
					);
			
		}
		@SubscribeEvent
		public static void LoadComplete(FMLLoadCompleteEvent event) {
			//adding enchanted book
//			ItemStack lucky_ench = new ItemStack(Items.ENCHANTED_BOOK);
//			LOGGER.error(lucky_ench);
//			EnchantedBookItem.addEnchantment(lucky_ench, new EnchantmentData(ModEnchantments.ench_lucky,1));
//			LOGGER.error(lucky_ench);
//			LOGGER.error(NonNullList.withSize(1, lucky_ench));
//			ItemGroup.COMBAT.fill(NonNullList.withSize(1, lucky_ench));
			//adding Ores
			LOGGER.debug("event fired");
			for(Biome biome : ForgeRegistries.BIOMES) {
				if(biome.getCategory() == Category.THEEND) {
					continue;
				}
				if(biome.getCategory() == Biome.Category.NETHER) {
					biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
							Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.nether_lucky_ore.getDefaultState(), /*vein size*/3))
							.func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(/*freq per chunk*/35,/*miny*/ 5, /*y-max-offset*/0, /*maxy*/256))));
					continue;
				}
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.lucky_ore.getDefaultState(), /*vein size*/3))
						.func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(/*freq per chunk*/25,/*miny*/ 5, /*y-max-offset*/0, /*maxy*/128))));
			      
			}
			// add ApplyLuckyBonus function
			ApplyLuckyBonus.Serializer applyLuckyBonus = new ApplyLuckyBonus.Serializer();
			LootFunctionManager.registerFunction(applyLuckyBonus);
		}
		
		//Setup Block or Item Registry
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(LuckyOre.MODID, name));
		}
		//Helper method for setup
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
	}
	
	@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.FORGE)
	public static final class ForgeEventSubscriber{
		@SubscribeEvent
		public static void onLootTableLoad(LootTableLoadEvent event) {
			// check Zombie loot table
			if(event.getName().equals(new ResourceLocation("entities/zombie"))) {
				LOGGER.info("Adding lucky dust to Zombie");
				event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID,"entities/zombie"))).build());
			}
			
		}
		
	}
	@ObjectHolder(MODID)
	public static class ModBlocks{
		public static final Block lucky_ore = null;
		public static final Block nether_lucky_ore = null;
		public static final Block lucky_diamond_ore = null;
		public static final Block lucky_redstone_ore = null;
		public static final Block lucky_lapis_ore = null;
		public static final Block lucky_emerald_ore = null;
	}
	@ObjectHolder(MODID)
	public static class ModItems{
		public static final Item lucky_dust = null;
		public static final EnchantedBookItem book_lucky_ench = null;
	}
	@ObjectHolder(MODID)
	public static class ModEnchantments{
		public static final Enchantment ench_lucky = null;
	}
}
