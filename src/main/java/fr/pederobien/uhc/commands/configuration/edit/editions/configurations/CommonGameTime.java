package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.configurations.IConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public abstract class CommonGameTime<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonGameTime(IPersistence<T> persistence, String explanation) {
		super(persistence, "gametime", explanation);
	}
		
	@Override
	public String edit(String[] args) {
		try {
			get().setGameTime(LocalTime.parse(args[0]));
			return "Game time defined : " + showTime(get().getGameTime());
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
