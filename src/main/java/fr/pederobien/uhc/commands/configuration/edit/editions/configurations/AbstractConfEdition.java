package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.time.LocalTime;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractEdition<T> {

	public AbstractConfEdition(IPersistence<T> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
