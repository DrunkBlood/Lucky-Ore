package drunkblood.luckyore.events;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.ConfigHolder;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.world.gen.ModOres;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.IConfigSpec;
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
			LuckyOreConfig.lucky_ore_above_low = ConfigHolder.CLIENT.lucky_ore_above_low.get();
			LuckyOreConfig.lucky_ore_below_high = ConfigHolder.CLIENT.lucky_ore_below_high.get();
			LuckyOreConfig.lucky_ore_air_discard = ConfigHolder.CLIENT.lucky_ore_air_discard.get();
			LuckyOreConfig.nether_lucky_ore_vein_count = ConfigHolder.CLIENT.nether_lucky_ore_vein_count.get();
			LuckyOreConfig.nether_lucky_ore_above_low = ConfigHolder.CLIENT.nether_lucky_ore_above_low.get();
			LuckyOreConfig.nether_lucky_ore_below_high = ConfigHolder.CLIENT.nether_lucky_ore_below_high.get();
			LuckyOreConfig.nether_lucky_ore_air_discard = ConfigHolder.CLIENT.nether_lucky_ore_air_discard.get();
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
