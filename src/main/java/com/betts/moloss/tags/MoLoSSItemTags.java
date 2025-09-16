package com.betts.moloss.tags;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class MoLoSSItemTags extends FabricTagProvider.ItemTagProvider {
    public MoLoSSItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ItemTags.WOLF_FOOD)
                .add(MoLoSSItems.CALAMARI)
                .add(MoLoSSItems.COOKED_CALAMARI);
        valueLookupBuilder(ItemTags.CAT_FOOD)
                .add(MoLoSSItems.CALAMARI);
    }
}