package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.world.item.CWItems;
import com.hamburger.cheeseware.world.level.block.entity.MilkCauldronBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;


//MAKE THIS A FUCKING BLOCK ENTITY
public class MilkCauldronBlock extends AbstractCauldronBlock implements EntityBlock {
    public static final MapCodec<MilkCauldronBlock> CODEC = simpleCodec(MilkCauldronBlock::new);

    public MilkCauldronBlock(Properties properties) {
        super(properties, CauldronInteraction.EMPTY);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(CWItems.RENNET) && !level.isClientSide) {
            if (level.getBlockEntity(pos) instanceof MilkCauldronBlockEntity milkCauldronBlockEntity) {
                if (!milkCauldronBlockEntity.getIsCurdling()) {
                    stack.shrink(1);
                    level.scheduleTick(pos,this, 600);
                    milkCauldronBlockEntity.setIsCurdling(true);

                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getMaxLocalRawBrightness(pos) >= 15) {
                level.setBlockAndUpdate(pos, CWBlocks.CHEDDAR_CAULDRON.get().defaultBlockState());
                }
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        return new ItemStack(Items.CAULDRON);
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isFull(BlockState blockState) {
        return true;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MilkCauldronBlockEntity(blockPos, blockState);
    }
}
