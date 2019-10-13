package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class ListHungerGame extends CommonList<IHungerGameConfiguration> {

	public ListHungerGame(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "to display all existing hunger game style (s)");
	}

	@Override
	protected String onSizeGreatThan0() {
		return "List of existing hunger game style (s) :\n";
	}

	@Override
	protected String onSizeEquals0() {
		return "No existing hunger game style";
	}
}
