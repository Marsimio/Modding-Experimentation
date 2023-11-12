package net.marsim.zejzamod.datagen;

import net.marsim.zejzamod.datagen.loot.ModBlockLootTable;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTable::new, LootContextParamSets.BLOCK)
        ));
    }
}
