package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

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
	private HashMap<Location, UUID> padLocations = new HashMap<>();
	private HashMap<UUID, TeleporterPad> pads = new HashMap<>();

	public TeleporterHandler(DevathonPlugin devathonPlugin) {
		this.devathonPlugin = devathonPlugin;
	}

	public void addLocation(Player player, Location location) {
		if (pendingPads.containsKey(player.getUniqueId())) {
			// Already has pending pad placed
			Location pad1 = pendingPads.get(player.getUniqueId());
			TeleporterPad teleporterPad = new TeleporterPad(pad1, location, player);
			pads.put(teleporterPad.getUuid(), teleporterPad);
			padLocations.put(pad1, teleporterPad.getUuid());
			padLocations.put(location, teleporterPad.getUuid());
			pendingPads.remove(player.getUniqueId());
			player.sendMessage(ChatColor.GREEN + "Pads have been linked, happy teleporting");
		} else {
			// First pad being placed
			pendingPads.put(player.getUniqueId(), location);
			player.sendMessage(ChatColor.GOLD + "First pad placed, place a second pad at the other location");
		}
	}

	public boolean isPendingLocation(Location location) {
		return pendingPads.containsValue(location);
	}

	public void removePendingLocation(Location location) {
		if (isPendingLocation(location)) {

		}
	}

	public boolean isTeleporterPad(Location location) {
		return padLocations.containsKey(location);
	}

	public TeleporterPad getTeleporterPad(Location location) {
		return pads.get(padLocations.get(location));
	}

}
