package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.time.LocalTime;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractConfEdition(String label, String explanation) {
		super(label, explanation);
	}

	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
