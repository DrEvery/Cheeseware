package com.hamburger.cheeseware.world.level.block;

import com.hamburger.cheeseware.Cheeseware;
import com.hamburger.cheeseware.world.level.block.entity.MilkCauldronBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Cheeseware.MODID);

    public static final Supplier<BlockEntityType<MilkCauldronBlockEntity>> MILK_CAULDRON_ENTITY = BLOCK_ENTITIES.register(
            "milk_cauldron",
            () -> new BlockEntityType<>(
                    MilkCauldronBlockEntity::new,
                    false,
                    CWBlocks.MILK_CAULDRON.get()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
