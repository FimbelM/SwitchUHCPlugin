package fr.pederobien.uhc.commands.configuration.edit.editions.enumerations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public enum SpawnEditions {
	CENTER("center", "to set the spawn's center"),
	DIMENSIONS("dimensions", "to set the dimensions of the spawn (width height depth)"),
	RENAME("rename", "to rename the spawn"),
	NEW("new", "to create a new spawn"),
	CURRENT("current", "to know the current spawn's name"),
	LAUNCH("launch", "to launch a spawn in the world"),
	SAVE("save", "to save a spawn"),
	REMOVE("remove", "to remove the spawn from the world"),
	EXTRACT("extract", "to extract world's block"),
	LIST("list", "to display all existing spawn(s)"),
	HELP("help", "to display all features");
	
	private String label;
	private String explanation;
	
	public static SpawnEditions find(String label) {
		for (SpawnEditions edition : SpawnEditions.values())
			if (edition.getLabel().equals(label))
				return edition;
		return null;
	}
	
	public static List<String> labels() {
		List<String> labels = new ArrayList<String>();
		for (SpawnEditions edition : SpawnEditions.values())
			labels.add(edition.label);
		return labels;
	}

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
