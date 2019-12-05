package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class RenameBase extends CommonRename<IBase> {

	public RenameBase() {
		super(MessageCode.RENAME_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String newName) {
		return MessageCode.RENAME_BASE_ALREADY_EXISTING.withArgs(get().getName(), newName);
	}

	@Override
	protected MessageCode onRename(String oldName, String newName) {
		return MessageCode.RENAME_BASE_RENAMED.withArgs(oldName, newName);
	}

	@Override
	protected MessageCode onNameIsMissing(String oldName) {
		return MessageCode.RENAME_BASE_MISSING_NAME.withArgs(oldName);
	}
}
