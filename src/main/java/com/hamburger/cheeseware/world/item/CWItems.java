package com.hamburger.cheeseware.world.item;

import com.hamburger.cheeseware.Cheeseware;
import com.hamburger.cheeseware.world.level.block.CWBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CWItems {
    public static final DeferredRegister.Items CHEESEITEMS = DeferredRegister.createItems(Cheeseware.MODID);

    //Cheeses
    public static final DeferredItem<Item> CHEDDAR_CHEESE = CHEESEITEMS.registerItem(
            "cheddar_cheese",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .build()
            )
    );

    public static final DeferredItem<BlockItem> CHEDDAR_WHEEL = CHEESEITEMS.registerSimpleBlockItem(
            "cheddar_wheel",
            CWBlocks.CHEDDAR_WHEEL_BLOCK
    );

    public static final DeferredItem<Item> SWISS_CHEESE = CHEESEITEMS.registerItem(
            "swiss_cheese",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .build()
            )
    );

    public static final DeferredItem<Item> PECORINO_CHEESE = CHEESEITEMS.registerItem(
            "pecorino_cheese",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .build()
            )
    );

    public static final DeferredItem<Item> CASU_MARTZU_CHEESE = CHEESEITEMS.registerItem(
            "casu_martzu_cheese",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .build()
            )
    );

    public static final DeferredItem<Item> MUNSTER_CHEESE = CHEESEITEMS.registerItem(
            "munster_cheese",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(6)
                            .build()
            )
    );

    public static final DeferredItem<BlockItem> MILK_CAULDRON_ITEM = CHEESEITEMS.registerSimpleBlockItem(
            CWBlocks.MILK_CAULDRON_BLOCK,
            new Item.Properties()
    );

    public static void register(IEventBus eventBus) {
        CHEESEITEMS.register(eventBus);
    }

}
