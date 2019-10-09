package fr.pederobien.uhc.game.blockedexgame;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.managers.PlayerManager;

public class StartedState extends AbstractBlockedexState {

	public StartedState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}
	
	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		for (Player player : PlayerManager.getClosePlayers(event.getEntity(), game.getConfiguration().getAreaRadiusOnPlayerDie()))
			System.out.println("Decreasing " + player.getName() + "'s health");
		
	}
	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	}
}
