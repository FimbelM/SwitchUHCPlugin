package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonRename;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class RenameBlockedexGame extends CommonRename<IBlockedexConfiguration> {

	public RenameBlockedexGame() {
		super(MessageCode.RENAME_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String newName) {
		sendMessage(MessageCode.RENAME_BLOCKEDEX_GAME_ALREADY_EXISTING, get().getName(), newName);
		return;
	}

	@Override
	protected void onRename(String oldName, String newName) {
		sendMessage(MessageCode.RENAME_BLOCKEDEX_GAME_RENAMED, oldName, newName);
	}

	@Override
	protected void onNameIsMissing(String oldName) {
		sendMessage(MessageCode.RENAME_BLOCKEDEX_GAME_MISSING_NAME, oldName);
	}
}
