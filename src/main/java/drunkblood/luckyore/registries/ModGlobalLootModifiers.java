package drunkblood.luckyore.registries;

import com.mojang.serialization.Codec;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.loot.LuckyBonusModifier;
import drunkblood.luckyore.loot.ZombieDustModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModGlobalLootModifiers {
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REG = DeferredRegister
			.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, LuckyOre.MODID);
	public static final RegistryObject<Codec<LuckyBonusModifier>> LUCKY_BONUS = LuckyBonusModifier.registerCodec(REG);
	public static final RegistryObject<Codec<ZombieDustModifier>> ZOMBIE_DUST = ZombieDustModifier.registerCodec(REG);

}
