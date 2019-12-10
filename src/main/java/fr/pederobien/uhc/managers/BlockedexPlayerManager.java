package fr.pederobien.uhc.managers;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;

public class BlockedexPlayerManager extends PlayerManager {
	private HashMap<Player, Restriction> map;

	public BlockedexPlayerManager(IUnmodifiableBlockedexConfiguration configuration) {
		map = new HashMap<Player, Restriction>();
		configuration.getTeams().forEach(t -> t.getPlayers().stream().forEach(p -> map.put(PlayerManager.getPlayer(p), new Restriction(p, t))));
	}

	public void decreaseMaxHealth(Player player, double decrease) {
		map.get(player).getPlayerRestriction().decreaseMaxHealth(decrease);
	}

	public void increaseMaxHealth(Player player, double increase) {
		map.get(player).getPlayerRestriction().increaseMaxHealth(increase);
	}

	public void decreasePlayerTeamMaxDeath(Player player) {
		TeamRestriction restriction = map.get(player).getTeamRestriction();
		if (restriction.decreaseMaxDeath())
			PlayerManager.setGameModeOfPlayer(player, restriction.isTeamEliminated() ? GameMode.SPECTATOR : GameMode.SURVIVAL);
	}

	public boolean isTeamPlayerEliminated(Player player) {
		return map.get(player).getTeamRestriction().isTeamEliminated();
	}

	private class Restriction {
		private PlayerRestriction playerRestriction;
		private TeamRestriction teamRestriction;

		public Restriction(String player, ETeam team) {
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

		public PlayerRestriction(String player) {
			this.player = PlayerManager.getPlayer(player);
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
		private ETeam team;
		private long maxDeath;

		public TeamRestriction(ETeam team) {
			this.team = team;
			maxDeath = team.getPlayers().size();
		}

		public boolean decreaseMaxDeath() {
			maxDeath--;
			if (isTeamEliminated())
				eliminate();
			return isTeamEliminated();
		}

		public boolean isTeamEliminated() {
			return maxDeath < 0;
		}

		public void eliminate() {
			BukkitManager.sendTitleToPlayers(EventFactory.createMessageCodeEvent(MessageCode.TEAM_ELIMINATED, team.getNameWithColor()));

			team.getPlayers().stream().map(n -> PlayerManager.getPlayer(n)).forEach(p -> {
				PlayerManager.dropPlayerInventoryItemNaturally(p);
				PlayerManager.setGameModeOfPlayer(p, GameMode.SPECTATOR);
				PlayerManager.teleporte(p, WorldManager.getSpawnOnJoin());
			});
		}
	}
}
