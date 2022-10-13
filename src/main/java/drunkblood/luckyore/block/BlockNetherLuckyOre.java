package drunkblood.luckyore.block;

import java.util.ArrayList;
import java.util.Map;

import drunkblood.luckyore.registries.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class BlockNetherLuckyOre extends Block {


	public BlockNetherLuckyOre(Properties properties) {
		super(properties);
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		super.playerWillDestroy(level, pos, state, player);
		if(!level.isClientSide()) {
			RandomSource random = level.random;
			ArrayList<BlockPos> netherrackNearby = new ArrayList<>();
			
			for(int z = -1; z<2;z++) {
				for(int y = -1; y<2;y++) {
					for(int x = -1; x<2;x++) {
						BlockPos testBlock = new BlockPos(pos.getX() + x , pos.getY() + y , pos.getZ() + z);
						if(level.getBlockState(testBlock).getBlock() == Blocks.NETHERRACK) {
							netherrackNearby.add(testBlock);
						}
					}
				}
			}
			// get enchantments
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(player.getMainHandItem());
			boolean fortune = enchants.containsKey(Enchantments.BLOCK_FORTUNE);
			short fortuneLVL = fortune ? (short) enchants.get(Enchantments.BLOCK_FORTUNE).intValue() : 0;
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
						level.setBlockAndUpdate(replacePos, Blocks.NETHER_QUARTZ_ORE.defaultBlockState());
					} else {
						level.setBlockAndUpdate(replacePos, Blocks.NETHER_GOLD_ORE.defaultBlockState());
					}
					amountConverted--;
				}
			}
		}
	}

}
