package fr.pederobien.uhc.scoreboard;

import org.bukkit.event.player.PlayerMoveEvent;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.task.TimeTask;

public class StopState extends AbstractScoreboardState {

	public StopState(IScoreboard scoreboard) {
		super(scoreboard, "Partie arrêtée");
	}
	
	@Override
	public void stop() {
		ScoreboardManager.removePlayersScoreboard();
	}
	
	@Override
	public void timeChanged(TimeTask task) {
		ScoreboardManager.setPlayersScoreboardWithCurrentLocation(getTitle(), getEntries());
	}
	
	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		ScoreboardManager.setPlayerScoreboardWithCurrentLocation(getTitle(), event.getPlayer(), getEntries());
	}

}
