package drunkblood.luckyore.registries;

import java.util.function.ToIntFunction;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.block.BlockLuckyOre;
import drunkblood.luckyore.block.BlockNetherLuckyOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> REG = DeferredRegister.create(ForgeRegistries.BLOCKS, LuckyOre.MODID);

	public static final RegistryObject<Block> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockLuckyOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockNetherLuckyOre(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK)
					.hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2)));
	public static final RegistryObject<Block> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(2)));
	public static final RegistryObject<Block> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new RedstoneOreBlock(AbstractBlock.Properties.create(Material.ROCK).func_235861_h_().tickRandomly()
					.func_235838_a_(lightValueHelper(9)).hardnessAndResistance(3.0F, 3.0F)));
	public static final RegistryObject<Block> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).harvestLevel(1)));

	private static ToIntFunction<BlockState> lightValueHelper(int i) {
		return (e) -> {
			return e.get(BlockStateProperties.LIT) ? i : 0;
		};
	}
}

