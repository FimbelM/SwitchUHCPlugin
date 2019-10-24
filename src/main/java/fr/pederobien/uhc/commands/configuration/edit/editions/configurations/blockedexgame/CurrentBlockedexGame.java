package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class CurrentBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public CurrentBlockedexGame() {
		super("current", "to know the name of the current blockedex game style");
	}

	@Override
	public String edit(String[] args) {
		return "Current blockedex game style " + get().getName();
	}
}
