package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.time.LocalTime;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.configurations.IConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public abstract class AbstractConfEdition<T extends IConfiguration> extends AbstractEdition<T> {

	public AbstractConfEdition(IPersistence<T> persistence, String label, String explanation) {
		super(persistence, label, explanation);
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}

	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
