package fr.pederobien.uhc.scoreboard;

import org.bukkit.GameMode;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

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

	public void registerTeam() {
		for (Team team : TeamsManager.getTeams())
			addEntries(team.getColor() + team.getDisplayName() + " : "
					+ TeamsManager.getNumberTeamPlayersOnMode(team, GameMode.SURVIVAL));
	}
}
