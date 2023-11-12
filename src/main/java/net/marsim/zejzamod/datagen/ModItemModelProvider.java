package net.marsim.zejzamod.datagen;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ZejzaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ZEJZANIUM);
        simpleItem(ModItems.RAW_ZEJZANIUM);
        simpleItem(ModItems.BUCKLERSHIELD);
        simpleItem(ModItems.EMBER);
        simpleItem(ModItems.ROTISSERIE_CHICKEN);

        swordItem(ModItems.FIREBALL_WAND);
        swordItem(ModItems.SARADOMINGODSWORD);
        swordItem(ModItems.FLAME_TONGUE);
        swordItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ZejzaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder swordItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ZejzaMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
