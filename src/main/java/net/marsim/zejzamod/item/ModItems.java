package net.marsim.zejzamod.item;

import net.marsim.zejzamod.ZejzaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZejzaMod.MOD_ID);

        public static final RegistryObject<Item> ZEJZANIUM = ITEMS.register("zejzanium",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZEJZANIUM = ITEMS.register("raw_zejzanium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
