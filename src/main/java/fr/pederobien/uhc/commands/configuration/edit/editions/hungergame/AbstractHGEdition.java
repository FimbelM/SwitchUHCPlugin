package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public abstract class AbstractHGEdition implements IEdition {
	private HGEditions edition;
	private HungerGamePersistence persistence;

	public AbstractHGEdition(HungerGamePersistence persistence, HGEditions edition) {
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
	
	protected HungerGamePersistence getPersistence() {
		return persistence;
	}
	
	protected HungerGameConfiguration getConf() {
		return persistence.get();
	}
	
	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
