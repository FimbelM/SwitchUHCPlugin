package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class ScoreboardRefresh extends AbstractHGEdition {

	public ScoreboardRefresh(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "scoreboardrefresh",
				"to set the number of servers's tic after which the scoreboard of each player is refreshed");
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setScoreboardRefresh(Long.parseLong(args[0]));
			return "Scoreboard refreshed each " + getConf().getScoreboardRefresh() + " tics";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the scoreboard refrresh value, need a number of tics";
		} catch (NumberFormatException e) {
			return "Cannot parse number of tics";
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
