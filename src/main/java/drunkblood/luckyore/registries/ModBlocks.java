package drunkblood.luckyore.registries;

import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.block.BlockBaseOre;
import drunkblood.luckyore.block.BlockLuckyBaseOre;
import drunkblood.luckyore.block.BlockLuckyOre;
import drunkblood.luckyore.block.BlockNetherLuckyOre;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	// add world gen for blocks
	// test
	public static final DeferredRegister<Block> REG = DeferredRegister.create(ForgeRegistries.BLOCKS, LuckyOre.MODID);
	public static final RegistryObject<Block> LUCKY_ORE = REG.register("lucky_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.STONE)));
	public static final RegistryObject<Block> NETHER_LUCKY_ORE = REG.register("nether_lucky_ore",
			() -> new BlockNetherLuckyOre(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)));
	public static final RegistryObject<Block> LUCKY_COPPER_ORE = REG.register("lucky_copper_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
	public static final RegistryObject<Block> LUCKY_GOLD_ORE = REG.register("lucky_gold_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> LUCKY_IRON_ORE = REG.register("lucky_iron_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE)));
	public static final RegistryObject<Block> LUCKY_COAL_ORE = REG.register("lucky_coal_ore",
			() -> new BlockLuckyBaseOre(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));
	// TODO Lucky Redstone Ore, Redstone Ore
	public static final RegistryObject<Block> REDSTONE_ORE = REG.register("redstone_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> COPPER_ORE = REG.register("copper_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> DIAMOND_ORE = REG.register("diamond_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
	public static final RegistryObject<Block> EMERALD_ORE = REG.register("emerald_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE)));
	public static final RegistryObject<Block> GOLD_ORE = REG.register("gold_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> IRON_ORE = REG.register("iron_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> LAPIS_ORE = REG.register("lapis_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE)));
	public static final RegistryObject<Block> COAL_ORE = REG.register("coal_ore",
			() -> new BlockBaseOre(BlockBehaviour.Properties.copy(Blocks.COAL_ORE)));
	// TODO Redstone Ore

	public static final RegistryObject<Block> LUCKY_DIORITE_ORE = REG.register("lucky_diorite_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
	public static final RegistryObject<Block> LUCKY_ANDERSITE_ORE = REG.register("lucky_andersite_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
	public static final RegistryObject<Block> LUCKY_GRANITE_ORE = REG.register("lucky_granite_ore",
			() -> new BlockLuckyOre(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
//	public static final RegistryObject<Block> LUCKY_DIAMOND_ORE = REG.register("lucky_diamond_ore",
//			() -> new DropExperienceBlock(Block.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DIAMOND_DIORITE_ORE = REG.register("diamond_diorite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DIAMOND_ANDERSITE_ORE = REG.register("diamond_andersite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DIAMOND_GRANITE_ORE = REG.register("diamond_granite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));
//	public static final RegistryObject<Block> LUCKY_EMERALD_ORE = REG.register("lucky_emerald_ore",
//			() -> new Block(Block.Properties.copy(Blocks.EMERALD_ORE)));
//	public static final RegistryObject<Block> LUCKY_LAPIS_ORE = REG.register("lucky_lapis_ore",
//			() -> new DropExperienceBlock(Block.Properties.copy(Blocks.LAPIS_ORE), UniformInt.of(2, 5)));
	public static final RegistryObject<Block> LAPIS_DIORITE_ORE = REG.register("lapis_diorite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE), UniformInt.of(2, 5)));
	public static final RegistryObject<Block> LAPIS_ANDERSITE_ORE = REG.register("lapis_andersite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE), UniformInt.of(2, 5)));
	public static final RegistryObject<Block> LAPIS_GRANITE_ORE = REG.register("lapis_granite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_ORE), UniformInt.of(2, 5)));
//	public static final RegistryObject<Block> LUCKY_COPPER_ORE = REG.register("lucky_copper_ore",
//			() -> new Block(Block.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> COPPER_DIORITE_ORE = REG.register("copper_diorite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> COPPER_ANDERSITE_ORE = REG.register("copper_andersite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
	public static final RegistryObject<Block> COPPER_GRANITE_ORE = REG.register("copper_granite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
//	public static final RegistryObject<Block> LUCKY_IRON_ORE = REG.register("lucky_iron_ore",
//			() -> new Block(Block.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> IRON_DIORITE_ORE = REG.register("iron_diorite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> IRON_ANDERSITE_ORE = REG.register("iron_andersite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> IRON_GRANITE_ORE = REG.register("iron_granite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
//	public static final RegistryObject<Block> LUCKY_GOLD_ORE = REG.register("lucky_gold_ore",
//			() -> new Block(Block.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> GOLD_DIORITE_ORE = REG.register("gold_diorite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> GOLD_ANDERSITE_ORE = REG.register("gold_andersite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> GOLD_GRANITE_ORE = REG.register("gold_granite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));
	public static final RegistryObject<Block> LUCKY_REDSTONE_ORE = REG.register("lucky_redstone_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> REDSTONE_DIORITE_ORE = REG.register("redstone_diorite_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> REDSTONE_ANDERSITE_ORE = REG.register("redstone_andersite_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> REDSTONE_GRANITE_ORE = REG.register("redstone_granite_ore",
			() -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_ORE)));
	public static final RegistryObject<Block> COAL_DIORITE_ORE = REG.register("coal_diorite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE), UniformInt.of(0, 2)));
	public static final RegistryObject<Block> COAL_ANDERSITE_ORE = REG.register("coal_andersite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE), UniformInt.of(0, 2)));
	public static final RegistryObject<Block> COAL_GRANITE_ORE = REG.register("coal_granite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE), UniformInt.of(0, 2)));
}

