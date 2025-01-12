package com.betts.moloss.world.item;

import com.betts.moloss.MoreLoreSeafoodSquids;
import com.betts.moloss.world.food.MoLoSSFoods;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static net.minecraft.world.item.Items.registerItem;

public class MoLoSSItems {
    public static final Item CALAMARI = registerItem(itemID("calamari"), Item::new, new Item.Properties().food(MoLoSSFoods.CALAMARI));
    public static final Item COOKED_CALAMARI = registerItem(itemID("cooked_calamari"), Item::new, new Item.Properties().food(MoLoSSFoods.COOKED_CALAMARI));

    public static ResourceKey<Item> itemID(String string) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MoreLoreSeafoodSquids.MOD_ID, string));
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            entries.addAfter(Items.PUFFERFISH, MoLoSSItems.CALAMARI);
            entries.addAfter(MoLoSSItems.CALAMARI, MoLoSSItems.COOKED_CALAMARI);
        } );
    }
}
