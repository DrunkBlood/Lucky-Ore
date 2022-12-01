package drunkblood.luckyore.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BlockLuckyBaseOre extends Block {
    public static final EnumProperty<OreType> ORE_TYPE = ModBlockProperties.ORE_TYPE;
    public BlockLuckyBaseOre(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ORE_TYPE, OreType.STONE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ORE_TYPE);
    }
}
