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
        addBlock(ModBlocks.LUCKY_ANDERSITE_ORE, "Lucky Andersite Ore");
        addBlock(ModBlocks.LUCKY_GRANITE_ORE, "Lucky Granite Ore");
        addBlock(ModBlocks.LUCKY_DIORITE_ORE, "Lucky Diorite Ore");
//        addBlock(ModBlocks.DEEPSLATE_LUCKY_ORE, "Deepslate Lucky Ore");
        addBlock(ModBlocks.NETHER_LUCKY_ORE, "Nether Lucky Ore");
        addBlock(ModBlocks.LUCKY_DIAMOND_ORE, "Lucky Diamond Ore");
        addBlock(ModBlocks.DIAMOND_ANDERSITE_ORE, "Diamond Andersite Ore");
        addBlock(ModBlocks.DIAMOND_DIORITE_ORE, "Diamond Diorite Ore");
        addBlock(ModBlocks.DIAMOND_GRANITE_ORE, "Diamond Granite Ore");
        addBlock(ModBlocks.LUCKY_REDSTONE_ORE, "Lucky Redstone Ore");
        addBlock(ModBlocks.REDSTONE_ANDERSITE_ORE, "Redstone Andersite Ore");
        addBlock(ModBlocks.REDSTONE_DIORITE_ORE, "Redstone Diorite Ore");
        addBlock(ModBlocks.REDSTONE_GRANITE_ORE, "Redstone Granite Ore");
        addBlock(ModBlocks.LUCKY_LAPIS_ORE, "Lucky Lapis Lazuli Ore");
        addBlock(ModBlocks.LAPIS_ANDERSITE_ORE, "Lapis Lazuli Andersite Ore");
        addBlock(ModBlocks.LAPIS_DIORITE_ORE, "Lapis Lazuli Diorite Ore");
        addBlock(ModBlocks.LAPIS_GRANITE_ORE, "Lapis Lazuli Granite Ore");
        addBlock(ModBlocks.LUCKY_IRON_ORE, "Lucky Iron Ore");
        addBlock(ModBlocks.IRON_ANDERSITE_ORE, "Lucky Andersite Ore");
        addBlock(ModBlocks.IRON_DIORITE_ORE, "Iron Diorite Ore");
        addBlock(ModBlocks.IRON_GRANITE_ORE, "Iron Granite Ore");
        addBlock(ModBlocks.LUCKY_COPPER_ORE, "Lucky Copper Ore");
        addBlock(ModBlocks.COPPER_ANDERSITE_ORE, "Copper Andersite Ore");
        addBlock(ModBlocks.COPPER_DIORITE_ORE, "Copper Diorite Ore");
        addBlock(ModBlocks.COPPER_GRANITE_ORE, "Copper Granite Ore");
        addBlock(ModBlocks.LUCKY_GOLD_ORE, "Lucky Gold Ore");
        addBlock(ModBlocks.GOLD_ANDERSITE_ORE, "Gold Andersite Ore");
        addBlock(ModBlocks.GOLD_DIORITE_ORE, "Gold Diorite Ore");
        addBlock(ModBlocks.GOLD_GRANITE_ORE, "Gold Granite Ore");
        addBlock(ModBlocks.LUCKY_EMERALD_ORE, "Lucky Emerald Ore");
        addBlock(ModBlocks.COAL_ANDERSITE_ORE, "Coal Andersite Ore");
        addBlock(ModBlocks.COAL_DIORITE_ORE, "Coal Diorite Ore");
        addBlock(ModBlocks.COAL_GRANITE_ORE, "Coal Granite Ore");

        // Enchantments
        addEnchantment(ModEnchantments.LUCKY, "Lucky");

        // Enchantment Descriptions
        addEnchantmentDescription(ModEnchantments.LUCKY, "Increases the yield of the Lucky Ores");
    }

    public void addEnchantmentDescription(Supplier<? extends Enchantment> key, String name) {
        add(key.get() + ".desc", name);
    }
}
