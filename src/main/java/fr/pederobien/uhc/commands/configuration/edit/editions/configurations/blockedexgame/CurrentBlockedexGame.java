package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class CurrentBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public CurrentBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "current", "to know the name of the current blockedex game style");
	}

	@Override
	public String edit(String[] args) {
		return "Current blockedex game style " + get().getName();
	}
}
