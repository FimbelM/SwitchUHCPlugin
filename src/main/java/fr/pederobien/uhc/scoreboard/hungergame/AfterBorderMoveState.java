package fr.pederobien.uhc.scoreboard.hungergame;

import org.bukkit.GameMode;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.WorldManager;

public class AfterBorderMoveState extends AbstractHungerGameScoreboardState {

	public AfterBorderMoveState(IHGScoreboard scoreboard) {
		super(scoreboard, "Brace Yourself");
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntryToTranslate(MessageCode.SCOREBOARD_HUNGER_GAME_BORDER, "" + WorldManager.getCurrentDiameter().intValue() / 2);
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
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
		for (ETeam team : scoreboard.getConfiguration().getTeams())
			addEntryToNotTranslate(team.getNameWithColor() + " : ", "" + team.getNumberPlayersOnMode(GameMode.SURVIVAL));
		addEmptyLine();
	}
}
