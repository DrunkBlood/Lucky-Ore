package drunkblood.luckyore.block;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import drunkblood.luckyore.registries.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetherLuckyOre extends Block{

	public BlockNetherLuckyOre(Properties properties) {
		super(properties);
	}
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		super.onBlockHarvested(worldIn, pos, state, player);
		if(!worldIn.isRemote()) {
			Random random = worldIn.rand;
			ArrayList<BlockPos> netherrackNearby = new ArrayList<BlockPos>();
			
			for(int z = -1; z<2;z++) {
				for(int y = -1; y<2;y++) {
					for(int x = -1; x<2;x++) {
						BlockPos testBlock = new BlockPos(pos.getX() + x , pos.getY() + y , pos.getZ() + z);
						if(worldIn.getBlockState(testBlock).getBlock() == Blocks.NETHERRACK) {
							netherrackNearby.add(testBlock);
						}
					}
				}
			}
			// get enchantments
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(player.getHeldItemMainhand());
			boolean fortune = enchants.containsKey(Enchantments.FORTUNE);
			short fortuneLVL = fortune ? (short) enchants.get(Enchantments.FORTUNE).intValue() : 0;
			boolean silk = enchants.containsKey(Enchantments.SILK_TOUCH);
			boolean lucky = enchants.containsKey(ModEnchantments.LUCKY.get());
			//replace with Nether Ores
			if(!netherrackNearby.isEmpty() && !silk) {
				int amountConverted = random.nextInt(2 + (fortune ? fortuneLVL*2: 0)) + 2 + (lucky ? 2 : 0);
				while (amountConverted > 0 && !netherrackNearby.isEmpty()){
					BlockPos replacePos = netherrackNearby.get(random.nextInt(netherrackNearby.size()));
					netherrackNearby.remove(replacePos);
					int chosenBlock = random.nextInt(100) + 1;
					if (chosenBlock > 30) {
						worldIn.setBlockState(replacePos, Blocks.NETHER_QUARTZ_ORE.getDefaultState());
					} else {
						worldIn.setBlockState(replacePos, Blocks.field_235334_I_.getDefaultState());
					}
					amountConverted--;
				}
			}
		}
	}

}
