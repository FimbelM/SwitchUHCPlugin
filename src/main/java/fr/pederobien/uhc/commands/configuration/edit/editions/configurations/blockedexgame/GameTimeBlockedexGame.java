package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class GameTimeBlockedexGame extends CommonGameTime<IBlockedexConfiguration> {

	public GameTimeBlockedexGame() {
		super(MessageCode.GAME_TIME_BLOCKEDEX_GAME_EXPLANATION);
	}
}
