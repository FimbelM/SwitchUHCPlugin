package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class RenameBlockedexGame extends CommonRename<IBlockedexConfiguration> {

	public RenameBlockedexGame() {
		super(MessageCode.RENAME_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String newName) {
		return MessageCode.RENAME_BLOCKEDEX_GAME_ALREADY_EXISTING.withArgs(get().getName(), newName);
	}

	@Override
	protected MessageCode onRename(String oldName, String newName) {
		return MessageCode.RENAME_BLOCKEDEX_GAME_RENAMED.withArgs(oldName, newName);
	}

	@Override
	protected MessageCode onNameIsMissing(String oldName) {
		return MessageCode.RENAME_BLOCKEDEX_GAME_MISSING_NAME.withArgs(oldName);
	}
}
