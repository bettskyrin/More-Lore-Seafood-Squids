package com.betts.moloss.world.entity.npc;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Optional;

public class MoLoSSVillagerTrades {

    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 4, factories -> {
            factories.add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(MoLoSSItems.CALAMARI, 15), new ItemStack(Items.EMERALD),16, 20, 0.05F
            ));
        });

    }
}
