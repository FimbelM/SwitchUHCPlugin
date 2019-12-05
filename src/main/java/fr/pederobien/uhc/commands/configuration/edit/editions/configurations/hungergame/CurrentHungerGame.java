package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class CurrentHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public CurrentHungerGame() {
		super("current", MessageCode.AS_CURRENT_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		return MessageCode.CURRENT_HUNGER_GAME_MESSAGE.withArgs(get().getName());
	}
}
