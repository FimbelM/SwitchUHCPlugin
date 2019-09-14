package fr.pederobien.uhc.game.hungergame;

import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;

public class HungerGameState extends AbstractState {

	public HungerGameState(IHungerGame game) {
		super(game);
	}
	
	@Override
	public void pause() {
		BukkitManager.broadcastMessageAsTitle("Partie suspendue");
		WorldManager.stopBorder();
		taskLauncher.pause();
		scoreboardLauncher.pause();
	}
	
	@Override
	public void relaunch() {
		BukkitManager.broadcastMessageAsTitle("Reprise");
		WorldManager.moveBorder(game.getConfiguration().getFinalBorderDiameter(), WorldManager.getCurrentDiameter().longValue());
		taskLauncher.relaunched();
		scoreboardLauncher.relaunched();
	}
	
	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}
	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		PlayerManager.setGameModeOfPlayer(event.getPlayer(), GameMode.SPECTATOR);
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}
}
