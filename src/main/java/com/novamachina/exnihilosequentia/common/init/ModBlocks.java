package com.novamachina.exnihilosequentia.common.init;

import com.novamachina.exnihilosequentia.common.block.BaseBlock;
import com.novamachina.exnihilosequentia.common.block.BaseFallingBlock;
import com.novamachina.exnihilosequentia.common.block.BlockBarrel;
import com.novamachina.exnihilosequentia.common.block.BlockSieve;
import com.novamachina.exnihilosequentia.common.block.EndCakeBlock;
import com.novamachina.exnihilosequentia.common.block.FiredCrucibleBlock;
import com.novamachina.exnihilosequentia.common.block.InfestedLeavesBlock;
import com.novamachina.exnihilosequentia.common.block.InfestingLeavesBlock;
import com.novamachina.exnihilosequentia.common.block.SeaWaterBlock;
import com.novamachina.exnihilosequentia.common.block.UnfiredCrucibleBlock;
import com.novamachina.exnihilosequentia.common.block.WitchWaterBlock;
import com.novamachina.exnihilosequentia.common.block.WoodCrucibleBlock;
import com.novamachina.exnihilosequentia.common.builder.BlockBuilder;
import com.novamachina.exnihilosequentia.common.tileentity.barrel.BarrelTile;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import com.novamachina.exnihilosequentia.common.utility.Constants.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    private static final DeferredRegister<Block> BLOCKS =
        new DeferredRegister<>(ForgeRegistries.BLOCKS, Constants.ModIds.EX_NIHILO_SEQUENTIA);

    public static final RegistryObject<BaseFallingBlock> DUST = BLOCKS
        .register(Constants.Blocks.DUST, () -> new BaseFallingBlock(new BlockBuilder().properties(
            Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.CLOTH)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<BaseFallingBlock> CRUSHED_NETHERRACK = BLOCKS
        .register(Constants.Blocks.CRUSHED_NETHERRACK, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<BaseFallingBlock> CRUSHED_END_STONE = BLOCKS
        .register(Constants.Blocks.CRUSHED_END_STONE, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<BaseFallingBlock> CRUSHED_ANDESITE = BLOCKS
        .register(Constants.Blocks.CRUSHED_ANDESITE, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<BaseFallingBlock> CRUSHED_DIORITE = BLOCKS
        .register(Constants.Blocks.CRUSHED_DIORITE, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<BaseFallingBlock> CRUSHED_GRANITE = BLOCKS
        .register(Constants.Blocks.CRUSHED_GRANITE, () -> new BaseFallingBlock(new BlockBuilder()
            .properties(Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F)
                .sound(SoundType.GROUND)).harvestLevel(ToolType.SHOVEL, 0)));
    public static final RegistryObject<EndCakeBlock> END_CAKE = BLOCKS
        .register(Constants.Blocks.END_CAKE, EndCakeBlock::new);
    public static final RegistryObject<BlockSieve> SIEVE = BLOCKS
        .register(Blocks.SIEVE, BlockSieve::new);
    public static final RegistryObject<FlowingFluidBlock> WITCH_WATER = BLOCKS
        .register(Constants.Blocks.WITCH_WATER, WitchWaterBlock::new);
    public static final RegistryObject<FlowingFluidBlock> SEA_WATER = BLOCKS
        .register(Constants.Blocks.SEA_WATER, SeaWaterBlock::new);
    public static final RegistryObject<BaseBlock> INFESTING_LEAVES = BLOCKS
        .register(Blocks.INFESTING_LEAVES, InfestingLeavesBlock::new);
    public static final RegistryObject<BaseBlock> INFESTED_LEAVES = BLOCKS
        .register(Blocks.INFESTED_LEAVES, InfestedLeavesBlock::new);
    public static final RegistryObject<BaseBlock> CRUCIBLE_UNFIRED = BLOCKS
        .register(Blocks.CRUCIBLE_UNFIRED, UnfiredCrucibleBlock::new);
    public static final RegistryObject<BaseBlock> CRUCIBLE_FIRED = BLOCKS
        .register(Blocks.CRUCIBLE_FIRED, FiredCrucibleBlock::new);
    public static final RegistryObject<BaseBlock> CRUCIBLE_WOOD = BLOCKS
        .register(Blocks.CRUCIBLE_WOOD, WoodCrucibleBlock::new);
    public static final RegistryObject<BaseBlock> BARREL_WOOD = BLOCKS
        .register(Blocks.BARREL_WOOD, () -> new BlockBarrel(new BlockBuilder().harvestLevel(ToolType.AXE, 0)
            .properties(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.75F).sound(SoundType.WOOD))
            .tileEntitySupplier(BarrelTile::new)));

    public static void init(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
