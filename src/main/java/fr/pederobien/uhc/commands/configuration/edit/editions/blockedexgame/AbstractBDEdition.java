package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.time.LocalTime;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public abstract class AbstractBDEdition extends AbstractEdition<IBlockedexConfiguration> implements IEdition {
	private BDEditions edition;

	public AbstractBDEdition(IPersistence<IBlockedexConfiguration> persistence, BDEditions edition) {
		super(persistence);
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

	protected String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}
}
