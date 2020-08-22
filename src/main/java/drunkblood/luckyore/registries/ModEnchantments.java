package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.enchantment.EnchantmentLucky;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantments {
	public static final DeferredRegister<Enchantment> REG = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
			LuckyOre.MODID);

	public static final RegistryObject<Enchantment> LUCKY = REG.register("ench_lucky",
			() -> new EnchantmentLucky(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));
}
