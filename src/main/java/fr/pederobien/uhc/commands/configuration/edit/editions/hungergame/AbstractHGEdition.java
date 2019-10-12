package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractHGEdition extends AbstractEdition<IHungerGameConfiguration> implements IEdition {

	public AbstractHGEdition(IPersistence<IHungerGameConfiguration> persistence, String label, String explanation) {
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
