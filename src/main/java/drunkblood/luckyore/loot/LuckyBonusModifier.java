package drunkblood.luckyore.loot;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class LuckyBonusModifier extends LootModifier {

	private int increasedDrops;

	protected LuckyBonusModifier(ILootCondition[] conditionsIn, int increasedDrops) {
		super(conditionsIn);
		this.increasedDrops = increasedDrops;
	}

	@Nonnull
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		ItemStack tool = context.get(LootParameters.TOOL);
		Random random = context.getRandom();
		if (tool != null) {
			int fortuneLvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, tool);
			for (ItemStack stack : generatedLoot) {
				int roll1 = increasedDrops + 3 + random.nextInt(5 + fortuneLvl * 2);
				int roll2 = increasedDrops + 3 + random.nextInt(5 + fortuneLvl * 2);
				roll1 = Math.max(roll1, roll2);
				stack.setCount(roll1);
			}
		}
		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<LuckyBonusModifier> {

		@Override
		public LuckyBonusModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
			int increasedDrops = JSONUtils.getInt(object, "increasedDrops");

			return new LuckyBonusModifier(conditionsIn, increasedDrops);
		}
	}
}
