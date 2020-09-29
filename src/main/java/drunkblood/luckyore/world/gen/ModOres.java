package drunkblood.luckyore.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;

import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ModOres {

	public static void initOres() {
		Registry.register(WorldGenRegistries.field_243653_e, ModBlocks.LUCKY_ORE.get().getRegistryName(),
				Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
								ModBlocks.LUCKY_ORE.get().getDefaultState(), LuckyOreConfig.lucky_ore_vein_size))
						.withPlacement(Placement.field_242907_l
								.configure(new TopSolidRangeConfig(LuckyOreConfig.lucky_ore_min_y,
										LuckyOreConfig.lucky_ore_min_y, LuckyOreConfig.lucky_ore_max_y)))
						.func_242728_a().func_242731_b(LuckyOreConfig.lucky_ore_vein_count));
		if (LuckyOreConfig.nether_lucky_ore_enabled) {
			Registry.register(WorldGenRegistries.field_243653_e, ModBlocks.NETHER_LUCKY_ORE.get().getRegistryName(),
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241883_b,
									ModBlocks.NETHER_LUCKY_ORE.get().getDefaultState(), LuckyOreConfig.nether_lucky_ore_vein_size))
							.withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(
									LuckyOreConfig.nether_lucky_ore_min_y, LuckyOreConfig.nether_lucky_ore_min_y,
									LuckyOreConfig.nether_lucky_ore_max_y)))
							.func_242728_a().func_242731_b(LuckyOreConfig.nether_lucky_ore_vein_count));
		}
	}

	public static void setupOres() {
		for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.field_243657_i.func_239659_c_()) {
			if (!biome.getValue().getCategory().equals(Biome.Category.NETHER)
					&& !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES,
						WorldGenRegistries.field_243653_e.getOrDefault(ModBlocks.LUCKY_ORE.get().getRegistryName()));
			}
			if (biome.getValue().getCategory().equals(Biome.Category.NETHER)
					&& LuckyOreConfig.nether_lucky_ore_enabled) {
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES,
						WorldGenRegistries.field_243653_e
								.getOrDefault(ModBlocks.NETHER_LUCKY_ORE.get().getRegistryName()));

			}
		}
	}

	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration,
			ConfiguredFeature<?, ?> configuredFeature) {
		List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
				biome.func_242440_e().func_242498_c());
		while (biomeFeatures.size() <= decoration.ordinal()) {
			biomeFeatures.add(Lists.newArrayList());
		}
		List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
		features.add(() -> configuredFeature);
		biomeFeatures.set(decoration.ordinal(), features);

		ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.func_242440_e(), biomeFeatures,
				"field_242484_f");
	}

}
