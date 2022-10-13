package drunkblood.luckyore.loot;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import drunkblood.luckyore.util.LuckyOreConstants;
import drunkblood.luckyore.registries.ModBlocks;
import drunkblood.luckyore.registries.ModGlobalLootModifiers;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class LuckyBonusModifier extends LootModifier {

	protected LuckyBonusModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	public static RegistryObject<Codec<LuckyBonusModifier>> registerCodec(final DeferredRegister<Codec<? extends IGlobalLootModifier>> REG){
		return REG.register("lucky_bonus", () ->
				RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, LuckyBonusModifier::new)
				));
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ItemStack tool = context.getParam(LootContextParams.TOOL);
		RandomSource random = context.getRandom();
		int increasedDrops = LuckyOreConstants.general_increased_drops;
		if (tool != null) {
			BlockState state = context.getParam(LootContextParams.BLOCK_STATE);
			if (state != null) {
				if (ModBlocks.LUCKY_EMERALD_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_emerald_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_lapis_ore_increased_drops;
				} else if (ModBlocks.LUCKY_LAPIS_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_redstone_ore_increased_drops;
				} else if (ModBlocks.LUCKY_DIAMOND_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_diamond_ore_increased_drops;
				} else if (ModBlocks.LUCKY_IRON_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_iron_ore_increased_drops;
				} else if (ModBlocks.LUCKY_COPPER_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_copper_ore_increased_drops;
				} else if (ModBlocks.LUCKY_GOLD_ORE.get().defaultBlockState().equals(state)) {
					increasedDrops += LuckyOreConstants.lucky_gold_ore_increased_drops;
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



	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return ModGlobalLootModifiers.LUCKY_BONUS.get();
	}

}
