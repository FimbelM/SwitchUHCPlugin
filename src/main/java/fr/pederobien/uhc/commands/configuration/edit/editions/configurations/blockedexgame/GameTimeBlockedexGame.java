package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonGameTime;
import fr.pederobien.uhc.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class GameTimeBlockedexGame extends CommonGameTime<IBlockedexConfiguration> {

	public GameTimeBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "to set the time of the blockedex game");
	}
}
