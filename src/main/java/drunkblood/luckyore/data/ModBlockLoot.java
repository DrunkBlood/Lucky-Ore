package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.registries.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLoot extends BlockLoot {
    @Override
    protected void addTables() {
        this.add(ModBlocks.LUCKY_ORE.get(), (p_124187_) -> createSingleItemTableWithSilkTouch(p_124187_, ModItems.LUCKY_DUST.get()));
        this.add(ModBlocks.DEEPSLATE_LUCKY_ORE.get(), (p_124187_) -> createSingleItemTableWithSilkTouch(p_124187_, ModItems.LUCKY_DUST.get()));
        this.add(ModBlocks.LUCKY_ANDERSITE_ORE.get(), (p_124187_) -> createSingleItemTableWithSilkTouch(p_124187_, ModItems.LUCKY_DUST.get()));
        this.add(ModBlocks.LUCKY_DIORITE_ORE.get(), (p_124187_) -> createSingleItemTableWithSilkTouch(p_124187_, ModItems.LUCKY_DUST.get()));
        this.add(ModBlocks.LUCKY_GRANITE_ORE.get(), (p_124187_) -> createSingleItemTableWithSilkTouch(p_124187_, ModItems.LUCKY_DUST.get()));

        this.add(ModBlocks.NETHER_LUCKY_ORE.get(), (BlockLoot::createSilkTouchOnlyTable));

        this.add(ModBlocks.LUCKY_COPPER_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.RAW_COPPER, 4, 0.5f)));
        this.add(ModBlocks.LUCKY_DIAMOND_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.DIAMOND, 4, 0.55f)));
        this.add(ModBlocks.LUCKY_EMERALD_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.EMERALD, 4, 0.55f)));
        this.add(ModBlocks.LUCKY_GOLD_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.RAW_GOLD, 6, 0.4f)));
        this.add(ModBlocks.LUCKY_IRON_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.RAW_IRON, 3, 0.75f)));
        this.add(ModBlocks.LUCKY_LAPIS_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.LAPIS_LAZULI, 15, 0.55f)));
        this.add(ModBlocks.LUCKY_REDSTONE_ORE.get(), (block -> createEnhancedLuckyOreTable(block, Items.REDSTONE, 9, 0.6f)));

        this.add(ModBlocks.COAL_ANDERSITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.COAL));
        this.add(ModBlocks.COAL_GRANITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.COAL));
        this.add(ModBlocks.COAL_DIORITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.COAL));

        this.add(ModBlocks.COPPER_DIORITE_ORE.get(), BlockLoot::createCopperOreDrops);
        this.add(ModBlocks.COPPER_GRANITE_ORE.get(), BlockLoot::createCopperOreDrops);
        this.add(ModBlocks.COPPER_ANDERSITE_ORE.get(), BlockLoot::createCopperOreDrops);

        this.add(ModBlocks.IRON_DIORITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_IRON));
        this.add(ModBlocks.IRON_ANDERSITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_IRON));
        this.add(ModBlocks.IRON_GRANITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_IRON));

        this.add(ModBlocks.GOLD_ANDERSITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_GOLD));
        this.add(ModBlocks.GOLD_GRANITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_GOLD));
        this.add(ModBlocks.GOLD_DIORITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.RAW_GOLD));

        this.add(ModBlocks.LAPIS_ANDERSITE_ORE.get(), BlockLoot::createLapisOreDrops);
        this.add(ModBlocks.LAPIS_GRANITE_ORE.get(), BlockLoot::createLapisOreDrops);
        this.add(ModBlocks.LAPIS_DIORITE_ORE.get(), BlockLoot::createLapisOreDrops);

        this.add(ModBlocks.DIAMOND_GRANITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.DIAMOND));
        this.add(ModBlocks.DIAMOND_DIORITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.DIAMOND));
        this.add(ModBlocks.DIAMOND_ANDERSITE_ORE.get(), (p_124080_) -> createOreDrop(p_124080_, Items.DIAMOND));

        this.add(ModBlocks.REDSTONE_DIORITE_ORE.get(), BlockLoot::createRedstoneOreDrops);
        this.add(ModBlocks.REDSTONE_GRANITE_ORE.get(), BlockLoot::createRedstoneOreDrops);
        this.add(ModBlocks.REDSTONE_ANDERSITE_ORE.get(), BlockLoot::createRedstoneOreDrops);

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.REG.getEntries().stream().map(RegistryObject::get).toList();
    }

    protected static LootTable.Builder createEnhancedLuckyOreTable(Block block, Item drop, int extra, float prob) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(drop)).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, prob, extra)));
    }
}
