package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class SaveBlockedexGame extends CommonSave<IBlockedexConfiguration> {

	public SaveBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "to save the current blockedex game style");
	}

	@Override
	protected String onSave() {
		return "Style " + get().getName() + " saved";
	}
}
