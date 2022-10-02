package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> fr) {
        // Upgrades
        addUpgradeRecipe(fr, Items.DIAMOND_ORE, ModItems.LUCKY_DIAMOND_ORE);
        addUpgradeRecipe(fr, Items.EMERALD_ORE, ModItems.LUCKY_EMERALD_ORE);
        addUpgradeRecipe(fr, Items.REDSTONE_ORE, ModItems.LUCKY_REDSTONE_ORE);
        addUpgradeRecipe(fr, Items.LAPIS_ORE, ModItems.LUCKY_LAPIS_ORE);
        addUpgradeRecipe(fr, Items.COPPER_ORE, ModItems.LUCKY_COPPER_ORE);
        addUpgradeRecipe(fr, Items.IRON_ORE, ModItems.LUCKY_IRON_ORE);
        addUpgradeRecipe(fr, Items.GOLD_ORE, ModItems.LUCKY_GOLD_ORE);
        addUpgradeRecipe(fr, Items.NETHERRACK, ModItems.NETHER_LUCKY_ORE);
    }

    private void addUpgradeRecipe(Consumer<FinishedRecipe> finishedRecipe, ItemLike source, Supplier<? extends Item> upgraded){
        ShapedRecipeBuilder
                .shaped(upgraded.get())
                .define('a', source)
                .define('x', ModItems.LUCKY_DUST.get())
                .pattern(" x ")
                .pattern("xax")
                .pattern(" x ")
                .unlockedBy("has_lucky", has(ModItems.LUCKY_DUST.get()))
                .save(finishedRecipe);
    }
}
