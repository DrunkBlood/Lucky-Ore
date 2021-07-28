package drunkblood.luckyore.loot;

import java.util.List;

import com.google.gson.JsonObject;

import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class ZombieDustModifier extends LootModifier {

	protected ZombieDustModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Override
	@Nonnull
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		/*
		 * "condition": "minecraft:random_chance_with_looting", "chance": 0.025,
		 * "looting_multiplier": 0.01
		 * 
		 * int i = p_test_1_.getLootingModifier(); return
		 * p_test_1_.getRandom().nextFloat() < this.chance + (float)i *
		 * this.lootingMultiplier;
		 */
		Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
		if (entity instanceof Zombie) {
			int i = context.getLootingModifier();
			if (context.getRandom().nextFloat() < LuckyOreConfig.zombie_dust_drop_chance
					+ (float) i * LuckyOreConfig.zombie_dust_looting_multiplier) {
				generatedLoot.add(new ItemStack(ModItems.LUCKY_DUST.get(), 1));
			}
		}
		
		 

		return generatedLoot;
	}

	public static class Serializer extends GlobalLootModifierSerializer<ZombieDustModifier> {

		@Override
		public ZombieDustModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditionsIn) {
			return new ZombieDustModifier(conditionsIn);
		}

		@Override
		public JsonObject write(ZombieDustModifier instance) {
			return makeConditions(instance.conditions);
		}
	}

}
