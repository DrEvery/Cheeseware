package com.hamburger.cheeseware.datagen;

import com.hamburger.cheeseware.Cheeseware;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Cheeseware.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ENUSLangProvider::new);
        event.createProvider(LOLLanguageProvider::new);
    }
}
