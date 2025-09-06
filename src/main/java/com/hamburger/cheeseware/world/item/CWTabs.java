package com.hamburger.cheeseware.world.item;

import com.hamburger.cheeseware.Cheeseware;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWTabs {
    public static final DeferredRegister<CreativeModeTab> CHEESETABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Cheeseware.MODID);

    public static final Supplier<CreativeModeTab> CHEESETAB = CHEESETABS.register(
            "cheesetab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + Cheeseware.MODID + ".cheesetab"))
                    .icon(() -> new ItemStack(CWItems.CHEDDAR_CHEESE.get()))
                    .displayItems((params, output) -> {
                        output.accept(CWItems.CHEDDAR_WHEEL);
                        output.accept(CWItems.CHEDDAR_CHEESE);
                        output.accept(CWItems.SWISS_WHEEL);
                        output.accept(CWItems.SWISS_CHEESE);
                        output.accept(CWItems.PECORINO_CHEESE);
                        output.accept(CWItems.PECORINO_WHEEL);
                        output.accept(CWItems.CASU_MARTZU_CHEESE);
                        output.accept(CWItems.MUNSTER_CHEESE);

                        output.accept(CWItems.CRACKER);
                        output.accept(CWItems.RENNET);
                        output.accept(CWItems.SALT);
                        output.accept(CWItems.SALT_BLOCK);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CHEESETABS.register(eventBus);
    }
}
