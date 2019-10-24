package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class SaveBlockedexGame extends CommonSave<IBlockedexConfiguration> {

	public SaveBlockedexGame() {
		super("to save the current blockedex game style");
	}

	@Override
	protected String onSave() {
		return "Style " + get().getName() + " saved";
	}
}
