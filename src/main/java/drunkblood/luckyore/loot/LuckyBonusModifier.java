package drunkblood.luckyore.loot;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class LuckyBonusModifier extends LootModifier {


	protected LuckyBonusModifier(ILootCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		ItemStack tool = context.get(LootParameters.TOOL);
		Random random = context.getRandom();
		int increasedDrops = LuckyOreConfig.general_increased_drops;
		if (tool != null) {
			BlockState state = context.get(LootParameters.BLOCK_STATE);
			if (state != null) {
				if (ModBlocks.LUCKY_EMERALD_ORE.get().getDefaultState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_emerald_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().getDefaultState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_lapis_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().getDefaultState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_redstone_ore_increased_drops;
				} else if (ModBlocks.LUCKY_DIAMOND_ORE.get().getDefaultState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_diamond_ore_increased_drops;
				}
			}
			for (ItemStack stack : generatedLoot) {
				int bonus = 0;
				int cap = (int) (Math.log(increasedDrops * 4 + 1) / Math.log(2)) + 4;
				for (int i = 0; i < cap; i++) {
					if (random.nextFloat() < 0.75f) {
						bonus++;
					}
				}
				stack.setCount(stack.getCount() + increasedDrops + bonus);
			}

		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<LuckyBonusModifier> {

		@Override
		public LuckyBonusModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
			return new LuckyBonusModifier(conditionsIn);
		}
	}
}
