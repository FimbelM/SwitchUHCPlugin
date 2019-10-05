package fr.pederobien.uhc.commands.configuration.edit.editions.enumerations;

import org.bukkit.ChatColor;

public enum SpawnEditions {
	CENTER("center", "to set the spawn's center"),
	DIMENSIONS("dimensions", "to set the dimensions of the spawn (width height depth)"),
	RENAME("rename", "to rename the spawn"), NEW("new", "to create a new spawn"),
	CURRENT("current", "to know the current spawn's name"), LAUNCH("launch", "to launch a spawn in the world"),
	SAVE("save", "to save a spawn"), REMOVE("remove", "to remove the spawn from the world"),
	EXTRACT("extract", "to extract world's block"), LIST("list", "to display all existing spawn(s)");
	private String label;
	private String explanation;

	private SpawnEditions(String label, String explanation) {
		this.label = label;
		this.explanation = explanation;
	}

	public String getLabel() {
		return label;
	}

	public String help() {
		return ChatColor.RED + label + ChatColor.RESET + " - " + ChatColor.BLUE + explanation;
	}
}
