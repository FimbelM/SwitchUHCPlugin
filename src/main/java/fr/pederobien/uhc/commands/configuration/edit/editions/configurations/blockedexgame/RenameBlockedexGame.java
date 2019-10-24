package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class RenameBlockedexGame extends CommonRename<IBlockedexConfiguration> {

	public RenameBlockedexGame() {
		super("to change the name of current blockedex game style");
	}

	@Override
	protected String onAlreadyExisting(String newName) {
		return "Cannot rename blockedex game style " + get().getName() + " as " + newName + ", style already exist";
	}

	@Override
	protected String onRename(String oldName, String newName) {
		return "Style " + oldName + " renamed as " + newName;
	}

	@Override
	protected String onNameIsMissing() {
		return null;
	}
}
