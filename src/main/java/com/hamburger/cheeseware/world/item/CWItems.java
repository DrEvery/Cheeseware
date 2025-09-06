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
                            .saturationModifier(7F)
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
                            .nutrition(5)
                            .saturationModifier(6F)
                            .build()
            )
    );

    public static final DeferredItem<BlockItem> SWISS_WHEEL = CHEESEITEMS.registerSimpleBlockItem(
            "swiss_wheel",
            CWBlocks.SWISS_WHEEL_BLOCK
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

    public static final DeferredItem<BlockItem> PECORINO_WHEEL = CHEESEITEMS.registerSimpleBlockItem(
            "pecorino_wheel",
            CWBlocks.PECORINO_WHEEL_BLOCK
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

    public static final DeferredItem<BlockItem> CASU_MARTZU_WHEEL = CHEESEITEMS.registerSimpleBlockItem(
            "casu_martzu_wheel",
            CWBlocks.CASU_MARTZU_WHEEL_BLOCK
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

    //MISC
    public static final DeferredItem<Item> CRACKER = CHEESEITEMS.registerItem(
            "cracker",
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(1F)
                            .build()
            )
    );

    public static final DeferredItem<Item> RENNET = CHEESEITEMS.registerItem(
            "rennet",
            Item::new
    );

    public static final DeferredItem<Item> SALT = CHEESEITEMS.registerItem(
            "salt",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<BlockItem> SALT_BLOCK = CHEESEITEMS.registerSimpleBlockItem(
            "salt_block",
            CWBlocks.SALT_BLOCK
    );

    public static void register(IEventBus eventBus) {
        CHEESEITEMS.register(eventBus);
    }

}
