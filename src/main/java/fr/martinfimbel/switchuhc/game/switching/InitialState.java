package fr.martinfimbel.switchuhc.game.switching;

import java.time.Duration;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.scoreboard.launcher.SWScoreboardLauncher;
import fr.martinfimbel.switchuhc.task.TaskLauncher;
import fr.martinfimbel.switchuhc.task.TimeLine;

public class InitialState extends AbstractSwitchGameState {

	public InitialState(ISwitchGame game) {
		super(game);
	}
	
	@Override
	public boolean initiate() {
		if (Duration.between(getConfiguration().getFractionTime(), getConfiguration().getGameTime()).isNegative()) {
			message = MessageCode.FRACTION_TIME_LESS_THAN_GAME_TIME;
			return false;
		}

		taskLauncher = new TaskLauncher(getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new SWScoreboardLauncher(taskLauncher.getTask(), getConfiguration());
		alreadyWarned = false;

		timeLine.addObserver(getConfiguration().getFractionTime(), game);
		timeLine.addObserver(getConfiguration().getGameTime(), game);
		timeLine.addObserver(getAbsoluteWarningTime(), game);
		timeLine.addObserver(getConfiguration().getPvpTime(), game);
		timeLine.addObserver(getConfiguration().getGameTime(), scoreboardLauncher);
		return true;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
