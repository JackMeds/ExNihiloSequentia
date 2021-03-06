package com.novamachina.exnihilosequentia.common.tileentity;

import com.novamachina.exnihilosequentia.common.block.InfestingLeavesBlock;
import com.novamachina.exnihilosequentia.common.init.ModTiles;
import com.novamachina.exnihilosequentia.common.utility.Config;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class InfestingLeavesTile extends TileEntity implements ITickableTileEntity {

    private int progress = 0;
    private int progressWaitInterval = (Config.SECONDS_TO_TRANSFORM_LEAVES.get() * 20) / 100;
    private int spreadCounter = 0;

    public InfestingLeavesTile() {
        super(ModTiles.INFESTING_LEAVES.get());
    }

    public int getProgress() {
        return progress;
    }

    @Override
    public void tick() {
        if (!world.isRemote()) {
            progressWaitInterval--;
            if (progressWaitInterval <= 0) {
                progress++;
                spreadCounter++;

                if (progress >= 100) {
                    InfestingLeavesBlock.finishInfestingBlock(world, pos);
                }

                if (spreadCounter >= Config.TICKS_BETWEEN_SPREAD_ATTEMPT.get()) {
                    InfestingLeavesBlock.spread(world, pos);
                    spreadCounter = 0;
                }
                progressWaitInterval = (Config.SECONDS_TO_TRANSFORM_LEAVES.get() * 20) / 100;
                world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("progress", progress);
        return new SUpdateTileEntityPacket(getPos(), -1, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT nbt = pkt.getNbtCompound();
        if (nbt.contains("progress")) {
            progress = nbt.getInt("progress");
        }
    }
}
