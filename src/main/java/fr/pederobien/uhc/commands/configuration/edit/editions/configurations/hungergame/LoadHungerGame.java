package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class LoadHungerGame extends CommonLoad<IHungerGameConfiguration> {

	public LoadHungerGame() {
		super("to load an hunger game style");
	}

	@Override
	protected String onStyleLoaded() {
		String style = "Hunger game style loaded : " + get().getName() + "\n";
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
		return "Cannot load hunger game style, need the name";
	}
}
