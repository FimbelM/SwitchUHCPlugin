package fr.martinfimbel.switchuhc.scoreboard.launcher;

import fr.martinfimbel.switchuhc.game.switching.ISwitchGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;
import fr.martinfimbel.switchuhc.scoreboard.switching.SwitchGameScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class SWScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableSwitchConfiguration> {

	private ISwitchGame game;

	public SWScoreboardLauncher(TimeTask task, IUnmodifiableSwitchConfiguration configuration, ISwitchGame game) {
		super(task, configuration);
		this.game = game;
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new SwitchGameScoreboard(getTask(), getConfiguration(), game);
	}

}
