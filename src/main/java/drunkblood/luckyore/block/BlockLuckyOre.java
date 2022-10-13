package drunkblood.luckyore.block;

import drunkblood.luckyore.registries.ModEnchantments;
import drunkblood.luckyore.util.OreBlockPicker;
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

import java.util.ArrayList;
import java.util.Map;


public class BlockLuckyOre extends Block {

	public BlockLuckyOre(Properties properties) {
		super(properties);
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
	      //level.playEvent(player, 2001, pos, getStateId(state));
		super.playerWillDestroy(level, pos, state, player);
		if(!level.isClientSide()) {
			// get enchantments
			Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(player.getMainHandItem());
			// early return
			boolean silk = enchants.containsKey(Enchantments.SILK_TOUCH);
			if(silk) return;
			boolean fortune = enchants.containsKey(Enchantments.BLOCK_FORTUNE);
			short fortuneLVL = fortune ? (short) enchants.get(Enchantments.BLOCK_FORTUNE).intValue() : 0;
			boolean lucky = enchants.containsKey(ModEnchantments.LUCKY.get());
			RandomSource random = level.random;
			ArrayList<OreBlockPicker.ReplacementPos> replacements = new ArrayList<>();
			BlockPos.MutableBlockPos testBlock = new BlockPos.MutableBlockPos();
			int xPos = pos.getX();
			int yPos = pos.getY();
			int zPos = pos.getZ();
			for(int z = -1; z<2;z++) {
				for(int y = -1; y<2;y++) {
					for(int x = -1; x<2;x++) {
						testBlock.set(xPos + x, yPos + y, zPos + z);
						Block block = level.getBlockState(testBlock).getBlock();
						if(block == Blocks.STONE) {
							replacements.add(new OreBlockPicker.ReplacementPos(testBlock, OreBlockPicker.ReplacementType.STONE));
						} else if(block == Blocks.DEEPSLATE){
							replacements.add(new OreBlockPicker.ReplacementPos(testBlock, OreBlockPicker.ReplacementType.DEEPSLATE));
						} else if(block == Blocks.DIORITE){
							replacements.add(new OreBlockPicker.ReplacementPos(testBlock, OreBlockPicker.ReplacementType.DIORITE));
						} else if(block == Blocks.ANDESITE){
							replacements.add(new OreBlockPicker.ReplacementPos(testBlock, OreBlockPicker.ReplacementType.ANDERSITE));
						} else if(block == Blocks.GRANITE){
							replacements.add(new OreBlockPicker.ReplacementPos(testBlock, OreBlockPicker.ReplacementType.GRANITE));
						}
					}
				}
			}
			if(replacements.isEmpty()) return;

			//Replace Blocks by distribution
			int amountConverted = random.nextInt(2 + (fortune ? fortuneLVL * 2: 0)) + 2;
			while (amountConverted > 0 && !replacements.isEmpty()){
				// get random pos
				OreBlockPicker.ReplacementPos replacePos = replacements.get(random.nextInt(replacements.size()));
				replacements.remove(replacePos);

				// roll the dice
				BlockState replacement = OreBlockPicker.chooseBlock(random, yPos, replacePos, lucky);
				level.setBlockAndUpdate(replacePos, replacement);
				--amountConverted;
			}
		}
	   }
}
