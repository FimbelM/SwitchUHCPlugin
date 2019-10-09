package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractHGEdition implements IEdition {
	private HGEditions edition;
	private IPersistence<IHungerGameConfiguration> persistence;

	public AbstractHGEdition(IPersistence<IHungerGameConfiguration> persistence, HGEditions edition) {
		this.persistence = persistence;
		this.edition = edition;
	}

	@Override
	public String getLabel() {
		return edition.getLabel();
	}

	@Override
	public String help() {
		return edition.help();
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return null;
	}

	protected IPersistence<IHungerGameConfiguration> getPersistence() {
		return persistence;
	}

	protected IHungerGameConfiguration getConf() {
		return persistence.get();
	}

	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}

	protected List<String> filter(List<String> list, String filter) {
		Predicate<String> match = str -> str.matches(filter + "(.*)");
		return list.stream().filter(match).collect(Collectors.toList());
	}
}
