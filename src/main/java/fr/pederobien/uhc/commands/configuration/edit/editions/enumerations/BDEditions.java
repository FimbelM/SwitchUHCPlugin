package fr.pederobien.uhc.commands.configuration.edit.editions.enumerations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public enum BDEditions {
	GAME_TIME("gametime", "to set the time of the game"),
	SCOREBOARD_REFRESH("scoreboardrefresh", "to set the number of servers's tic after which the scoreboard of each player is refreshed"),
	RENAME("rename", "to change the name of current blockedex game style"),
	LOAD("load", "to load a blockedex game style"),
	NEW("new", "to create a new blockedex game style"),
	CURRENT("current", "to know the name of the current blockedex game style"),
	AS_CURRENT("ascurrent", "to set the current blockedex game as the current configuration"),
	SAVE("save", "to save the current blockedex game style"),
	LIST("list", "to display all existing blockedex game style (s)"),
	HELP("help", "to display all features");

	private String label;
	private String explanation;
	
	public static BDEditions find(String label) {
		for (BDEditions edition : BDEditions.values())
			if (edition.getLabel().equals(label))
				return edition;
		return null;
	}
	
	public static List<String> labels() {
		List<String> labels = new ArrayList<String>();
		for (BDEditions edition : BDEditions.values())
			labels.add(edition.label);
		return labels;
	}

	private BDEditions(String label, String explanation) {
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
