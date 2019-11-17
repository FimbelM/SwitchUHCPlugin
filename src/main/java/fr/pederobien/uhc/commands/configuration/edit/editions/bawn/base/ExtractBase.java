package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import java.util.Collection;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.managers.ETeam;

public class ExtractBase extends CommonExtract<IBase> {

	public ExtractBase() {
		super("to extract base's blocks");
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
		String onExtracted = "Base " + get().getName() + " extracted\n";
		switch (get().getChestsNumber()) {
		case 1:
			onExtracted += "One chest for " + get().getChests().values().iterator().next().getColorNameWithColor() + " team";
			break;
			default:
				onExtracted += "Chests for teams : " + colorName(get().getChests().values());
		}
		return onExtracted;
	}

	private String colorName(Collection<ETeam> teams) {
		String colorName = "";
		for (ETeam team : teams)
			colorName += team.getColorNameWithColor() + " ";
		return colorName;
	}
}
