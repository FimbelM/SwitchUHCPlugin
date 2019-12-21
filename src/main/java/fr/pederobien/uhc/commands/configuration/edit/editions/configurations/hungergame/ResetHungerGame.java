package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonReset;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class ResetHungerGame extends CommonReset<IHungerGameConfiguration> {

	public ResetHungerGame() {
		super(MessageCode.RESET_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_HUNGER_GAME_MESSAGE, name);
	}

}
