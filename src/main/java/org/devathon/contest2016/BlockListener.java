package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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
		if (event.getBlock().getType().equals(Material.IRON_PLATE) && event.getItemInHand().hasItemMeta()) {
			devathonPlugin.getTeleporterHandler().addLocation(event.getPlayer(), event.getBlock().getLocation());
			return;
		}

		Block blockBelow = event.getBlock().getLocation().clone().add(0, -1, 0).getBlock();
		if (blockBelow != null && blockBelow.getType().equals(Material.IRON_PLATE) && (devathonPlugin.getTeleporterHandler().isTeleporterPad(blockBelow.getLocation()) || devathonPlugin.getTeleporterHandler().isPendingLocation(blockBelow.getLocation()))) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBucket(PlayerBucketEmptyEvent event) {

	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getType().equals(Material.IRON_PLATE)) {

		}
	}

	@EventHandler
	public void onBlockInteract(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.PHYSICAL)) {
			if (event.getClickedBlock().getType().equals(Material.IRON_PLATE)) {
				if (devathonPlugin.getTeleporterHandler().isPendingLocation(event.getClickedBlock().getLocation())) {
					event.getPlayer().sendMessage(ChatColor.RED + "This pad has not yet been linked");
				} else if (devathonPlugin.getTeleporterHandler().isTeleporterPad(event.getClickedBlock().getLocation())) {
					TeleporterPad teleporterPad = devathonPlugin.getTeleporterHandler().getTeleporterPad(event.getClickedBlock().getLocation());
					teleporterPad.teleport(event.getPlayer(), event.getClickedBlock().getLocation());
				}
			}
		}
	}

}
