package fr.pederobien.uhc.managers;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.BukkitManager;

public class BlockedexPlayerManager extends PlayerManager {
	private HashMap<Player, Restriction> map;

	public BlockedexPlayerManager() {
		map = new HashMap<Player, Restriction>();
		for (Team team : TeamsManager.getTeams())
			for (Player player : TeamsManager.getPlayers(team))
				map.put(player, new Restriction(player, team));
	}

	public void decreaseMaxHealth(Player player, double decrease) {
		map.get(player).getPlayerRestriction().decreaseMaxHealth(decrease);
	}

	public void increaseMaxHealth(Player player, double increase) {
		map.get(player).getPlayerRestriction().increaseMaxHealth(increase);
	}

	public void decreasePlayerTeamMaxDeath(Player player) {
		TeamRestriction restriction = map.get(player).getTeamRestriction();
		restriction.decreaseMaxDeath();
		if (restriction.isTeamEliminated()) {
			PlayerManager.setGameModeOfPlayer(player, GameMode.SPECTATOR);
			restriction.eliminate();
		} else
			PlayerManager.setGameModeOfPlayer(player, GameMode.SURVIVAL);
	}

	public boolean isTeamPlayerEliminated(Player player) {
		return map.get(player).getTeamRestriction().isTeamEliminated();
	}

	private class Restriction {
		private PlayerRestriction playerRestriction;
		private TeamRestriction teamRestriction;

		public Restriction(Player player, Team team) {
			playerRestriction = new PlayerRestriction(player);
			teamRestriction = new TeamRestriction(team);
		}

		public PlayerRestriction getPlayerRestriction() {
			return playerRestriction;
		}

		public TeamRestriction getTeamRestriction() {
			return teamRestriction;
		}
	}

	private class PlayerRestriction {
		private Player player;

		public PlayerRestriction(Player player) {
			this.player = player;
		}

		public double getMaxHealth() {
			return player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
		}

		public void setMaxHealth(double maxHealth) {
			setMaxHealthOfPlayer(player, maxHealth);
		}

		public void increaseMaxHealth(double increase) {
			setMaxHealth(getMaxHealth() + increase);
		}

		public void decreaseMaxHealth(double decrease) {
			setMaxHealth(getMaxHealth() - decrease);
		}
	}

	private class TeamRestriction {
		private Team team;
		private int maxDeath;

		public TeamRestriction(Team team) {
			this.team = team;
			maxDeath = TeamsManager.getPlayers(team).size();
		}

		public void decreaseMaxDeath() {
			maxDeath--;
		}

		public boolean isTeamEliminated() {
			return maxDeath < 0;
		}

		public void eliminate() {
			BukkitManager.broadcastMessageAsTitle("Team " + team.getName() + " eliminated");
			for (Player player : TeamsManager.getPlayers(team)) {
				PlayerManager.dropPlayerInventoryItemNaturally(player);
				PlayerManager.setGameModeOfPlayer(player, GameMode.SPECTATOR);
				PlayerManager.teleporte(player, WorldManager.getSpawnOnJoin());
			}
		}
	}
}
