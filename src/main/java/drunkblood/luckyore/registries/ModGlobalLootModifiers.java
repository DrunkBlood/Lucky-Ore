package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.loot.LuckyBonusModifier;
import drunkblood.luckyore.loot.ZombieDustModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGlobalLootModifiers {
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> REG = DeferredRegister
			.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, LuckyOre.MODID);

	public static final RegistryObject<GlobalLootModifierSerializer<LuckyBonusModifier>> LUCKY_BONUS = REG
			.register("lucky_bonus", () -> new LuckyBonusModifier.Serializer());
	public static final RegistryObject<GlobalLootModifierSerializer<ZombieDustModifier>> ZOMBIE_DUST = REG
			.register("zombie_dust", () -> new ZombieDustModifier.Serializer());

}
