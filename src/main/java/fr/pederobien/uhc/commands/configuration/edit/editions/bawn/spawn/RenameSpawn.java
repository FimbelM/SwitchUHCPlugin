package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RenameSpawn extends CommonRename<ISpawn> {

	public RenameSpawn() {
		super("to rename the spawn");
	}

	@Override
	protected String onAlreadyExisting(String newName) {
		return "Cannot rename spawn " + get().getName() + " as " + newName + ", spawn already exist";
	}

	@Override
	protected String onRename(String oldName, String newName) {
		return "Spawn " + oldName + " renamed as " + newName;
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot rename the spawn, need the name";
	}
}
