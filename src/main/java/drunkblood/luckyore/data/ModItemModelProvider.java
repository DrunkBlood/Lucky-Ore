package drunkblood.luckyore.data;

import drunkblood.luckyore.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        addBasicItem(ModItems.LUCKY_DUST);
    }

    private void addBasicItem(Supplier<? extends  Item> item){
        basicItem(item.get());
    }
}
