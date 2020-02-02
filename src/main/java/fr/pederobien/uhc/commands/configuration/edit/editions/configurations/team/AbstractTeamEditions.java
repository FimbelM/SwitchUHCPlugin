package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.entity.Player;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public abstract class AbstractTeamEditions<T extends IConfiguration> extends AbstractMapEdition<T> {

	public AbstractTeamEditions(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	protected Optional<ITeam> getTeam(String name) {
		return get().getTeams().stream().filter(t -> t.getName().equals(name)).findFirst();
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

	protected Stream<String> getPlayersName(ITeam team, String[] playersAlreadyMentionned) {
		return team.getPlayers().stream().map(p -> p.getName()).filter(s -> !Arrays.asList(playersAlreadyMentionned).contains(s));
	}

	protected Stream<String> getAvailableColors() {
		List<EColor> availableColors = new ArrayList<EColor>();
		List<EColor> forbidenColors = get().getTeams().stream().map(t -> t.getColor()).collect(Collectors.toList());
		for (EColor color : EColor.values())
			if (!forbidenColors.contains(color))
				availableColors.add(color);
		return availableColors.stream().map(c -> c.getColorName());
	}

	protected AddPlayerEvent addPlayers(ITeam team, String... args) {
		String playerNames = team.getColor().getChatColor() + "";
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < args.length; i++) {
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				ITeam teamPlayer = TeamsManager.getTeam(get(), player);
				if (teamPlayer != null) {
					sendMessage(MessageCode.TEAM_PLAYER_ALREADY_IN_TEAM, player.getName(), teamPlayer.getColoredName());
					return null;
				}
				playerNames += player.getName();
				players.add(player);
				if (i < args.length - 1)
					playerNames += " ";
			} catch (NullPointerException e) {
				sendMessage(MessageCode.TEAM_BAD_PLAYER, args[i]);
				return null;
			}
		}

		for (Player player : players)
			team.addPlayer(player);
		return new AddPlayerEvent(players, playerNames);
	}

	protected class AddPlayerEvent {
		private List<Player> players;
		private String playerNames;

		public AddPlayerEvent(List<Player> players, String playerNames) {
			this.players = players;
			this.playerNames = playerNames;
		}

		public List<Player> getPlayers() {
			return players;
		}

		public String getPlayerNames() {
			return playerNames;
		}
	}
}
