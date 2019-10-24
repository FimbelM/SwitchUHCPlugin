package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class RenameHungerGame extends CommonRename<IHungerGameConfiguration> {

	public RenameHungerGame() {
		super("to change the name of current hunger game style");
	}

	@Override
	protected String onAlreadyExisting(String newName) {
		return "Cannot rename hunger game style " + get().getName() + " as " + newName + ", style already exist";
	}

	@Override
	protected String onRename(String oldName, String newName) {
		return "Style " + oldName + " renamed as " + newName;
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot rename hunger game style, need the new name";
	}
}
