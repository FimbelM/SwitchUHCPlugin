package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class GameTimeHungerGame extends CommonGameTime<IHungerGameConfiguration> {

	public GameTimeHungerGame() {
		super(MessageCode.GAME_TIME_HUNGER_GAME_EXPLANATION);
	}
}
