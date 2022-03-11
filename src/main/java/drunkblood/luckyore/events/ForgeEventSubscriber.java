package drunkblood.luckyore.events;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.world.gen.ModOres;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void biomeLoadingEventListener(BiomeLoadingEvent event){
        if(Biome.BiomeCategory.NETHER.equals(event.getCategory())){
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION,
                    ModOres.NETHER_LUCKY_ORE);
        } else if(! Biome.BiomeCategory.THEEND.equals(event.getCategory())){
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                    ModOres.LUCKY_ORE);
        }
    }
}
