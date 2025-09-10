package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.world.item.CWItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CurdCauldronBlock extends AbstractCauldronBlock {

    public CurdCauldronBlock(Properties properties, CauldronInteraction.InteractionMap interactions) {
        super(properties, interactions);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide){
            level.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
            player.getInventory().add(CWItems.CURDS.toStack(6));
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
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
