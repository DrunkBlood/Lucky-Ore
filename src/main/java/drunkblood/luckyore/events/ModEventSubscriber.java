package drunkblood.luckyore.events;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.data.*;
import drunkblood.luckyore.registries.ModOres;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static drunkblood.luckyore.registries.ModOres.*;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

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
		generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));

		// features
		RegistryAccess.Writable registryAccess = RegistryAccess.builtinCopy();
		RegistryOps<JsonElement> registryOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);

		configuredFeatures(event.includeServer(), generator, existingFileHelper, registryOps);
		placedFeatures(event.includeServer(), generator, existingFileHelper, registryAccess, registryOps);
		biomeModifiers(event.includeServer(), generator, existingFileHelper, registryOps);

	}

	private static void biomeModifiers(boolean includeServer, DataGenerator generator, ExistingFileHelper existingFileHelper, RegistryOps<JsonElement> registryOps) {
		Registry<PlacedFeature> placedFeatureRegistry = registryOps.registry(Registry.PLACED_FEATURE_REGISTRY).get();

		HolderSet.Named<Biome> isOverworldTag = new HolderSet.Named<>(registryOps.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD);

		HolderSet.Direct<PlacedFeature> overworldFeatureSet = HolderSet.direct(
				getPlacedFeatureHolder(ModOres.LUCKY_ORE, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_COAL_UPPER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_COAL_LOWER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_IRON_UPPER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_IRON_MIDDLE, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_IRON_SMALL, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_GOLD_EXTRA, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_GOLD, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_GOLD_LOWER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_REDSTONE, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_REDSTONE_LOWER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_DIAMOND, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_DIAMOND_LARGE, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_DIAMOND_BURIED, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_LAPIS, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_LAPIS_BURIED, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_COPPER, placedFeatureRegistry),
		getPlacedFeatureHolder(ModOres.ORE_COPPER_LARGE, placedFeatureRegistry)
		);
		final BiomeModifier overworldBiomeModifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				isOverworldTag,
				overworldFeatureSet,
				GenerationStep.Decoration.UNDERGROUND_ORES
		);

		HolderSet.Named<Biome> isNetherTag = new HolderSet.Named<>(registryOps.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_NETHER);
		Holder<PlacedFeature> netherLuckyOreFeatureHolder = getPlacedFeatureHolder(ModOres.NETHER_LUCKY_ORE, placedFeatureRegistry);

		HolderSet.Direct<PlacedFeature> netherFeatureSet = HolderSet.direct(netherLuckyOreFeatureHolder);
		final BiomeModifier netherBiomeModifier = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				isNetherTag,
				netherFeatureSet,
				GenerationStep.Decoration.UNDERGROUND_ORES
		);

		Map<ResourceLocation, BiomeModifier> biomeModifierMap =
				Map.of(
						new ResourceLocation(LuckyOre.MODID, "add_overworld_ores"), overworldBiomeModifier,
						new ResourceLocation(LuckyOre.MODID, "add_nether_ores"), netherBiomeModifier);
		JsonCodecProvider biomeModifierProvier = JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, LuckyOre.MODID, registryOps, ForgeRegistries.Keys.BIOME_MODIFIERS, biomeModifierMap
		);
		generator.addProvider(includeServer, biomeModifierProvier);
	}

	@NotNull
	private static Holder<PlacedFeature> getPlacedFeatureHolder(RegistryObject<PlacedFeature> registryObject, Registry<PlacedFeature> placedFeatureRegistry) {
		ResourceKey<PlacedFeature> resourceKey = registryObject.getKey();
		Holder<PlacedFeature> placedFeatureHolder = placedFeatureRegistry.getHolderOrThrow(resourceKey);
		return placedFeatureHolder;
	}


	private static final Map<ResourceLocation, PlacedFeature> placedMap = new Hashtable<>();

	private static void placedFeatures(boolean includeServer, DataGenerator generator, ExistingFileHelper existingFileHelper, RegistryAccess.Writable registryAccess, RegistryOps<JsonElement> registryOps) {
		Registry<ConfiguredFeature<?, ?>> configuredFeatureRegistry = registryAccess.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get();

		addPlacedFeature("placed_ore_lucky_ore", ModOres.luckyOrePlacements(), ModOres.LUCKY_ORE_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("placed_ore_nether_lucky_ore", ModOres.netherLuckyOrePlacements(), ModOres.NETHER_LUCKY_ORE_FEATURE, configuredFeatureRegistry);
		
		
		addPlacedFeature("ore_coal_upper", commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(136), VerticalAnchor.top())), ORE_COAL_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_coal_lower", commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))), ORE_COAL_BURIED_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_iron_upper", commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))), ORE_IRON_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_iron_middle", commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))), ORE_IRON_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_iron_small", commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))), ORE_IRON_SMALL_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_gold_extra", commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256))), ORE_GOLD_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_gold", commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))), ORE_GOLD_BURIED_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_gold_lower", orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48))), ORE_GOLD_BURIED_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_redstone", commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))), ORE_REDSTONE_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_redstone_lower", commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32))), ORE_REDSTONE_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_diamond", commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))), ORE_DIAMOND_SMALL_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_diamond_large", rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))), ORE_DIAMOND_LARGE_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_diamond_buried", commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))), ORE_DIAMOND_BURIED_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_lapis", commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))), ORE_LAPIS_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_lapis_buried", commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))), ORE_LAPIS_BURIED_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_copper", commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))), ORE_COPPPER_SMALL_FEATURE, configuredFeatureRegistry);
		addPlacedFeature("ore_copper_large", commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))), ORE_COPPER_LARGE_FEATURE, configuredFeatureRegistry);

		JsonCodecProvider placedProvider = JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, LuckyOre.MODID, registryOps, Registry.PLACED_FEATURE_REGISTRY, placedMap);
		generator.addProvider(includeServer, placedProvider);
	}

	private static void addPlacedFeature(String name, List<PlacementModifier> placementModifiers, RegistryObject<ConfiguredFeature<?,?>> configuredFeature, Registry<ConfiguredFeature<?, ?>> configuredFeatureRegistry){
		ResourceKey<ConfiguredFeature<?, ?>> resourceKey = configuredFeature.getKey();
		Holder<ConfiguredFeature<?, ?>> configuredFeatureHolder = configuredFeatureRegistry.getHolderOrThrow(resourceKey);
		PlacedFeature placedFeature = new PlacedFeature(configuredFeatureHolder, placementModifiers);
		placedMap.put(new ResourceLocation(LuckyOre.MODID, name), placedFeature);
	}

	private static void configuredFeatures(boolean includeServer, DataGenerator generator, ExistingFileHelper existingFileHelper, RegistryOps<JsonElement> registryOps) {
		Map<ResourceLocation, ConfiguredFeature<?,?>> configuredMap = new Hashtable<>();
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "configured_ore_lucky_ore"), ModOres.LUCKY_ORE_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_coal"), ModOres.ORE_COAL_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_coal_buried"), ModOres.ORE_COAL_BURIED_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_iron"), ModOres.ORE_IRON_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_iron_small"), ModOres.ORE_IRON_SMALL_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_gold"), ModOres.ORE_GOLD_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_gold_buried"), ModOres.ORE_GOLD_BURIED_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_redstone"), ModOres.ORE_REDSTONE_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_diamond_small"), ModOres.ORE_DIAMOND_SMALL_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_diamond_large"), ModOres.ORE_DIAMOND_LARGE_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_diamond_buried"), ModOres.ORE_DIAMOND_BURIED_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_lapis"), ModOres.ORE_LAPIS_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_lapis_buried"), ModOres.ORE_LAPIS_BURIED_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_copper_small"), ModOres.ORE_COPPPER_SMALL_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "ore_copper_large"), ModOres.ORE_COPPER_LARGE_FEATURE.get());
		configuredMap.put(new ResourceLocation(LuckyOre.MODID, "configured_ore_nether_lucky_ore"), ModOres.NETHER_LUCKY_ORE_FEATURE.get());

		JsonCodecProvider configuredProvider = JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, LuckyOre.MODID, registryOps, Registry.CONFIGURED_FEATURE_REGISTRY, configuredMap);
		generator.addProvider(includeServer, configuredProvider);
	}



}
