package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class DeleteBlockedexGame extends CommonDelete<IBlockedexConfiguration> {

	public DeleteBlockedexGame() {
		super("to delete a blockedex game style");
	}

	@Override
	protected String onDeleted(String name) {
		return "Blockedex style " + name + " deleted";
	}

}
