package fr.pederobien.uhc.game.blockedexgame;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

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
		Player player = event.getEntity();
		if (player.getKiller() instanceof Player)
			onPlayerDieByPlayer(player);
		else
			onPlayerDieByEnvironment(player);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	}
	
	private void onPlayerDieByEnvironment(Player player) {
		for (Player pl : TeamsManager.getCollegues(player))
			bdPlayerManager.decreaseMaxHealth(pl, game.getConfiguration().getStepOnMaxHealth());
	}
	
	private void onPlayerDieByPlayer(Player player) {
		List<Player> players = PlayerManager.getClosePlayers(player, game.getConfiguration().getAreaRadiusOnPlayerDie());
		if (players.size() > 0)
			for (Player pl : players)
				bdPlayerManager.decreaseMaxHealth(pl, game.getConfiguration().getStepOnMaxHealth());
		else
			bdPlayerManager.decreaseMaxHealth(player, game.getConfiguration().getStepOnMaxHealth()*2);
	}
}
