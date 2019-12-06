package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RenameSpawn extends CommonRename<ISpawn> {

	public RenameSpawn() {
		super(MessageCode.RENAME_SPAWN_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String newName) {
		sendMessage(MessageCode.RENAME_SPAWN_ALREADY_EXISTING, get().getName(), newName);
	}

	@Override
	protected void onRename(String oldName, String newName) {
		sendMessage(MessageCode.RENAME_SPAWN_RENAMED, oldName, newName);
	}

	@Override
	protected void onNameIsMissing(String oldName) {
		sendMessage(MessageCode.RENAME_SPAWN_MISSING_NAME, oldName);
	}
}
