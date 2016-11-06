package org.devathon.contest2016;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin {
	private TeleporterHandler teleporterHandler = null;

	@Override
	public void onEnable() {
		getLogger().info("Enabling Devathon Teleporter Plugin...");

		teleporterHandler = new TeleporterHandler(this);

		// Custom recipe

		ItemStack teleporterPad = new ItemStack(Material.IRON_PLATE);
		ItemMeta teleporterPadMeta = teleporterPad.getItemMeta();
		teleporterPadMeta.setDisplayName(ChatColor.GOLD + "Teleporter Pad");
		teleporterPad.setItemMeta(teleporterPadMeta);

		ShapedRecipe teleporterRecipe = new ShapedRecipe(teleporterPad).shape("rdr", "did", "rdr").setIngredient('r', Material.REDSTONE).setIngredient('d', Material.DIAMOND).setIngredient('i', Material.IRON_PLATE);
		getServer().addRecipe(teleporterRecipe);

		// Register Listeners

		getServer().getPluginManager().registerEvents(new BlockListener(this), this);
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabling Devathon Teleporter Plugin...");
	}

	public TeleporterHandler getTeleporterHandler() {
		return teleporterHandler;
	}

}

