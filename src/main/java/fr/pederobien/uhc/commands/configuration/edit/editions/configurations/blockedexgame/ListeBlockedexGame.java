package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonList;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class ListeBlockedexGame extends CommonList<IBlockedexConfiguration> {

	public ListeBlockedexGame() {
		super("to display all existing blockedex game style (s)");
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
