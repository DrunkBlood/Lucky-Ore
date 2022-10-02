package drunkblood.luckyore.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import drunkblood.luckyore.config.LuckyOreConfig;
import drunkblood.luckyore.registries.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ZombieDustModifier extends LootModifier {

	protected ZombieDustModifier(LootItemCondition[] conditionsIn) {
		super(conditionsIn);
	}

	public static RegistryObject<Codec<ZombieDustModifier>> registerCodec(final DeferredRegister<Codec<? extends IGlobalLootModifier>> REG) {
		return REG.register("zombie_dust", () ->
				RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, ZombieDustModifier::new)
				));
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
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

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return null;
	}


}
