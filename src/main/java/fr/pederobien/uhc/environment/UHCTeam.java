package fr.pederobien.uhc.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.managers.EColor;

public class UHCTeam implements ITeam {
	private String name;
	private EColor color;
	private List<Player> players;

	private UHCTeam(String name, EColor color) {
		this.name = name;
		this.color = color;

		players = new ArrayList<Player>();
	}

	public static ITeam createTeam(String name, EColor color) {
		return new UHCTeam(name, color);
	}

	@Override
	public String getColoredName() {
		return color.getInColor(name);
	}

	@Override
	public EColor getColor() {
		return color;
	}

	@Override
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	@Override
	public List<Player> getPlayersOnMode(GameMode mode) {
		List<Player> playersOnMode = new ArrayList<Player>();
		for (Player player : players)
			if (player.getGameMode().equals(mode))
				playersOnMode.contains(player);
		return playersOnMode;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setColor(EColor color) {
		this.color = color;
		for (Player player : players)
			player.setDisplayName(getColor().getInColor(player.getName()));
	}

	@Override
	public void addPlayer(Player player) {
		player.setDisplayName(getColor().getInColor(player.getName()));
		players.add(player);
	}

	@Override
	public void removePlayer(Player player) {
		player.setDisplayName(player.getName());
		players.remove(player);
	}

	@Override
	public void clear() {
		players.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(name);
		builder.append(" [");
		for (int i = 0; i < players.size(); i++) {
			builder.append(players.get(i).getName());
			if (i < players.size() - 1)
				builder.append(" ");
		}
		builder.append("]");
		return color.getInColor(builder.toString());
	}
}
