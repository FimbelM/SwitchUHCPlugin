package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
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
}
