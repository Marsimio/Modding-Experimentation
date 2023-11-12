package net.marsim.zejzamod.datagen;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ZejzaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.ZEJZANIUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_ZEJZANIUM_ORE);
        blockWithItem(ModBlocks.ZEJZANIUM_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
