package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;

public class PlayerDontReviveState extends AbstractHungerGameState {

	public PlayerDontReviveState(IHungerGame game) {
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
		BukkitManager.broadcastMessageAsTitle("Déplacement bordure", "red");
		WorldManager.moveBorder(game.getConfiguration().getFinalBorderDiameter(), game.getConfiguration().getInitialBorderDiameter().longValue());
		game.setCurrentState(game.getHungerGame());
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		PlayerManager.setGameModeOfPlayer(event.getEntity(), GameMode.SPECTATOR);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}
}
