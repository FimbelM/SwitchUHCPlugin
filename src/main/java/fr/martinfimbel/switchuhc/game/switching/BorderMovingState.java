package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;

import org.bukkit.GameMode;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.dictionary.NotificationCenter;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.event.EventFactory;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class BorderMovingState extends AbstractSwitchGameState {
	public BorderMovingState(ISwitchGame game) {
		super(game);
	}

	@Override
	public void pause() {
		onPause();
		WorldManager.stopBorder();
	}

	@Override
	public void relaunch() {
		onRelaunched();
		WorldManager.moveBorder(getConfiguration().getFinalBorderDiameter(),
				WorldManager.getCurrentDiameter().longValue() / getConfiguration().getBorderSpeed().longValue());
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		PlayerManager.setGameModeOfPlayer(event.getEntity(), GameMode.SPECTATOR);
		shouldStopGame();
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {
		event.setCancelled(true);
		NotificationCenter.sendMessage(
				EventFactory.createMessageEvent(event.getPlayer(), MessageCode.PLAYER_MUST_STAY_IN_THE_OVERWORLD,
						WorldManager.getNormalizeWorldName(event.getTo().getWorld().getName())));
	}

	@Override
	public void time(LocalTime time) {
		boolean switchAfterBorderMoves = false;
		String YN = getConfiguration().getSwitchAfterBorderMoves();
		if (YN.equals("Y")) {
			switchAfterBorderMoves = true;
			if (time.equals(game.getNextSwitchTime()) && switchAfterBorderMoves == true)
				Switch();
		}
	}
}
