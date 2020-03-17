package drunkblood.luckyore.loot.function;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.LuckyOre.ModEnchantments;

import java.util.Random;
import java.util.Set;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootFunction;
import net.minecraft.world.storage.loot.LootParameter;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;

public class ApplyLuckyBonus extends LootFunction {
   private int increasedDrops;
   private ApplyLuckyBonus(ILootCondition[] conditionsIn, int drops) {
      super(conditionsIn);
      this.increasedDrops = drops;
   }

   public Set<LootParameter<?>> getRequiredParameters() {
      return ImmutableSet.of(LootParameters.TOOL);
   }

   public ItemStack doApply(ItemStack stack, LootContext context) {
      ItemStack itemstack = context.get(LootParameters.TOOL);
      if (itemstack != null) {
        ListNBT nbttaglist = itemstack.getEnchantmentTagList();
        Random random = context.getRandom();
        boolean lucky = false;
        boolean fortune = false;
        short fortunelvl = 0;
		if (nbttaglist != null)
	        {
	            for (int i1 = 0; i1 < nbttaglist.size(); ++i1)
	            {
	                String enchantmentID = nbttaglist.getCompound(i1).getString("id");

	                if (enchantmentID.equals(String.valueOf((Object)ModEnchantments.ench_lucky.getRegistryName()))) {
	                	lucky = true;
	                }
	                if (enchantmentID.equals(String.valueOf((Object)Enchantments.FORTUNE.getRegistryName()))){
	                	fortune = true;
	                	fortunelvl = nbttaglist.getCompound(i1).getShort("lvl");
	                }
	            }
	        }
		int roll1 = increasedDrops + 3 + random.nextInt(5 + (fortune ? 2*fortunelvl : 0));
		if(lucky) {
			int roll2 = increasedDrops + 3 + random.nextInt(5 + (fortune ? 2*fortunelvl : 0));
			roll1 = Math.max(roll1, roll2);
		}
        stack.setCount(roll1);
      }

      return stack;
   }

   public static LootFunction.Builder<?> build(int drops) {
      return builder((context) -> {
         return new ApplyLuckyBonus(context, drops);
      });
   }

   public static class Serializer extends LootFunction.Serializer<ApplyLuckyBonus> {
      public Serializer() {
         super(new ResourceLocation(LuckyOre.MODID,"apply_lucky_bonus"), ApplyLuckyBonus.class);
      }

	public void serialize(JsonObject object, ApplyLuckyBonus functionClazz, JsonSerializationContext serializationContext) {
         super.serialize(object, functionClazz, serializationContext);
         object.add("incdrops", serializationContext.serialize(functionClazz.increasedDrops));
      }

	public ApplyLuckyBonus deserialize(JsonObject object, JsonDeserializationContext deserializationContext, ILootCondition[] conditionsIn) {
         int drops = JSONUtils.getInt(object, "incdrops");
		 return new ApplyLuckyBonus(conditionsIn, drops);
      }
   }

}