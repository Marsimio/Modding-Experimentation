package net.marsim.zejzamod.item;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZejzaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ZEJZA_TAB = CREATIVE_MODE_TABS.register("zejza_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZEJZANIUM.get()))
                    .title(Component.translatable("creativetab.zejza_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ZEJZANIUM.get());
                        pOutput.accept(ModItems.RAW_ZEJZANIUM.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.FIREBALL_WAND.get());
                        pOutput.accept(ModItems.FLAME_TONGUE.get());
                        pOutput.accept(ModItems.SARADOMINGODSWORD.get());
                        pOutput.accept(ModItems.BUCKLERSHIELD.get());
                        pOutput.accept(ModItems.ROTISSERIE_CHICKEN.get());
                        pOutput.accept(ModItems.EMBER.get());

                        pOutput.accept(ModBlocks.ZEJZANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.ZEJZANIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ZEJZANIUM_ORE.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
