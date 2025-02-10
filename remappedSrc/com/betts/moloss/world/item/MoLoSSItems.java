package com.betts.moloss.world.item;

import com.betts.moloss.MoreLoreSeafoodSquids;
import com.betts.moloss.world.food.MoLoSSFoods;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static net.minecraft.item.Items.register;

public class MoLoSSItems {
    public static final Item CALAMARI = register(itemID("calamari"), Item::new, new Item.Settings().food(MoLoSSFoods.CALAMARI));
    public static final Item COOKED_CALAMARI = register(itemID("cooked_calamari"), Item::new, new Item.Settings().food(MoLoSSFoods.COOKED_CALAMARI));

    public static RegistryKey<Item> itemID(String string) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreLoreSeafoodSquids.MOD_ID, string));
    }

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addBefore(Items.COD, MoLoSSItems.CALAMARI);
            entries.addAfter(MoLoSSItems.CALAMARI, MoLoSSItems.COOKED_CALAMARI);
        } );
    }
}
