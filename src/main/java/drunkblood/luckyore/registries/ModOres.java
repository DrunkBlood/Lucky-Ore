package drunkblood.luckyore.registries;

import com.google.common.collect.ImmutableList;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.util.LuckyOreConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

public class ModOres {

	public static final DeferredRegister<ConfiguredFeature<?, ?>> REG_CONFIG = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, LuckyOre.MODID);
	public static final DeferredRegister<PlacedFeature> REG_PLACED = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, LuckyOre.MODID);

	public static final RuleTest DIORITE_ORE_REPLACEABLES = new BlockMatchTest(Blocks.DIORITE);
	public static final RuleTest GRANITE_ORE_REPLACEABLES = new BlockMatchTest(Blocks.GRANITE);
	public static final RuleTest ANDERSITE_ORE_REPLACEABLES = new BlockMatchTest(Blocks.ANDESITE);

	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_IRON_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.IRON_ANDERSITE_ORE.get().defaultBlockState()), 
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.IRON_GRANITE_ORE.get().defaultBlockState()), 
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.IRON_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_GOLD_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.GOLD_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.GOLD_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.GOLD_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_DIAMOND_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.DIAMOND_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.DIAMOND_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.DIAMOND_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_LAPIS_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.LAPIS_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.LAPIS_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.LAPIS_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COPPER_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.COPPER_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.COPPER_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.COPPER_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COAL_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.COAL_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.COAL_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.COAL_DIORITE_ORE.get().defaultBlockState())
	);
	public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_REDSTONE_TARGET_LIST = () -> List.of(
			OreConfiguration.target(ANDERSITE_ORE_REPLACEABLES, ModBlocks.REDSTONE_ANDERSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.REDSTONE_GRANITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.REDSTONE_DIORITE_ORE.get().defaultBlockState())
	);
	public static final RegistryObject<ConfiguredFeature<?,?>> LUCKY_ORE_FEATURE;
	public static final RegistryObject<ConfiguredFeature<?,?>> NETHER_LUCKY_ORE_FEATURE;
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COAL_FEATURE = REG_CONFIG.register("ore_coal", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COAL_TARGET_LIST.get(), 17)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COAL_BURIED_FEATURE = REG_CONFIG.register("ore_coal_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COAL_TARGET_LIST.get(), 17, 0.5F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_IRON_FEATURE = REG_CONFIG.register("ore_iron", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_IRON_TARGET_LIST.get(), 9)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_IRON_SMALL_FEATURE = REG_CONFIG.register("ore_iron_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_IRON_TARGET_LIST.get(), 4)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GOLD_FEATURE = REG_CONFIG.register("ore_gold", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_GOLD_TARGET_LIST.get(), 9)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_GOLD_BURIED_FEATURE = REG_CONFIG.register("ore_gold_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_GOLD_TARGET_LIST.get(), 9, 0.5F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_REDSTONE_FEATURE = REG_CONFIG.register("ore_redstone", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_REDSTONE_TARGET_LIST.get(), 8)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DIAMOND_SMALL_FEATURE = REG_CONFIG.register("ore_diamond_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_DIAMOND_TARGET_LIST.get(), 4, 0.5F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DIAMOND_LARGE_FEATURE = REG_CONFIG.register("ore_diamond_large", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_DIAMOND_TARGET_LIST.get(), 12, 0.7F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DIAMOND_BURIED_FEATURE = REG_CONFIG.register("ore_diamond_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_DIAMOND_TARGET_LIST.get(), 8, 1.0F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LAPIS_FEATURE = REG_CONFIG.register("ore_lapis", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_LAPIS_TARGET_LIST.get(), 7)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_LAPIS_BURIED_FEATURE = REG_CONFIG.register("ore_lapis_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_LAPIS_TARGET_LIST.get(), 7, 1.0F)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COPPPER_SMALL_FEATURE = REG_CONFIG.register("ore_copper_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COPPER_TARGET_LIST.get(), 10)));
	public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_COPPER_LARGE_FEATURE = REG_CONFIG.register("ore_copper_large", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_COPPER_TARGET_LIST.get(), 20)));
	
	public static final RegistryObject<PlacedFeature> LUCKY_ORE;
	public static final RegistryObject<PlacedFeature> NETHER_LUCKY_ORE;
	public static final RegistryObject<PlacedFeature> ORE_COAL_UPPER = REG_PLACED.register("ore_coal_upper", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_COAL), commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top()))));
	public static final RegistryObject<PlacedFeature> ORE_COAL_LOWER = REG_PLACED.register("ore_coal_lower", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_COAL_BURIED), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));
	public static final RegistryObject<PlacedFeature> ORE_IRON_UPPER = REG_PLACED.register("ore_iron_upper", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_IRON), commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))));
	public static final RegistryObject<PlacedFeature> ORE_IRON_MIDDLE = REG_PLACED.register("ore_iron_middle", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_IRON), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
	public static final RegistryObject<PlacedFeature> ORE_IRON_SMALL = REG_PLACED.register("ore_iron_small", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_IRON_SMALL), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72)))));
	public static final RegistryObject<PlacedFeature> ORE_GOLD_EXTRA = REG_PLACED.register("ore_gold_extra", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_GOLD), commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256)))));
	public static final RegistryObject<PlacedFeature> ORE_GOLD = REG_PLACED.register("ore_gold", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_GOLD_BURIED), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
	public static final RegistryObject<PlacedFeature> ORE_GOLD_LOWER = REG_PLACED.register("ore_gold_lower", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_GOLD_BURIED), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
	public static final RegistryObject<PlacedFeature> ORE_REDSTONE = REG_PLACED.register("ore_redstone", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_REDSTONE), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
	public static final RegistryObject<PlacedFeature> ORE_REDSTONE_LOWER = REG_PLACED.register("ore_redstone_lower", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_REDSTONE), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
	public static final RegistryObject<PlacedFeature> ORE_DIAMOND = REG_PLACED.register("ore_diamond", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_DIAMOND_SMALL), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final RegistryObject<PlacedFeature> ORE_DIAMOND_LARGE = REG_PLACED.register("ore_diamond_large", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_DIAMOND_LARGE), rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final RegistryObject<PlacedFeature> ORE_DIAMOND_BURIED = REG_PLACED.register("ore_diamond_buried", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_DIAMOND_BURIED), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final RegistryObject<PlacedFeature> ORE_LAPIS = REG_PLACED.register("ore_lapis", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_LAPIS), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
	public static final RegistryObject<PlacedFeature> ORE_LAPIS_BURIED = REG_PLACED.register("ore_lapis_buried", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_LAPIS_BURIED), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)))));
	public static final RegistryObject<PlacedFeature> ORE_COPPER = REG_PLACED.register("ore_copper", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_COPPPER_SMALL), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	public static final RegistryObject<PlacedFeature> ORE_COPPER_LARGE = REG_PLACED.register("ore_copper_large", () -> 
		new PlacedFeature(Holder.hackyErase(OreFeatures.ORE_COPPER_LARGE), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));

	static {
		LUCKY_ORE_FEATURE = REG_CONFIG.register("configured_ore_lucky_ore", () -> {
			List<OreConfiguration.TargetBlockState> luckyOreTargets = ImmutableList.of(
					OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.LUCKY_ORE.get().defaultBlockState()),
					OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LUCKY_ORE.get().defaultBlockState()),
					OreConfiguration.target(new BlockMatchTest(Blocks.DIORITE), ModBlocks.LUCKY_DIORITE_ORE.get().defaultBlockState()),
					OreConfiguration.target(new BlockMatchTest(Blocks.GRANITE), ModBlocks.LUCKY_GRANITE_ORE.get().defaultBlockState()),
					OreConfiguration.target(new BlockMatchTest(Blocks.ANDESITE), ModBlocks.LUCKY_ANDERSITE_ORE.get().defaultBlockState())
			);
			OreConfiguration luckyOreConfiguration = new OreConfiguration(
					luckyOreTargets,
					LuckyOreConstants.lucky_ore_air_discard
			);
			return new ConfiguredFeature<>(Feature.ORE, luckyOreConfiguration);
		});

		LUCKY_ORE = REG_PLACED.register("placed_ore_lucky_ore", () ->
				new PlacedFeature(LUCKY_ORE_FEATURE.getHolder().orElseThrow(IllegalStateException::new), luckyOrePlacements()));
		NETHER_LUCKY_ORE_FEATURE = REG_CONFIG.register("configured_ore_nether_lucky_ore", () -> {
			OreConfiguration netherLuckyOreConfiguration = new OreConfiguration(
					OreFeatures.NETHERRACK,
					ModBlocks.NETHER_LUCKY_ORE.get().defaultBlockState(),
					LuckyOreConstants.nether_lucky_ore_air_discard
			);
			return new ConfiguredFeature<>(Feature.ORE, netherLuckyOreConfiguration);
		});
		NETHER_LUCKY_ORE = REG_PLACED.register("placed_ore_nether_lucky_ore", () ->
				new PlacedFeature(NETHER_LUCKY_ORE_FEATURE.getHolder().orElseThrow(IllegalStateException::new), netherLuckyOrePlacements()));
	}

	public static List<PlacementModifier> luckyOrePlacements(){
		return ImmutableList.of(
				CountPlacement.of(LuckyOreConstants.lucky_ore_vein_size),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConstants.lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConstants.lucky_ore_below_high)
				),
				BiomeFilter.biome());
	}

	public static List<PlacementModifier> netherLuckyOrePlacements(){
		return ImmutableList.of(
				CountPlacement.of(LuckyOreConstants.nether_lucky_ore_vein_size),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(
						VerticalAnchor.absolute(LuckyOreConstants.nether_lucky_ore_above_low),
						VerticalAnchor.absolute(LuckyOreConstants.nether_lucky_ore_below_high)
				),
				BiomeFilter.biome());
	}

	/*
	VANILLA
	 */
	public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	}

}
