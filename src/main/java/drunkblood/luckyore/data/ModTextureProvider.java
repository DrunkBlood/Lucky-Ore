package drunkblood.luckyore.data;

import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import drunkblood.luckyore.LuckyOre;
import drunkblood.luckyore.registries.ModBlocks;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ModTextureProvider implements DataProvider {

    private final DataGenerator dataGenerator;
    private List<Texture> textures = new LinkedList<>();
    private static final int IMAGE_WIDTH = 16;
    private static final int IMAGE_HEIGHT = 16;
    private static final List<String> BASIC_ORE_NAMES = List.of(
            "andesite.png",
            "diorite.png",
            "granite.png"
    );
    private static final List<String> STONE_ORE_NAMES = List.of(
            "stone.png",
            "deepslate.png"
    );
    private final Map<String, BufferedImage> basicOres = new TreeMap<>();
    private final Map<String, BufferedImage> stoneOres = new TreeMap<>();
    private BufferedImage oreBuffer;

    public ModTextureProvider(DataGenerator dataGenerator){
        this.dataGenerator = dataGenerator;
    }

    private void addTextures() {
        addBasicOre(ModBlocks.COAL_ORE, "coal_ore.png");
        addBasicOre(ModBlocks.COPPER_ORE, "copper_ore.png");
        addBasicOre(ModBlocks.DIAMOND_ORE, "diamond_ore.png");
        addBasicOre(ModBlocks.EMERALD_ORE, "emerald_ore.png");
        addBasicOre(ModBlocks.GOLD_ORE, "gold_ore.png");
        addBasicOre(ModBlocks.IRON_ORE, "iron_ore.png");
        addBasicOre(ModBlocks.LAPIS_ORE, "lapis_ore.png");
        addBasicOre(ModBlocks.REDSTONE_ORE, "redstone_ore.png");

        addOre(ModBlocks.LUCKY_COAL_ORE, "lucky_coal_ore.png");
        addOre(ModBlocks.LUCKY_COPPER_ORE, "lucky_copper_ore.png");
        addOre(ModBlocks.LUCKY_DIAMOND_ORE, "lucky_diamond_ore.png");
        addOre(ModBlocks.LUCKY_EMERALD_ORE, "lucky_emerald_ore.png");
        addOre(ModBlocks.LUCKY_GOLD_ORE, "lucky_gold_ore.png");
        addOre(ModBlocks.LUCKY_IRON_ORE, "lucky_iron_ore.png");
        addOre(ModBlocks.LUCKY_LAPIS_ORE, "lucky_lapis_ore.png");
        addOre(ModBlocks.LUCKY_REDSTONE_ORE, "lucky_redstone_ore.png");

        addOre(ModBlocks.LUCKY_ORE, "lucky_ore.png");

    }

    @Override
    public void run(CachedOutput cachedOutput) {
        addTextures();
        if(!textures.isEmpty()){
            loadOres();
            textures.forEach(texture -> saveTexture(texture, cachedOutput));
        }
    }

    private void loadOres() {
        BASIC_ORE_NAMES.forEach(name -> loadImage(name, basicOres));
        STONE_ORE_NAMES.forEach(name -> loadImage(name, stoneOres));
        oreBuffer = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    private void loadImage(String name, Map<String, BufferedImage> maptoFill) {
        try {
            File file = new File("mask/" + name);
            BufferedImage oreImage = ImageIO.read(file);
            maptoFill.put(name, oreImage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveTexture(Texture texture, CachedOutput cachedOutput) {
        // load mask
        BufferedImage mask = null;
        try {
            File file = new File("mask/" + texture.mask);
            mask = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not get mask for: " + texture);
        }
        if(mask == null) return;

        Raster maskData = mask.getData();
        int[] buffer = new int[4];
        for (Map.Entry<String, BufferedImage> orePair :
                basicOres.entrySet()) {
            writeMask(texture, cachedOutput, mask, maskData, buffer, orePair.getKey(), orePair.getValue());
        }
        if(!texture.addStone) return;
        for (Map.Entry<String, BufferedImage> orePair :
                stoneOres.entrySet()) {
            writeMask(texture, cachedOutput, mask, maskData, buffer, orePair.getKey(), orePair.getValue());
        }
    }

    private void writeMask(Texture texture, CachedOutput cachedOutput, BufferedImage mask, Raster maskData, int[] buffer, String oreName, BufferedImage oreImage) {
        // apply mask
        for (int y = 0; y < IMAGE_WIDTH; y++) {
            for (int x = 0; x < IMAGE_HEIGHT; x++) {
                int[] pixel = maskData.getPixel(x, y, buffer);
                int alpha = pixel[3];
                int rgbValue;
                if(alpha == 0){
                    rgbValue = oreImage.getRGB(x, y);
                } else {
                    rgbValue = mask.getRGB(x, y);
                }
                oreBuffer.setRGB(x, y, rgbValue);
            }
        }

        // save result
        Path imagePath = this.dataGenerator.getOutputFolder().resolve("assets/" + LuckyOre.MODID + "/textures/block/" +
                texture.blockName.getPath() + "_" + oreName);

        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        HashingOutputStream hashingoutputstream = new HashingOutputStream(Hashing.sha1(), bytearrayoutputstream);
        try {
            ImageIO.write(oreBuffer, "png", hashingoutputstream);
            cachedOutput.writeIfNeeded(imagePath, bytearrayoutputstream.toByteArray(), hashingoutputstream.hash());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not write mask result of: " + texture + " with oreName = " + oreName);
        }
    }


    private void addBasicOre(RegistryObject<Block> block, String mask) {
        textures.add(new Texture(block.getId(), false, mask));
    }
    private void addOre(RegistryObject<Block> block, String mask){
        textures.add(new Texture(block.getId(), true, mask));
    }

    @Override
    public String getName() {
        return "TextureProvider";
    }
    record Texture(ResourceLocation blockName, boolean addStone, String mask){}
}
