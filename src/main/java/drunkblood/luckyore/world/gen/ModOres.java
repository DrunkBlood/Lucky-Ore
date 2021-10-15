package drunkblood.luckyore.world.gen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModOres {

	public static void initOres() {
		/*
		ORE_GOLD = register("ore_gold",
		Feature.ORE.configured(new OreConfiguration(ORE_GOLD_TARGET_LIST, 9))
		.rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(31)).squared().count(2));

		ORE_GOLD_TARGET_LIST = ImmutableList.of(
		OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, Features.States.GOLD_ORE),
		OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, Features.States.DEEPSLATE_GOLD_ORE));
		 */
		ImmutableList<OreConfiguration.TargetBlockState> LUCKY_ORE_TARGETS = ImmutableList.of(
				OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.LUCKY_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LUCKY_ORE.get().defaultBlockState())

		);
		ImmutableList<OreConfiguration.TargetBlockState> NETHER_LUCKY_ORE_TARGETS = ImmutableList.of(
				OreConfiguration.target(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_LUCKY_ORE.get().defaultBlockState()));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ModBlocks.LUCKY_ORE.get().getRegistryName(),
			Feature.ORE
					.configured(new OreConfiguration(LUCKY_ORE_TARGETS, LuckyOreConfig.lucky_ore_vein_size))
					.rangeUniform(
							VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_min_y),
							VerticalAnchor.absolute(LuckyOreConfig.lucky_ore_max_y))
					.squared()
					.count(LuckyOreConfig.lucky_ore_vein_count));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ModBlocks.NETHER_LUCKY_ORE.get().getRegistryName(),
			Feature.ORE
					.configured(new OreConfiguration(NETHER_LUCKY_ORE_TARGETS, LuckyOreConfig.nether_lucky_ore_vein_size))
					.rangeUniform(
							VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_min_y),
							VerticalAnchor.absolute(LuckyOreConfig.nether_lucky_ore_max_y))
					.squared()
					.count(LuckyOreConfig.nether_lucky_ore_vein_count));
	}

}
