package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class ScoreboardRefresh extends AbstractHGEdition {

	public ScoreboardRefresh(HungerGamePersistence persistence) {
		super(persistence, HGEditions.SCOREBOARD_REFRESH);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setScoreboardRefresh(Long.parseLong(args[1]));
			return "Scoreboard refreshed each " + getConf().getScoreboardRefresh() + " tics";
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			return "Cannot set the scoreboard refrresh value, need a number of tics";
		}
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<number of tics>");
		default:
			return null;
		}
	}
}
