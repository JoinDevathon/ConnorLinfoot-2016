package org.devathon.contest2016;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * File created by Connor Linfoot on 05/11/16.
 * Copyright © 2016. All rights reserved.
 * This file along with any other assets may
 * not be reproduced or distributed in any
 * way without written permission of the author.
 */
public class BlockListener implements Listener {
	private DevathonPlugin devathonPlugin;

	public BlockListener(DevathonPlugin devathonPlugin) {
		this.devathonPlugin = devathonPlugin;
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if( event.getBlock().getType().equals(Material.IRON_PLATE) && event.getItemInHand().hasItemMeta() ) {
			devathonPlugin.getTeleporterHandler().addLocation(event.getPlayer(),event.getBlock().getLocation());
		}
	}

}
