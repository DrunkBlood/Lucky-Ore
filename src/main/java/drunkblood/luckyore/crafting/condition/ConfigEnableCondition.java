package drunkblood.luckyore.crafting.condition;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.LuckyOreConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigEnableCondition implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(LuckyOre.MODID, "enabled_by_cfg");
	private static final Map<String, Supplier<Boolean>> configs;
	static {
		configs = new HashMap<String, Supplier<Boolean>>();
		configs.put("lucky_diamond_ore", () -> LuckyOreConfig.lucky_diamond_ore_enabled);
		configs.put("lucky_emerald_ore", () -> LuckyOreConfig.lucky_emerald_ore_enabled);
		configs.put("lucky_lapis_ore", () -> LuckyOreConfig.lucky_lapis_ore_enabled);
		configs.put("lucky_redstone_ore", () -> LuckyOreConfig.lucky_redstone_ore_enabled);
		configs.put("lucky_iron_ore", () -> LuckyOreConfig.lucky_iron_ore_enabled);
		configs.put("lucky_gold_ore", () -> LuckyOreConfig.lucky_gold_ore_enabled);
		configs.put("lucky_copper_ore", () -> LuckyOreConfig.lucky_copper_ore_enabled);
		configs.put("nether_lucky_ore", () -> LuckyOreConfig.nether_lucky_ore_enabled);
	}
	private final String configKey;

	public ConfigEnableCondition(String configKey) {
		this.configKey = configKey;
	}

	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test(IContext context) {
		return configs.get(configKey).get();
	}

	public static class Serializer implements IConditionSerializer<ConfigEnableCondition> {

		@Override
		public void write(JsonObject json, ConfigEnableCondition value) {
			json.addProperty("enabled_by_cfg", value.configKey);
		}

		@Override
		public ConfigEnableCondition read(JsonObject json) {
			if (!json.has("enabled_by_cfg") || !configs.containsKey(json.get("enabled_by_cfg").getAsString())) {
				throw new JsonParseException("Invalid config condition!");
			}
			return new ConfigEnableCondition(json.get("enabled_by_cfg").getAsString());
		}

		@Override
		public ResourceLocation getID() {
			return ConfigEnableCondition.ID;
		}

	}

}
