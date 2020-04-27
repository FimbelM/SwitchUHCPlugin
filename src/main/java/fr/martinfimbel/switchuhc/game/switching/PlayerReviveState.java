package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.managers.ScoreboardKillManager;

public class PlayerReviveState extends AbstractSwitchGameState {
	public PlayerReviveState(ISwitchGame game) {
		super(game);
	}
	
	@Override
	public void pause() {
		onPause();
	}

	@Override
	public void relaunch() {
		onRelaunched();
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}

	@Override
	public void time(LocalTime time) {
		if (time.equals(getConfiguration().getPvpTime()))
			authorizedPvp();
		if (time.equals(getAbsoluteWarningTime()))
			warnPlayers();
		if (time.equals(getConfiguration().getFractionTime()))
			changeFromReviveToNotRevive();
		if (time.equals(game.getNextSwitchTime()))
			Switch();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		if (killer instanceof Player) {
			ScoreboardKillManager.increase(killer);
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
		Player player = event.getPlayer();
		String letter = game.getConfiguration().getReviveNearTeamate();
		List<Player> teamate = TeamsManager.getCollegues(player);
		if (event.getPlayer().getKiller() instanceof Player)
			event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		else if (letter.equalsIgnoreCase("N"))
			event.setRespawnLocation(WorldManager.getRandomlyLocation(WorldManager.getCurrentDiameter().intValue(),
					getConfiguration().getBorderCenter().getLocation()));
		else if (teamate.size() == 0) {
			event.setRespawnLocation(WorldManager.getRandomlyLocation(WorldManager.getCurrentDiameter().intValue(),
					getConfiguration().getBorderCenter().getLocation()));
		} else {
			Random rand = new Random();
			Location teamateLocation = teamate.get(rand.nextInt(teamate.size())).getLocation();
			event.setRespawnLocation(teamateLocation);
		}

	}

	private void changeFromReviveToNotRevive() {
		sendTitle(EColor.DARK_RED, MessageCode.NO_MORE_RESURRECTION);
		game.setCurrentState(game.getPlayerDontRevive());
	}

}
