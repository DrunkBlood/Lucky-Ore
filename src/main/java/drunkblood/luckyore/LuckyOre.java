package drunkblood.luckyore;


import drunkblood.luckyore.registries.*;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
		ModGlobalLootModifiers.REG.register(modBus);
		ModOres.REG_CONFIG.register(modBus);
		ModOres.REG_PLACED.register(modBus);

	}

}
