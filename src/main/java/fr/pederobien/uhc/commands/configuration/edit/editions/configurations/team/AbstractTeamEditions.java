package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

	protected Stream<String> getTeamNamesWithoutColor() {
		List<String> teams = emptyList();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithoutColor());
		return teams.stream();
	}

	protected List<String> getTeamNamesWithColor() {
		List<String> teams = emptyList();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithColor());
		return teams;
	}

	protected Stream<String> getTeams(String[] teamAlreadyMentionned) {
		List<String> teams = new ArrayList<String>();
		for (ETeam team : get().getTeams())
			if (!Arrays.asList(teamAlreadyMentionned).contains(team.getNameWithoutColor()))
				teams.add(team.getNameWithoutColor());
		return teams.stream();
	}

	protected Stream<String> getFreePlayersName(String[] playersAlreadyMentionned) {
		return PlayerManager.getPlayers().map(p -> p.getName())
				.filter(n -> get().getPlayersRegistered().contains(n));
	}

	protected Stream<String> getPlayersName(String teamName, String[] playersAlreadyMentionned) {
		return TeamsManager.getPlayers(TeamsManager.getTeam(teamName)).stream().map(p -> p.getName())
				.filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getAvailableColors() {
		List<String> usedColor = get().getTeams().stream().map(t -> t.getColorName()).collect(Collectors.toList());
		return ETeam.getColorsName().stream().filter(c -> !usedColor.contains(c));
	}
}
