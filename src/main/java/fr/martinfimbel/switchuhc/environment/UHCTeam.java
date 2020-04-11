package fr.martinfimbel.switchuhc.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.EColor;

public class UHCTeam implements ITeam {
	private String name;
	private EColor color;
	private List<Player> players;
	private boolean createdOnServer, isCopy;

	private UHCTeam(String name, EColor color, boolean isCopy) {
		this.name = name;
		this.color = color;
		this.isCopy = isCopy;

		players = new ArrayList<Player>();
		createdOnServer = false;
	}

	public static ITeam createTeam(String name, EColor color) {
		return new UHCTeam(name, color, false);
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
				playersOnMode.add(player);
		return playersOnMode;
	}

	@Override
	public boolean isCreatedOnServer() {
		return createdOnServer;
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
			updateUhcPlayer(player, color);
	}

	@Override
	public void addPlayer(Player player) {
		updateUhcPlayer(player, getColor());
		players.add(player);
	}

	@Override
	public void removePlayer(Player player) {
		updateUhcPlayer(player, null);
		players.remove(player);
	}
	
	@Override
	public void clear() {
		for (Player player : players)
			updateUhcPlayer(player, null);
		players.clear();
	}

	@Override
	public void setCreatedOnServer(boolean createdOnServer) {
		this.createdOnServer = createdOnServer;
	}
	
	@Override
	public Object clone() {
		ITeam team = new UHCTeam(getName(), getColor(), true);
		for (Player player : getPlayers())
			team.addPlayer(player);
		return team;
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

	private void updateUhcPlayer(Player player, EColor color) {
		if (isCopy)
			return;
		
		if (color == null) {
			player.setDisplayName(player.getName());
			player.setPlayerListName(player.getName());
			UHCPlayer.get(player).setColor(null);
		} else {
			player.setDisplayName(color.getInColor(player.getName()));
			player.setPlayerListName(color.getInColor(player.getName()));
			UHCPlayer.get(player).setColor(color);
		}
	}
}
