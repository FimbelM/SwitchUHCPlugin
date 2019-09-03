package fr.pederobien.uhc.scoreboard;

import org.bukkit.GameMode;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class AfterBorderMoveState extends AbstractScoreboardState {

	public AfterBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Brace Yourself");
	}
	
	@Override
	void updateEntries() {
		addEntries(scoreboard.getChatColor() + prepareTimeNoEscape(task.getTotalTime()));
		addEntries(scoreboard.getChatColor() + "Temps de jeu");
		registerTeam();
		addEntries(scoreboard.getChatColor() + "Rayon bordure : " + WorldManager.getCurrentDiameter() / 2);
	}

	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}

	public void registerTeam() {
		for (Team team : TeamsManager.getTeams())
			addEntries(team.getColor() + team.getDisplayName() + " : "
					+ TeamsManager.getNumberTeamPlayersOnMode(team, GameMode.SURVIVAL));
	}
}
