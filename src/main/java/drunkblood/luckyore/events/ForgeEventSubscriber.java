package drunkblood.luckyore.events;

import drunkblood.luckyore.LuckyOre;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(modid = LuckyOre.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {
	@SubscribeEvent
	public static void onLootTableLoad(LootTableLoadEvent event) {
		// check Zombie loot table
		// TODO refactor to Global Loot Modifiers
		if (event.getName().equals(new ResourceLocation("entities/zombie"))) {
			LuckyOre.LOGGER.info("Adding lucky dust to Zombie");
			event.getTable().addPool(LootPool.builder()
					.addEntry(TableLootEntry.builder(new ResourceLocation(LuckyOre.MODID, "entities/zombie"))).build());
		}

	}
}
