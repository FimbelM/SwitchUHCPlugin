package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class SaveHungerGame extends CommonSave<IHungerGameConfiguration> {

	public SaveHungerGame() {
		super(MessageCode.SAVE_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onSave() {
		return MessageCode.SAVE_HUNGER_GAME_SAVED.withArgs(get().getName());
	}
}
