package drunkblood.luckyore.config;

import drunkblood.luckyore.LuckyOre;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
	public final ForgeConfigSpec.BooleanValue lucky_enchantment_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_diamond_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_emerald_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_lapis_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_redstone_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_iron_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_copper_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_gold_ore_enabled;
	public final ForgeConfigSpec.BooleanValue nether_lucky_ore_enabled;

	public final ForgeConfigSpec.ConfigValue<Integer> lucky_ore_vein_count;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_ore_above_low;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_ore_below_high;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_ore_air_discard;
	public final ForgeConfigSpec.ConfigValue<Integer> nether_lucky_ore_vein_count;
	public final ForgeConfigSpec.ConfigValue<Integer> nether_lucky_ore_above_low;
	public final ForgeConfigSpec.ConfigValue<Integer> nether_lucky_ore_below_high;
	public final ForgeConfigSpec.ConfigValue<Integer> nether_lucky_ore_air_discard;
	public final ForgeConfigSpec.ConfigValue<Integer> general_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_emerald_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_lapis_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_redstone_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_iron_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_copper_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_gold_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Integer> lucky_diamond_ore_increased_drops;
	public final ForgeConfigSpec.ConfigValue<Double> zombie_dust_drop_chance;
	public final ForgeConfigSpec.ConfigValue<Double> zombie_dust_looting_multiplier;

	ClientConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		lucky_diamond_ore_enabled = builder.comment("The Lucky Diamond Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_diamond_ore").define("lucky_diamond_ore", true);
		lucky_emerald_ore_enabled = builder.comment("The Lucky Emerald Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_emerald_ore").define("lucky_emerald_ore", true);
		lucky_lapis_ore_enabled = builder.comment("The Lucky Lapis Lazuli Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_lapis_ore").define("lucky_lapis_ore", true);
		lucky_redstone_ore_enabled = builder.comment("The Lucky Redstone Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_redstone_ore").define("lucky_redstone_ore", true);
		lucky_iron_ore_enabled = builder.comment("The Lucky Iron Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_iron_ore").define("lucky_redstone_ore", true);
		lucky_copper_ore_enabled = builder.comment("The Lucky Copper Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_copper_ore").define("lucky_redstone_ore", true);
		lucky_gold_ore_enabled = builder.comment("The Lucky Gold Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_gold_ore").define("lucky_redstone_ore", true);
		nether_lucky_ore_enabled = builder.comment("Nether Lucky Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_diamond_ore").define("lucky_diamond_ore", true);
		zombie_dust_drop_chance = builder.comment("Chances for Rare Zombie Drops - see vanilla zombie.json loottable")
				.translation(LuckyOre.MODID + "config.zombie_dust_drop_chance").define("dust_drop_chance", 0.025);
		zombie_dust_looting_multiplier = builder.comment("How far does looting affect the dust drop chances")
				.translation(LuckyOre.MODID + "config.zombie_dust_looting_multiplier")
				.define("dust_looting_multiplier", 0.01);
		builder.push("lucky_enchantment");
		lucky_enchantment_enabled = builder.comment("The Lucky Enchantment is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_enchantment").define("lucky_enchantment", true);
		general_increased_drops = builder.comment("General amount of raw bonus drops gained from the Lucky Enchantment")
				.translation(LuckyOre.MODID + "config.general_increased_drops").define("general_inc_drops", 0);
		lucky_emerald_ore_increased_drops = builder
				.comment("Specific amount of raw bonus drops gained from the Lucky Enchantment")
				.translation(LuckyOre.MODID + "config.lucky_emerald_ore_increased_drops")
				.define("lucky_emerald_ore_inc_drops", 3);
		lucky_lapis_ore_increased_drops = builder.define("lucky_lapis_ore_inc_drops", 8);
		lucky_redstone_ore_increased_drops = builder.define("lucky_redstone_ore_increased_drops", 6);
		lucky_diamond_ore_increased_drops = builder.define("lucky_diamond_ore_increased_drops", 0);
		lucky_iron_ore_increased_drops = builder.define("lucky_iron_ore_increased_drops", 2);
		lucky_copper_ore_increased_drops = builder.define("lucky_copper_ore_increased_drops", 3);
		lucky_gold_ore_increased_drops = builder.define("lucky_gold_ore_increased_drops", 5);
		builder.pop(2);
		builder.push("worldgen");
		builder.push("lucky_ore");
		lucky_ore_vein_count = builder.comment("Configuration for Lucky Ore")
				.translation(LuckyOre.MODID + "config.lucky_ore_gen").define("vein_count", 20);
		lucky_ore_above_low = builder.define("above_min_y", 10);
		lucky_ore_below_high = builder.define("below_max_y", 10);
		lucky_ore_air_discard = builder.define("discardChanceOnAirExposure", 9);
		builder.pop();
		builder.push("nether_lucky ore");
		nether_lucky_ore_vein_count = builder.comment("Configuration for Nether Lucky Ore")
				.translation(LuckyOre.MODID + "config.lucky_ore_gen").define("vein_count", 35);
		nether_lucky_ore_above_low = builder.define("above_min_y", 10);
		nether_lucky_ore_below_high = builder.define("below_max_y", 10);
		nether_lucky_ore_air_discard = builder.define("discardChanceOnAirExposure", 14);

	}
}
