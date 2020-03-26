package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonRename;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class RenameBase extends CommonRename<IBase> {

	public RenameBase() {
		super(MessageCode.RENAME_BASE_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String newName) {
		sendMessage(MessageCode.RENAME_BASE_ALREADY_EXISTING, get().getName(), newName);
	}

	@Override
	protected void onRename(String oldName, String newName) {
		sendMessage(MessageCode.RENAME_BASE_RENAMED, oldName, newName);
	}

	@Override
	protected void onNameIsMissing(String oldName) {
		sendMessage(MessageCode.RENAME_BASE_MISSING_NAME, oldName);
	}
}
