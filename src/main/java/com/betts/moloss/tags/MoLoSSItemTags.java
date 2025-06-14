package com.betts.moloss.tags;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class MoLoSSItemTags extends FabricTagProvider<Item> {
    public MoLoSSItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ITEM, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateRawBuilder(ItemTags.WOLF_FOOD)
                .add(TagEntry.tag(MoLoSSItems.itemID("calamari").location()))
                .add(TagEntry.tag(MoLoSSItems.itemID("cooked_calamari").location()));
        getOrCreateRawBuilder(ItemTags.CAT_FOOD)
                .add(TagEntry.tag(MoLoSSItems.itemID("calamari").location()));
    }
}