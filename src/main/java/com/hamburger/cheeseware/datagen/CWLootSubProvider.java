package com.hamburger.cheeseware.datagen;

import com.hamburger.cheeseware.world.level.block.CWBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class CWLootSubProvider extends BlockLootSubProvider {


    protected CWLootSubProvider(HolderLookup.Provider lookupProvider) {
        super (Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() {
        dropSelf(CWBlocks.CHEDDAR_WHEEL_BLOCK.get());
        dropSelf(CWBlocks.SWISS_WHEEL_BLOCK.get());
        dropSelf(CWBlocks.PECORINO_WHEEL_BLOCK.get());
        dropSelf(CWBlocks.CASU_MARTZU_WHEEL_BLOCK.get());

        dropSelf(CWBlocks.SALT_BLOCK.get());

        dropOther(CWBlocks.MILK_CAULDRON.get(), Items.CAULDRON);
        dropOther(CWBlocks.CHEDDAR_CAULDRON.get(), Items.CAULDRON);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CWBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
