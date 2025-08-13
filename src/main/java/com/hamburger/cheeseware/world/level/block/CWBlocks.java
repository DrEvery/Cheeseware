package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.Cheeseware;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CWBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cheeseware.MODID);

    public static final DeferredBlock<MilkCauldronBlock> MILK_CAULDRON_BLOCK = BLOCKS.registerBlock(
            "milk_cauldron_block",
            registryName -> new MilkCauldronBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.0F).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":milk_cauldron_block")))
                    ,CauldronInteraction.EMPTY)
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
