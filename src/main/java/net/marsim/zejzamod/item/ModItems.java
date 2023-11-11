package net.marsim.zejzamod.item;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.item.custom.FireballWandItem;
import net.marsim.zejzamod.item.custom.MetalDetectorItem;
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

        public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

        public static final RegistryObject<Item> FIREBALL_WAND = ITEMS.register("fireball_wand",
            () -> new FireballWandItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
