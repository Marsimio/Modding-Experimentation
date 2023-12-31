package net.marsim.zejzamod.datagen;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.block.ModBlocks;
import net.marsim.zejzamod.item.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ZejzaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.ZEJZANIUM_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ZEJZANIUM_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.DEEPSLATE_ZEJZANIUM_ORE.get());
                        ModBlocks.ZEJZANIUM_BLOCK.get();


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ZEJZANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_ZEJZANIUM_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);



    }
}
