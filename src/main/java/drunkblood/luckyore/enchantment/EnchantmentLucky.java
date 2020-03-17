package drunkblood.luckyore.enchantment;

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
	public boolean isTreasureEnchantment() {
	   return true;
	}
	@Override
	public int getMaxLevel() {
	   return 1;
	}
	@Override
	public boolean canApplyTogether(Enchantment ench) {
	   return super.canApplyTogether(ench) && ench != Enchantments.SILK_TOUCH;
	}
}
