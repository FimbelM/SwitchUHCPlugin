package fr.pederobien.uhc.game.hungergame;

import java.time.Duration;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.scoreboard.launcher.HGScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractHungerGameState {

	public InitialState(IHungerGame game) {
		super(game);
	}

	@Override
	public boolean initiate() {
		if (Duration.between(game.getConfiguration().getFractionTime(), game.getConfiguration().getGameTime()).isNegative()) {
			message = MessageCode.FRACTION_TIME_LESS_THAN_GAME_TIME;
			return false;
		}

		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new HGScoreboardLauncher(taskLauncher.getTask(), game.getConfiguration());
		alreadyWarned = false;

		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(game.getConfiguration().getWarningTime(), game);
		timeLine.addObserver(game.getConfiguration().getPvpTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), scoreboardLauncher);
		return true;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
