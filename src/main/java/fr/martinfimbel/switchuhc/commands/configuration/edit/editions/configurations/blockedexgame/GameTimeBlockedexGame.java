package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class GameTimeBlockedexGame extends CommonGameTime<IBlockedexConfiguration> {

	public GameTimeBlockedexGame() {
		super(MessageCode.GAME_TIME_BLOCKEDEX_GAME_EXPLANATION);
	}
}
