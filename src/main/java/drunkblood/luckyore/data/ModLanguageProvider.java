package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.registries.ModEnchantments;
import drunkblood.luckyore.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ModItems.LUCKY_DUST, "Lucky Dust");

        // Blocks
        addBlock(ModBlocks.LUCKY_ORE, "Lucky Ore");
        addBlock(ModBlocks.DEEPSLATE_LUCKY_ORE, "Deepslate Lucky Ore");
        addBlock(ModBlocks.NETHER_LUCKY_ORE, "Nether Lucky Ore");
        addBlock(ModBlocks.LUCKY_DIAMOND_ORE, "Lucky Diamond Ore");
        addBlock(ModBlocks.LUCKY_REDSTONE_ORE, "Lucky Redstone Ore");
        addBlock(ModBlocks.LUCKY_LAPIS_ORE, "Lucky Lapis Lazuli Ore");
        addBlock(ModBlocks.LUCKY_IRON_ORE, "Lucky Iron Ore");
        addBlock(ModBlocks.LUCKY_COPPER_ORE, "Lucky Copper Ore");
        addBlock(ModBlocks.LUCKY_GOLD_ORE, "Lucky Gold Ore");
        addBlock(ModBlocks.LUCKY_EMERALD_ORE, "Lucky Emerald Ore");

        // Enchantments
        addEnchantment(ModEnchantments.LUCKY, "Lucky");

        // Enchantment Descriptions
        addEnchantmentDescription(ModEnchantments.LUCKY, "Increases the yield of the Lucky Ores");
    }

    public void addEnchantmentDescription(Supplier<? extends Enchantment> key, String name) {
        add(key.get() + ".desc", name);
    }
}
