package drunkblood.luckyore.events;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.ConfigHolder;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.world.gen.ModOres;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
	@SubscribeEvent
	public static void ModConfig(ModConfigEvent event) {
		final IConfigSpec configSpec = event.getConfig().getSpec();
		if (configSpec == ConfigHolder.CLIENT_SPEC) {
			// Client config has changed || first loaded
			LuckyOreConfig.lucky_enchantment_enabled = ConfigHolder.CLIENT.lucky_enchantment_enabled.get();
			LuckyOreConfig.lucky_diamond_ore_enabled = ConfigHolder.CLIENT.lucky_diamond_ore_enabled.get();
			LuckyOreConfig.lucky_emerald_ore_enabled = ConfigHolder.CLIENT.lucky_emerald_ore_enabled.get();
			LuckyOreConfig.lucky_lapis_ore_enabled = ConfigHolder.CLIENT.lucky_lapis_ore_enabled.get();
			LuckyOreConfig.lucky_iron_ore_enabled = ConfigHolder.CLIENT.lucky_iron_ore_enabled.get();
			LuckyOreConfig.lucky_copper_ore_enabled = ConfigHolder.CLIENT.lucky_copper_ore_enabled.get();
			LuckyOreConfig.lucky_gold_ore_enabled = ConfigHolder.CLIENT.lucky_gold_ore_enabled.get();
			LuckyOreConfig.lucky_redstone_ore_enabled = ConfigHolder.CLIENT.lucky_redstone_ore_enabled.get();
			LuckyOreConfig.nether_lucky_ore_enabled = ConfigHolder.CLIENT.nether_lucky_ore_enabled.get();
			LuckyOreConfig.lucky_ore_vein_count = ConfigHolder.CLIENT.lucky_ore_vein_count.get();
			LuckyOreConfig.lucky_ore_vein_size = ConfigHolder.CLIENT.lucky_ore_vein_size.get();
			LuckyOreConfig.lucky_ore_min_y = ConfigHolder.CLIENT.lucky_ore_min_y.get();
			LuckyOreConfig.lucky_ore_max_y = ConfigHolder.CLIENT.lucky_ore_max_y.get();
			LuckyOreConfig.nether_lucky_ore_vein_count = ConfigHolder.CLIENT.nether_lucky_ore_vein_count.get();
			LuckyOreConfig.nether_lucky_ore_vein_size = ConfigHolder.CLIENT.nether_lucky_ore_vein_size.get();
			LuckyOreConfig.nether_lucky_ore_min_y = ConfigHolder.CLIENT.nether_lucky_ore_min_y.get();
			LuckyOreConfig.lucky_emerald_ore_increased_drops = ConfigHolder.CLIENT.lucky_emerald_ore_increased_drops
					.get();
			LuckyOreConfig.lucky_lapis_ore_increased_drops = ConfigHolder.CLIENT.lucky_lapis_ore_increased_drops.get();
			LuckyOreConfig.lucky_iron_ore_increased_drops = ConfigHolder.CLIENT.lucky_iron_ore_increased_drops.get();
			LuckyOreConfig.lucky_gold_ore_increased_drops = ConfigHolder.CLIENT.lucky_gold_ore_increased_drops.get();
			LuckyOreConfig.lucky_copper_ore_increased_drops = ConfigHolder.CLIENT.lucky_copper_ore_increased_drops.get();
			LuckyOreConfig.lucky_redstone_ore_increased_drops = ConfigHolder.CLIENT.lucky_redstone_ore_increased_drops
					.get();
			LuckyOreConfig.general_increased_drops = ConfigHolder.CLIENT.general_increased_drops.get();
			LuckyOreConfig.lucky_diamond_ore_increased_drops = ConfigHolder.CLIENT.lucky_diamond_ore_increased_drops
					.get();
			LuckyOreConfig.zombie_dust_drop_chance = ConfigHolder.CLIENT.zombie_dust_drop_chance
					.get().floatValue();
			LuckyOreConfig.zombie_dust_looting_multiplier = ConfigHolder.CLIENT.zombie_dust_looting_multiplier
					.get().floatValue();
		} else if (configSpec == ConfigHolder.SERVER_SPEC) {
			// Server config has changed || first loaded
		}
	}

	@SubscribeEvent
	public static void CommonSetup(FMLCommonSetupEvent event) {
		ModOres.initOres();
	}

}
