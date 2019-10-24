package fr.pederobien.uhc.commands.configuration.edit.editions;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.interfaces.IEdition;

public abstract class AbstractEdition implements IEdition {
	private String label, explanation;

	public AbstractEdition(String label, String explanation) {
		this.label = label;
		this.explanation = explanation;
	}

	@Override
	public String help() {
		return ChatColor.DARK_RED + label + " - " + ChatColor.DARK_AQUA + explanation;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getExplanation() {
		return explanation;
	}
}
