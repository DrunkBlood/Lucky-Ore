package drunkblood.luckyore.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class EnchantmentLucky extends Enchantment {

	public EnchantmentLucky(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
		super(rarity, enchantmentCategory, equipmentSlots);
	}


	@Override
	public int getMinCost(int enchantmentLevel) {
		return enchantmentLevel * 25;
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return this.getMinCost(enchantmentLevel) + 50;
	}

	@Override
	public boolean checkCompatibility(Enchantment ench) {
		return super.checkCompatibility(ench) && ench != Enchantments.SILK_TOUCH;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
}
