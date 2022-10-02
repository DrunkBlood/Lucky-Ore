package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        addBasicBlockWithItemModels(ModBlocks.DEEPSLATE_LUCKY_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_COPPER_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_DIAMOND_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_EMERALD_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_GOLD_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_IRON_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_LAPIS_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_ORE);
        addBasicBlockWithItemModels(ModBlocks.LUCKY_REDSTONE_ORE);
        addBasicBlockWithItemModels(ModBlocks.NETHER_LUCKY_ORE);
    }

    private void addBasicBlockWithItemModels(Supplier<? extends Block> block){
        Block block1 = block.get();
        ModelFile modelFile = cubeAll(block1);
        simpleBlock(block1, modelFile);
        simpleBlockItem(block1, modelFile);
    }
}
