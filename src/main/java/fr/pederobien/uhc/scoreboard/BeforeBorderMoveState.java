package fr.pederobien.uhc.scoreboard;

import org.bukkit.event.player.PlayerMoveEvent;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.task.TimeTask;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");
		
		addEntries("D�placement bordure dans");
		addEntries(prepareTimeOneEscape(task.getDecreasingTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void run() {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}
	
	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
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