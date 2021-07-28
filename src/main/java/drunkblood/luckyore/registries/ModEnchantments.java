package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.enchantment.EnchantmentLucky;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
	public static final DeferredRegister<Enchantment> REG = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
			LuckyOre.MODID);

	public static final RegistryObject<Enchantment> LUCKY = REG.register("ench_lucky",
			() -> new EnchantmentLucky(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
}
