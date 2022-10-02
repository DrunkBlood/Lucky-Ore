package drunkblood.luckyore.registries;

import com.google.common.collect.ImmutableList;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.LuckyOreConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModOres {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> REG_CONFIG = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, LuckyOre.MODID);
	public static final DeferredRegister<PlacedFeature> REG_PLACED = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, LuckyOre.MODID);
	public static final RegistryObject<ConfiguredFeature<?,?>> LUCKY_ORE_FEATURE;
	public static final RegistryObject<ConfiguredFeature<?,?>> NETHER_LUCKY_ORE_FEATURE;
	public static final RegistryObject<PlacedFeature> LUCKY_ORE;
	public static final RegistryObject<PlacedFeature> NETHER_LUCKY_ORE;

	static {
		LUCKY_ORE_FEATURE = REG_CONFIG.register("configured_ore_lucky_ore", () -> {
			List<OreConfiguration.TargetBlockState> luckyOreTargets = ImmutableList.of(
					OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LUCKY_ORE.get().defaultBlockState()),
					OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LUCKY_ORE.get().defaultBlockState())
			);
			OreConfiguration luckyOreConfiguration = new OreConfiguration(
					luckyOreTargets,
					LuckyOreConfig.lucky_ore_air_discard
			);
			return new ConfiguredFeature<>(Feature.ORE, luckyOreConfiguration);
		});

		LUCKY_ORE = REG_PLACED.register("placed_ore_lucky_ore", () -> {
			List<PlacementModifier> luckyOrePlacementModifiers = ImmutableList.of(
					CountPlacement.of(LuckyOreConfig.lucky_ore_vein_count),
					InSquarePlacement.spread(),
					HeightRangePlacement.uniform(
							VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_above_low),
							VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_below_high)
					),
					BiomeFilter.biome());
			return new PlacedFeature(LUCKY_ORE_FEATURE.getHolder().orElseThrow(IllegalStateException::new), luckyOrePlacementModifiers);
		});
		NETHER_LUCKY_ORE_FEATURE = REG_CONFIG.register("configured_ore_nether_lucky_ore", () -> {
			OreConfiguration netherLuckyOreConfiguration = new OreConfiguration(
					OreFeatures.NETHERRACK,
					ModBlocks.NETHER_LUCKY_ORE.get().defaultBlockState(),
					LuckyOreConfig.nether_lucky_ore_air_discard
			);
			return new ConfiguredFeature<>(Feature.ORE, netherLuckyOreConfiguration);
		});
		NETHER_LUCKY_ORE = REG_PLACED.register("placed_ore_nether_lucky_ore", () ->{
			List<PlacementModifier> netherLuckyOrePlacementModifiers = ImmutableList.of(
					CountPlacement.of(LuckyOreConfig.nether_lucky_ore_vein_count),
					InSquarePlacement.spread(),
					HeightRangePlacement.uniform(
							VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_above_low),
							VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_below_high)
					),
					BiomeFilter.biome());
			return new PlacedFeature(NETHER_LUCKY_ORE_FEATURE.getHolder().orElseThrow(IllegalStateException::new), netherLuckyOrePlacementModifiers);
		});
	}

}
