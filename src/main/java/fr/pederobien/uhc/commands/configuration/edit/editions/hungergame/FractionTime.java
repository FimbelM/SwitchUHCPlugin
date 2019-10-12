package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class FractionTime extends AbstractHGEdition {

	public FractionTime(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "fractiontime", "to set the time after which players will not respawn in survivor mode");
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setFractionTime(LocalTime.parse(args[0]));
			return "Fraction time defined : " + showTime(getConf().getFractionTime());
		} catch (IndexOutOfBoundsException | DateTimeParseException e) {
			return "Cannot set the fraction time, need time at format hh:mm:ss";
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
