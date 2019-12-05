package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class DeleteHungerGame extends CommonDelete<IHungerGameConfiguration> {

	public DeleteHungerGame() {
		super(MessageCode.DELETE_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onDeleted(String name) {
		return MessageCode.DELETE_HUNGER_GAME_MESSAGE.withArgs(name);
	}
}
