package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class GameTimeBlockedexGame extends CommonGameTime<IBlockedexConfiguration> {

	public GameTimeBlockedexGame() {
		super("to set the time of the blockedex game");
	}
}
