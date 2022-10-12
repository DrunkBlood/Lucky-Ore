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
                ModBlocks.DIAMOND_ANDERSITE_ORE,
                ModBlocks.DIAMOND_DIORITE_ORE,
                ModBlocks.DIAMOND_GRANITE_ORE,
                ModBlocks.LUCKY_REDSTONE_ORE,
                ModBlocks.REDSTONE_ANDERSITE_ORE,
                ModBlocks.REDSTONE_DIORITE_ORE,
                ModBlocks.REDSTONE_GRANITE_ORE,
                ModBlocks.LUCKY_EMERALD_ORE,
                ModBlocks.LUCKY_GOLD_ORE,
                ModBlocks.GOLD_ANDERSITE_ORE,
                ModBlocks.GOLD_DIORITE_ORE,
                ModBlocks.GOLD_GRANITE_ORE
        );
        addTagsByProvider(BlockTags.NEEDS_STONE_TOOL,
                ModBlocks.LUCKY_IRON_ORE,
                ModBlocks.IRON_ANDERSITE_ORE,
                ModBlocks.IRON_DIORITE_ORE,
                ModBlocks.IRON_GRANITE_ORE,
                ModBlocks.LUCKY_COPPER_ORE,
                ModBlocks.COPPER_DIORITE_ORE,
                ModBlocks.COPPER_ANDERSITE_ORE,
                ModBlocks.COPPER_GRANITE_ORE,
                ModBlocks.NETHER_LUCKY_ORE,
                ModBlocks.LUCKY_ANDERSITE_ORE,
                ModBlocks.LUCKY_GRANITE_ORE,
                ModBlocks.LUCKY_DIORITE_ORE,
                ModBlocks.DEEPSLATE_LUCKY_ORE,
                ModBlocks.LUCKY_ORE);
        addTagsByProvider(BlockTags.MINEABLE_WITH_PICKAXE,
                ModBlocks.LUCKY_IRON_ORE,
                ModBlocks.IRON_ANDERSITE_ORE,
                ModBlocks.IRON_DIORITE_ORE,
                ModBlocks.IRON_GRANITE_ORE,
                ModBlocks.LUCKY_COPPER_ORE,
                ModBlocks.COPPER_DIORITE_ORE,
                ModBlocks.COPPER_ANDERSITE_ORE,
                ModBlocks.COPPER_GRANITE_ORE,
                ModBlocks.NETHER_LUCKY_ORE,
                ModBlocks.LUCKY_ANDERSITE_ORE,
                ModBlocks.LUCKY_GRANITE_ORE,
                ModBlocks.LUCKY_DIORITE_ORE,
                ModBlocks.DEEPSLATE_LUCKY_ORE,
                ModBlocks.LUCKY_ORE,
                ModBlocks.LUCKY_DIAMOND_ORE,
                ModBlocks.DIAMOND_ANDERSITE_ORE,
                ModBlocks.DIAMOND_DIORITE_ORE,
                ModBlocks.DIAMOND_GRANITE_ORE,
                ModBlocks.LUCKY_REDSTONE_ORE,
                ModBlocks.REDSTONE_ANDERSITE_ORE,
                ModBlocks.REDSTONE_DIORITE_ORE,
                ModBlocks.REDSTONE_GRANITE_ORE,
                ModBlocks.LUCKY_EMERALD_ORE,
                ModBlocks.LUCKY_GOLD_ORE,
                ModBlocks.GOLD_ANDERSITE_ORE,
                ModBlocks.GOLD_DIORITE_ORE,
                ModBlocks.GOLD_GRANITE_ORE);
    }

    private void addTagsByProvider(TagKey<Block> tag, Supplier<? extends Block>... blocks){
        TagAppender<Block> blockTagAppender = this.tag(tag);
        Arrays.stream(blocks).map(Supplier::get).forEach(blockTagAppender::add);
    }

}
