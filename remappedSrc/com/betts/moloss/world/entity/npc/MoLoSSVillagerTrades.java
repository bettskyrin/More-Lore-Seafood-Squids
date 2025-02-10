package com.betts.moloss.world.entity.npc;

import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import java.util.Optional;

public class MoLoSSVillagerTrades {

    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 4, factories -> {
            factories.add((entity, randomSource) -> new TradeOffer(
                    new TradedItem(MoLoSSItems.CALAMARI, 15), new ItemStack(Items.EMERALD),16, 20, 0.05F
            ));
        });

    }
}
