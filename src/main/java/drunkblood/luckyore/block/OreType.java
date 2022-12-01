package drunkblood.luckyore.block;

import net.minecraft.util.StringRepresentable;

public enum OreType implements StringRepresentable {
    NONE("none"),
    STONE("stone"),
    DEEPSLATE("deepslate"),
    DIORITE("diorite"),
    ANDERSITE("andersite"),
    GRANITE("granite");

    private final String name;

    OreType(String name){this.name = name;}



    @Override
    public String getSerializedName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getSerializedName();
    }
}
