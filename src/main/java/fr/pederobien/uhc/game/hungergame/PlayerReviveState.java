package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;

public class PlayerReviveState extends AbstractHungerGameState {

	public PlayerReviveState(IHungerGame game) {
		super(game);
	}

	@Override
	public void pause() {
		BukkitManager.broadcastMessageAsTitle("Partie suspendue");
		taskLauncher.pause();
		scoreboardLauncher.pause();
	}

	@Override
	public void relaunch() {
		BukkitManager.broadcastMessageAsTitle("Reprise");
		taskLauncher.relaunched();
		scoreboardLauncher.relaunched();
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}

	@Override
	public void time() {
		BukkitManager.broadcastMessageAsTitle("Plus de résurrection", "red");
		game.setCurrentState(game.getPlayerDontRevive());
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		if (event.getEntity().getKiller() instanceof Player) {
			event.setKeepInventory(false);
			PlayerManager.setGameModeOfPlayer(event.getEntity(), GameMode.SPECTATOR);
		} else {
			event.setKeepInventory(true);
			PlayerManager.setGameModeOfPlayer(event.getEntity(), GameMode.SURVIVAL);
		}
		shouldStopGame();
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (event.getPlayer().getKiller() instanceof Player)
			event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		else
			event.setRespawnLocation(WorldManager.getRandomlyLocation(WorldManager.getCurrentDiameter().intValue()));
	}
}
