package fr.martinfimbel.switchuhc.game.hungergame;

import java.time.LocalTime;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class PlayerReviveState extends AbstractHungerGameState {

	public PlayerReviveState(IHungerGame game) {
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

	private void changeFromReviveToNotRevive() {
		sendTitle(EColor.DARK_RED, MessageCode.NO_MORE_RESURRECTION);
		game.setCurrentState(game.getPlayerDontRevive());
	}
}
