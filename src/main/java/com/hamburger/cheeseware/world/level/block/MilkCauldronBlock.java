package com.hamburger.cheeseware.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

public class MilkCauldronBlock extends AbstractCauldronBlock {
    public MilkCauldronBlock(Properties properties, CauldronInteraction.InteractionMap interactions) {
        super(properties, interactions);
    }


    @Override
    protected MapCodec<MilkCauldronBlock> codec() {
        return null;
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return true;
    }
}
