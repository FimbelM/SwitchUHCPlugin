package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.util.Collection;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBase;

public class ExtractBase extends CommonExtract<IBase> {

	public ExtractBase(IPersistence<IBase> persistence) {
		super(persistence, "to extract base's blocks");
	}

	@Override
	public String edit(String[] args) {
		try {
			return super.edit(args);
		} catch (IllegalArgumentException e) {
			return ChatColor.RED + e.getMessage();
		}
	}

	@Override
	protected String onExtracted() {
		StringBuilder builder = new StringBuilder();
		builder.append("Base " + get().getName() + " extracted\n")
				.append("Number of chests : " + get().getChestsNumber() + "\n")
				.append("Recognized teams : " + colorName(get().getChests().values()) + "\n");
		return builder.toString();
	}

	private String colorName(Collection<ChatColor> colors) {
		String colorName = "";
		for (ChatColor color : colors)
			colorName += TeamsManager.getColorName(color) + " ";
		return colorName;
	}
}
