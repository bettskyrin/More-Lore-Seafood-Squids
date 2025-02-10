package com.betts.moloss.data.loot.packs;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;

public class MoLoSSLoot {
    public static void modifyLoot() {
        LootTableEvents.MODIFY.register((resourceKey, tableBuilder, source, provider) -> {
            EntityPredicate onFirePredicate = EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true)).build(); // When on fire

            if (resourceKey.equals(LootTables.VILLAGE_FISHER_CHEST)) {
                tableBuilder.modifyPools(poolBuilder -> {
                    poolBuilder.with(ItemEntry.builder(MoLoSSItems.CALAMARI).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))).build(); // Add Calamari
                });
            } else if (resourceKey.equals(LootTables.FISHING_FISH_GAMEPLAY)) {
                tableBuilder.modifyPools(poolBuilder -> {
                    poolBuilder.with(ItemEntry.builder(MoLoSSItems.CALAMARI).weight(13)).build();
                });
            } else if (resourceKey.equals(LootTables.HERO_OF_THE_VILLAGE_FISHERMAN_GIFT_GAMEPLAY)) {
                tableBuilder.modifyPools(poolBuilder -> {
                   poolBuilder.with(ItemEntry.builder(MoLoSSItems.CALAMARI)).build();
                });
            } else if (resourceKey.equals(EntityType.SQUID.getLootTableKey().orElseThrow()) || resourceKey.equals(EntityType.GLOW_SQUID.getLootTableKey().orElseThrow())) {
                LootPool.Builder squidPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(MoLoSSItems.CALAMARI)
                                .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, onFirePredicate))));
                tableBuilder.pool(squidPool).build();
            } else if (resourceKey.equals(EntityType.POLAR_BEAR.getLootTableKey().orElseThrow())) {
                tableBuilder.modifyPools(poolBuilder -> {
                    poolBuilder.with(ItemEntry.builder(MoLoSSItems.CALAMARI)
                            .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, onFirePredicate)))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))
                            .apply(EnchantedCountIncreaseLootFunction.builder(provider, UniformLootNumberProvider.create(0.0F, 1.0F)))).build();
                });
            }
        });
    }
}
