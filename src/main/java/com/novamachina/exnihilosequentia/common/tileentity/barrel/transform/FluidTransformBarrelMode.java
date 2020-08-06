package com.novamachina.exnihilosequentia.common.tileentity.barrel.transform;

import com.novamachina.exnihilosequentia.common.setup.ModFluids;
import com.novamachina.exnihilosequentia.common.setup.ModRegistries;
import com.novamachina.exnihilosequentia.common.tileentity.barrel.AbstractBarrelMode;
import com.novamachina.exnihilosequentia.common.tileentity.barrel.BarrelTile;
import com.novamachina.exnihilosequentia.common.utility.Config;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

public class FluidTransformBarrelMode extends AbstractBarrelMode {
    private int currentProgress;

    public FluidTransformBarrelMode(String name) {
        super(name);
        currentProgress = 0;
    }

    @Override
    public void tick(BarrelTile barrelTile) {
        if (ModRegistries.FLUID_TRANSFORM.isValidRecipe(barrelTile.getTank().getFluid().getFluid(), barrelTile.getWorld()
            .getBlockState(barrelTile.getPos().add(0, -1, 0)).getBlock())) {
            currentProgress++;
            spawnParticle(barrelTile);
            if(currentProgress >= Config.SECONDS_TO_FLUID_TRANSFORM.get() * 20) {
                currentProgress = 0;
                Fluid newFluid = ModRegistries.FLUID_TRANSFORM.getResult(barrelTile.getFluid());
                barrelTile.getTank().setFluid(new FluidStack(newFluid, BarrelTile.MAX_FLUID_AMOUNT));
                barrelTile.setMode(Constants.BarrelModes.FLUID);
            }
        }
    }

    @Override
    public ActionResultType onBlockActivated(BarrelTile barrelTile, PlayerEntity player, Hand handIn, IFluidHandler fluidHandler, IItemHandler itemHandler) {
        return null;
    }

    @Override
    public boolean canFillWithFluid(BarrelTile barrel) {
        return false;
    }

    @Override
    public boolean isEmptyMode() {
        return false;
    }

    @Override
    protected boolean isTriggerItem(ItemStack stack) {
        return false;
    }

    @Override
    public void read(CompoundNBT nbt) {
        currentProgress = nbt.getInt("currentProgress");
    }

    @Override
    public CompoundNBT write() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("currentProgress", currentProgress);
        return nbt;
    }

    @Override
    protected void spawnParticle(BarrelTile barrelTile) {
        ((ServerWorld) barrelTile.getWorld())
            .spawnParticle(ParticleTypes.EFFECT,
                barrelTile.getPos().getX() + barrelTile.getWorld().rand.nextDouble(),
                barrelTile.getPos().getY() + barrelTile.getWorld().rand.nextDouble(),
                barrelTile.getPos().getZ() + barrelTile.getWorld().rand.nextDouble(),
                1,
                0.0,
                0.0,
                0.0,
                0.05);
    }
}