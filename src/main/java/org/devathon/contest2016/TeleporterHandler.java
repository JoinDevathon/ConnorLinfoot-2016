package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * File created by Connor Linfoot on 05/11/16.
 * Copyright © 2016. All rights reserved.
 * This file along with any other assets may
 * not be reproduced or distributed in any
 * way without written permission of the author.
 */
public class TeleporterHandler {
	private DevathonPlugin devathonPlugin;
	private HashMap<UUID, Location> pendingPads = new HashMap<>();
	private ArrayList<TeleporterPad> pads = new ArrayList<>();

	public TeleporterHandler(DevathonPlugin devathonPlugin) {
		this.devathonPlugin = devathonPlugin;
	}

	public void addLocation(Player player, Location location) {
		if (pendingPads.containsKey(player.getUniqueId())) {
			// Already has pending pad placed
			Location pad1 = pendingPads.get(player.getUniqueId());
			TeleporterPad teleporterPad = new TeleporterPad(pad1, location, player);
			pendingPads.remove(player.getUniqueId());
		} else {
			// First pad being placed
			pendingPads.put(player.getUniqueId(), location);
			player.sendMessage(ChatColor.GOLD + "First pad placed, place a second pad at the other location");
		}
	}

}
