package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public abstract class AbstractTeamEditions<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractTeamEditions(String label, String explanation) {
		super(label, explanation);
	}

	protected List<String> getTeamNamesWithoutColor() {
		List<String> teams = emptyList();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithoutColor());
		return teams;
	}

	protected List<String> getTeamNamesWithColor() {
		List<String> teams = emptyList();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithColor());
		return teams;
	}

	protected List<String> getTeams(String[] teamAlreadyMentionned) {
		List<String> teams = new ArrayList<String>();
		for (ETeam team : get().getTeams())
			if (!Arrays.asList(teamAlreadyMentionned).contains(team.getNameWithoutColor()))
				teams.add(team.getNameWithoutColor());
		return teams;
	}

	protected List<String> getFreePlayersName(String[] playersAlreadyMentionned) {
		List<String> players = emptyList();
		List<String> allPlayers = PlayerManager.getPlayersName();
		List<String> playersInTeam = emptyList();

		for (ETeam team : get().getTeams())
			playersInTeam.addAll(team.getPlayers());

		allPlayers.removeAll(playersInTeam);
		for (String player : allPlayers)
			if (!Arrays.asList(playersAlreadyMentionned).contains(player))
				players.add(player);
		return players;
	}

	protected Stream<String> getPlayersName(String teamName, String[] playersAlreadyMentionned) {
		return TeamsManager.getPlayers(TeamsManager.getTeam(teamName)).stream()
		.map(p -> p.getName())
		.filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}
	
	protected List<String> getAvailableColors() {
		List<String> availableColors = ETeam.getColorsName();
		for (ETeam team : get().getTeams())
			availableColors.remove(team.getNameWithoutColor());
		return availableColors;
	}
}
