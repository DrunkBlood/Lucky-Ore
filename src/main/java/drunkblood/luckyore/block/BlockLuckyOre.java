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

public class BlockLuckyOre extends Block{

	public BlockLuckyOre(Properties properties) {
		super(properties);
	}
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
	      //worldIn.playEvent(player, 2001, pos, getStateId(state));
		super.onBlockHarvested(worldIn, pos, state, player);
		if(!worldIn.isRemote()) {
			Random random = worldIn.rand;
			ArrayList<BlockPos> stoneNearby = new ArrayList<BlockPos>();
			for(int z = -1; z<2;z++) {
				for(int y = -1; y<2;y++) {
					for(int x = -1; x<2;x++) {
						BlockPos testBlock = new BlockPos(pos.getX() + x , pos.getY() + y , pos.getZ() + z);
						if(worldIn.getBlockState(testBlock).getBlock() == Blocks.STONE) {
							stoneNearby.add(testBlock);
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
			//Replace Blocks by distribution
			if(!stoneNearby.isEmpty() && pos.getY() <= 120 && pos.getY() >= 5 && !silk) {
				int amountConverted = random.nextInt(2 + (fortune ? fortuneLVL*2: 0)) + 2;
				while (amountConverted > 0 && !stoneNearby.isEmpty()){
					BlockPos replacePos = stoneNearby.get(random.nextInt(stoneNearby.size()));
					stoneNearby.remove(replacePos);
					int chosenBlock = random.nextInt(100) + 1;
					if (lucky) {
						chosenBlock = Math.max(chosenBlock,random.nextInt(100)+1);
					}
					if (pos.getY() >= 60) {
						worldIn.setBlockState(replacePos, Blocks.COAL_ORE.getDefaultState());
					}
					else if (pos.getY() >= 30) {
						if(chosenBlock <= 50) {
							worldIn.setBlockState(replacePos, Blocks.COAL_ORE.getDefaultState());
						}else {
							worldIn.setBlockState(replacePos, Blocks.IRON_ORE.getDefaultState());
						}
					}
					else if (pos.getY() >= 15) {
						if(chosenBlock <= 25) {
							worldIn.setBlockState(replacePos, Blocks.COAL_ORE.getDefaultState());
						}else if (chosenBlock <= 75){
							worldIn.setBlockState(replacePos, Blocks.IRON_ORE.getDefaultState());
						}else if (chosenBlock <= 90) {
							worldIn.setBlockState(replacePos, Blocks.GOLD_ORE.getDefaultState());
						}else {
							worldIn.setBlockState(replacePos, Blocks.LAPIS_ORE.getDefaultState());
						}
					}
					else if (pos.getY() >= 5) {
						if(chosenBlock <= 20) {
							worldIn.setBlockState(replacePos, Blocks.COAL_ORE.getDefaultState());
						}else if (chosenBlock <= 60){
							worldIn.setBlockState(replacePos, Blocks.IRON_ORE.getDefaultState());
						}else if (chosenBlock <= 75) {
							worldIn.setBlockState(replacePos, Blocks.GOLD_ORE.getDefaultState());
						}else if (chosenBlock <= 82){
							worldIn.setBlockState(replacePos, Blocks.LAPIS_ORE.getDefaultState());
						}else if (chosenBlock <= 95) {
							worldIn.setBlockState(replacePos, Blocks.REDSTONE_ORE.getDefaultState());
						}else {
							worldIn.setBlockState(replacePos, Blocks.DIAMOND_ORE.getDefaultState());
						}
					}
					amountConverted--;
				}
			}
		}
	   }
}
