package drunkblood.luckyore.events;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.ConfigHolder;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.data.*;
import drunkblood.luckyore.registries.ModOres;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;
import java.util.Map;

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
	public static void GatherData(GatherDataEvent event){
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, LuckyOre.MODID, existingFileHelper));
		generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, LuckyOre.MODID, existingFileHelper));
		generator.addProvider(event.includeServer(), new ModBlockTagsProvider(generator, LuckyOre.MODID, existingFileHelper));
		generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
		generator.addProvider(event.includeServer(), new ModLanguageProvider(generator, LuckyOre.MODID));
		generator.addProvider(event.includeServer(), new ModGermanLanguageProvider(generator, LuckyOre.MODID));

		// Biome modifiers
		RegistryAccess.Writable registryAccess = RegistryAccess.builtinCopy();
		RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);
		Map<ResourceLocation, ConfiguredFeature<?,?>> configuredMap =
				Map.of(new ResourceLocation(LuckyOre.MODID, "configured_ore_lucky_ore"), ModOres.LUCKY_ORE_FEATURE.get(),
					   new ResourceLocation(LuckyOre.MODID, "configured_ore_nether_lucky_ore"), ModOres.NETHER_LUCKY_ORE_FEATURE.get());
		JsonCodecProvider configuredProvider = JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, LuckyOre.MODID, registryOps, Registry.CONFIGURED_FEATURE_REGISTRY, configuredMap);
		generator.addProvider(event.includeServer(), configuredProvider);

		Registry<ConfiguredFeature<?, ?>> configuredFeatureRegistry = registryAccess.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get();

		List<PlacementModifier> luckyOrePlacementModifiers = ImmutableList.of(
				CountPlacement.of(LuckyOreConfig.lucky_ore_vein_count),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_below_high)
				),
				BiomeFilter.biome());
		ResourceKey<ConfiguredFeature<?, ?>> luckyOreResourceKey = ModOres.LUCKY_ORE_FEATURE.getKey();
		Holder<ConfiguredFeature<?, ?>> luckyOreConfigured = configuredFeatureRegistry.getHolderOrThrow(luckyOreResourceKey);
		PlacedFeature luckyOreFeature = new PlacedFeature(luckyOreConfigured, luckyOrePlacementModifiers);

		List<PlacementModifier> netherLuckyOrePlacementModifiers = ImmutableList.of(
				CountPlacement.of(LuckyOreConfig.nether_lucky_ore_vein_count),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_below_high)
				),
				BiomeFilter.biome());
		ResourceKey<ConfiguredFeature<?, ?>> netherLuckyOreResourceKey = ModOres.NETHER_LUCKY_ORE_FEATURE.getKey();
		Holder<ConfiguredFeature<?, ?>> netherLuckyOreConfigured = configuredFeatureRegistry.getHolderOrThrow(netherLuckyOreResourceKey);
		PlacedFeature netherLuckyOreFeature = new PlacedFeature(netherLuckyOreConfigured, netherLuckyOrePlacementModifiers);
		Map<ResourceLocation, PlacedFeature> placedMap =
				Map.of(new ResourceLocation(LuckyOre.MODID, "placed_ore_lucky_ore"), luckyOreFeature,
					   new ResourceLocation(LuckyOre.MODID, "placed_ore_nether_lucky_ore"), netherLuckyOreFeature);
		JsonCodecProvider placedProvider = JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, LuckyOre.MODID, registryOps, Registry.PLACED_FEATURE_REGISTRY, placedMap);
		generator.addProvider(event.includeServer(), placedProvider);
	}

}
