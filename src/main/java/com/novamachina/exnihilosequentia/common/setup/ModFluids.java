package com.novamachina.exnihilosequentia.common.setup;

import com.novamachina.exnihilosequentia.common.fluid.WitchWaterFluid;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {

    private static final DeferredRegister<Fluid> FLUIDS =
        new DeferredRegister<>(ForgeRegistries.FLUIDS, Constants.ModInfo.MOD_ID);

    public static final RegistryObject<FlowingFluid> WITCH_WATER_STILL = FLUIDS
        .register(Constants.Fluids.WITCH_WATER_STILL,
            () -> new WitchWaterFluid.Source(WitchWaterFluid.WITCH_WATER_PROPS));
    public static final RegistryObject<FlowingFluid> WITCH_WATER_FLOW  = FLUIDS
        .register(Constants.Fluids.WITCH_WATER_FLOW,
            () -> new WitchWaterFluid.Flowing(WitchWaterFluid.WITCH_WATER_PROPS));

    public static void init(IEventBus modEventBus) {
        FLUIDS.register(modEventBus);
    }
}
