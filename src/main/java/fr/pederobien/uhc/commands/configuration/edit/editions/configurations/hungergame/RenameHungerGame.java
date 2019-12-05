package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonRename;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class RenameHungerGame extends CommonRename<IHungerGameConfiguration> {

	public RenameHungerGame() {
		super(MessageCode.RENAME_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String newName) {
		return MessageCode.RENAME_HUNGER_GAME_ALREADY_EXISTING.withArgs(get().getName(), newName);
	}

	@Override
	protected MessageCode onRename(String oldName, String newName) {
		return MessageCode.RENAME_HUNGER_GAME_RENAMED.withArgs(oldName, newName);
	}

	@Override
	protected MessageCode onNameIsMissing(String oldName) {
		return MessageCode.RENAME_HUNGER_GAME_MISSING_NAME.withArgs(oldName);
	}
}
