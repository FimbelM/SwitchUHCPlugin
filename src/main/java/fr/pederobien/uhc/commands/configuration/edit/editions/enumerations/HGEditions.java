package fr.pederobien.uhc.commands.configuration.edit.editions.enumerations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public enum HGEditions {
	BORDER_CENTER("bordercenter", "to set the center of the world's border"),
	INITIAL_BORDER_DIAMETER("initialborderdiameter", "to set the initial diameter of the world's border"),
	FINAL_BORDER_DIAMETER("finalborderdiameter", "to set the initial diameter of the world's border"),
	GAME_TIME("gametime", "to set the time after which the world border move from its initial to final diameter"),
	FRACTION_TIME("fractiontime", "to set the time after which players will not respawn in survivor mode"),
	SCOREBOARD_REFRESH("scoreboardrefresh", "to set the number of servers's tic after which the scoreboard of each player is refreshed"),
	RENAME("rename", "to change the name of current hunger game style"),
	LOAD("load", "to load an hunger game style"),
	NEW("new", "to create a new hunger game style"),
	CURRENT("current", "to know the name of the current hunger game style"),
	AS_CURRENT("ascurrent", "to set the current hunger game style as the current configuration"),
	SAVE("save", "to save the current hunger game style"),
	LIST("list", "to display all existing hunger game style (s)"),
	HELP("help", "to display all features");

	private String label;
	private String explanation;
	
	public static HGEditions find(String label) {
		for (HGEditions edition : HGEditions.values())
			if (edition.getLabel().equals(label))
				return edition;
		return null;
	}
	
	public static List<String> labels() {
		List<String> labels = new ArrayList<String>();
		for (HGEditions edition : HGEditions.values())
			labels.add(edition.label);
		return labels;
	}

	private HGEditions(String label, String explanation) {
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
