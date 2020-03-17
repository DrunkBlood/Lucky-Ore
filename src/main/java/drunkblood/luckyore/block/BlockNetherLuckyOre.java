package drunkblood.luckyore.block;

import java.util.ArrayList;
import java.util.Random;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.LuckyOre.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.ListNBT;
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
			boolean fortune = false;
			short fortuneLVL = 0;
			boolean silk = false;
			boolean lucky = false;
			// Get tool enchantment
			ListNBT nbttaglist = player.getHeldItemMainhand().getEnchantmentTagList();
			if (nbttaglist != null)
	        {
	            for (int i = 0; i < nbttaglist.size(); ++i)
	            {
	                String enchantmentID = nbttaglist.getCompound(i).getString("id");
	                LuckyOre.LOGGER.debug(enchantmentID);
	                LuckyOre.LOGGER.debug(String.valueOf((Object)Enchantments.FORTUNE.getRegistryName()));

	                if (enchantmentID.equals(String.valueOf((Object)Enchantments.FORTUNE.getRegistryName())))
	                {
	                	fortune = true;
	                	fortuneLVL = nbttaglist.getCompound(i).getShort("lvl");
	                }
	                if (enchantmentID.contentEquals(String.valueOf((Object)Enchantments.SILK_TOUCH.getRegistryName()))) {
	                	silk = true;
	                }
	                if (enchantmentID.equals(String.valueOf((Object)ModEnchantments.ench_lucky.getRegistryName()))) {
	                	lucky = true;
	                }
	            }
	        }
			//replace with Nether Ores
			if(!netherrackNearby.isEmpty() && !silk) {
				int amountConverted = random.nextInt(2 + (fortune ? fortuneLVL*2: 0)) + 2 + (lucky ? 2 : 0);
				while (amountConverted > 0 && !netherrackNearby.isEmpty()){
					BlockPos replacePos = netherrackNearby.get(random.nextInt(netherrackNearby.size()));
					netherrackNearby.remove(replacePos);
					//int chosenBlock = random.nextInt(100) + 1;
					if (true) {
						worldIn.setBlockState(replacePos, Blocks.NETHER_QUARTZ_ORE.getDefaultState());
					}
					amountConverted--;
				}
			}
		}
	}

}
