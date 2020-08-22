package drunkblood.luckyore.config;

import drunkblood.luckyore.LuckyOre;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
	public final ForgeConfigSpec.BooleanValue lucky_enchantment_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_diamond_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_emerald_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_lapis_ore_enabled;
	public final ForgeConfigSpec.BooleanValue lucky_redstone_ore_enabled;
	public final ForgeConfigSpec.BooleanValue nether_lucky_ore_enabled;

	ClientConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("general");
		lucky_enchantment_enabled = builder.comment("true: the Lucky Enchantment is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_enchantment").define("lucky_enchantment", true);
		lucky_diamond_ore_enabled = builder.comment("true: the Lucky Diamond Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_diamond_ore").define("lucky_diamond_ore", true);
		lucky_emerald_ore_enabled = builder.comment("true: the Lucky Emerald Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_emerald_ore").define("lucky_emerald_ore", true);
		lucky_lapis_ore_enabled = builder.comment("true: the Lucky Lapis Lazuli Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_lapis_ore").define("lucky_lapis_ore", true);
		lucky_redstone_ore_enabled = builder.comment("true: the Lucky Redstone Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_redstone_ore").define("lucky_redstone_ore", true);
		nether_lucky_ore_enabled = builder.comment("true: Nether Lucky Ore is obtainable/enabled")
				.translation(LuckyOre.MODID + "config.lucky_diamond_ore").define("lucky_diamond_ore", true);

	}
}
