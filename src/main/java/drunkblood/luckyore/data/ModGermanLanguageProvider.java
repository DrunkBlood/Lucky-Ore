package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.registries.ModEnchantments;
import drunkblood.luckyore.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class ModGermanLanguageProvider extends LanguageProvider {
    public ModGermanLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid, "de_de");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ModItems.LUCKY_DUST, "Glücks-Staub");

        // Blocks
        addBlock(ModBlocks.LUCKY_ORE, "Glückserz");
        addBlock(ModBlocks.DEEPSLATE_LUCKY_ORE, "Tiefenschiefer-Glückserz");
        addBlock(ModBlocks.NETHER_LUCKY_ORE, "Nether-Glückserz");
        addBlock(ModBlocks.LUCKY_DIAMOND_ORE, "Glücks-Diamanterz");
        addBlock(ModBlocks.LUCKY_REDSTONE_ORE, "Glücks-Redstone-Erz");
        addBlock(ModBlocks.LUCKY_LAPIS_ORE, "Glücks-Lapislazulierz");
        addBlock(ModBlocks.LUCKY_IRON_ORE, "Glücks-Eisenerz");
        addBlock(ModBlocks.LUCKY_COPPER_ORE, "Glücks-Kupfererz");
        addBlock(ModBlocks.LUCKY_GOLD_ORE, "Glücks-Golderz");
        addBlock(ModBlocks.LUCKY_EMERALD_ORE, "Glücks-Smaragerz");

        // Enchantments
        addEnchantment(ModEnchantments.LUCKY, "Glück");

        // Enchantment Descriptions
        addEnchantmentDescription(ModEnchantments.LUCKY, "Erhöht den Ertrag von Glückserzen");
    }

    public void addEnchantmentDescription(Supplier<? extends Enchantment> key, String name) {
        add(key.get() + ".desc", name);
    }
}
