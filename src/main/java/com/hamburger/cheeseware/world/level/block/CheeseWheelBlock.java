package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.world.item.CWItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CheeseWheelBlock extends Block {

    public static final IntegerProperty PIECES;
    private static final VoxelShape SHAPE;

    public CheeseWheelBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PIECES);
    }

    static {
        PIECES = BlockStateProperties.BITES;
        SHAPE = Block.box(3.0F, 0.0F, 3.0F, 13.0F, 4.0F, 13.0F);
    }
}
