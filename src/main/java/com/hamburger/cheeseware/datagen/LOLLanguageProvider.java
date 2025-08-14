package com.hamburger.cheeseware.datagen;

import com.hamburger.cheeseware.Cheeseware;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LOLLanguageProvider extends LanguageProvider {
    public LOLLanguageProvider(PackOutput output) {
        super(output, Cheeseware.MODID, "lol_us");
    }

    @Override
    protected void addTranslations() {

    }
}
