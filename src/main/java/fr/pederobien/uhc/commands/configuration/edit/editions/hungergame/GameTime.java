package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class GameTime extends AbstractHGEdition {

	public GameTime(HungerGamePersistence persistence) {
		super(persistence, HGEditions.GAME_TIME);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setGameTime(LocalTime.parse(args[1]));
			return "New game time " + showTime(getConf().getGameTime()) + " defined";
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
