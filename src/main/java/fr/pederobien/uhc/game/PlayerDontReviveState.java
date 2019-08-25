package fr.pederobien.uhc.game;

import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;

public class PlayerDontReviveState extends AbstractState {

	public PlayerDontReviveState(IGame game) {
		super(game);
	}
	
	@Override
	public void pause(IGameState before) {
		game.setCurrentState(game.getPause()).pause(before);
	}
	
	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}
	
	@Override
	public void run() {
		BukkitManager.broadcastMessageAsTitle("Brace Yourself");
		game.setCurrentState(game.getHungerGame());
	}
	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		PlayerManager.setGameModeOfPlayer(event.getPlayer(), GameMode.SPECTATOR);
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
	}
}
