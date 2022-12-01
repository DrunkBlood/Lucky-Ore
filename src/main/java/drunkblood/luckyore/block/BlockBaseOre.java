package drunkblood.luckyore.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BlockBaseOre extends Block{
    public static final EnumProperty<OreTypeVariant> ORE_TYPE_VARIANT = ModBlockProperties.ORE_TYPE_VARIANT;
    public BlockBaseOre(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ORE_TYPE_VARIANT, OreTypeVariant.ANDERSITE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ORE_TYPE_VARIANT);
    }
}
