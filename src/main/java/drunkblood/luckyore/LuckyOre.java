package drunkblood.luckyore;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import drunkblood.luckyore.config.ConfigHolder;
import drunkblood.luckyore.crafting.condition.ConfigEnableCondition;
import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.registries.ModEnchantments;
import drunkblood.luckyore.registries.ModItems;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LuckyOre.MODID)
public class LuckyOre {
	public static final String MODID = "luckyore";
	public static final String NAME = "Lucky Ore";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public LuckyOre() {
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();

		// DeferredRegister
		ModBlocks.REG.register(modBus);
		ModItems.REG.register(modBus);
		ModEnchantments.REG.register(modBus);

		// Config
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		// TODO enable when doing Server Config
		// modLoadingContext.registerConfig(ModConfig.Type.SERVER,
		// ConfigHolder.SERVER_SPEC);

		// Crafting
		CraftingHelper.register(new ConfigEnableCondition.Serializer());
	}
}
