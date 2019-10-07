package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;

public abstract class AbstractBDEdition implements IEdition {
	private BDEditions edition;
	private BlockedexPersistence persistence;

	public AbstractBDEdition(BlockedexPersistence persistence, BDEditions edition) {
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
	
	protected BlockedexPersistence getPersistence() {
		return persistence;
	}
	
	protected BlockedexConfiguration getConf() {
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