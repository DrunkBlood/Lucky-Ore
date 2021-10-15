package drunkblood.luckyore.events;

import com.google.common.collect.Lists;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingEventListener(BiomeLoadingEvent event){
        if(Biome.BiomeCategory.NETHER.equals(event.getCategory())){
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                    BuiltinRegistries.CONFIGURED_FEATURE.get(ModBlocks.NETHER_LUCKY_ORE.get().getRegistryName()));
        } else if(! Biome.BiomeCategory.THEEND.equals(event.getCategory())){
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                    BuiltinRegistries.CONFIGURED_FEATURE.get(ModBlocks.LUCKY_ORE.get().getRegistryName()));
        }
    }
}
