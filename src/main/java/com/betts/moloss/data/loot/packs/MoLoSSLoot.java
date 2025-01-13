package com.betts.moloss.data.loot.packs;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.advancements.critereon.EntityFlagsPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MoLoSSLoot {
    public static void modifyLoot() {
        EntityPredicate onFirePredicate = EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)).build(); // When on fire

        LootTableEvents.REPLACE.register((resourceKey, lootTable, lootTableSource, provider) -> {
            if (resourceKey.equals(BuiltInLootTables.VILLAGE_FISHER)) {
                LootPool.Builder fisherPool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 5.0F))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.COD).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.WATER_BUCKET).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.BARREL).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.WHEAT_SEEDS).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(MoLoSSItems.CALAMARI).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))); // Add Calamari
                return LootTable.lootTable().withPool(fisherPool).build();
            } else if (resourceKey.equals(BuiltInLootTables.FISHING_FISH)) {
                LootPool.Builder fishingPool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.COD).setWeight(60))
                    .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                    .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                    .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))
                    .add(LootItem.lootTableItem(MoLoSSItems.CALAMARI).setWeight(13));
                return LootTable.lootTable().withPool(fishingPool).build();
            } else if (resourceKey.equals(BuiltInLootTables.FISHERMAN_GIFT)) {
                LootPool.Builder giftPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.COD))
                        .add(LootItem.lootTableItem(Items.SALMON))
                        .add(LootItem.lootTableItem(MoLoSSItems.CALAMARI));
                return LootTable.lootTable().withPool(giftPool).build();
            } else if (resourceKey.equals(EntityType.POLAR_BEAR.getDefaultLootTable().orElseThrow())) {
                LootPool.Builder polarBearPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(MoLoSSItems.CALAMARI)
                            .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, onFirePredicate)))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.COD)
                            .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, onFirePredicate)))
                            .setWeight(3)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(Items.SALMON)
                            .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, onFirePredicate)))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                            .apply(EnchantedCountIncreaseFunction.lootingMultiplier(provider, UniformGenerator.between(0.0F, 1.0F))));
                return LootTable.lootTable().withPool(polarBearPool).build();
            }
            return lootTable;
        });

        LootTableEvents.MODIFY.register((resourceKey, tableBuilder, source, provider) -> {
            if (resourceKey.equals(EntityType.SQUID.getDefaultLootTable().orElseThrow()) || resourceKey.equals(EntityType.GLOW_SQUID.getDefaultLootTable().orElseThrow())) {
                LootPool.Builder squidPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(MoLoSSItems.CALAMARI)
                            .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, onFirePredicate))));
                tableBuilder.withPool(squidPool).build();
            }
        });
    }
}
