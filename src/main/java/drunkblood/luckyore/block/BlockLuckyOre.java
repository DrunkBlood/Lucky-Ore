package drunkblood.luckyore.block;

import drunkblood.luckyore.registries.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
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
import java.util.Random;


public class BlockLuckyOre extends Block {

	enum ReplacementType{
		DEEPSLATE,
		STONE
	}

	static class ReplacementPos extends BlockPos{

		private final ReplacementType replacementType;

		public ReplacementPos(Vec3i vec3, ReplacementType replacementType) {
			super(vec3);
			this.replacementType = replacementType;
		}
	}

	public BlockLuckyOre(Properties properties) {
		super(properties);
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
	      //level.playEvent(player, 2001, pos, getStateId(state));
		super.playerWillDestroy(level, pos, state, player);
		if(!level.isClientSide()) {
			RandomSource random = level.random;
			ArrayList<ReplacementPos> replacements = new ArrayList<>();
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
							replacements.add(new ReplacementPos(testBlock, ReplacementType.STONE));
						} else if(block == Blocks.DEEPSLATE){
							replacements.add(new ReplacementPos(testBlock, ReplacementType.DEEPSLATE));
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
			// early return
			if(silk || replacements.isEmpty()) return;

			//Replace Blocks by distribution
			int amountConverted = random.nextInt(2 + (fortune ? fortuneLVL *2: 0)) + 2;
			while (amountConverted > 0 && !replacements.isEmpty()){
				// get random pos
				ReplacementPos replacePos = replacements.get(random.nextInt(replacements.size()));
				replacements.remove(replacePos);

				// roll the dice
				int chosenBlock = random.nextInt(100) + 1;
				if (lucky) {
					// roll twice and choose better
					chosenBlock = Math.max(chosenBlock, random.nextInt(100)+1);
				}

				// replace Block
				replaceBlock(level, replacePos, yPos, chosenBlock);
				--amountConverted;
			}
		}
	   }

	private void replaceBlock(Level level, ReplacementPos replacePos, int yPos, int chosenBlock) {
		if (yPos >= 60) {
			level.setBlockAndUpdate(replacePos, getCoal(replacePos.replacementType));
		}
		else if (yPos >= 30) {
			if(chosenBlock <= 33) {
				level.setBlockAndUpdate(replacePos, getCoal(replacePos.replacementType));
			}else if(chosenBlock <= 67){
				level.setBlockAndUpdate(replacePos, getIron(replacePos.replacementType));
			} else {
				level.setBlockAndUpdate(replacePos, getCopper(replacePos.replacementType));
			}
		}
		else if (yPos >= 15) {
			if(chosenBlock <= 25) {
				level.setBlockAndUpdate(replacePos, getCoal(replacePos.replacementType));
			}else if (chosenBlock <= 50){
				level.setBlockAndUpdate(replacePos, getCopper(replacePos.replacementType));
			}else if (chosenBlock <= 80){
				level.setBlockAndUpdate(replacePos, getIron(replacePos.replacementType));
			}else if (chosenBlock <= 90) {
				level.setBlockAndUpdate(replacePos, getGold(replacePos.replacementType));
			}else {
				level.setBlockAndUpdate(replacePos, getLapis(replacePos.replacementType));
			}
		}
		else if (yPos >= 5) {
			if(chosenBlock <= 20) {
				level.setBlockAndUpdate(replacePos, getCoal(replacePos.replacementType));
			}else if (chosenBlock <= 60){
				level.setBlockAndUpdate(replacePos, getIron(replacePos.replacementType));
			}else if (chosenBlock <= 75) {
				level.setBlockAndUpdate(replacePos, getGold(replacePos.replacementType));
			}else if (chosenBlock <= 82){
				level.setBlockAndUpdate(replacePos, getLapis(replacePos.replacementType));
			}else if (chosenBlock <= 95) {
				level.setBlockAndUpdate(replacePos, getRedstone(replacePos.replacementType));
			}else {
				level.setBlockAndUpdate(replacePos, getDiamond(replacePos.replacementType));
			}
		}
	}

	private BlockState getCoal(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.COAL_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_COAL_ORE.defaultBlockState();}
			default -> {return Blocks.COAL_ORE.defaultBlockState();}
		}
	}

	private BlockState getIron(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.IRON_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_IRON_ORE.defaultBlockState();}
			default -> {return Blocks.IRON_ORE.defaultBlockState();}
		}
	}

	private BlockState getCopper(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.COPPER_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState();}
			default -> {return Blocks.COPPER_ORE.defaultBlockState();}
		}
	}

	private BlockState getGold(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.GOLD_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState();}
			default -> {return Blocks.GOLD_ORE.defaultBlockState();}
		}
	}

	private BlockState getLapis(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.LAPIS_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState();}
			default -> {return Blocks.LAPIS_ORE.defaultBlockState();}
		}
	}

	private BlockState getDiamond(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.DIAMOND_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState();}
			default -> {return Blocks.DIAMOND_ORE.defaultBlockState();}
		}
	}

	private BlockState getRedstone(ReplacementType replacementType) {
		switch (replacementType) {
			case STONE -> {return Blocks.REDSTONE_ORE.defaultBlockState();}
			case DEEPSLATE -> {return Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState();}
			default -> {return Blocks.REDSTONE_ORE.defaultBlockState();}
		}
	}
}
