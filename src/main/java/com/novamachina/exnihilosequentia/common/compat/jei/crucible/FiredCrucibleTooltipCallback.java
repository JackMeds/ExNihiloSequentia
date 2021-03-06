package com.novamachina.exnihilosequentia.common.compat.jei.crucible;

import com.novamachina.exnihilosequentia.common.api.ExNihiloRegistries;
import com.novamachina.exnihilosequentia.common.registries.crucible.Meltable;
import mezz.jei.api.gui.ingredient.ITooltipCallback;
import net.minecraft.item.ItemStack;

import java.util.List;

public class FiredCrucibleTooltipCallback implements ITooltipCallback<ItemStack> {
    @Override
    public void onTooltip(int slotIndex, boolean input, ItemStack ingredient, List<String> tooltip) {
        if (input) {
            Meltable meltable = ExNihiloRegistries.CRUCIBLE_REGISTRY.getMeltable(ingredient.getItem());
            tooltip.add(String.format("Fluid Amount: %d mb", meltable.getAmount()));
        }
    }
}
