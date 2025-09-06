package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.Cheeseware;
import com.hamburger.cheeseware.world.level.block.entity.MilkCauldronBlockEntity;
import com.hamburger.cheeseware.world.level.block.wheels.CheddarWheel;
import com.hamburger.cheeseware.world.level.block.wheels.PecorinoWheel;
import com.hamburger.cheeseware.world.level.block.wheels.SwissWheel;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cheeseware.MODID);

    public static final DeferredBlock<AbstractCauldronBlock> MILK_CAULDRON = BLOCKS.registerBlock(
            "milk_cauldron",
            properties -> new MilkCauldronBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2.0F).requiresCorrectToolForDrops().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":milk_cauldron"))).randomTicks())
    );

    public static final DeferredBlock<AbstractCauldronBlock> CHEDDAR_CAULDRON = BLOCKS.registerBlock(
            "cheddar_cauldron",
            properties -> new CheddarCauldronBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2.0F).requiresCorrectToolForDrops().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":cheddar_cauldron"))), CauldronInteraction.EMPTY)
    );

    //Cheese Wheels
    public static final DeferredBlock<AbstractCheeseWheelBlock> CHEDDAR_WHEEL_BLOCK = BLOCKS.registerBlock(
            "cheddar_wheel",
            properties -> new CheddarWheel(BlockBehaviour.Properties.of().strength(0.5F).noOcclusion().sound(SoundType.HONEY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":cheddar_wheel"))))
    );

    public static final DeferredBlock<AbstractCheeseWheelBlock> SWISS_WHEEL_BLOCK = BLOCKS.registerBlock(
            "swiss_wheel",
            properties -> new SwissWheel(BlockBehaviour.Properties.of().strength(0.5F).noOcclusion().sound(SoundType.HONEY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":swiss_wheel"))))
    );

    public static final DeferredBlock<AbstractCheeseWheelBlock> PECORINO_WHEEL_BLOCK = BLOCKS.registerBlock(
            "pecorino_wheel",
            properties -> new PecorinoWheel(BlockBehaviour.Properties.of().strength(0.5F).noOcclusion().sound(SoundType.HONEY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":swiss_wheel"))))
    );

    public static final DeferredBlock<Block> SALT_BLOCK = BLOCKS.registerBlock(
            "salt_block",
            properties -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.FIRE).strength(0.5F)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(Cheeseware.MODID + ":salt_block"))))
    );


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
