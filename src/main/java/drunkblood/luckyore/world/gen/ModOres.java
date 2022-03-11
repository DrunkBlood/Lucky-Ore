package drunkblood.luckyore.world.gen;

import com.google.common.collect.ImmutableList;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOres {

	public static Holder<PlacedFeature> NETHER_LUCKY_ORE;
	public static Holder<PlacedFeature> LUCKY_ORE;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> LUCKY_ORE_FEATURE;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_LUCKY_ORE_FEATURE;

	public static void initOres() {
		registerLuckyOre();
		registerNetherLuckyOre();
	}

	private static void registerLuckyOre() {
		List<OreConfiguration.TargetBlockState> luckyOreTargets = ImmutableList.of(
				OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LUCKY_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LUCKY_ORE.get().defaultBlockState())
		);
		OreConfiguration luckyOreConfiguration = new OreConfiguration(
				luckyOreTargets,
				LuckyOreConfig.lucky_ore_air_discard
		);
		LUCKY_ORE_FEATURE = registerFeature(
				"ore_lucky_ore",
				Feature.ORE,
				luckyOreConfiguration
		);
		List<PlacementModifier> luckyOrePlacementModifiers = ImmutableList.of(
				CountPlacement.of(LuckyOreConfig.lucky_ore_vein_count),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_below_high)
				),
				BiomeFilter.biome());
		LUCKY_ORE = registerPlacedFeature(
				"ore_lucky_ore",
				LUCKY_ORE_FEATURE,
				luckyOrePlacementModifiers
		);
	}

	private static void registerNetherLuckyOre() {
		OreConfiguration netherLuckyOreConfiguration = new OreConfiguration(
				OreFeatures.NETHERRACK,
				ModBlocks.NETHER_LUCKY_ORE.get().defaultBlockState(),
				LuckyOreConfig.nether_lucky_ore_air_discard
		);
		NETHER_LUCKY_ORE_FEATURE = registerFeature(
				"ore_nether_lucky_ore",
				Feature.ORE,
				netherLuckyOreConfiguration
		);
		List<PlacementModifier> netherLuckyOrePlacementModifiers = ImmutableList.of(
				CountPlacement.of(LuckyOreConfig.nether_lucky_ore_vein_count),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_below_high)
				),
				BiomeFilter.biome());
		NETHER_LUCKY_ORE = registerPlacedFeature(
				"ore_nether_lucky_ore",
				NETHER_LUCKY_ORE_FEATURE,
				netherLuckyOrePlacementModifiers
		);
	}

	private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>>
	registerFeature(String name, F feature, FC config){
		return BuiltinRegistries.registerExact(
				BuiltinRegistries.CONFIGURED_FEATURE,
				new ResourceLocation(LuckyOre.MODID, name).toString(),
				new ConfiguredFeature<>(feature, config)
		);
	}
	private static Holder<PlacedFeature> registerPlacedFeature(
			String name,
			Holder<? extends ConfiguredFeature<?, ?>> configuredFeature,
			List<PlacementModifier> placementModifiers){
		return BuiltinRegistries.registerExact(
				BuiltinRegistries.PLACED_FEATURE,
				new ResourceLocation(LuckyOre.MODID, name).toString(),
				new PlacedFeature(Holder.hackyErase(configuredFeature), List.copyOf(placementModifiers)
		));
	}

}
