package drunkblood.luckyore.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockProperties {
    public static final EnumProperty<OreType> ORE_TYPE = EnumProperty.create("ore_tyoe", OreType.class);
    public static final EnumProperty<OreTypeVariant> ORE_TYPE_VARIANT = EnumProperty.create("ore_tyoe_rare", OreTypeVariant.class);
}
