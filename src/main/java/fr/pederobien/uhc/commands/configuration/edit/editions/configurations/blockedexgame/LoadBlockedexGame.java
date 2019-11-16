package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class LoadBlockedexGame extends CommonLoad<IBlockedexConfiguration> {

	public LoadBlockedexGame() {
		super("to load a blockedex game style");
	}

	@Override
	protected String onStyleLoaded() {
		String style = "Blockedex game style loaded : " + get().getName() + "\n";
		switch (get().getTeams().size()) {
		case 0 :
			style += "No team created";
			break;
		case 1 :
			style += "Team " + get().getTeams().get(0).getNameWithColor() + " created";
			break;
		default :
			style += "Teams created : " + getTeamNamesWithColor();
		}
		return style;
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot load blockedex game style, need the name";
	}
}
