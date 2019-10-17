package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class LoadHungerGame extends CommonLoad<IHungerGameConfiguration> {

	public LoadHungerGame(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "to load an hunger game style");
	}

	@Override
	protected String onStyleLoaded() {
		return "Hunger game style loaded : " + get().getName();
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot load hunger game style, need the name";
	}
}
