package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class GameTimeHungerGame extends CommonGameTime<IHungerGameConfiguration> {

	public GameTimeHungerGame() {
		super(MessageCode.GAME_TIME_HUNGER_GAME_EXPLANATION);
	}
}
