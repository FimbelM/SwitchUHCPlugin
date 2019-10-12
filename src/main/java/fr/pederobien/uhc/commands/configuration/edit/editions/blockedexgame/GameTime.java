package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class GameTime extends AbstractBDEdition {

	public GameTime(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "gametime", "to set the time of the game");
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setGameTime(LocalTime.parse(args[0]));
			return "Game time defined : " + showTime(getConf().getGameTime());
		} catch (IndexOutOfBoundsException | DateTimeParseException e) {
			return "Cannot set the game time, need time at format hh:mm:ss";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<hh:mm:ss>");
		default:
			return null;
		}
	}
}
