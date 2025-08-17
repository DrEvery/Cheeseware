package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.world.item.CWItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class CheddarWheel extends AbstractCheeseWheelBlock{
    public CheddarWheel(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int leftovers = state.getValue(PIECES);
        if(leftovers < 3) {
            level.setBlock(pos, state.setValue(PIECES, leftovers + 1), 3);
            player.getInventory().add(new ItemStack(CWItems.CHEDDAR_CHEESE.get()));
        }
        else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            player.getInventory().add(new ItemStack(CWItems.CHEDDAR_CHEESE.get()));
        }
        return InteractionResult.SUCCESS;
    }

    
}
