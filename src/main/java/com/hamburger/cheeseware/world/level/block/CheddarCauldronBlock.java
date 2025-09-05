package com.hamburger.cheeseware.world.level.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CheddarCauldronBlock extends AbstractCauldronBlock {

    public CheddarCauldronBlock(Properties properties, CauldronInteraction.InteractionMap interactions) {
        super(properties, interactions);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        return new ItemStack(Items.CAULDRON);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return null;
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return false;
    }
}
