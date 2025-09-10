package com.hamburger.cheeseware.datagen;

import com.hamburger.cheeseware.world.item.CWItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class CWRecipeProvider extends RecipeProvider {
    protected CWRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, CWItems.CHEDDAR_WHEEL.get())
                .requires(CWItems.CURDS)
                .requires(CWItems.SALT)
                .requires(Items.ORANGE_DYE)

                .unlockedBy("has_salt",this.has(CWItems.SALT))
                .save(this.output);

    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new CWRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
