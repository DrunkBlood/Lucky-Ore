package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.block.BlockLuckyOre;
import drunkblood.luckyore.block.BlockNetherLuckyOre;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> REG = DeferredRegister.create(ForgeRegistries.BLOCKS, LuckyOre.MODID);
	public static final RegistryObject<Block> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_LUCKY_ORE = REG.register("deepslate_lucky_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
	public static final RegistryObject<Block> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockNetherLuckyOre(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)));
	public static final RegistryObject<Block> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new Block(Block.Properties.copy(Blocks.EMERALD_ORE)));
	public static final RegistryObject<Block> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new Block(Block.Properties.copy(Blocks.LAPIS_ORE)));
	public static final RegistryObject<Block> LUCKY_COPPER_ORE = REG.register("lucky_copper_ore",
			() -> new Block(Block.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> LUCKY_IRON_ORE = REG.register("lucky_iron_ore",
			() -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> LUCKY_GOLD_ORE = REG.register("lucky_gold_ore",
			() -> new Block(Block.Properties.copy(Blocks.GOLD_ORE)));
}

