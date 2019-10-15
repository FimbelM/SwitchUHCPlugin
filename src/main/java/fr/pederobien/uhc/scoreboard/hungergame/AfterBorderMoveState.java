package fr.pederobien.uhc.scoreboard.hungergame;

import org.bukkit.GameMode;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class AfterBorderMoveState extends AbstractHungerGameScoreboardState {

	public AfterBorderMoveState(IHGScoreboard scoreboard) {
		super(scoreboard, "Brace Yourself");
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntries("Bordure", "" + WorldManager.getCurrentDiameter().intValue() / 2);
		addEntries("Temps", prepareTime(getTask().getTotalTime()));
	}

	@Override
	public void pause(IHGScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}

	public void registerTeam() {
		for (Team team : TeamsManager.getTeams())
			addEntries(team.getColor() + team.getDisplayName(),
					"" + TeamsManager.getNumberTeamPlayersOnMode(team, GameMode.SURVIVAL));
		addEmptyLine();
	}
}
