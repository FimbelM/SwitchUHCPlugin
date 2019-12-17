package fr.pederobien.uhc.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.ChatColor;
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
		return color.getChatColor() + name + ChatColor.RESET;
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
			player.setDisplayName(getColor().getChatColor() + player.getName() + ChatColor.RESET);
	}

	@Override
	public void addPlayer(Player player) {
		player.setDisplayName(getColor().getChatColor() + player.getName() + ChatColor.RESET);
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
}
