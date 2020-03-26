package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonRename;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class RenameHungerGame extends CommonRename<IHungerGameConfiguration> {

	public RenameHungerGame() {
		super(MessageCode.RENAME_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String newName) {
		sendMessage(MessageCode.RENAME_HUNGER_GAME_ALREADY_EXISTING, get().getName(), newName);
	}

	@Override
	protected void onRename(String oldName, String newName) {
		sendMessage(MessageCode.RENAME_HUNGER_GAME_RENAMED, oldName, newName);
	}

	@Override
	protected void onNameIsMissing(String oldName) {
		sendMessage(MessageCode.RENAME_HUNGER_GAME_MISSING_NAME, oldName);
	}
}
