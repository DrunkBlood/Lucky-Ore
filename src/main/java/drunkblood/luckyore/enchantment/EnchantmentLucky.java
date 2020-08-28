package drunkblood.luckyore.enchantment;

import drunkblood.luckyore.config.LuckyOreConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class EnchantmentLucky extends Enchantment{

	public EnchantmentLucky(Rarity rarityIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentType.DIGGER, slots);
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
	    return enchantmentLevel * 25;
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
	   return this.getMinEnchantability(enchantmentLevel) + 50;
	}
	@Override
	public boolean canApplyTogether(Enchantment ench) {
	   return super.canApplyTogether(ench) && ench != Enchantments.SILK_TOUCH;
	}

	@Override
	public boolean isTreasureEnchantment() {
		return true;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return LuckyOreConfig.lucky_enchantment_enabled;
	}
}
