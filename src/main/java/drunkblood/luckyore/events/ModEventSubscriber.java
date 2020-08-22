package drunkblood.luckyore.events;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.ConfigHolder;
import drunkblood.luckyore.config.LuckyOreConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
	@SubscribeEvent
	public static void ModConfig(ModConfig.ModConfigEvent event) {
		final ForgeConfigSpec configSpec = event.getConfig().getSpec();
		if (configSpec == ConfigHolder.CLIENT_SPEC) {
			// Client config has changed || first loaded
			LuckyOreConfig.lucky_enchantment_enabled = ConfigHolder.CLIENT.lucky_enchantment_enabled.get();
			LuckyOreConfig.lucky_diamond_ore_enabled = ConfigHolder.CLIENT.lucky_diamond_ore_enabled.get();
			LuckyOreConfig.lucky_emerald_ore_enabled = ConfigHolder.CLIENT.lucky_emerald_ore_enabled.get();
			LuckyOreConfig.lucky_lapis_ore_enabled = ConfigHolder.CLIENT.lucky_lapis_ore_enabled.get();
			LuckyOreConfig.lucky_redstone_ore_enabled = ConfigHolder.CLIENT.lucky_redstone_ore_enabled.get();
			LuckyOreConfig.nether_lucky_ore_enabled = ConfigHolder.CLIENT.nether_lucky_ore_enabled.get();
		} else if (configSpec == ConfigHolder.SERVER_SPEC) {
			// Server config has changed || first loaded
		}
	}

	@SubscribeEvent
	public static void LoadComplete(FMLLoadCompleteEvent event) {
		// adding Ores
		return;
		// TODO OreSpawn not yet implemented
//		LuckyOre.LOGGER.debug("event fired");
//		for (Biome biome : ForgeRegistries.BIOMES) {
//			if (biome.getCategory() == Category.THEEND) {
//				continue;
//			}
//			if (biome.getCategory() == Biome.Category.NETHER) {
//				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
//						Feature.ORE
//								.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK,
//										ModBlocks.nether_lucky_ore.getDefaultState(), /* vein size */3))
//								.func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(
//										/* freq per chunk */35, /* miny */ 5, /* y-max-offset */0, /* maxy */256))));
//				continue;
//			}
//			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
//					Feature.ORE
//							.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
//									ModBlocks.lucky_ore.getDefaultState(), /* vein size */3))
//							.func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(
//									/* freq per chunk */25, /* miny */ 5, /* y-max-offset */0, /* maxy */128))));
//
//		}
//		// add ApplyLuckyBonus function
//		ApplyLuckyBonus.Serializer applyLuckyBonus = new ApplyLuckyBonus.Serializer();
//		LootFunctionManager.registerFunction(applyLuckyBonus);
	}
}
