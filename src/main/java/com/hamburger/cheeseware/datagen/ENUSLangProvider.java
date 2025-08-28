package com.hamburger.cheeseware.datagen;

import com.hamburger.cheeseware.Cheeseware;
import com.hamburger.cheeseware.world.item.CWItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ENUSLangProvider extends LanguageProvider {
    public ENUSLangProvider(PackOutput output) {
        super(output, Cheeseware.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Items
        this.addItem(CWItems.CHEDDAR_CHEESE, "Cheddar Cheese");
        this.addItem(CWItems.CHEDDAR_WHEEL, "Cheddar Wheel");
        this.addItem(CWItems.SWISS_CHEESE, "Swiss Cheese");
        this.addItem(CWItems.SWISS_WHEEL, "Swiss Wheel");
        this.addItem(CWItems.PECORINO_CHEESE, "Pecorino");
        this.addItem(CWItems.CASU_MARTZU_CHEESE, "Casu Martzu");
        this.addItem(CWItems.MUNSTER_CHEESE, "Munster Cheese");

        this.addItem(CWItems.CRACKER, "Cracker");
        this.addItem(CWItems.SALT, "Salt");
        this.addItem(CWItems.SALT_BLOCK, "Salt Block");

        //Tabs
        this.add("itemGroup.%s.cheesetab".formatted(Cheeseware.MODID), "Cheeseware");
    }
}
