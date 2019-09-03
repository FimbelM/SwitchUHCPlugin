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
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
		addEntries("Temps de jeu");
		registerTeam();
		addEntries("Rayon bordure : " + WorldManager.getCurrentDiameter() / 2);
		addEntries(getShowingLocation());
		addEntries("Coordonnées X/Y/Z");
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
