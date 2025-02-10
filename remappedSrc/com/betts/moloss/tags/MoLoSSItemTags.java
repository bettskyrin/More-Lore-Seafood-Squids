package com.betts.moloss.tags;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import java.util.concurrent.CompletableFuture;

public class MoLoSSItemTags extends FabricTagProvider<Item> {
    public MoLoSSItemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup provider) {
        getOrCreateTagBuilder(ItemTags.WOLF_FOOD)
                .add(MoLoSSItems.CALAMARI)
                .add(MoLoSSItems.COOKED_CALAMARI);
        getOrCreateTagBuilder(ItemTags.CAT_FOOD)
                .add(MoLoSSItems.CALAMARI);
    }
}