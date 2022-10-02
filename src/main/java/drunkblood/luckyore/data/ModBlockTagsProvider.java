package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator p_126511_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        addTagsByProvider(BlockTags.NEEDS_IRON_TOOL,
                ModBlocks.LUCKY_DIAMOND_ORE,
                ModBlocks.LUCKY_REDSTONE_ORE,
                ModBlocks.LUCKY_EMERALD_ORE,
                ModBlocks.LUCKY_GOLD_ORE);
        addTagsByProvider(BlockTags.NEEDS_STONE_TOOL,
                ModBlocks.LUCKY_IRON_ORE,
                ModBlocks.LUCKY_COPPER_ORE,
                ModBlocks.NETHER_LUCKY_ORE,
                ModBlocks.DEEPSLATE_LUCKY_ORE,
                ModBlocks.LUCKY_ORE);
        addTagsByProvider(BlockTags.MINEABLE_WITH_PICKAXE,
                ModBlocks.LUCKY_IRON_ORE,
                ModBlocks.LUCKY_COPPER_ORE,
                ModBlocks.NETHER_LUCKY_ORE,
                ModBlocks.DEEPSLATE_LUCKY_ORE,
                ModBlocks.LUCKY_ORE,
                ModBlocks.LUCKY_DIAMOND_ORE,
                ModBlocks.LUCKY_REDSTONE_ORE,
                ModBlocks.LUCKY_EMERALD_ORE,
                ModBlocks.LUCKY_GOLD_ORE);
    }

    private void addTagsByProvider(TagKey<Block> tag, Supplier<? extends Block>... blocks){
        TagAppender<Block> blockTagAppender = this.tag(tag);
        Arrays.stream(blocks).map(Supplier::get).forEach(blockTagAppender::add);
    }

}
