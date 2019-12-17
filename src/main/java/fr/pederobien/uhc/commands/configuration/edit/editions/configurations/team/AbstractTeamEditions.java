package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;

public abstract class AbstractTeamEditions<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractTeamEditions(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	protected Stream<String> getTeamNamesWithoutColor() {
		return get().getTeams().stream().map(t -> t.getName());
	}

	protected List<String> getTeamNamesWithColor() {
		return get().getTeams().stream().map(t -> t.getColoredName()).collect(Collectors.toList());
	}

	protected Stream<String> getTeams(String[] teamAlreadyMentionned) {
		return get().getTeams().stream().map(t -> t.getName()).filter(n -> !Arrays.asList(teamAlreadyMentionned).contains(n));
	}

	protected Stream<String> getFreePlayersName(String[] playersAlreadyMentionned) {
		List<String> players = PlayerManager.getPlayers().map(p -> p.getName()).collect(Collectors.toList());
		players.removeAll(get().getPlayersRegistered().collect(Collectors.toList()));
		return players.stream().filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getPlayersName(String teamName, String[] playersAlreadyMentionned) {
		return get().getTeams().stream().filter(t -> t.getName().equals(teamName)).findFirst().get().getPlayers().stream().map(p -> p.getName())
				.filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getAvailableColors() {
		List<EColor> availableColors = new ArrayList<EColor>();
		List<EColor> forbidenColors = get().getTeams().stream().map(t -> t.getColor()).collect(Collectors.toList());
		for (EColor color : EColor.values())
			if (!forbidenColors.contains(color))
				availableColors.add(color);
		return availableColors.stream().map(c -> c.getColorName());
	}

	protected String showTeams() {
		String teams = "";
		for (ITeam team : get().getTeams()) {
			teams += team.getColor().getChatColor() + team.getName() + " [";
			for (int i = 0; i < team.getPlayers().size(); i++) {
				teams += team.getPlayers().get(i).getName();
				if (i < team.getPlayers().size() - 1)
					teams += " ";
			}
			teams += "]\n";
		}
		return teams;
	}
}
