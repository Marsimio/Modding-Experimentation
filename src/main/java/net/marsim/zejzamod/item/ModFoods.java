package net.marsim.zejzamod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ROTISSERIE_CHICKEN = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 0), 1).build();
}
