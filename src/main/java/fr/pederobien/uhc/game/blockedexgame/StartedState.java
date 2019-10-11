package fr.pederobien.uhc.game.blockedexgame;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StartedState extends AbstractBlockedexState {
	private List<Player> collegues;

	public StartedState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		event.setKeepInventory(true);
		Player player = event.getEntity();
		collegues = TeamsManager.getCollegues(player);
		if (player.getKiller() instanceof Player) {
			onPlayerDieByPlayer(player);
			onPlayerKill(player.getKiller());
		} else
			onPlayerDieByEnvironment(player);
		PlayerManager.setGameModeOfPlayer(player, GameMode.SURVIVAL);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (collegues.size() > 0)
			event.setRespawnLocation(TeamsManager.getRandom(collegues).getLocation());
		else
			event.setRespawnLocation(WorldManager.getRandomlyLocation(game.getConfiguration().getDiameterAreaOnPlayerRespawn()));
	}

	private void onPlayerDieByEnvironment(Player player) {
		collegues.add(player);
		for (Player pl : collegues)
			bdPlayerManager.decreaseMaxHealth(pl, game.getConfiguration().getStepOnMaxHealth());
		collegues.remove(player);
	}

	private void onPlayerDieByPlayer(Player player) {
		List<Player> players = PlayerManager.getClosePlayers(player,
				game.getConfiguration().getRadiusAreaOnPlayerDie());
		if (players.size() > 0) {
			players.add(player);
			for (Player pl : players)
				bdPlayerManager.decreaseMaxHealth(pl, game.getConfiguration().getStepOnMaxHealth());
		} else
			bdPlayerManager.decreaseMaxHealth(player, game.getConfiguration().getStepOnMaxHealth() * 2);
	}

	private void onPlayerKill(Player player) {
		List<Player> players = PlayerManager.getClosePlayers(player,
				game.getConfiguration().getRadiusAreaOnPlayerKill());
		if (players.size() > 0) {
			players.add(player);
			for (Player pl : players)
				bdPlayerManager.increaseMaxHealth(pl, game.getConfiguration().getStepOnMaxHealth());
		} else
			bdPlayerManager.increaseMaxHealth(player, game.getConfiguration().getStepOnMaxHealth() * 2);
	}
}
