package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public abstract class AbstractTeamEditions<T extends IConfiguration> extends AbstractEdition<T> {

	public AbstractTeamEditions(IPersistence<T> persistence, String label, String explanation) {
		super(persistence, label, explanation);
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
	
	protected List<String> getPlayersName(String teamName, String[] playersAlreadyMentionned) {
		List<String> players = emptyList();
		for (String name : TeamsManager.getPlayersName(teamName)) {
			if (!Arrays.asList(playersAlreadyMentionned).contains(name))
				players.add(name);
		}
		return players;
	}
}
