package net.marsim.zejzamod.item;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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
        public static final RegistryObject<Item> FLAME_TONGUE = ITEMS.register("flame_tongue",
            () -> new FlameTongueItem(Tiers.DIAMOND, 3, -2.4F,new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3f).build())));
        public static final RegistryObject<Item> SARADOMINGODSWORD = ITEMS.register("saradomin_godsword",
            () -> new SaradominGodswordSwordItem(Tiers.DIAMOND, 3 ,-0.5F,new Item.Properties()));
        public static final RegistryObject<Item> BUCKLERSHIELD = ITEMS.register("buckler_shield",
            () -> new BucklerShieldItem(new Item.Properties()));
        public static final RegistryObject<Item> ROTISSERIE_CHICKEN = ITEMS.register("rotisserie_chicken",
                () -> new Item(new Item.Properties().food(ModFoods.ROTISSERIE_CHICKEN)));
        public static final RegistryObject<Item> EMBER = ITEMS.register("ember",
                () -> new FuelItem(new Item.Properties(), 400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
