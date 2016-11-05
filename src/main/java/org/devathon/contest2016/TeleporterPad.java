package org.devathon.contest2016;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * File created by Connor Linfoot on 05/11/16.
 * Copyright © 2016. All rights reserved.
 * This file along with any other assets may
 * not be reproduced or distributed in any
 * way without written permission of the author.
 */
public class TeleporterPad {
	private Location pad1 = null;
	private Location pad2 = null;
	private UUID owner = null;

	public TeleporterPad(Location pad1, Location pad2, Player owner ) {
		this.pad1 = pad1;
		this.pad2 = pad2;
		this.owner = owner.getUniqueId();
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

}
