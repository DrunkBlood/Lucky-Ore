package drunkblood.luckyore.loot;

import java.util.List;

import com.google.gson.JsonObject;

import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class ZombieDustModifier extends LootModifier {

	protected ZombieDustModifier(ILootCondition[] conditionsIn) {
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
		Entity entity = context.get(LootParameters.THIS_ENTITY);
		if (entity instanceof ZombieEntity) {
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
		public ZombieDustModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
			return new ZombieDustModifier(conditionsIn);
		}

		@Override
		public JsonObject write(ZombieDustModifier instance) {
			return makeConditions(instance.conditions);
		}
	}

}
