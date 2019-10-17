package fr.pederobien.uhc.commands.configuration.edit.editions.configurations;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class CommonScoreboardRefresh<T extends IConfiguration> extends AbstractConfEdition<T> {

	public CommonScoreboardRefresh(IPersistence<T> persistence) {
		super(persistence, "scoreboardrefresh",
				"to set the number of servers's tic after which the scoreboard of each player is refreshed");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setScoreboardRefresh(Long.parseLong(args[0]));
			return "Scoreboard refreshed each " + get().getScoreboardRefresh() + " tics";
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
