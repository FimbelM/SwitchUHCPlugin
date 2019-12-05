package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;

public abstract class AbstractTeamEditions<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractTeamEditions(String label, MessageCode explanation) {
		super(label, explanation);
	}

	protected Stream<String> getTeamNamesWithoutColor() {
		return get().getTeams().stream().map(t -> t.getNameWithoutColor());
	}

	protected List<String> getTeamNamesWithColor() {
		return get().getTeams().stream().map(t -> t.getNameWithColor()).collect(Collectors.toList());
	}

	protected Stream<String> getTeams(String[] teamAlreadyMentionned) {
		return get().getTeams().stream().map(t -> t.getNameWithoutColor())
				.filter(n -> !Arrays.asList(teamAlreadyMentionned).contains(n));
	}

	protected Stream<String> getFreePlayersName(String[] playersAlreadyMentionned) {
		List<String> players = PlayerManager.getPlayers().map(p -> p.getName()).collect(Collectors.toList());
		players.removeAll(get().getPlayersRegistered().collect(Collectors.toList()));
		return players.stream().filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getPlayersName(String teamName, String[] playersAlreadyMentionned) {
		return get().getTeams().stream().filter(t -> t.getNameWithoutColor().equals(teamName)).findFirst().get()
		.getPlayers().stream().filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getAvailableColors() {
		return ETeam.getColorsName().stream().filter(c -> {
			for (ETeam team : get().getTeams())
				if (c.equals(team.getColorName()))
					return false;
			return true;
		});
	}
}
