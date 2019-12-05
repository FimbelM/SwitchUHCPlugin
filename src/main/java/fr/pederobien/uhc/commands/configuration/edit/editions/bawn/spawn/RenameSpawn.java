package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class RenameSpawn extends CommonRename<ISpawn> {

	public RenameSpawn() {
		super(MessageCode.RENAME_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String newName) {
		return MessageCode.RENAME_SPAWN_ALREADY_EXISTING.withArgs(get().getName(), newName);
	}

	@Override
	protected MessageCode onRename(String oldName, String newName) {
		return MessageCode.RENAME_SPAWN_RENAMED.withArgs(oldName, newName);
	}

	@Override
	protected MessageCode onNameIsMissing(String oldName) {
		return MessageCode.RENAME_SPAWN_MISSING_NAME.withArgs(oldName);
	}
}
