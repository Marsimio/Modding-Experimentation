package net.marsim.zejzamod.datagen;

import net.marsim.zejzamod.ZejzaMod;
import net.marsim.zejzamod.block.ModBlocks;
import net.marsim.zejzamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ZEJZANIUM_SMELTABLES = List.of(ModItems.RAW_ZEJZANIUM.get(),
            ModBlocks.ZEJZANIUM_ORE.get(), ModBlocks.DEEPSLATE_ZEJZANIUM_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_297267_) {
        oreSmelting(p_297267_, ZEJZANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZEJZANIUM.get(), 0.25f, 200, "zejzanium");
        oreBlasting(p_297267_, ZEJZANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ZEJZANIUM.get(), 0.25f, 100, "zejzanium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZEJZANIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ZEJZANIUM.get())
                .unlockedBy(getHasName(ModItems.ZEJZANIUM.get()), has(ModItems.ZEJZANIUM.get()))
                .save(p_297267_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZEJZANIUM.get(), 9)
                .requires(ModBlocks.ZEJZANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ZEJZANIUM_BLOCK.get()), has(ModBlocks.ZEJZANIUM_BLOCK.get()))
                .save(p_297267_);
    }

    protected static void oreSmelting(RecipeOutput p_300202_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(p_300202_, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput p_298528_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(p_298528_, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput p_297621_, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_297621_, ZejzaMod.MOD_ID +":"+ getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
