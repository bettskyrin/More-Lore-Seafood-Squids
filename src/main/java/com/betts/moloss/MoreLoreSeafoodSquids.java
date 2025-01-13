package com.betts.moloss;

import com.betts.moloss.data.loot.packs.MoLoSSLoot;
import com.betts.moloss.world.item.MoLoSSItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreLoreSeafoodSquids implements ModInitializer {
	public static final String MOD_ID = "moloss";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("More Lore: Seafood Squids initializing!");
		MoLoSSItems.register();
		MoLoSSLoot.modifyLoot();
	}
}