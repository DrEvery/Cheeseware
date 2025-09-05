package com.hamburger.cheeseware.world.level.block.entity;

import com.hamburger.cheeseware.world.level.block.CWBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class MilkCauldronBlockEntity extends BlockEntity {

    private boolean isCurdling;
    public MilkCauldronBlockEntity(BlockPos pos, BlockState blockState) {
        super(CWBlockEntities.MILK_CAULDRON_ENTITY.get(), pos, blockState);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.isCurdling = input.getBooleanOr("isCurdling", false);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putBoolean("isCurdling", this.isCurdling);
    }

    public boolean getIsCurdling() {
        return this.isCurdling;
    }

    public void setIsCurdling(boolean bool) {
        this.isCurdling = bool;
    }

}
