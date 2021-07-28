package drunkblood.luckyore.loot;


import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModBlocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class LuckyBonusModifier extends LootModifier {


	protected LuckyBonusModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		ItemStack tool = context.getParam(LootContextParams.TOOL);
		Random random = context.getRandom();
		int increasedDrops = LuckyOreConfig.general_increased_drops;
		if (tool != null) {
			BlockState state = context.getParam(LootContextParams.BLOCK_STATE);
			if (state != null) {
				if (ModBlocks.LUCKY_EMERALD_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_emerald_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_lapis_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_redstone_ore_increased_drops;
				} else if (ModBlocks.LUCKY_DIAMOND_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_diamond_ore_increased_drops;
				} else if (ModBlocks.LUCKY_IRON_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_iron_ore_increased_drops;
				} else if (ModBlocks.LUCKY_COPPER_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_copper_ore_increased_drops;
				} else if (ModBlocks.LUCKY_GOLD_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConfig.lucky_gold_ore_increased_drops;
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
		public LuckyBonusModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			return new LuckyBonusModifier(conditionsIn);
		}

		@Override
		public JsonObject write(LuckyBonusModifier instance) {
			return makeConditions(instance.conditions);
		}
	}
}
