package com.hamburger.cheeseware.mixin;

import com.hamburger.cheeseware.world.level.block.CWBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

import static net.minecraft.core.cauldron.CauldronInteraction.*;

@Mixin(CauldronInteraction.class)
public interface MilkCauldronInteractionMixin {

    @Unique
    private static InteractionResult fillMilkInteraction(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack filledStack) {
        return isUnderWater(level, pos) ? InteractionResult.CONSUME : emptyBucket(level, pos, player, hand, filledStack, CWBlocks.MILK_CAULDRON_BLOCK.get().defaultBlockState(), SoundEvents.BUCKET_EMPTY);
    }

    @Unique
    private static InteractionResult emptyMilkInteraction(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, ItemStack emptyStack) {
        if (state.getBlock() == CWBlocks.MILK_CAULDRON_BLOCK.get()) {
            return fillBucket(state, level, pos, player, hand, emptyStack, new ItemStack(Items.MILK_BUCKET), (state1) -> true, SoundEvents.BUCKET_FILL);
        } else if (state.getBlock() == Blocks.LAVA_CAULDRON) {
            return fillBucket(state, level, pos, player, hand, emptyStack, new ItemStack(Items.LAVA_BUCKET), (p_175651_) -> true, SoundEvents.BUCKET_FILL_LAVA);
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Unique
    private static boolean isUnderWater(Level level, BlockPos pos) {
        FluidState fluidstate = level.getFluidState(pos.above());
        return fluidstate.is(FluidTags.WATER);
    }

    @Inject(at = @At("HEAD"), method = "addDefaultInteractions")
    private static void addDefaultInteractions(Map<Item, CauldronInteraction> interactionsMap, CallbackInfo ci) {
        interactionsMap.put(Items.MILK_BUCKET, MilkCauldronInteractionMixin::fillMilkInteraction);
        interactionsMap.put(Items.BUCKET, MilkCauldronInteractionMixin::emptyMilkInteraction);
    }

}
