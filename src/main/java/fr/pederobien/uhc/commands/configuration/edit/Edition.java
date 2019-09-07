package fr.pederobien.uhc.commands.configuration.edit;

import org.bukkit.ChatColor;

public class Edition {
	private String label;
	private String explanation;
	private String expectedArgs;
	
	public Edition(String label, String explanation, String expectedArgs) {
		this.label = label;
		this.explanation = explanation;
		this.expectedArgs = expectedArgs;
	}
	
	public String help() {
		return ChatColor.RED + label + ChatColor.RESET + " - " + ChatColor.BLUE + explanation;
	}

	public String getLabel() {
		return label;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getExpectedArgs() {
		return expectedArgs;
	}
}
