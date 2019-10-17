package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class ListeBlockedexGame extends CommonList<IBlockedexConfiguration> {

	public ListeBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "to display all existing blockedex game style (s)");
	}

	@Override
	protected String onSizeGreatThan0() {
		return "List of existing blockedex game style (s) :\n";
	}

	@Override
	protected String onSizeEquals0() {
		return "No existing blockedex game style";
	}
}
