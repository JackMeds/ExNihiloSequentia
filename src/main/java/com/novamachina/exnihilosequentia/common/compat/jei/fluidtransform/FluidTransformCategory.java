package com.novamachina.exnihilosequentia.common.compat.jei.fluidtransform;

import com.novamachina.exnihilosequentia.common.utility.Constants;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.util.ResourceLocation;

public class FluidTransformCategory implements IRecipeCategory<FluidTransformJEIRecipe> {
    private static final ResourceLocation texture = new ResourceLocation(Constants.ModIds.EX_NIHILO_SEQUENTIA, "textures/gui/jei_fluid_transform.png");
    public static ResourceLocation UID = new ResourceLocation(Constants.ModIds.EX_NIHILO_SEQUENTIA, "fluidtransform");
    private final IDrawableStatic background;
    private final IDrawableStatic slotHighlight;

    public FluidTransformCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(texture, 0, 0, 166, 63);
        this.slotHighlight = guiHelper.createDrawable(texture, 166, 0, 18, 18);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends FluidTransformJEIRecipe> getRecipeClass() {
        return FluidTransformJEIRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Fluid Transform";
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public void setIngredients(FluidTransformJEIRecipe recipe, IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.FLUID, recipe.getFluidInBarrel());
        ingredients.setInput(VanillaTypes.ITEM, recipe.getBlockBelow());
        ingredients.setOutput(VanillaTypes.FLUID, recipe.getResult());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, FluidTransformJEIRecipe recipe, IIngredients ingredients) {
        recipeLayout.getFluidStacks().init(0, true, 48, 10);
        recipeLayout.getItemStacks().init(0, true, 74, 36);
        recipeLayout.getFluidStacks().init(1, false, 102, 10);

        recipeLayout.getFluidStacks().set(0, recipe.getFluidInBarrel());
        recipeLayout.getItemStacks().set(0, recipe.getBlockBelow());
        recipeLayout.getFluidStacks().set(1, recipe.getResult());
    }
}
