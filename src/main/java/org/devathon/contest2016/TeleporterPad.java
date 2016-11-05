package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * File created by Connor Linfoot on 05/11/16.
 * Copyright © 2016. All rights reserved.
 * This file along with any other assets may
 * not be reproduced or distributed in any
 * way without written permission of the author.
 */
public class TeleporterPad {
	private UUID uuid = null;
	private Location pad1 = null;
	private Location pad2 = null;
	private UUID owner = null;

	public TeleporterPad(Location pad1, Location pad2, Player owner) {
		this.uuid = UUID.randomUUID();
		this.pad1 = pad1;
		this.pad2 = pad2;
		this.owner = owner.getUniqueId();
	}

	public UUID getUuid() {
		return uuid;
	}

	public Location getPad1() {
		return pad1;
	}

	public Location getPad2() {
		return pad2;
	}

	public UUID getOwner() {
		return owner;
	}

	public void teleport(Player player, Location location) {
		if (getPad1().equals(location)) {
			player.teleport(getPad2().clone().add(0.5, 1, 0.5));
			player.sendMessage(ChatColor.GREEN + "Whoosh");
		} else if (getPad2().equals(location)) {
			player.teleport(getPad1().clone().add(0.5, 1, 0.5));
			player.sendMessage(ChatColor.GREEN + "Whoosh");
		} else {
			// This shouldn't happen... if so RIP?
			player.sendMessage("I don't even know how you got here...");
		}
	}

}
