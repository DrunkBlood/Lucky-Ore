package drunkblood.luckyore.block;

import net.minecraft.util.StringRepresentable;

public enum OreTypeVariant implements StringRepresentable {
    NONE("none"),
    DIORITE("diorite"),
    ANDERSITE("andersite"),
    GRANITE("granite");

    private final String name;

    OreTypeVariant(String name){this.name = name;}



    @Override
    public String getSerializedName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getSerializedName();
    }
}