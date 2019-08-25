package fr.pederobien.uhc.scoreboard;

import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.task.TimeTask;

public class AfterBorderMoveState extends AbstractScoreboardState {

	public AfterBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Brace Yourself");

		addEntries("Rayon bordure : " + WorldManager.getCurrentDiameter() / 2);
		registerTeam();
		addEntries("Temps de jeu");
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
	}

	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
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

	public void registerTeam() {
		for (Team team : TeamsManager.getTeams())
			addEntries(team.getColor() + team.getDisplayName() + " : "
					+ TeamsManager.getNumberTeamPlayersOnMode(team, GameMode.SURVIVAL));
	}
}
